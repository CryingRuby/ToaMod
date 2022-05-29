
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.toamod.block.WeaponTableBlock;
import net.mcreator.toamod.block.UpgradingTableBlock;
import net.mcreator.toamod.block.OreRespawnStoneBlock;
import net.mcreator.toamod.block.MagmaBlock;
import net.mcreator.toamod.block.LogBlock;
import net.mcreator.toamod.block.JadeOreBlock;
import net.mcreator.toamod.block.IronOreBlock;
import net.mcreator.toamod.block.GoldOreBlock;
import net.mcreator.toamod.block.CursedObsidianBlock;
import net.mcreator.toamod.block.CristalOreBlock;
import net.mcreator.toamod.block.CookingTableBlock;
import net.mcreator.toamod.block.ControlBarrierBlock;
import net.mcreator.toamod.block.CoalOreBlock;
import net.mcreator.toamod.block.ChestNormalBlock;
import net.mcreator.toamod.block.ChestLegendaryBlock;
import net.mcreator.toamod.block.ChestEpicBlock;
import net.mcreator.toamod.block.ArmoryTableBlock;
import net.mcreator.toamod.ToamodMod;

public class ToamodModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ToamodMod.MODID);
	public static final RegistryObject<Block> LOG = REGISTRY.register("log", () -> new LogBlock());
	public static final RegistryObject<Block> ORE_RESPAWN_STONE = REGISTRY.register("ore_respawn_stone", () -> new OreRespawnStoneBlock());
	public static final RegistryObject<Block> COAL_ORE = REGISTRY.register("coal_ore", () -> new CoalOreBlock());
	public static final RegistryObject<Block> IRON_ORE = REGISTRY.register("iron_ore", () -> new IronOreBlock());
	public static final RegistryObject<Block> GOLD_ORE = REGISTRY.register("gold_ore", () -> new GoldOreBlock());
	public static final RegistryObject<Block> CRISTAL_ORE = REGISTRY.register("cristal_ore", () -> new CristalOreBlock());
	public static final RegistryObject<Block> JADE_ORE = REGISTRY.register("jade_ore", () -> new JadeOreBlock());
	public static final RegistryObject<Block> MAGMA = REGISTRY.register("magma", () -> new MagmaBlock());
	public static final RegistryObject<Block> CURSED_OBSIDIAN = REGISTRY.register("cursed_obsidian", () -> new CursedObsidianBlock());
	public static final RegistryObject<Block> CHEST_NORMAL = REGISTRY.register("chest_normal", () -> new ChestNormalBlock());
	public static final RegistryObject<Block> CHEST_EPIC = REGISTRY.register("chest_epic", () -> new ChestEpicBlock());
	public static final RegistryObject<Block> CHEST_LEGENDARY = REGISTRY.register("chest_legendary", () -> new ChestLegendaryBlock());
	public static final RegistryObject<Block> CONTROL_BARRIER = REGISTRY.register("control_barrier", () -> new ControlBarrierBlock());
	public static final RegistryObject<Block> UPGRADING_TABLE = REGISTRY.register("upgrading_table", () -> new UpgradingTableBlock());
	public static final RegistryObject<Block> COOKING_TABLE = REGISTRY.register("cooking_table", () -> new CookingTableBlock());
	public static final RegistryObject<Block> ARMORY_TABLE = REGISTRY.register("armory_table", () -> new ArmoryTableBlock());
	public static final RegistryObject<Block> WEAPON_TABLE = REGISTRY.register("weapon_table", () -> new WeaponTableBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ChestNormalBlock.registerRenderLayer();
			ChestEpicBlock.registerRenderLayer();
			ChestLegendaryBlock.registerRenderLayer();
			ControlBarrierBlock.registerRenderLayer();
			UpgradingTableBlock.registerRenderLayer();
			CookingTableBlock.registerRenderLayer();
			ArmoryTableBlock.registerRenderLayer();
			WeaponTableBlock.registerRenderLayer();
		}
	}
}
