package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;

public class EnchantableBookActivatedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack enchbook = ItemStack.EMPTY;
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).magicdust >= itemstack.getOrCreateTag().getDouble("mdReq")) {
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ToamodModVariables.PlayerVariables())).magicdust - itemstack.getOrCreateTag().getDouble("mdReq");
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.magicdust = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			enchbook = new ItemStack(ToamodModItems.ENCHANTMENT_BOOK.get());
			enchbook.getOrCreateTag().putString("enchantment", (itemstack.getOrCreateTag().getString("enchantment")));
			enchbook.getOrCreateTag().putDouble("enchlvl", (itemstack.getOrCreateTag().getDouble("enchlvl")));
			enchbook.getOrCreateTag().putDouble("rarity", 2);
			enchbook.setHoverName(Component.literal((((enchbook.getDisplayName().getString()).replace("]", "")).replace("[", "\u00A7f") + " \u00A77(\u00A79"
					+ Component.translatable(("enchantment.toamod." + (itemstack.getOrCreateTag().getString("enchantment")).toLowerCase())).getString() + " "
					+ Component.translatable(("number.roman." + new java.text.DecimalFormat("##").format(itemstack.getOrCreateTag().getDouble("enchlvl")))).getString() + "\u00A77)\u00A7r")));
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = enchbook.copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("msg.enchbook.mdReq").getString())), false);
		}
	}
}
