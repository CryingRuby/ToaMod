
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.toamod.block.SmoothWarpedPlanksBlock;
import net.mcreator.toamod.block.SmoothSprucePlanksBlock;
import net.mcreator.toamod.block.SmoothOakPlanksBlock;
import net.mcreator.toamod.block.SmoothJunglePlanksBlock;
import net.mcreator.toamod.block.SmoothDarkOakPlanksBlock;
import net.mcreator.toamod.block.SmoothCrimsonPlanksBlock;
import net.mcreator.toamod.block.SmoothBirchPlanksBlock;
import net.mcreator.toamod.block.SmoothAcaciaPlanksBlock;
import net.mcreator.toamod.block.RespawnOreBlock;
import net.mcreator.toamod.block.PlayerBarrierBlock;
import net.mcreator.toamod.block.PestoGoblinOmletteBlock;
import net.mcreator.toamod.block.OreRespawnStoneBlock;
import net.mcreator.toamod.block.MithrilOreBlock;
import net.mcreator.toamod.block.MagmaBlock;
import net.mcreator.toamod.block.MagicCrafterBlock;
import net.mcreator.toamod.block.LogBlock;
import net.mcreator.toamod.block.JadeOreBlock;
import net.mcreator.toamod.block.IronOreBlock;
import net.mcreator.toamod.block.InvControlBarrierBlock;
import net.mcreator.toamod.block.HardStoneSlabBlock;
import net.mcreator.toamod.block.HardStoneBlock;
import net.mcreator.toamod.block.GoldOreBlock;
import net.mcreator.toamod.block.GoblinOmletteBlock;
import net.mcreator.toamod.block.ForgerBlock;
import net.mcreator.toamod.block.EnhancmentTableBlock;
import net.mcreator.toamod.block.EmpheiasSoulBlock;
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
import net.mcreator.toamod.block.CondensedIronBlockBlock;
import net.mcreator.toamod.block.CoalOreBlock;
import net.mcreator.toamod.block.ChestNormalBlock;
import net.mcreator.toamod.block.ChestLegendaryBlock;
import net.mcreator.toamod.block.ChestEpicBlock;
import net.mcreator.toamod.block.BlacksmithTableBlock;
import net.mcreator.toamod.ToamodMod;

