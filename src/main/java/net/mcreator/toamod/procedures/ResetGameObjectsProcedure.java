package net.mcreator.toamod.procedures;

import net.minecraft.world.level.LevelAccessor;

import classes.ToaGameResetData;

public class ResetGameObjectsProcedure {
	public static void execute(LevelAccessor world) {
		//Reset Chests, Souls, NPCs, ...
		ToaGameResetData.resetGameData(world);
	}
}
