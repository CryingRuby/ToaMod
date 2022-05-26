
package net.mcreator.toamod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.toamod.procedures.MagicShieldOnTickProcedure;
import net.mcreator.toamod.procedures.MagicShieldAppliedProcedure;

public class MagicShieldMobEffect extends MobEffect {
	public MagicShieldMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14763586);
	}

	@Override
	public String getDescriptionId() {
		return "effect.toamod.magic_shield";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		MagicShieldAppliedProcedure.execute(entity, amplifier);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		MagicShieldOnTickProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
