package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class GoblinInitialSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("lvl", (Mth.nextInt(RandomSource.create(), 1, 3)));
		entity.getPersistentData().putDouble("maxHealth", (13 * entity.getPersistentData().getDouble("lvl")));
		entity.getPersistentData().putDouble("currentHealth", (entity.getPersistentData().getDouble("maxHealth")));
		entity.getPersistentData().putDouble("AR", (10 * entity.getPersistentData().getDouble("lvl")));
		entity.getPersistentData().putDouble("MR", (10 * entity.getPersistentData().getDouble("lvl")));
		entity.getPersistentData().putDouble("AD", (3 * entity.getPersistentData().getDouble("lvl")));
		entity.getPersistentData().putDouble("MP", 0);
		entity.getPersistentData().putDouble("CR", Math.round(1.25 * entity.getPersistentData().getDouble("lvl")));
		entity.getPersistentData().putDouble("CD", Math.round(1.75 * entity.getPersistentData().getDouble("lvl") + 10));
		SetEntityDisplayNameProcedure.execute(entity);
	}
}
