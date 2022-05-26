package net.mcreator.toamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

import net.mcreator.toamod.network.ToamodModVariables;

import java.util.List;
import java.util.ArrayList;

public class ControlBarrierDestroyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean destroy = false;
		Entity player = null;
		{
			List<? extends Player> _players = new ArrayList<>(world.players());
			for (Entity entityiterator : _players) {
				player = entityiterator;
			}
		}
		destroy = false;
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(x, y, z), "chkBossesDef")) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "inputBossesDef") <= (player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).bossesDefeated) {
				destroy = true;
				if (player instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("CHKbossDef"), (false));
			} else {
				destroy = false;
			}
		}
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(x, y, z), "chkPlayerLvl")) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "inputPlayerLvl") <= (player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).level) {
				destroy = true;
				if (player instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("CHKplyLvl"), (false));
			} else {
				destroy = false;
			}
		}
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(x, y, z), "chkAttackSkill")) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "inputAttackSLvl") <= (player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).skillAttackLvl) {
				destroy = true;
				if (player instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("CHKAtkSLvl"), (false));
			} else {
				destroy = false;
			}
		}
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(x, y, z), "chkDefenseSkill")) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z),
					"inputDefenseSLvl") <= (player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).skillDefenseLvl) {
				destroy = true;
				if (player instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("CHKDefSLvl"), (false));
			} else {
				destroy = false;
			}
		}
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos(x, y, z), "chkMagicSkill")) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "inputMagicSLvl") <= (player.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).skillMagicLvl) {
				destroy = true;
				if (player instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent("CHKMagSLvl"), (false));
			} else {
				destroy = false;
			}
		}
		if (destroy) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
