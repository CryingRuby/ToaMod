package net.mcreator.toamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class GoblinSpawnConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _lvl0 && _lvl0.isDay() && Math.random() < 0.75 || !(world instanceof Level _lvl1 && _lvl1.isDay())) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("toamod:windy_plains"))) {
				if (Math.random() < 0.4) {
					return true;
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("toamod:plains_forest"))) {
				if (Math.random() < 0.55) {
					return true;
				}
			} else if (world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("toamod:goblin_hideout"))) {
				return true;
			}
		}
		return false;
	}
}
