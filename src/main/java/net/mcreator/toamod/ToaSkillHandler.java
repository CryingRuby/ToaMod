package net.mcreator.toamod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.procedures.ChkPlayerLvlLevelUpProcedure;
import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.item.IronSwordItem;
import net.mcreator.toamod.item.HardenedIronSwordItem;
import net.mcreator.toamod.item.GoldenSwordItem;
import net.mcreator.toamod.enchantment.VampirismEnchantment;
import net.mcreator.toamod.enchantment.SpikesEnchantment;
import net.mcreator.toamod.enchantment.ShinyEnchantment;
import net.mcreator.toamod.enchantment.SharpnessEnchantment;
import net.mcreator.toamod.enchantment.ScavengerEnchantment;
import net.mcreator.toamod.enchantment.ProtectionEnchantment;
import net.mcreator.toamod.enchantment.PowerfulEnchantment;
import net.mcreator.toamod.enchantment.ManaflowEnchantment;
import net.mcreator.toamod.enchantment.MagicProtectionEnchantment;
import net.mcreator.toamod.enchantment.IgniteEnchantment;
import net.mcreator.toamod.enchantment.GrowthEnchantment;
import net.mcreator.toamod.enchantment.FortuneEnchantment;
import net.mcreator.toamod.enchantment.FocusEnchantment;
import net.mcreator.toamod.enchantment.ExecutingEnchantment;
import net.mcreator.toamod.enchantment.DivineGiftEnchantment;
import net.mcreator.toamod.enchantment.CriticalEnchantment;

import java.util.List;
import java.util.ArrayList;

public final class ToaSkillHandler {
	private ToaSkillHandler() {
	}

	public enum SkillType {
		COMBAT("Combat", "§7Kill mobs and bosses to gain Combat XP!"), 
		MINING("Mining", "§7Mine ores to gain Mining XP!"), 
		MAGIC("Magic", "§7Enchant items, find secrets and more to gain Magic XP"), 
		COOKING("Cooking", "§7Cook meals, gather ingredients and more to gain Cooking XP");

		public final String Name;
		public final String Description;

		SkillType(String _name, String _desc) {
			Name = _name;
			Description = _desc;
		}
	}

	public static final int[] XpForLevelUp = {50, 200, 500, 1000, 1500, 2000, 3500, 5000, 7500, 10_000, 15_000, 20_000, 30_000, 50_000, 75_000, 100_000, 200_000, 300_000, 400_000, 500_000, 600_000, 700_000, 800_000, 900_000, 1_000_000};
	public static final int[] CorRewOnLvlUp = {100, 500, 1000, 3000, 4000, 5000, 7500, 10_000, 15_000, 20_000, 25_000, 30_000, 40_000, 50_000, 65_000, 80_000, 100_000, 125_000, 150_000, 175_000, 200_000, 225_000, 250_000, 275_000, 300_000};
	public static final int MaxSkillLevel = 25;

