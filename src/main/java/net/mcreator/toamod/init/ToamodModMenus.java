
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.toamod.world.inventory.SkillsMenuMenu;
import net.mcreator.toamod.world.inventory.PlayerStatsMenuMenu;
import net.mcreator.toamod.world.inventory.PlayerRecipesItemInventoryMenu;
import net.mcreator.toamod.world.inventory.PlayerProfileMenu;
import net.mcreator.toamod.world.inventory.MiningMilestoneGuiMenu;
import net.mcreator.toamod.world.inventory.MinSkillRewardsMenuMenu;
import net.mcreator.toamod.world.inventory.MilestonesMenuMenu;
import net.mcreator.toamod.world.inventory.MagicCrafterGuiMenu;
import net.mcreator.toamod.world.inventory.MagSkillRewardsMenuMenu;
import net.mcreator.toamod.world.inventory.IllfangRngDropsMenuMenu;
import net.mcreator.toamod.world.inventory.HorseUpgradeGuiMenu;
import net.mcreator.toamod.world.inventory.HorsePatternChangeGuiMenu;
import net.mcreator.toamod.world.inventory.HorseColorChangeGuiMenu;
import net.mcreator.toamod.world.inventory.ForgerStarsMenu;
import net.mcreator.toamod.world.inventory.ForgerStackableMenu;
import net.mcreator.toamod.world.inventory.ForgerRunesMenu;
import net.mcreator.toamod.world.inventory.ForgerReforgeMenu;
import net.mcreator.toamod.world.inventory.ForgerPrestigeMenu;
import net.mcreator.toamod.world.inventory.ForgerGuiMenu;
import net.mcreator.toamod.world.inventory.FighterMilestoneRewardsMenuMenu;
import net.mcreator.toamod.world.inventory.EnhancementTableGuiMenu;
import net.mcreator.toamod.world.inventory.DwarvesWayMilestoneRewardsMenuMenu;
import net.mcreator.toamod.world.inventory.CookingTableGuiMenu;
import net.mcreator.toamod.world.inventory.CookSkillRewardsMenuMenu;
import net.mcreator.toamod.world.inventory.ControlBarrierGuiMenu;
import net.mcreator.toamod.world.inventory.CombatMilestoneGuiMenu;
import net.mcreator.toamod.world.inventory.ComSkillRewardsMenuMenu;
import net.mcreator.toamod.world.inventory.CollectionMenuMenu;
import net.mcreator.toamod.world.inventory.ChestNormalGuiMenu;
import net.mcreator.toamod.world.inventory.ChestLegendaryGuiMenu;
import net.mcreator.toamod.world.inventory.ChestEpicGuiMenu;
import net.mcreator.toamod.world.inventory.BlacksmithTableGuiMenu;
import net.mcreator.toamod.world.inventory.ArtefactsMenuMenu;
import net.mcreator.toamod.ToamodMod;

