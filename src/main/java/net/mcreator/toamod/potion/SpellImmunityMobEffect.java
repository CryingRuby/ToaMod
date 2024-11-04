
package net.mcreator.toamod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.toamod.procedures.SpellImmunityOnTickProcedure;

public class SpellImmunityMobEffect extends MobEffect {
	public SpellImmunityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1258233);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SpellImmunityOnTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
