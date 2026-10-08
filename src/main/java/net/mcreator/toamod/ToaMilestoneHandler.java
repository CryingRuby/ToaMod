package net.mcreator.toamod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.procedures.ChkPlayerLvlLevelUpProcedure;
import net.mcreator.toamod.network.ToamodModVariables;

public final class ToaMilestoneHandler {
	public enum MilestoneType {
		PATH_OF_THE_REAPER("Path Of The Reaper", "\u00A7bThe Bartender", 10, 20), DWARFS_WAY("Dwarfs Way", "Kaijin", 10, 20);

		MilestoneType(String _Name, String _RewardNPCName, int... _StatsToLvlUp) {
			StatsToLvlUp = _StatsToLvlUp;
			Name = _Name;
			RewardNPCName = _RewardNPCName;
		}

		public final int StatsToLvlUp[];
		public final String Name;
		public final String RewardNPCName; //probably later as ToaNpc instead of String
	}

	public static final int MaxMileLevel = 20;

	public static void addStatToMile(Player player, int statAmount, MilestoneType mileType) {
		ToamodModVariables.PlayerVariables capability = (player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables()));
		player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap -> {
			switch (mileType) {
				case PATH_OF_THE_REAPER :
					cap.combatMilestoneLvl += statAmount;
					break;
				case DWARFS_WAY :
					cap.miningMilestoneLvl += statAmount;
					break;
				default :
			}
			capability.syncPlayerVariables(player);
		});
		levelUpIfPossible(player, mileType);
	}

	private static void levelUpIfPossible(Player player, MilestoneType mileType) {
		ToamodModVariables.PlayerVariables capability = player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables());
		final int mileLvl;
		int mileStat = -1;
		

		switch (mileType) {
			case PATH_OF_THE_REAPER :
				mileLvl = (int) capability.combatMilestoneLvl;
				mileStat = (int) capability.totalMobsKilled;
				break;
			case DWARFS_WAY :
				mileLvl = (int) capability.miningMilestoneLvl;
				mileStat = (int) capability.totalOresMined;
				break;
			default :
				return;
		}
		
		if (mileLvl >= MaxMileLevel)
			return;
		
		//change player vars when lvl up
		if (mileStat >= mileType.StatsToLvlUp[mileLvl]) {
			player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap -> {
				switch (mileType) {
					case PATH_OF_THE_REAPER :
						cap.combatMilestoneLvl++;
						break;
					case DWARFS_WAY :
						cap.miningMilestoneLvl++;
						break;
					default :
				}
				printMilestoneLvlUp(player, mileLvl + 1, mileType);
				//add player xp depending on skill-lvl
				capability.xp += 10 * Math.ceil((double) mileLvl / 10.0);
				ChkPlayerLvlLevelUpProcedure.execute(player);
				capability.syncPlayerVariables(player);
			});
		}
	}

	public static void printMilestoneLvlUp(Player player, int newLvl, MilestoneType mileType) {
		if (newLvl < 1)
			return;
		ToaFormats.printSeperationLine(player);
		ToaFormats.printEmptyLine(player);

		player.displayClientMessage(Component.literal("§3" + mileType.Name + " Milestone:"), false);
		player.displayClientMessage(Component.literal("§6" + (newLvl - 1) + " §3-> § 6§l" + newLvl), false);

		ToaFormats.printEmptyLine(player);

		ToamodModVariables.PlayerVariables capability = player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables());
		int unclaimedRewards = (int) switch (mileType) {
			case PATH_OF_THE_REAPER -> capability.comMilestoneRewardsClaimed;
			case DWARFS_WAY -> capability.minMilestoneRewardsClaimed;
		};
		player.displayClientMessage(Component.literal("§7You have " + unclaimedRewards + " unclaimed rewards, speak to " + mileType.RewardNPCName + " to collect.§r"), false);

		ToaFormats.printEmptyLine(player);
		ToaFormats.printSeperationLine(player);

	}

}
