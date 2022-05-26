
package net.mcreator.toamod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class VulnerableMobEffect extends MobEffect {
	public VulnerableMobEffect() {
		super(MobEffectCategory.HARMFUL, -6750208);
	}

	@Override
	public String getDescriptionId() {
		return "effect.toamod.vulnerable";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
