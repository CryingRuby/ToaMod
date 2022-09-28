package net.mcreator.toamod.procedures;

import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.network.ToamodModVariables;

import java.util.concurrent.atomic.AtomicReference;

public class CheckForgerGuiRemoveRuneProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
							.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world,
				new BlockPos(
						(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
						(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
						(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ),
				0)).getOrCreateTag().getBoolean("forgeable") && !("").equals((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
									.ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world,
						new BlockPos(
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ),
						0)).getOrCreateTag().getString("runeType"))) {
			return true;
		}
		return false;
	}
}
