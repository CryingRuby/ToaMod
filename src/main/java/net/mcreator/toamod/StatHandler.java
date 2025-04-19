package net.mcreator.toamod;

import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.InteractionHand;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.toamod.network.ToamodModVariables;

import java.util.Optional;
import java.util.ArrayList;

public final class StatHandler {
	private static final EquipmentSlot[] armorSlots = {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
	private static final String[] statNbtIds = {"str", "dex", "con", "int", "wis", "cr", "cd", "lifesteal", "hp", "ar", "mr", "mf", "minf"};

	private StatHandler() {
	}

	public static float[] getPlayerStats(Player player, byte[] idList) {
		float[] stats = new float[idList.length];
		//Gather different stat sources
		//weapon (mainhand) stats
		CompoundTag weaponStats = player.getItemInHand(InteractionHand.MAIN_HAND).getOrCreateTag().getCompound("Stats");
		//armor stats
		ArrayList<CompoundTag> armorStats = new ArrayList<>();
		for (int i = 0; i < armorSlots.length; i++) {
			if (player.getItemBySlot(armorSlots[i]).getItem() != Items.AIR)
				armorStats.add(player.getItemBySlot(armorSlots[i]).getOrCreateTag().getCompound("Stats"));
		}
		//equipment stats
		ArrayList<CompoundTag> equipStats = new ArrayList<>();
		Optional<ICuriosItemHandler> equipmentInv = CuriosApi.getCuriosInventory(player).resolve();
		if (equipmentInv.isPresent()) {
			for (int i = 0; i < equipmentInv.get().getSlots(); i++) {
				if (equipmentInv.get().getEquippedCurios().getStackInSlot(i).getItem() != Items.AIR)
					equipStats.add(equipmentInv.get().getEquippedCurios().getStackInSlot(i).getOrCreateTag().getCompound("Stats"));
			}
		}
		//collect all final stats given in idList parameter
		for (int i = 0; i < idList.length; i++) {
			stats[i] = getPlayerStatValue(player, statNbtIds[idList[i]], weaponStats, armorStats, equipStats);
		}
		return stats;
	}

	private static float getPlayerStatValue(Player player, String stat, CompoundTag weaponStats, ArrayList<CompoundTag> armorStats, ArrayList<CompoundTag> equipStats) {
		float value = 0;
		//weapon
		value += weaponStats.getFloat(stat);
		//armor
		for (int i = 0; i < armorStats.size(); i++) {
			value += armorStats.get(i).getFloat(stat);
		}
		//artefacts
		//equipment
		for (int i = 0; i < equipStats.size(); i++) {
			value += equipStats.get(i).getFloat(stat);
		}
		return value;
	}

	public static float[] getEntityStats(LivingEntity entity, byte[] idList) {
		float[] stats = new float[idList.length];
		for (int i = 0; i < idList.length; i++) {
			stats[i] = entity.getPersistentData().getFloat(statNbtIds[idList[i]]);
		}
		return stats;
	}

	public static int getPlayerCor(Player entity) {
		return (int) (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).cor;
	}

	public static void addPlayerCor(Player entity, int value) {
		int setCor = getPlayerCor(entity) + value;
		entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
			capability.cor = setCor;
			capability.syncPlayerVariables(entity);
		});
	}
}
