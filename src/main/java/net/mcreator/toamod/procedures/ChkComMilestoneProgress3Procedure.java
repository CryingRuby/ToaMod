package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.network.ToamodModVariables;

public class ChkComMilestoneProgress3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneProgress >= 18.75;
	}
}
