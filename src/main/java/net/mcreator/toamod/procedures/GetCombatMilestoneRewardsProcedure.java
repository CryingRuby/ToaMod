package net.mcreator.toamod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;

public class GetCombatMilestoneRewardsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed < 20) {
			{
				double _setval = (2500 + 2500 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed)
						* (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cor = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(
						new TextComponent(("\u00A76+" + (2.5 + 2.5 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed)
								* (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed
								+ "k Cor\u00A7r")),
						(false));
		} else {
			{
				double _setval = 1000000;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cor = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76+1m Cor\u00A7r"), (false));
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed % 2 == 0) {
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).attackDamage + 1;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.attackDamage = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).abilityPower + 1;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.abilityPower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7c+1 Attack Damage \u00A77/\u00A75 +1 Ability Power"), (false));
		} else {
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).critRate + 1;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.critRate = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).critDmg + 2.5;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.critDmg = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A74+1 Critical Rate \u00A77/\u00A74 +2.5 Critical Damage"), (false));
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed == 18) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ToamodModItems.MYTHIC_RUNE_SCROLL.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7c+1 Mythic Rune Scroll (Item)\u00A7r"), (false));
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed == 19) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7dSharpness X \u00A77/\u00A7d Powerful X \u00A77unlocked (enchantment)\u00A7r"),
						(false));
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).comMilestoneRewardsClaimed == 20) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ToamodModItems.FIERY_HEART.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76+ Last Stand (Passiv Item)\u00A7r"), (false));
		}
	}
}
