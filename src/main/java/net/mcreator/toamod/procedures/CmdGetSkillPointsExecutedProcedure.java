package net.mcreator.toamod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.network.ToamodModVariables;

import java.util.HashMap;

public class CmdGetSkillPointsExecutedProcedure {
	public static void execute(Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		{
			double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).skillPoints + new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "");
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.skillPoints = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