	public static void addSkillXP(Player player, double xpAmount, SkillType skillType) {
		ToamodModVariables.PlayerVariables capability = (player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables()));
		double playerWisFac = 1 + StatHandler.getPlayerStats(player, new byte[]{4})[0] / 100;
		player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap -> {
			switch (skillType) {
				case COMBAT :
					cap.skillAttackXp += xpAmount;
					break;
				case MINING :
					cap.skillDefenseXp += xpAmount;
					break;
				case MAGIC :
					cap.skillMagicXp += xpAmount;
					break;
				case COOKING :
					cap.skillCookingXp += xpAmount;
					break;
				default :
			}
			capability.syncPlayerVariables(player);
		});
		levelUpIfPossible(player, skillType);
	}

	private static void levelUpIfPossible(Player player, SkillType skillType) {
		ToamodModVariables.PlayerVariables capability = (player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables()));
		final int skillLvl;
		int skillXp = -1;
		switch (skillType) {
			case COMBAT :
				skillLvl = (int) capability.skillAttackLvl;
				skillXp = (int) capability.skillAttackXp;
				break;
			case MINING :
				skillLvl = (int) capability.skillDefenseLvl;
				skillXp = (int) capability.skillDefenseXp;
				break;
			case MAGIC :
				skillLvl = (int) capability.skillMagicLvl;
				skillXp = (int) capability.skillMagicXp;
				break;
			case COOKING :
				skillLvl = (int) capability.skillCookingLvl;
				skillXp = (int) capability.skillCookingXp;
				break;
			default :
				return;
		}
		if (skillLvl >= MaxSkillLevel)
			return;
		//change player vars when lvl up
		if (skillXp >= XpForLevelUp[skillLvl]) {
			player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap -> {
				switch (skillType) {
					case COMBAT :
						cap.skillAttackLvl++;
						cap.skillAttackXp -= XpForLevelUp[skillLvl];
						break;
					case MINING :
						cap.skillDefenseLvl++;
						cap.skillDefenseXp -= XpForLevelUp[skillLvl];
						break;
					case MAGIC :
						cap.skillMagicLvl++;
						cap.skillMagicXp -= XpForLevelUp[skillLvl];
						break;
					case COOKING :
						cap.skillCookingLvl++;
						cap.skillCookingXp -= XpForLevelUp[skillLvl];
						break;
					default :
				}
				printSkillUpMsg(player, skillLvl + 1, skillType);
				//add player xp depending on skill-lvl
				capability.xp += 10 * Math.ceil((double) skillLvl / 10.0);
				ChkPlayerLvlLevelUpProcedure.execute(player);
				capability.syncPlayerVariables(player);
			});
		}
	}

	/**
	 * Actually applies the rewards of a specfific level of the skill
	 * @param the specific lvl the rewards are applied
	 * @param the type of skill the rewards are collected from
	 */
	public static void applySkillRewards(int lvl, SkillType skillType) {
		switch (skillType) {
			case COMBAT :
				applyAtkRewards(lvl);
				break;
			case MINING :
				applyDefRewards(lvl);
				break;
			case MAGIC :
				applyMagRewards(lvl);
				break;
			case COOKING :
				applyCookRewards(lvl);
				break;
			default :
		}
	}

	private static void applyAtkRewards(int lvl) {
	}

	private static void applyDefRewards(int lvl) {
	}

	private static void applyMagRewards(int lvl) {
	}

	private static void applyCookRewards(int lvl) {
	}

	/**
	 * Collects the rewards for a level (1-25 atm) of a skill. Lines are without any Prefix like "§8- "!
	 * @param the specific lvl the rewards are collected from
	 * @param the skill the rewards are collected from
	 * 
	 * @return the list of txt lines with each representing a reward (or multiple in case of enchants unlocked)
	 */
	public static List<String> getSkillRewardStrings(int lvl, SkillType skillType) {
		return switch (skillType) {
			case COMBAT -> getAtkRewardStrings(lvl);
			case MINING -> getDefRewardStrings(lvl);
			case MAGIC -> getMagRewardStrings(lvl);
			case COOKING -> getCookRewardStrings(lvl);
			default -> null;
		};
	}

	private static List<String> getAtkRewardStrings(int lvl) {
		ArrayList<String> rewards = new ArrayList<>();
		//Überlegung: Nicht einzelne Lvl von Enchants unlocken, sondern ganzes Enchant (alle Lvl) => Dann aber maybe im Magic Skill
		switch (lvl) {
			case 1 :
				addRewRecipe(rewards, new IronSwordItem());
				break;
			case 2 :
				addRewRecipe(rewards, new HardenedIronSwordItem());
				break;
			case 3 :
				addRewRecipe(rewards, new GoldenSwordItem());
				break;
			case 4 :
				//addRewRecipe(rewards, MithrilSwordItem::new);
				break;
			default :
		}
		rewards.add("§8- §7+§6" + CorRewOnLvlUp[lvl - 1]);
		int statIncrease = 3 * (lvl / 5 + 1);
		rewards.add("§8- §7+§c" + statIncrease + " §7Strength");
		rewards.add("§8- §7+§b" + statIncrease + " §7Intelligence");
		rewards.add("§8- §7+§41% §7Crit Rate");
		rewards.add("§8- §b+"+(10 * Math.ceil((double) lvl / 10.0))+" TOA XP");
		return rewards;
	}

	private static List<String> getDefRewardStrings(int lvl) {
		ArrayList<String> rewards = new ArrayList<>();
		switch (lvl) {
			case 1 :
				rewards.add("§8- §fIron Armor §7set recipe unlocked");
				break;
			case 2 :
				rewards.add("§8- §fHardened Iron Armor §7set recipe unlocked");
				break;
			case 3 :
				rewards.add("§8- §aGold Armor §7set recipe unlocked");
				break;
			case 4 :
				//addRewRecipe(rewards, MithrilArmorItem::new);
			default :
		}
		rewards.add("§8- §7+§6" + CorRewOnLvlUp[lvl - 1]);
		int statIncrease = 5 * (lvl / 5 + 1);
		rewards.add("§8- §7+§e" + statIncrease + " §7Armor");
		rewards.add("§8- §7+§9" + statIncrease + " §7Magic Res");
		rewards.add("§8- §7+§c5 §7Health");
		rewards.add("§8- §b+"+(10 * Math.ceil((double) lvl / 10.0))+" TOA XP");
		return rewards;
	}

	private static List<String> getMagRewardStrings(int lvl) {
		ArrayList<String> rewards = new ArrayList<>();
		switch (lvl) {
			case 1 :
				addRewEnchant(rewards, new SharpnessEnchantment());
				addRewEnchant(rewards, new PowerfulEnchantment());
			case 2 :
				addRewEnchant(rewards, new ProtectionEnchantment());
				addRewEnchant(rewards, new MagicProtectionEnchantment());
			case 3 :
				addRewEnchant(rewards, new ScavengerEnchantment());
				addRewEnchant(rewards, new ManaflowEnchantment());
			case 4 :
				addRewEnchant(rewards, new GrowthEnchantment());
			case 5 :
				addRewEnchant(rewards, new CriticalEnchantment());
				addRewEnchant(rewards, new FortuneEnchantment());
			case 6 :
				addRewEnchant(rewards, new IgniteEnchantment());
				addRewEnchant(rewards, new ShinyEnchantment());
			case 7 :
				addRewEnchant(rewards, new ExecutingEnchantment());
				addRewEnchant(rewards, new SpikesEnchantment());
			case 10 :
				addRewEnchant(rewards, new VampirismEnchantment());
			case 12 :
				addRewEnchant(rewards, new FocusEnchantment());
			case 15 :
				addRewEnchant(rewards, new DivineGiftEnchantment());
			case 16 :
			default :
		}
		rewards.add("§8- §7+§6" + CorRewOnLvlUp[lvl - 1]);
		int statIncrease = 5 * (lvl / 5 + 1);
		rewards.add("§8- §7+§3" + statIncrease + " §7Wisdom");
		rewards.add("§8- §b+"+(10 * Math.ceil((double) lvl / 10.0))+" TOA XP");
		return rewards;
	}

	private static List<String> getCookRewardStrings(int lvl) {
		ArrayList<String> rewards = new ArrayList<>();
		//COOMING SOON -> TODO
		rewards.add("§8- §7+§c5 §7Health");
		rewards.add("§8- §b+"+(10 * Math.ceil((double) lvl / 10.0)) + " TOA XP");
		return rewards;
	}

	/**
	 * Helper method to improve code visiblity.
	 * adds a recipe as a reward to the list.
	 * @param list the recipe is added to
	 * @param the item that is unlocked (the recipe of the item is added)
	 */
	private static void addRewRecipe(List<String> rewards, Item item) {
		rewards.add("§8- " + (new ItemStack(item)).getDisplayName() + " §7recipe unlocked");
	}

	/**
	 * Helper method to improve code visiblity.
	 * adds enchants as rewards to the list as ONE line.
	 * @param list the enchants are added to
	 * @param the enchants that are added 
	 */
	private static void addRewEnchant(List<String> rewards, ToaEnchantment enchant) {
		rewards.add("§8- §9" + enchant.getEnchantName() + " §7enchant unlocked");
	}

	public static void printSkillUpMsg(Player player, int newLvl, SkillType skillType) {
		if (newLvl < 1)
			return;
		ToaFormats.printSeperationLine(player);
		ToaFormats.printEmptyLine(player);

		player.displayClientMessage(Component.literal("§3" + skillType.Name + " Skill:"), false);
		player.displayClientMessage(Component.literal("§6" + (newLvl - 1) + " §3-> § 6§l" + newLvl), false);

		ToaFormats.printEmptyLine(player);

		player.displayClientMessage(Component.literal("§3Rewards:"), false);
		List<String> rewards = getSkillRewardStrings(newLvl, skillType);
		if (rewards == null)
			return;
		for (int i = 0; i < rewards.size(); i++) {
			player.displayClientMessage(Component.literal(rewards.get(i)), false);
		}

		ToaFormats.printEmptyLine(player);
		ToaFormats.printSeperationLine(player);
	}

}
