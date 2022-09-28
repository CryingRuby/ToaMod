
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.toamod.world.inventory.WeaponTableGuiMenu;
import net.mcreator.toamod.world.inventory.SoundAreaSwitchGuiMenu;
import net.mcreator.toamod.world.inventory.MiningMilestoneGuiMenu;
import net.mcreator.toamod.world.inventory.HorseUpgradeGuiMenu;
import net.mcreator.toamod.world.inventory.HorsePatternChangeGuiMenu;
import net.mcreator.toamod.world.inventory.HorseColorChangeGuiMenu;
import net.mcreator.toamod.world.inventory.ForgerGuiMenu;
import net.mcreator.toamod.world.inventory.EnhancementTableGuiMenu;
import net.mcreator.toamod.world.inventory.CookingTableGuiMenu;
import net.mcreator.toamod.world.inventory.ControlBarrierGuiMenu;
import net.mcreator.toamod.world.inventory.CombatMilestoneGuiMenu;
import net.mcreator.toamod.world.inventory.ChestNormalGuiMenu;
import net.mcreator.toamod.world.inventory.ChestLegendaryGuiMenu;
import net.mcreator.toamod.world.inventory.ChestEpicGuiMenu;
import net.mcreator.toamod.world.inventory.ArmoryTableGuiMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ToamodModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<ChestNormalGuiMenu> CHEST_NORMAL_GUI = register("chest_normal_gui",
			(id, inv, extraData) -> new ChestNormalGuiMenu(id, inv, extraData));
	public static final MenuType<ChestEpicGuiMenu> CHEST_EPIC_GUI = register("chest_epic_gui",
			(id, inv, extraData) -> new ChestEpicGuiMenu(id, inv, extraData));
	public static final MenuType<ChestLegendaryGuiMenu> CHEST_LEGENDARY_GUI = register("chest_legendary_gui",
			(id, inv, extraData) -> new ChestLegendaryGuiMenu(id, inv, extraData));
	public static final MenuType<ControlBarrierGuiMenu> CONTROL_BARRIER_GUI = register("control_barrier_gui",
			(id, inv, extraData) -> new ControlBarrierGuiMenu(id, inv, extraData));
	public static final MenuType<ArmoryTableGuiMenu> ARMORY_TABLE_GUI = register("armory_table_gui",
			(id, inv, extraData) -> new ArmoryTableGuiMenu(id, inv, extraData));
	public static final MenuType<WeaponTableGuiMenu> WEAPON_TABLE_GUI = register("weapon_table_gui",
			(id, inv, extraData) -> new WeaponTableGuiMenu(id, inv, extraData));
	public static final MenuType<CookingTableGuiMenu> COOKING_TABLE_GUI = register("cooking_table_gui",
			(id, inv, extraData) -> new CookingTableGuiMenu(id, inv, extraData));
	public static final MenuType<HorseUpgradeGuiMenu> HORSE_UPGRADE_GUI = register("horse_upgrade_gui",
			(id, inv, extraData) -> new HorseUpgradeGuiMenu(id, inv, extraData));
	public static final MenuType<EnhancementTableGuiMenu> ENHANCEMENT_TABLE_GUI = register("enhancement_table_gui",
			(id, inv, extraData) -> new EnhancementTableGuiMenu(id, inv, extraData));
	public static final MenuType<HorseColorChangeGuiMenu> HORSE_COLOR_CHANGE_GUI = register("horse_color_change_gui",
			(id, inv, extraData) -> new HorseColorChangeGuiMenu(id, inv, extraData));
	public static final MenuType<HorsePatternChangeGuiMenu> HORSE_PATTERN_CHANGE_GUI = register("horse_pattern_change_gui",
			(id, inv, extraData) -> new HorsePatternChangeGuiMenu(id, inv, extraData));
	public static final MenuType<MiningMilestoneGuiMenu> MINING_MILESTONE_GUI = register("mining_milestone_gui",
			(id, inv, extraData) -> new MiningMilestoneGuiMenu(id, inv, extraData));
	public static final MenuType<CombatMilestoneGuiMenu> COMBAT_MILESTONE_GUI = register("combat_milestone_gui",
			(id, inv, extraData) -> new CombatMilestoneGuiMenu(id, inv, extraData));
	public static final MenuType<SoundAreaSwitchGuiMenu> SOUND_AREA_SWITCH_GUI = register("sound_area_switch_gui",
			(id, inv, extraData) -> new SoundAreaSwitchGuiMenu(id, inv, extraData));
	public static final MenuType<ForgerGuiMenu> FORGER_GUI = register("forger_gui", (id, inv, extraData) -> new ForgerGuiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
