
package net.mcreator.toamod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.toamod.procedures.OnSwampFoulnessTickProcedure;
import net.mcreator.toamod.procedures.OnSwampFoulnessConditionProcedure;
import net.mcreator.toamod.procedures.OnSwampFoulnessAppliedProcedure;

public class SwampFoulnessMobEffect extends MobEffect {
	public SwampFoulnessMobEffect() {
		super(MobEffectCategory.HARMFUL, -11607752);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		OnSwampFoulnessAppliedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		OnSwampFoulnessTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return OnSwampFoulnessConditionProcedure.execute(duration);
	}
}
