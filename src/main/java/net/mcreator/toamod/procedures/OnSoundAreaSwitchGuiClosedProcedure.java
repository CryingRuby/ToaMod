package net.mcreator.toamod.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.toamod.network.ToamodModVariables;

import java.util.HashMap;

public class OnSoundAreaSwitchGuiClosedProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(
					(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
					(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
					(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getTileData().putString("entranceTo",
						(guistate.containsKey("text:entranceTo") ? ((EditBox) guistate.get("text:entranceTo")).getValue() : ""));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(
					(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
					(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
					(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getTileData().putString("backTo",
						(guistate.containsKey("text:backTo") ? ((EditBox) guistate.get("text:backTo")).getValue() : ""));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
