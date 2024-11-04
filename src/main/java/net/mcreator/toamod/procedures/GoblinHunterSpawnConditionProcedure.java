package net.mcreator.toamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class GoblinHunterSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world instanceof Level _lvl0 && _lvl0.isDay() && Math.random() < 0.05 || !(world instanceof Level _lvl1 && _lvl1.isDay())) {
			if (Math.random() < 0.5) {
				return true;
			}
		}
		return false;
	}
}
