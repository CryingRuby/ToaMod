
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.toamod.client.gui.WeaponTableGuiScreen;
import net.mcreator.toamod.client.gui.SoundAreaSwitchGuiScreen;
import net.mcreator.toamod.client.gui.MiningMilestoneGuiScreen;
import net.mcreator.toamod.client.gui.HorseUpgradeGuiScreen;
import net.mcreator.toamod.client.gui.HorsePatternChangeGuiScreen;
import net.mcreator.toamod.client.gui.HorseColorChangeGuiScreen;
import net.mcreator.toamod.client.gui.ForgerGuiScreen;
import net.mcreator.toamod.client.gui.EnhancementTableGuiScreen;
import net.mcreator.toamod.client.gui.CookingTableGuiScreen;
import net.mcreator.toamod.client.gui.ControlBarrierGuiScreen;
import net.mcreator.toamod.client.gui.CombatMilestoneGuiScreen;
import net.mcreator.toamod.client.gui.ChestNormalGuiScreen;
import net.mcreator.toamod.client.gui.ChestLegendaryGuiScreen;
import net.mcreator.toamod.client.gui.ChestEpicGuiScreen;
import net.mcreator.toamod.client.gui.ArmoryTableGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ToamodModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ToamodModMenus.CHEST_NORMAL_GUI, ChestNormalGuiScreen::new);
			MenuScreens.register(ToamodModMenus.CHEST_EPIC_GUI, ChestEpicGuiScreen::new);
			MenuScreens.register(ToamodModMenus.CHEST_LEGENDARY_GUI, ChestLegendaryGuiScreen::new);
			MenuScreens.register(ToamodModMenus.CONTROL_BARRIER_GUI, ControlBarrierGuiScreen::new);
			MenuScreens.register(ToamodModMenus.ARMORY_TABLE_GUI, ArmoryTableGuiScreen::new);
			MenuScreens.register(ToamodModMenus.WEAPON_TABLE_GUI, WeaponTableGuiScreen::new);
			MenuScreens.register(ToamodModMenus.COOKING_TABLE_GUI, CookingTableGuiScreen::new);
			MenuScreens.register(ToamodModMenus.HORSE_UPGRADE_GUI, HorseUpgradeGuiScreen::new);
			MenuScreens.register(ToamodModMenus.ENHANCEMENT_TABLE_GUI, EnhancementTableGuiScreen::new);
			MenuScreens.register(ToamodModMenus.HORSE_COLOR_CHANGE_GUI, HorseColorChangeGuiScreen::new);
			MenuScreens.register(ToamodModMenus.HORSE_PATTERN_CHANGE_GUI, HorsePatternChangeGuiScreen::new);
			MenuScreens.register(ToamodModMenus.MINING_MILESTONE_GUI, MiningMilestoneGuiScreen::new);
			MenuScreens.register(ToamodModMenus.COMBAT_MILESTONE_GUI, CombatMilestoneGuiScreen::new);
			MenuScreens.register(ToamodModMenus.SOUND_AREA_SWITCH_GUI, SoundAreaSwitchGuiScreen::new);
			MenuScreens.register(ToamodModMenus.FORGER_GUI, ForgerGuiScreen::new);
		});
	}
}
