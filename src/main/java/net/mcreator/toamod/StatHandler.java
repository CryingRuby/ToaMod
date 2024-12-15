package net.mcreator.toamod;

import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.item.Items;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.InteractionHand;
import net.minecraft.nbt.CompoundTag;

import java.util.Optional;
import java.util.ArrayList;

public final class StatHandler {
	private static final EquipmentSlot[] armorSlots = {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
	private static final String[] statNbtPostfix = {"_f", "_p"};

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
			
			byte hasPercentage = (idList[i] >= 5 && idList[i] <= 7)? 0 : 1; //cr, cd, lifesteal do NOT have percentages
			String stat = switch (idList[i]) {
				case 0 -> "str";
				case 1 -> "dex";
				case 2 -> "con";
				case 3 -> "int";
				case 4 -> "wis";
				case 5 -> "cr";
				case 6 -> "cd";
				case 7 -> "lifesteal";
				case 8 -> "hp";
				case 9 -> "ar";
				case 10 -> "mr";
				case 11 -> "mf";
				case 12 -> "minf";
				default -> "";
			};
			if (stat.equals("")) {
				stats[i] = 0;
				continue;
			}
			stats[i] = getPlayerStatValue(player, stat, hasPercentage, weaponStats, armorStats, equipStats);
		}
		return stats;
	}

	private static float getPlayerStatValue(Player player, String stat, byte hasPercentage, CompoundTag weaponStats, ArrayList<CompoundTag> armorStats, ArrayList<CompoundTag> equipStats) {
		float[] stats = {0, 1}; //{flat, perc}
		//For flat and maybe percentage go through all stat sources and collect assosiated stat
		for(int p = 0; p <= hasPercentage; p++){
			String statNbt = stat + statNbtPostfix[p];
			//weapon
			stats[p] += weaponStats.getFloat(statNbt);
	
			//armor
			for (int i = 0; i < armorStats.size(); i++) {
				stats[p] += armorStats.get(i).getFloat(statNbt);
			}
			
			//artefacts
			//equipment
			for (int i = 0; i < equipStats.size(); i++) {
				stats[p] += equipStats.get(i).getFloat(statNbt);
			}
		}
		return stats[0] * stats[1];
	}
}
