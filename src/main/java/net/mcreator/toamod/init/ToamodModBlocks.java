
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
import net.mcreator.toamod.block.SoundAreaSwitchBlock;
import net.mcreator.toamod.block.OreRespawnStoneBlock;
import net.mcreator.toamod.block.MagmaBlock;
import net.mcreator.toamod.block.MagicCrafterBlock;
import net.mcreator.toamod.block.LogBlock;
import net.mcreator.toamod.block.JadeOreBlock;
import net.mcreator.toamod.block.IronOreBlock;
import net.mcreator.toamod.block.GoldOreBlock;
import net.mcreator.toamod.block.ForgerBlock;
import net.mcreator.toamod.block.EnhancmentTableBlock;
import net.mcreator.toamod.block.DecGrindstoneSideBlock;
import net.mcreator.toamod.block.DecGrindstoneDownBlock;
import net.mcreator.toamod.block.DecGrindstoneBlock;
import net.mcreator.toamod.block.DecCraftingTableBlock;
import net.mcreator.toamod.block.DecBarrelVerticalBlock;
import net.mcreator.toamod.block.DecBarrelHorizontalBlock;
import net.mcreator.toamod.block.DecAnvilBlock;
import net.mcreator.toamod.block.CursedObsidianBlock;
import net.mcreator.toamod.block.CristalOreBlock;
import net.mcreator.toamod.block.CreatureBarrierBlock;
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
	public static final RegistryObject<Block> CONTROL_BARRIER = REGISTRY.register("control_barrier", () -> new ControlBarrierBlock());
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
	public static final RegistryObject<Block> COOKING_TABLE = REGISTRY.register("cooking_table", () -> new CookingTableBlock());
	public static final RegistryObject<Block> ARMORY_TABLE = REGISTRY.register("armory_table", () -> new ArmoryTableBlock());
	public static final RegistryObject<Block> WEAPON_TABLE = REGISTRY.register("weapon_table", () -> new WeaponTableBlock());
	public static final RegistryObject<Block> DEC_CRAFTING_TABLE = REGISTRY.register("dec_crafting_table", () -> new DecCraftingTableBlock());
	public static final RegistryObject<Block> DEC_BARREL_VERTICAL = REGISTRY.register("dec_barrel_vertical", () -> new DecBarrelVerticalBlock());
	public static final RegistryObject<Block> DEC_BARREL_HORIZONTAL = REGISTRY.register("dec_barrel_horizontal",
			() -> new DecBarrelHorizontalBlock());
	public static final RegistryObject<Block> DEC_ANVIL = REGISTRY.register("dec_anvil", () -> new DecAnvilBlock());
	public static final RegistryObject<Block> DEC_GRINDSTONE = REGISTRY.register("dec_grindstone", () -> new DecGrindstoneBlock());
	public static final RegistryObject<Block> DEC_GRINDSTONE_DOWN = REGISTRY.register("dec_grindstone_down", () -> new DecGrindstoneDownBlock());
	public static final RegistryObject<Block> DEC_GRINDSTONE_SIDE = REGISTRY.register("dec_grindstone_side", () -> new DecGrindstoneSideBlock());
	public static final RegistryObject<Block> CREATURE_BARRIER = REGISTRY.register("creature_barrier", () -> new CreatureBarrierBlock());
	public static final RegistryObject<Block> SOUND_AREA_SWITCH = REGISTRY.register("sound_area_switch", () -> new SoundAreaSwitchBlock());
	public static final RegistryObject<Block> ENHANCMENT_TABLE = REGISTRY.register("enhancment_table", () -> new EnhancmentTableBlock());
	public static final RegistryObject<Block> MAGIC_CRAFTER = REGISTRY.register("magic_crafter", () -> new MagicCrafterBlock());
	public static final RegistryObject<Block> FORGER = REGISTRY.register("forger", () -> new ForgerBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ControlBarrierBlock.registerRenderLayer();
			ChestNormalBlock.registerRenderLayer();
			ChestEpicBlock.registerRenderLayer();
			ChestLegendaryBlock.registerRenderLayer();
			CookingTableBlock.registerRenderLayer();
			ArmoryTableBlock.registerRenderLayer();
			WeaponTableBlock.registerRenderLayer();
			DecAnvilBlock.registerRenderLayer();
			DecGrindstoneBlock.registerRenderLayer();
			DecGrindstoneDownBlock.registerRenderLayer();
			DecGrindstoneSideBlock.registerRenderLayer();
			CreatureBarrierBlock.registerRenderLayer();
			SoundAreaSwitchBlock.registerRenderLayer();
			ForgerBlock.registerRenderLayer();
		}
	}
}
