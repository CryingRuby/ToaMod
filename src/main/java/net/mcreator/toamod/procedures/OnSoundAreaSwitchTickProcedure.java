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

public class OnSoundAreaSwitchTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!(new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world,
				new BlockPos(
						(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
						(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
						(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ),
				"txtFilled"))) {
			if (guistate.get("text:entranceTo") instanceof EditBox _tf)
				_tf.setValue((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(world,
						new BlockPos(
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ),
						"entranceTo")));
			if (guistate.get("text:backTo") instanceof EditBox _tf)
				_tf.setValue((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getString(tag);
						return "";
					}
				}.getValue(world,
						new BlockPos(
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).guiBlockX,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).guiBlockY,
								(entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).guiBlockZ),
						"backTo")));
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
					_blockEntity.getTileData().putBoolean("txtFilled", (true));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
