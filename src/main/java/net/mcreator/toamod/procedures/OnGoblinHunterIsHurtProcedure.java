package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.init.ToamodModMobEffects;

public class OnGoblinHunterIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((!entity.getPersistentData().getBoolean("effCooldown") && entity.getPersistentData()
				.getBoolean("engaged")) == ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ToamodModMobEffects.STRENGTH.get()) ? _livEnt.getEffect(ToamodModMobEffects.STRENGTH.get()).getAmplifier() : 0) == 8)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(ToamodModMobEffects.STRENGTH.get());
			entity.getPersistentData().putBoolean("effCooldown", true);
		}
	}
}
