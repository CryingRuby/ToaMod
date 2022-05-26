
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.toamod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.toamod.block.entity.WeaponTableBlockEntity;
import net.mcreator.toamod.block.entity.UpgradingTableBlockEntity;
import net.mcreator.toamod.block.entity.OreRespawnStoneBlockEntity;
import net.mcreator.toamod.block.entity.CookingTableBlockEntity;
import net.mcreator.toamod.block.entity.ControlBarrierBlockEntity;
import net.mcreator.toamod.block.entity.ChestNormalBlockEntity;
import net.mcreator.toamod.block.entity.ChestLegendaryBlockEntity;
import net.mcreator.toamod.block.entity.ChestEpicBlockEntity;
import net.mcreator.toamod.block.entity.ArmoryTableBlockEntity;
import net.mcreator.toamod.ToamodMod;

public class ToamodModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ToamodMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ORE_RESPAWN_STONE = register("ore_respawn_stone", ToamodModBlocks.ORE_RESPAWN_STONE,
			OreRespawnStoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHEST_NORMAL = register("chest_normal", ToamodModBlocks.CHEST_NORMAL,
			ChestNormalBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHEST_EPIC = register("chest_epic", ToamodModBlocks.CHEST_EPIC, ChestEpicBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHEST_LEGENDARY = register("chest_legendary", ToamodModBlocks.CHEST_LEGENDARY,
			ChestLegendaryBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CONTROL_BARRIER = register("control_barrier", ToamodModBlocks.CONTROL_BARRIER,
			ControlBarrierBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> UPGRADING_TABLE = register("upgrading_table", ToamodModBlocks.UPGRADING_TABLE,
			UpgradingTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COOKING_TABLE = register("cooking_table", ToamodModBlocks.COOKING_TABLE,
			CookingTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ARMORY_TABLE = register("armory_table", ToamodModBlocks.ARMORY_TABLE,
			ArmoryTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WEAPON_TABLE = register("weapon_table", ToamodModBlocks.WEAPON_TABLE,
			WeaponTableBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
