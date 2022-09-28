package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.toamod.network.ToamodModVariables;

public class CmdResetHorseStatsExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 1;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.horseLvl = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 1;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.horseMSCorNeeded = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 0.202;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.horseMoveSpeed = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					new TextComponent(("horseMoveSpeed: " + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).horseMoveSpeed)),
					(false));
	}
}
