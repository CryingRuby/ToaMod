package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.toamod.network.ToamodModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CmdAddTotalOresMinedExecutedProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).totalOresMined + DoubleArgumentType.getDouble(arguments, "value");
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.totalOresMined = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).totalMobsKilled + DoubleArgumentType.getDouble(arguments, "value");
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.totalMobsKilled = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
