
package net.mcreator.toamod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.toamod.procedures.ColdEmbraceOnTickProcedure;

public class ColdEmbraceMobEffect extends MobEffect {
	public ColdEmbraceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10027009);
	}

	@Override
	public String getDescriptionId() {
		return "effect.toamod.cold_embrace";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ColdEmbraceOnTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
