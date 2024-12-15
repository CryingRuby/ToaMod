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
			String stat = "";
			byte hasPercentage = 1;
			switch (idList[i]) {
				case 0 :
					stat = "str";
					break;
				case 1 :
					stat = "dex";
					break;
				case 2 :
					stat = "con";
					break;
				case 3 :
					stat = "int";
					break;
				case 4 :
					stat = "wis";
					break;
				case 5 :
					stat = "cr";
					hasPercentage = 0;
					break;
				case 6 :
					stat = "cd";
					hasPercentage = 0;
					break;
				case 7 :
					stat = "lifesteal";
					hasPercentage = 0;
					break;
				case 8 :
					stat = "hp";
					break;
				case 9 :
					stat = "ar";
					break;
				case 10 :
					stat = "mr";
					break;
				case 11 :
					stat = "mf";
					break;
				case 12 :
					stat = "minf";
					break;
				default :
					break;
			}
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
