package net.mcreator.toamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class ControlBarrierGuiThisGUIOpenedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("works"), (false));
		if (guistate.get("text:inputBossesDef") instanceof EditBox _tf)
			_tf.setValue("?");
		if (guistate.get("text:inputPlayerLvl") instanceof EditBox _tf)
			_tf.setValue(("" + (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "inputPlayerLvl"))));
		if (guistate.get("text:inputAttackSLvl") instanceof EditBox _tf)
			_tf.setValue(("" + (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "inputAttackSLvl"))));
		if (guistate.get("text:inputDefenseSLvl") instanceof EditBox _tf)
			_tf.setValue(("" + (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "inputDefenseSLvl"))));
		if (guistate.get("text:inputMagicSLvl") instanceof EditBox _tf)
			_tf.setValue(("" + (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "inputMagicSLvl"))));
	}
}
