package net.mcreator.toamod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.init.ToamodModBlocks;

import java.util.concurrent.atomic.AtomicReference;

public class GetChestLootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack coritem = ItemStack.EMPTY;
		ItemStack mditem = ItemStack.EMPTY;
		String emptySlots = "";
		double chestValue = 0;
		double corMin = 0;
		double corMax = 0;
		double mdMin = 0;
		double mdMax = 0;
		double i = 0;
		double rng = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ToamodModBlocks.CHEST_NORMAL.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("data merge block ~ ~ ~ {LootTable:\"toamod:chests/chest_normal_" + ""
								+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentRegion) + "\"}"));
			chestValue = 1;
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ToamodModBlocks.CHEST_EPIC.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("data merge block ~ ~ ~ {LootTable:\"toamod:chests/chest_epic_" + ""
								+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentRegion) + "\"}"));
			chestValue = 2;
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ToamodModBlocks.CHEST_LEGENDARY.get()) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("data merge block ~ ~ ~ {LootTable:\"toamod:chests/chest_legendary_" + "" + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentRegion
								+ "\"}"));
			chestValue = 3;
		}
		coritem = new ItemStack(ToamodModItems.COR.get());
		mditem = new ItemStack(ToamodModItems.MAGIC_DUST.get());
		corMin = Math.round((40 * Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentRegion, chestValue) + Math.pow(28, chestValue)
				+ 23 * Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentRegion, 2) + 361 * Math.pow(chestValue, 2)) - 300);
		corMax = Math.round(2.5 * corMin);
		mdMin = Math.round((0.3 + Math.pow((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).currentRegion, chestValue) + 5 + chestValue + Math.pow(5, chestValue)) - 6.5);
		mdMax = Math.round(2.5 * mdMin);
		coritem.getOrCreateTag().putDouble("amount", (Mth.nextInt(RandomSource.create(), (int) corMin, (int) corMax)));
		mditem.getOrCreateTag().putDouble("amount", (Mth.nextInt(RandomSource.create(), (int) mdMin, (int) mdMax)));
		coritem.setHoverName(Component.literal(("\u00A76Cor \u00A77(\u00A76" + new java.text.DecimalFormat("##").format(coritem.getOrCreateTag().getDouble("amount")) + "\u00A77)\u00A7r")));
		mditem.setHoverName(Component.literal(("\u00A76Magic Dust \u00A77(\u00A76" + new java.text.DecimalFormat("##").format(mditem.getOrCreateTag().getDouble("amount")) + "\u00A77)\u00A7r")));
		for (int index0 = 0; index0 < (int) (3 + 6 * chestValue); index0++) {
			if (Blocks.AIR.asItem() == (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), (int) i)).getItem()) {
				if (i > 9) {
					emptySlots = emptySlots + "" + new java.text.DecimalFormat("##").format(i) + ",";
				} else {
					emptySlots = emptySlots + "0" + new java.text.DecimalFormat("##").format(i) + ",";
				}
			}
		}
		if (("").equals(emptySlots)) {
			for (int index1 = 0; index1 < (int) (3 + 6 * chestValue); index1++) {
				if (ToamodModItems.COAL.get() == (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), (int) i)).getItem() || ToamodModItems.RAW_TURKEY.get() == (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), (int) i)).getItem() || ToamodModItems.PURE_IRON.get() == (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), (int) i)).getItem()) {
					if (i > 9) {
						emptySlots = emptySlots + "" + new java.text.DecimalFormat("##").format(i) + ",";
					} else {
						emptySlots = emptySlots + "0" + new java.text.DecimalFormat("##").format(i) + ",";
					}
				}
			}
		}
		rng = Mth.nextInt(RandomSource.create(), 0, (int) ((emptySlots).length() / 3 - 1));
		if (Math.random() < 0.3 * chestValue + 0.4) {
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent != null) {
					final int _slotid = (int) new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(emptySlots.substring((int) (3 * rng), (int) (3 * rng + 2)));
					final ItemStack _setstack = coritem.copy();
					_setstack.setCount(1);
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
		}
		emptySlots = emptySlots.replace(emptySlots.substring((int) (3 * rng), (int) (3 * rng + 2)), "");
		rng = Mth.nextInt(RandomSource.create(), 0, (int) ((emptySlots).length() / 3 - 1));
		if (Math.random() < 0.5 * chestValue - 0.5) {
			{
				BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
				if (_ent != null) {
					final int _slotid = (int) new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(emptySlots.substring((int) (3 * rng), (int) (3 * rng + 2)));
					final ItemStack _setstack = mditem.copy();
					_setstack.setCount(1);
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable)
							((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
					});
				}
			}
		}
	}
}
