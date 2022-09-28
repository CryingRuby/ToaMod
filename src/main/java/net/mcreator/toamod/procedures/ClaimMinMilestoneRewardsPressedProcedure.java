package net.mcreator.toamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.toamod.network.ToamodModVariables;

public class ClaimMinMilestoneRewardsPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double progressBefore = 0;
		progressBefore = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed;
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneLvl - progressBefore == 0) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7cYou have no unclaimed Rewards!\u00A7r"), (false));
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
		for (int index0 = 0; index0 < (int) ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).miningMilestoneLvl - progressBefore); index0++) {
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed + 1;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MinMilestoneRewardsClaimed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			GetMiningMilestoneRewardsProcedure.execute(entity);
		}
	}
}
