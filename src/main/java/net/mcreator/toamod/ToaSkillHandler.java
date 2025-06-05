package net.mcreator.toamod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

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

	enum SkillType {
		COMBAT("Combat"), MINING("Mining"), MAGIC("Magic"), COOKING("Cooking");

		public final String Name;

		SkillType(String _name) {
			Name = _name;
		}
	}

	public static final int[] XpForLevelUp = {50, 125, 200, 300, 500, 750, 1000, 1500, 2000, 3500, 5000, 7500, 10_000, 15_000, 20_000, 30_000, 50_000, 75_000, 100_000, 200_000, 300_000, 400_000, 500_000, 600_000, 700_000};
	public static final int[] CorRewOnLvlUp = {250, 500, 750, 1000, 2000, 3000, 4000, 5000, 7500, 10_000, 15_000, 20_000, 25_000, 30_000, 40_000, 50_000, 65_000, 80_000, 100_000, 125_000, 150_000, 175_000, 200_000, 225_000, 250_000};
	public static final int MaxSkillLevel = 25;

	public static void addSkillXP(ServerPlayer player, int xpAmount, SkillType skillType) {
		ToamodModVariables.PlayerVariables capability = (player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables()));
		int skillXp = switch (skillType) {
			case COMBAT -> (int) capability.skillAttackXp;
			case MINING -> (int) capability.skillDefenseXp;
			case MAGIC -> (int) capability.skillMagicXp;
			case COOKING -> (int) capability.skillCookingXp;
			default -> 0;
		};
		levelUpIfPossible(player, skillXp, skillType);
	}

	private static void levelUpIfPossible(ServerPlayer player, int skillXp, SkillType skillType) {
		ToamodModVariables.PlayerVariables capability = (player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables()));
		int skillLvl = switch (skillType) {
			case COMBAT -> (int) capability.skillAttackLvl;
			case MINING -> (int) capability.skillDefenseLvl;
			case MAGIC -> (int) capability.skillMagicLvl;
			case COOKING -> (int) capability.skillCookingLvl;
			default -> 0;
		};
		if (skillLvl >= MaxSkillLevel)
			return;
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
				capability.syncPlayerVariables(player);
			});
		}
	}

	/**
	 * Actually applies the rewards of a specfific level of the skill
	 * @param the specific lvl the rewards are applied
	 * @param the type of skill the rewards are collected from
	 */
	public static void applySkillRewards(int lvl, SkillType skilltype) {
		switch (skilltype) {
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
	public static List<Component> getSkillRewardStrings(int lvl, SkillType skilltype) {
		return switch (skilltype) {
			case COMBAT -> getAtkRewardStrings(lvl);
			case MINING -> getDefRewardStrings(lvl);
			case MAGIC -> getMagRewardStrings(lvl);
			case COOKING -> getCookRewardStrings(lvl);
			default -> null;
		};
	}

	private static List<Component> getAtkRewardStrings(int lvl) {
		ArrayList<Component> rewards = new ArrayList<>();
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
		rewards.add(Component.literal("§8- §7+§6" + CorRewOnLvlUp[lvl - 1]));
		int statIncrease = 3 * (lvl / 5 + 1);
		rewards.add(Component.literal("§8- §7+§c" + statIncrease + " §7Strength"));
		rewards.add(Component.literal("§8- §7+§b" + statIncrease + " §7Intelligence"));
		rewards.add(Component.literal("§8- §7+§41% §7Crit Rate"));
		return rewards;
	}

	private static List<Component> getDefRewardStrings(int lvl) {
		ArrayList<Component> rewards = new ArrayList<>();
		switch (lvl) {
			case 1 :
				rewards.add(Component.literal("§8- §fIron Armor §7set recipe unlocked"));
				break;
			case 2 :
				rewards.add(Component.literal("§8- §fHardened Iron Armor §7set recipe unlocked"));
				break;
			case 3 :
				rewards.add(Component.literal("§8- §aGold Armor §7set recipe unlocked"));
				break;
			case 4 :
				//addRewRecipe(rewards, MithrilArmorItem::new);
			default :
		}
		rewards.add(Component.literal("§8- §7+§6" + CorRewOnLvlUp[lvl - 1]));
		int statIncrease = 5 * (lvl / 5 + 1);
		rewards.add(Component.literal("§8- §7+§e" + statIncrease + " §7Armor"));
		rewards.add(Component.literal("§8- §7+§9" + statIncrease + " §7Magic Res"));
		rewards.add(Component.literal("§8- §7+§c5 §7Health"));
		return rewards;
	}

	private static List<Component> getMagRewardStrings(int lvl) {
		ArrayList<Component> rewards = new ArrayList<>();
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
		rewards.add(Component.literal("§8- §7+§6" + CorRewOnLvlUp[lvl - 1]));
		int statIncrease = 5 * (lvl / 5 + 1);
		rewards.add(Component.literal("§8- §7+§3" + statIncrease + " §7Wisdom"));
		return rewards;
	}

	private static List<Component> getCookRewardStrings(int lvl) {
		ArrayList<Component> rewards = new ArrayList<>();
		//COOMING SOON -> TODO
		rewards.add(Component.literal("§8- §7+§c5 §7Health"));
		return rewards;
	}

	/**
	 * Helper method to improve code visiblity.
	 * adds a recipe as a reward to the list.
	 * @param list the recipe is added to
	 * @param the item that is unlocked (the recipe of the item is added)
	 */
	private static void addRewRecipe(List<Component> rewards, Item item) {
		rewards.add(Component.literal("§8- " + (new ItemStack(item)).getDisplayName() + " §7recipe unlocked"));
	}

	/**
	 * Helper method to improve code visiblity.
	 * adds enchants as rewards to the list as ONE line.
	 * @param list the enchants are added to
	 * @param the enchants that are added 
	 */
	private static void addRewEnchant(List<Component> rewards, ToaEnchantment enchant) {
		rewards.add(Component.literal("§8- §9" + enchant.getEnchantName() + " §7enchant unlocked"));
	}

	public static void printSkillUpMsg(Player player, int newLvl, SkillType skilltype) {
		if (newLvl < 1)
			return;
		printSeperationLine(player);
		printEmptyLine(player);
		player.displayClientMessage(Component.literal("§3" + skilltype.Name + " Skill:"), false);
		player.displayClientMessage(Component.literal("§6" + (newLvl - 1) + " §3-> § 6§l" + newLvl), false);
		printEmptyLine(player);
		player.displayClientMessage(Component.literal("§3Rewards:"), false);
		List<Component> rewards = getSkillRewardStrings(newLvl, skilltype);
		if (rewards == null)
			return;
		for (int i = 0; i < rewards.size(); i++) {
			player.displayClientMessage(rewards.get(i), false);
		}
		printEmptyLine(player);
		printSeperationLine(player);
	}

	public static void printSeperationLine(Player player) {
		player.displayClientMessage(Component.literal("§3-----------------------------------------------------"), false); //54x '-'
	}

	public static void printEmptyLine(Player player) {
		player.displayClientMessage(Component.literal(" "), false);
	}
}
