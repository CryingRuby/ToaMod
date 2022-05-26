package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.toamod.network.ToamodModVariables;

public class CmdStatsExecutedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					new TextComponent(("Crit Chance: " + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).kritChance)),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					new TextComponent(("Crit Damage: " + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).kritDamage)),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					new TextComponent(("Anility Power: " + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).bonusAbilityPower)),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					new TextComponent(("Damage Reduction: " + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).damageReduction)),
					(false));
	}
}
