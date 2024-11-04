package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;

public class ClaimComMilestonRewardsPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double progressBefore = 0;
		progressBefore = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed;
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl - progressBefore == 0) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cYou have no unclaimed Rewards!\u00A7r"), false);
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
		for (int index0 = 0; index0 < (int) ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).combatMilestoneLvl - progressBefore); index0++) {
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed + 1;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.comMilestoneRewardsClaimed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			GetCombatMilestoneRewardsProcedure.execute(entity);
		}
	}
}