public class ToamodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ToamodMod.MODID);
	public static final RegistryObject<MenuType<ChestNormalGuiMenu>> CHEST_NORMAL_GUI = REGISTRY.register("chest_normal_gui", () -> IForgeMenuType.create(ChestNormalGuiMenu::new));
	public static final RegistryObject<MenuType<ChestEpicGuiMenu>> CHEST_EPIC_GUI = REGISTRY.register("chest_epic_gui", () -> IForgeMenuType.create(ChestEpicGuiMenu::new));
	public static final RegistryObject<MenuType<ChestLegendaryGuiMenu>> CHEST_LEGENDARY_GUI = REGISTRY.register("chest_legendary_gui", () -> IForgeMenuType.create(ChestLegendaryGuiMenu::new));
	public static final RegistryObject<MenuType<ControlBarrierGuiMenu>> CONTROL_BARRIER_GUI = REGISTRY.register("control_barrier_gui", () -> IForgeMenuType.create(ControlBarrierGuiMenu::new));
	public static final RegistryObject<MenuType<CookingTableGuiMenu>> COOKING_TABLE_GUI = REGISTRY.register("cooking_table_gui", () -> IForgeMenuType.create(CookingTableGuiMenu::new));
	public static final RegistryObject<MenuType<HorseUpgradeGuiMenu>> HORSE_UPGRADE_GUI = REGISTRY.register("horse_upgrade_gui", () -> IForgeMenuType.create(HorseUpgradeGuiMenu::new));
	public static final RegistryObject<MenuType<EnhancementTableGuiMenu>> ENHANCEMENT_TABLE_GUI = REGISTRY.register("enhancement_table_gui", () -> IForgeMenuType.create(EnhancementTableGuiMenu::new));
	public static final RegistryObject<MenuType<HorseColorChangeGuiMenu>> HORSE_COLOR_CHANGE_GUI = REGISTRY.register("horse_color_change_gui", () -> IForgeMenuType.create(HorseColorChangeGuiMenu::new));
	public static final RegistryObject<MenuType<HorsePatternChangeGuiMenu>> HORSE_PATTERN_CHANGE_GUI = REGISTRY.register("horse_pattern_change_gui", () -> IForgeMenuType.create(HorsePatternChangeGuiMenu::new));
	public static final RegistryObject<MenuType<MiningMilestoneGuiMenu>> MINING_MILESTONE_GUI = REGISTRY.register("mining_milestone_gui", () -> IForgeMenuType.create(MiningMilestoneGuiMenu::new));
	public static final RegistryObject<MenuType<CombatMilestoneGuiMenu>> COMBAT_MILESTONE_GUI = REGISTRY.register("combat_milestone_gui", () -> IForgeMenuType.create(CombatMilestoneGuiMenu::new));
	public static final RegistryObject<MenuType<BlacksmithTableGuiMenu>> BLACKSMITH_TABLE_GUI = REGISTRY.register("blacksmith_table_gui", () -> IForgeMenuType.create(BlacksmithTableGuiMenu::new));
	public static final RegistryObject<MenuType<MagicCrafterGuiMenu>> MAGIC_CRAFTER_GUI = REGISTRY.register("magic_crafter_gui", () -> IForgeMenuType.create(MagicCrafterGuiMenu::new));
	public static final RegistryObject<MenuType<PlayerProfileMenu>> PLAYER_PROFILE = REGISTRY.register("player_profile", () -> IForgeMenuType.create(PlayerProfileMenu::new));
	public static final RegistryObject<MenuType<ArtefactsMenuMenu>> ARTEFACTS_MENU = REGISTRY.register("artefacts_menu", () -> IForgeMenuType.create(ArtefactsMenuMenu::new));
	public static final RegistryObject<MenuType<SkillsMenuMenu>> SKILLS_MENU = REGISTRY.register("skills_menu", () -> IForgeMenuType.create(SkillsMenuMenu::new));
	public static final RegistryObject<MenuType<MilestonesMenuMenu>> MILESTONES_MENU = REGISTRY.register("milestones_menu", () -> IForgeMenuType.create(MilestonesMenuMenu::new));
	public static final RegistryObject<MenuType<CollectionMenuMenu>> COLLECTION_MENU = REGISTRY.register("collection_menu", () -> IForgeMenuType.create(CollectionMenuMenu::new));
	public static final RegistryObject<MenuType<ComSkillRewardsMenuMenu>> COM_SKILL_REWARDS_MENU = REGISTRY.register("com_skill_rewards_menu", () -> IForgeMenuType.create(ComSkillRewardsMenuMenu::new));
	public static final RegistryObject<MenuType<MagSkillRewardsMenuMenu>> MAG_SKILL_REWARDS_MENU = REGISTRY.register("mag_skill_rewards_menu", () -> IForgeMenuType.create(MagSkillRewardsMenuMenu::new));
	public static final RegistryObject<MenuType<CookSkillRewardsMenuMenu>> COOK_SKILL_REWARDS_MENU = REGISTRY.register("cook_skill_rewards_menu", () -> IForgeMenuType.create(CookSkillRewardsMenuMenu::new));
	public static final RegistryObject<MenuType<FighterMilestoneRewardsMenuMenu>> FIGHTER_MILESTONE_REWARDS_MENU = REGISTRY.register("fighter_milestone_rewards_menu", () -> IForgeMenuType.create(FighterMilestoneRewardsMenuMenu::new));
	public static final RegistryObject<MenuType<DwarvesWayMilestoneRewardsMenuMenu>> DWARVES_WAY_MILESTONE_REWARDS_MENU = REGISTRY.register("dwarves_way_milestone_rewards_menu", () -> IForgeMenuType.create(DwarvesWayMilestoneRewardsMenuMenu::new));
	public static final RegistryObject<MenuType<MinSkillRewardsMenuMenu>> MIN_SKILL_REWARDS_MENU = REGISTRY.register("min_skill_rewards_menu", () -> IForgeMenuType.create(MinSkillRewardsMenuMenu::new));
	public static final RegistryObject<MenuType<PlayerStatsMenuMenu>> PLAYER_STATS_MENU = REGISTRY.register("player_stats_menu", () -> IForgeMenuType.create(PlayerStatsMenuMenu::new));
	public static final RegistryObject<MenuType<IllfangRngDropsMenuMenu>> ILLFANG_RNG_DROPS_MENU = REGISTRY.register("illfang_rng_drops_menu", () -> IForgeMenuType.create(IllfangRngDropsMenuMenu::new));
	public static final RegistryObject<MenuType<PlayerRecipesItemInventoryMenu>> PLAYER_RECIPES_ITEM_INVENTORY = REGISTRY.register("player_recipes_item_inventory", () -> IForgeMenuType.create(PlayerRecipesItemInventoryMenu::new));
	public static final RegistryObject<MenuType<ForgerGuiMenu>> FORGER_GUI = REGISTRY.register("forger_gui", () -> IForgeMenuType.create(ForgerGuiMenu::new));
	public static final RegistryObject<MenuType<ForgerReforgeMenu>> FORGER_REFORGE = REGISTRY.register("forger_reforge", () -> IForgeMenuType.create(ForgerReforgeMenu::new));
	public static final RegistryObject<MenuType<ForgerRunesMenu>> FORGER_RUNES = REGISTRY.register("forger_runes", () -> IForgeMenuType.create(ForgerRunesMenu::new));
	public static final RegistryObject<MenuType<ForgerStarsMenu>> FORGER_STARS = REGISTRY.register("forger_stars", () -> IForgeMenuType.create(ForgerStarsMenu::new));
	public static final RegistryObject<MenuType<ForgerStackableMenu>> FORGER_STACKABLE = REGISTRY.register("forger_stackable", () -> IForgeMenuType.create(ForgerStackableMenu::new));
	public static final RegistryObject<MenuType<ForgerPrestigeMenu>> FORGER_PRESTIGE = REGISTRY.register("forger_prestige", () -> IForgeMenuType.create(ForgerPrestigeMenu::new));
}
