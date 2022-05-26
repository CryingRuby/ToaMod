package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.network.ToamodModVariables;

public class MagicShieldAppliedProcedure {
	public static void execute(Entity entity, double amplifier) {
		if (entity == null)
			return;
		{
			double _setval = Math.round((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.3 * amplifier);
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.shieldAmountMax = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).shieldAmountMax;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.shieldAmount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = amplifier;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.shieldLvl = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
