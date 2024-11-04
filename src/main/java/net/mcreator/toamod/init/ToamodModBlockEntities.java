
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.toamod.block.entity.RespawnOreBlockEntity;
import net.mcreator.toamod.block.entity.PlayerBarrierBlockEntity;
import net.mcreator.toamod.block.entity.PestoGoblinOmletteBlockEntity;
import net.mcreator.toamod.block.entity.OreRespawnStoneBlockEntity;
import net.mcreator.toamod.block.entity.MagicCrafterBlockEntity;
import net.mcreator.toamod.block.entity.InvControlBarrierBlockEntity;
import net.mcreator.toamod.block.entity.GoblinOmletteBlockEntity;
import net.mcreator.toamod.block.entity.ForgerBlockEntity;
import net.mcreator.toamod.block.entity.EnhancmentTableBlockEntity;
import net.mcreator.toamod.block.entity.CreatureBarrierBlockEntity;
import net.mcreator.toamod.block.entity.CookingTableBlockEntity;
import net.mcreator.toamod.block.entity.ControlBarrierBlockEntity;
import net.mcreator.toamod.block.entity.ChestNormalBlockEntity;
import net.mcreator.toamod.block.entity.ChestLegendaryBlockEntity;
import net.mcreator.toamod.block.entity.ChestEpicBlockEntity;
import net.mcreator.toamod.block.entity.BlacksmithTableBlockEntity;
import net.mcreator.toamod.ToamodMod;

public class ToamodModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ToamodMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> CHEST_NORMAL = register("chest_normal", ToamodModBlocks.CHEST_NORMAL, ChestNormalBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHEST_EPIC = register("chest_epic", ToamodModBlocks.CHEST_EPIC, ChestEpicBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHEST_LEGENDARY = register("chest_legendary", ToamodModBlocks.CHEST_LEGENDARY, ChestLegendaryBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ORE_RESPAWN_STONE = register("ore_respawn_stone", ToamodModBlocks.ORE_RESPAWN_STONE, OreRespawnStoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CONTROL_BARRIER = register("control_barrier", ToamodModBlocks.CONTROL_BARRIER, ControlBarrierBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COOKING_TABLE = register("cooking_table", ToamodModBlocks.COOKING_TABLE, CookingTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CREATURE_BARRIER = register("creature_barrier", ToamodModBlocks.CREATURE_BARRIER, CreatureBarrierBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ENHANCMENT_TABLE = register("enhancment_table", ToamodModBlocks.ENHANCMENT_TABLE, EnhancmentTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MAGIC_CRAFTER = register("magic_crafter", ToamodModBlocks.MAGIC_CRAFTER, MagicCrafterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FORGER = register("forger", ToamodModBlocks.FORGER, ForgerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLACKSMITH_TABLE = register("blacksmith_table", ToamodModBlocks.BLACKSMITH_TABLE, BlacksmithTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GOBLIN_OMLETTE = register("goblin_omlette", ToamodModBlocks.GOBLIN_OMLETTE, GoblinOmletteBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PLAYER_BARRIER = register("player_barrier", ToamodModBlocks.PLAYER_BARRIER, PlayerBarrierBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PESTO_GOBLIN_OMLETTE = register("pesto_goblin_omlette", ToamodModBlocks.PESTO_GOBLIN_OMLETTE, PestoGoblinOmletteBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> INV_CONTROL_BARRIER = register("inv_control_barrier", ToamodModBlocks.INV_CONTROL_BARRIER, InvControlBarrierBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RESPAWN_ORE = register("respawn_ore", ToamodModBlocks.RESPAWN_ORE, RespawnOreBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
