package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.network.ToamodModVariables;

public class OnTableRightClickedProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = x;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.guiBlockX = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = y;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.guiBlockY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = z;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.guiBlockZ = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
