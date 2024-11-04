package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.entity.BossIllfangEntity;

public class OnBossIllfangTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double xPly = 0;
		double zPly = 0;
		double yPart = 0;
		double i = 0;
		String testNotes = "";
		if (entity.getPersistentData().getDouble("ab1CD") > 0) {
			entity.getPersistentData().putDouble("ab1CD", (entity.getPersistentData().getDouble("ab1CD") - 1));
		}
		if (entity.getPersistentData().getDouble("ab2CD") > 0 && entity.getPersistentData().getDouble("phase") >= 1) {
			entity.getPersistentData().putDouble("ab2CD", (entity.getPersistentData().getDouble("ab2CD") - 1));
		}
		if (entity.getPersistentData().getDouble("ab3CD") > 0 && entity.getPersistentData().getDouble("phase") == 2) {
			entity.getPersistentData().putDouble("ab3CD", (entity.getPersistentData().getDouble("ab3CD") - 1));
		}
		if (entity.getPersistentData().getDouble("ab1CD") == 0) {
			if (entity instanceof BossIllfangEntity) {
				((BossIllfangEntity) entity).setAnimation("animation.BossIllfang.ability1");
			}
			entity.getPersistentData().putDouble("ab1CD", 160);
		}
		if (entity.getPersistentData().getDouble("ab2CD") == 0) {
			if (entity instanceof BossIllfangEntity) {
				((BossIllfangEntity) entity).setAnimation("animation.BossIllfang.ability2");
			}
			entity.getPersistentData().putDouble("ab2CD", 200);
		}
		if (entity.getPersistentData().getDouble("ab3CD") == 0) {
			if (entity instanceof BossIllfangEntity) {
				((BossIllfangEntity) entity).setAnimation("animation.BossIllfang.ability3_dash");
			}
			entity.getPersistentData().putDouble("ab3CD", 220);
		}
	}
}
