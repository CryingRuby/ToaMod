
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.toamod.client.gui.SkillsMenuScreen;
import net.mcreator.toamod.client.gui.PlayerStatsMenuScreen;
import net.mcreator.toamod.client.gui.PlayerRecipesItemInventoryScreen;
import net.mcreator.toamod.client.gui.PlayerProfileScreen;
import net.mcreator.toamod.client.gui.MiningMilestoneGuiScreen;
import net.mcreator.toamod.client.gui.MinSkillRewardsMenuScreen;
import net.mcreator.toamod.client.gui.MilestonesMenuScreen;
import net.mcreator.toamod.client.gui.MagicCrafterGuiScreen;
import net.mcreator.toamod.client.gui.MagSkillRewardsMenuScreen;
import net.mcreator.toamod.client.gui.IllfangRngDropsMenuScreen;
import net.mcreator.toamod.client.gui.HorseUpgradeGuiScreen;
import net.mcreator.toamod.client.gui.HorsePatternChangeGuiScreen;
import net.mcreator.toamod.client.gui.HorseColorChangeGuiScreen;
import net.mcreator.toamod.client.gui.ForgerStarsScreen;
import net.mcreator.toamod.client.gui.ForgerStackableScreen;
import net.mcreator.toamod.client.gui.ForgerRunesScreen;
import net.mcreator.toamod.client.gui.ForgerReforgeScreen;
import net.mcreator.toamod.client.gui.ForgerPrestigeScreen;
import net.mcreator.toamod.client.gui.ForgerGuiScreen;
import net.mcreator.toamod.client.gui.ForgerEnchantsScreen;
import net.mcreator.toamod.client.gui.ForgerEnchantsApplyScreen;
import net.mcreator.toamod.client.gui.FighterMilestoneRewardsMenuScreen;
import net.mcreator.toamod.client.gui.EnhancementTableGuiScreen;
import net.mcreator.toamod.client.gui.DwarvesWayMilestoneRewardsMenuScreen;
import net.mcreator.toamod.client.gui.CookingTableGuiScreen;
import net.mcreator.toamod.client.gui.CookSkillRewardsMenuScreen;
import net.mcreator.toamod.client.gui.ControlBarrierGuiScreen;
import net.mcreator.toamod.client.gui.CombatMilestoneGuiScreen;
import net.mcreator.toamod.client.gui.ComSkillRewardsMenuScreen;
import net.mcreator.toamod.client.gui.CollectionMenuScreen;
import net.mcreator.toamod.client.gui.ChestNormalGuiScreen;
import net.mcreator.toamod.client.gui.ChestLegendaryGuiScreen;
import net.mcreator.toamod.client.gui.ChestEpicGuiScreen;
import net.mcreator.toamod.client.gui.BlacksmithTableGuiScreen;
import net.mcreator.toamod.client.gui.ArtefactsMenuScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ToamodModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ToamodModMenus.CHEST_NORMAL_GUI.get(), ChestNormalGuiScreen::new);
			MenuScreens.register(ToamodModMenus.CHEST_EPIC_GUI.get(), ChestEpicGuiScreen::new);
			MenuScreens.register(ToamodModMenus.CHEST_LEGENDARY_GUI.get(), ChestLegendaryGuiScreen::new);
			MenuScreens.register(ToamodModMenus.CONTROL_BARRIER_GUI.get(), ControlBarrierGuiScreen::new);
			MenuScreens.register(ToamodModMenus.COOKING_TABLE_GUI.get(), CookingTableGuiScreen::new);
			MenuScreens.register(ToamodModMenus.HORSE_UPGRADE_GUI.get(), HorseUpgradeGuiScreen::new);
			MenuScreens.register(ToamodModMenus.ENHANCEMENT_TABLE_GUI.get(), EnhancementTableGuiScreen::new);
			MenuScreens.register(ToamodModMenus.HORSE_COLOR_CHANGE_GUI.get(), HorseColorChangeGuiScreen::new);
			MenuScreens.register(ToamodModMenus.HORSE_PATTERN_CHANGE_GUI.get(), HorsePatternChangeGuiScreen::new);
			MenuScreens.register(ToamodModMenus.MINING_MILESTONE_GUI.get(), MiningMilestoneGuiScreen::new);
			MenuScreens.register(ToamodModMenus.COMBAT_MILESTONE_GUI.get(), CombatMilestoneGuiScreen::new);
			MenuScreens.register(ToamodModMenus.BLACKSMITH_TABLE_GUI.get(), BlacksmithTableGuiScreen::new);
			MenuScreens.register(ToamodModMenus.MAGIC_CRAFTER_GUI.get(), MagicCrafterGuiScreen::new);
			MenuScreens.register(ToamodModMenus.PLAYER_PROFILE.get(), PlayerProfileScreen::new);
			MenuScreens.register(ToamodModMenus.ARTEFACTS_MENU.get(), ArtefactsMenuScreen::new);
			MenuScreens.register(ToamodModMenus.SKILLS_MENU.get(), SkillsMenuScreen::new);
			MenuScreens.register(ToamodModMenus.MILESTONES_MENU.get(), MilestonesMenuScreen::new);
			MenuScreens.register(ToamodModMenus.COLLECTION_MENU.get(), CollectionMenuScreen::new);
			MenuScreens.register(ToamodModMenus.COM_SKILL_REWARDS_MENU.get(), ComSkillRewardsMenuScreen::new);
			MenuScreens.register(ToamodModMenus.MAG_SKILL_REWARDS_MENU.get(), MagSkillRewardsMenuScreen::new);
			MenuScreens.register(ToamodModMenus.COOK_SKILL_REWARDS_MENU.get(), CookSkillRewardsMenuScreen::new);
			MenuScreens.register(ToamodModMenus.FIGHTER_MILESTONE_REWARDS_MENU.get(), FighterMilestoneRewardsMenuScreen::new);
			MenuScreens.register(ToamodModMenus.DWARVES_WAY_MILESTONE_REWARDS_MENU.get(), DwarvesWayMilestoneRewardsMenuScreen::new);
			MenuScreens.register(ToamodModMenus.MIN_SKILL_REWARDS_MENU.get(), MinSkillRewardsMenuScreen::new);
			MenuScreens.register(ToamodModMenus.PLAYER_STATS_MENU.get(), PlayerStatsMenuScreen::new);
			MenuScreens.register(ToamodModMenus.ILLFANG_RNG_DROPS_MENU.get(), IllfangRngDropsMenuScreen::new);
			MenuScreens.register(ToamodModMenus.PLAYER_RECIPES_ITEM_INVENTORY.get(), PlayerRecipesItemInventoryScreen::new);
			MenuScreens.register(ToamodModMenus.FORGER_GUI.get(), ForgerGuiScreen::new);
			MenuScreens.register(ToamodModMenus.FORGER_REFORGE.get(), ForgerReforgeScreen::new);
			MenuScreens.register(ToamodModMenus.FORGER_RUNES.get(), ForgerRunesScreen::new);
			MenuScreens.register(ToamodModMenus.FORGER_STARS.get(), ForgerStarsScreen::new);
			MenuScreens.register(ToamodModMenus.FORGER_STACKABLE.get(), ForgerStackableScreen::new);
			MenuScreens.register(ToamodModMenus.FORGER_PRESTIGE.get(), ForgerPrestigeScreen::new);
			MenuScreens.register(ToamodModMenus.FORGER_ENCHANTS.get(), ForgerEnchantsScreen::new);
			MenuScreens.register(ToamodModMenus.FORGER_ENCHANTS_APPLY.get(), ForgerEnchantsApplyScreen::new);
		});
	}
}
