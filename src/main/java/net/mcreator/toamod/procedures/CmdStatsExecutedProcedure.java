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
					new TextComponent(("Attack Damage: " + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).attackDamage)),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					new TextComponent(("Ability Power: " + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).abilityPower)),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Armor: " + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).armor)), (false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(
					new TextComponent(("Magic Resistance: " + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ToamodModVariables.PlayerVariables())).magicResistance)),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Crit Chance: " + (entity
					.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).critRate)),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Crit Damage: " + (entity
					.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).critDmg)),
					(false));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(("Max Mana:" + (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).maxMana)), (false));
	}
}
