package net.mcreator.toamod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;

public class GetMiningMilestoneRewardsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed < 20) {
			{
				double _setval = 5000 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cor = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal(("\u00A76+" + 5 * (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed + "k Cor\u00A7r")), false);
		} else {
			{
				double _setval = 1000000;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.cor = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76+1m Cor\u00A7r"), false);
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed > 3) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ToamodModItems.RUNE_FRAGMENTS.get()).copy();
				_setstack.setCount((int) (4 * ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed - 5)));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(
						("\u00A7a+ " + new java.text.DecimalFormat("##").format(4 * ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed - 5))
								+ " Rune Fragments\u00A7r")),
						false);
		}
		{
			double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).miningFortune + 0.05;
			entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.miningFortune = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u00A77+\u00A765 Mining Fortune"), false);
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed == 5) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7dFortune " + Component.translatable("number.roman.1").getString() + "\u00A77 recipe for Magic Crafter\u00A7r")), false);
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed == 10) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ToamodModItems.DWARFS_HYMN.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76+ Dwarfs Hymn (Active Item)\u00A7r"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7dFortune " + Component.translatable("number.roman.2").getString() + "\u00A77 recipe for Magic Crafter\u00A7r")), false);
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed == 14) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7dFortune " + Component.translatable("number.roman.3").getString() + "\u00A77 recipe for Magic Crafter\u00A7r")), false);
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed == 17) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7dFortune " + Component.translatable("number.roman.4").getString() + "\u00A77 recipe for Magic Crafter\u00A7r")), false);
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed == 19) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(ToamodModItems.MYTHIC_RUNE_SCROLL.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c+ Mythic Rune Scroll\u00A7r"), false);
		}
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).MinMilestoneRewardsClaimed == 20) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c+ Ancient Dwarfen Pickaxe (Upgrade) -> \u00A77Give your \u00A76Magmatic Pickaxe (lvl.9)\u00A77 to the \u00A7bBlacksmith\u00A77 to upgrade it\u00A7r"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A7dFortune " + Component.translatable("number.roman.5").getString() + "\u00A77 recipe for Magic Crafter\u00A7r")), false);
		}
	}
}
