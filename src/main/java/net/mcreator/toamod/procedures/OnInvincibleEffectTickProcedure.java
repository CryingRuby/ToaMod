package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.toamod.init.ToamodModMobEffects;

public class OnInvincibleEffectTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(ToamodModMobEffects.SPELL_IMMUNITY.get(), 20, 1, false, false));
	}
}