public class ToamodModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ToamodMod.MODID);
	public static final RegistryObject<Block> CURSED_OBSIDIAN = REGISTRY.register("cursed_obsidian", () -> new CursedObsidianBlock());
	public static final RegistryObject<Block> MAGMA = REGISTRY.register("magma", () -> new MagmaBlock());
	public static final RegistryObject<Block> COAL_ORE = REGISTRY.register("coal_ore", () -> new CoalOreBlock());
	public static final RegistryObject<Block> IRON_ORE = REGISTRY.register("iron_ore", () -> new IronOreBlock());
	public static final RegistryObject<Block> GOLD_ORE = REGISTRY.register("gold_ore", () -> new GoldOreBlock());
	public static final RegistryObject<Block> JADE_ORE = REGISTRY.register("jade_ore", () -> new JadeOreBlock());
	public static final RegistryObject<Block> CRISTAL_ORE = REGISTRY.register("cristal_ore", () -> new CristalOreBlock());
	public static final RegistryObject<Block> CHEST_NORMAL = REGISTRY.register("chest_normal", () -> new ChestNormalBlock());
	public static final RegistryObject<Block> CHEST_EPIC = REGISTRY.register("chest_epic", () -> new ChestEpicBlock());
	public static final RegistryObject<Block> CHEST_LEGENDARY = REGISTRY.register("chest_legendary", () -> new ChestLegendaryBlock());
	public static final RegistryObject<Block> ORE_RESPAWN_STONE = REGISTRY.register("ore_respawn_stone", () -> new OreRespawnStoneBlock());
	public static final RegistryObject<Block> CONTROL_BARRIER = REGISTRY.register("control_barrier", () -> new ControlBarrierBlock());
	public static final RegistryObject<Block> COOKING_TABLE = REGISTRY.register("cooking_table", () -> new CookingTableBlock());
	public static final RegistryObject<Block> LOG = REGISTRY.register("log", () -> new LogBlock());
	public static final RegistryObject<Block> DEC_CRAFTING_TABLE = REGISTRY.register("dec_crafting_table", () -> new DecCraftingTableBlock());
	public static final RegistryObject<Block> DEC_BARREL_VERTICAL = REGISTRY.register("dec_barrel_vertical", () -> new DecBarrelVerticalBlock());
	public static final RegistryObject<Block> DEC_BARREL_HORIZONTAL = REGISTRY.register("dec_barrel_horizontal", () -> new DecBarrelHorizontalBlock());
	public static final RegistryObject<Block> DEC_ANVIL = REGISTRY.register("dec_anvil", () -> new DecAnvilBlock());
	public static final RegistryObject<Block> DEC_GRINDSTONE = REGISTRY.register("dec_grindstone", () -> new DecGrindstoneBlock());
	public static final RegistryObject<Block> DEC_GRINDSTONE_DOWN = REGISTRY.register("dec_grindstone_down", () -> new DecGrindstoneDownBlock());
	public static final RegistryObject<Block> DEC_GRINDSTONE_SIDE = REGISTRY.register("dec_grindstone_side", () -> new DecGrindstoneSideBlock());
	public static final RegistryObject<Block> CREATURE_BARRIER = REGISTRY.register("creature_barrier", () -> new CreatureBarrierBlock());
	public static final RegistryObject<Block> ENHANCMENT_TABLE = REGISTRY.register("enhancment_table", () -> new EnhancmentTableBlock());
	public static final RegistryObject<Block> MAGIC_CRAFTER = REGISTRY.register("magic_crafter", () -> new MagicCrafterBlock());
	public static final RegistryObject<Block> FORGER = REGISTRY.register("forger", () -> new ForgerBlock());
	public static final RegistryObject<Block> HARD_STONE = REGISTRY.register("hard_stone", () -> new HardStoneBlock());
	public static final RegistryObject<Block> HARD_STONE_SLAB = REGISTRY.register("hard_stone_slab", () -> new HardStoneSlabBlock());
	public static final RegistryObject<Block> GOBLIN_OMLETTE = REGISTRY.register("goblin_omlette", () -> new GoblinOmletteBlock());
	public static final RegistryObject<Block> PLAYER_BARRIER = REGISTRY.register("player_barrier", () -> new PlayerBarrierBlock());
	public static final RegistryObject<Block> PESTO_GOBLIN_OMLETTE = REGISTRY.register("pesto_goblin_omlette", () -> new PestoGoblinOmletteBlock());
	public static final RegistryObject<Block> INV_CONTROL_BARRIER = REGISTRY.register("inv_control_barrier", () -> new InvControlBarrierBlock());
	public static final RegistryObject<Block> SMOOTH_ACACIA_PLANKS = REGISTRY.register("smooth_acacia_planks", () -> new SmoothAcaciaPlanksBlock());
	public static final RegistryObject<Block> SMOOTH_BIRCH_PLANKS = REGISTRY.register("smooth_birch_planks", () -> new SmoothBirchPlanksBlock());
	public static final RegistryObject<Block> SMOOTH_CRIMSON_PLANKS = REGISTRY.register("smooth_crimson_planks", () -> new SmoothCrimsonPlanksBlock());
	public static final RegistryObject<Block> SMOOTH_DARK_OAK_PLANKS = REGISTRY.register("smooth_dark_oak_planks", () -> new SmoothDarkOakPlanksBlock());
	public static final RegistryObject<Block> SMOOTH_JUNGLE_PLANKS = REGISTRY.register("smooth_jungle_planks", () -> new SmoothJunglePlanksBlock());
	public static final RegistryObject<Block> SMOOTH_OAK_PLANKS = REGISTRY.register("smooth_oak_planks", () -> new SmoothOakPlanksBlock());
	public static final RegistryObject<Block> SMOOTH_WARPED_PLANKS = REGISTRY.register("smooth_warped_planks", () -> new SmoothWarpedPlanksBlock());
	public static final RegistryObject<Block> SMOOTH_SPRUCE_PLANKS = REGISTRY.register("smooth_spruce_planks", () -> new SmoothSprucePlanksBlock());
	public static final RegistryObject<Block> EMPHEIAS_SOUL = REGISTRY.register("empheias_soul", () -> new EmpheiasSoulBlock());
	public static final RegistryObject<Block> RESPAWN_ORE = REGISTRY.register("respawn_ore", () -> new RespawnOreBlock());
	public static final RegistryObject<Block> MITHRIL_ORE = REGISTRY.register("mithril_ore", () -> new MithrilOreBlock());
	public static final RegistryObject<Block> CONDENSED_IRON_BLOCK = REGISTRY.register("condensed_iron_block", () -> new CondensedIronBlockBlock());
	public static final RegistryObject<Block> BLACKSMITH_TABLE = REGISTRY.register("blacksmith_table", () -> new BlacksmithTableBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
