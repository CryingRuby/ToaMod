
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
import net.mcreator.toamod.client.gui.UpgradingTableGuiScreen;
import net.mcreator.toamod.client.gui.PlayerLevelTreeScreen;
import net.mcreator.toamod.client.gui.CookingTableGuiScreen;
import net.mcreator.toamod.client.gui.ControlBarrierGuiScreen;
import net.mcreator.toamod.client.gui.ChestNormalGuiScreen;
import net.mcreator.toamod.client.gui.ChestLegendaryGuiScreen;
import net.mcreator.toamod.client.gui.ChestEpicGuiScreen;
import net.mcreator.toamod.client.gui.ArmoryTableGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ToamodModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ToamodModMenus.UPGRADING_TABLE_GUI, UpgradingTableGuiScreen::new);
			MenuScreens.register(ToamodModMenus.CHEST_NORMAL_GUI, ChestNormalGuiScreen::new);
			MenuScreens.register(ToamodModMenus.CHEST_EPIC_GUI, ChestEpicGuiScreen::new);
			MenuScreens.register(ToamodModMenus.CHEST_LEGENDARY_GUI, ChestLegendaryGuiScreen::new);
			MenuScreens.register(ToamodModMenus.CONTROL_BARRIER_GUI, ControlBarrierGuiScreen::new);
			MenuScreens.register(ToamodModMenus.PLAYER_LEVEL_TREE, PlayerLevelTreeScreen::new);
			MenuScreens.register(ToamodModMenus.ARMORY_TABLE_GUI, ArmoryTableGuiScreen::new);
			MenuScreens.register(ToamodModMenus.WEAPON_TABLE_GUI, WeaponTableGuiScreen::new);
			MenuScreens.register(ToamodModMenus.COOKING_TABLE_GUI, CookingTableGuiScreen::new);
		});
	}
}
