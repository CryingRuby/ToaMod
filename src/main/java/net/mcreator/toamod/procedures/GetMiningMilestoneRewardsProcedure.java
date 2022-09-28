package net.mcreator.toamod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;

public class GetMiningMilestoneRewardsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed < 20) {
			{
				double _setval = 5000 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cor = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(
						new TextComponent(("\u00A76+" + 5 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed + "k Cor\u00A7r")),
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
				.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed > 4) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ToamodModItems.RUNE_FRAGMENTS.get());
				_setstack.setCount((int) (4 * ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed - 5)));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(
						new TextComponent(("\u00A7a+ "
								+ new java.text.DecimalFormat("##")
										.format(4 * ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed - 5))
								+ " Rune Fragments\u00A7r")),
						(false));
		}
		{
			double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).armor + 1;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.armor = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).magicResistance + 1;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.magicResistance = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("\u00A7e+1 Armor \u00A77/\u00A7b +1 Magic Resistance"), (false));
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed % 5 == 0
				&& (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed != 0) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("\u00A7bFortune "
						+ new java.text.DecimalFormat("##").format((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed / 5)
						+ "\u00A77 can be applied to pickaxes\u00A7r")), (false));
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed == 10) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ToamodModItems.DWARFS_HYMN.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A76+ Dwarfs Hymn (Active Item)\u00A7r"), (false));
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed == 20) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(
						"\u00A7c+ Ancient Dwarfen Pickaxe (Upgrade) -> \u00A77Give your \u00A76Magmatic Pickaxe (lvl.9)\u00A77 to the \u00A7bBlacksmith\u00A77 to upgrade it\u00A7r"),
						(false));
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed == 19) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ToamodModItems.MYTHIC_RUNE_SCROLL.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7c+ Mythic Rune Scroll\u00A7r"), (false));
		}
	}
}
