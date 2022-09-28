package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.init.ToamodModEnchantments;

public class EnchantableBookActivatedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack enchbook = ItemStack.EMPTY;
		if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ToamodModVariables.PlayerVariables())).magicdust >= itemstack.getOrCreateTag().getDouble("mdrequired")) {
			{
				double _setval = (entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ToamodModVariables.PlayerVariables())).magicdust - 55;
				entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.magicdust = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			enchbook = new ItemStack(ToamodModItems.BOOK_EXECUTING_1.get());
			enchbook.getOrCreateTag().putString("enchantment", (itemstack.getOrCreateTag().getString("enchantment")));
			enchbook.getOrCreateTag().putDouble("enchlvl", (itemstack.getOrCreateTag().getDouble("enchlvl")));
			enchbook.getOrCreateTag().putString("type", "enchbook");
			if ((enchbook.getOrCreateTag().getString("enchantment")).equals("executing")) {
				(enchbook).enchant(ToamodModEnchantments.EXECUTING.get(), (int) enchbook.getOrCreateTag().getDouble("enchlvl"));
			} else if ((enchbook.getOrCreateTag().getString("enchantment")).equals("lifesteel")) {
				(enchbook).enchant(ToamodModEnchantments.LIFE_STEEL.get(), (int) enchbook.getOrCreateTag().getDouble("enchlvl"));
			} else if ((enchbook.getOrCreateTag().getString("enchantment")).equals("sharpness")) {
				(enchbook).enchant(ToamodModEnchantments.SHARPNESS.get(), (int) enchbook.getOrCreateTag().getDouble("enchlvl"));
			} else if ((enchbook.getOrCreateTag().getString("enchantment")).equals("protection")) {
				(enchbook).enchant(ToamodModEnchantments.PROTECTION.get(), (int) enchbook.getOrCreateTag().getDouble("enchlvl"));
			} else if ((enchbook.getOrCreateTag().getString("enchantment")).equals("stickyfeet")) {
				(enchbook).enchant(ToamodModEnchantments.STICKY_FEET.get(), (int) enchbook.getOrCreateTag().getDouble("enchlvl"));
			} else if ((enchbook.getOrCreateTag().getString("enchantment")).equals("spikes")) {
				(enchbook).enchant(ToamodModEnchantments.SPIKES.get(), (int) enchbook.getOrCreateTag().getDouble("enchlvl"));
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = enchbook;
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\uFFFDcYou don't have enough \uFFFDbmagic dust\uFFFDc!\uFFFDr"), (false));
		}
	}
}
