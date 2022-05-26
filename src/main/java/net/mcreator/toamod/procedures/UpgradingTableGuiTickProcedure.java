package net.mcreator.toamod.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.toamod.network.ToamodModVariables;
import net.mcreator.toamod.init.ToamodModItems;
import net.mcreator.toamod.init.ToamodModEnchantments;

import java.util.function.Supplier;
import java.util.Map;

public class UpgradingTableGuiTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double totalcorrequired = 0;
		double totalmdrequired = 0;
		ItemStack correquired = ItemStack.EMPTY;
		ItemStack mdrequired = ItemStack.EMPTY;
		ItemStack finalitem = ItemStack.EMPTY;
		boolean validRecipe = false;
		correquired = new ItemStack(ToamodModItems.COR.get());
		mdrequired = new ItemStack(ToamodModItems.MAGIC_DUST.get());
		validRecipe = false;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getItem() instanceof SwordItem) {
			finalitem = ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).copy());
			if (((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("type"))
					.equals("enchbook")) {
				if (((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("sharpness")
						&& EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get(),
								(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
										&& _splr.get() instanceof Map _slt
												? ((Slot) _slt.get(0)).getItem()
												: ItemStack.EMPTY)) == (entity instanceof ServerPlayer _plrSlotItem
														&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
																? ((Slot) _slt.get(1)).getItem()
																: ItemStack.EMPTY)
														.getOrCreateTag().getDouble("enchlvl") - 1) {
					totalcorrequired = 1000 + 50 * ((Math.pow(2,
							(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
									&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("enchlvl"))
							+ UpgradingTableCostCalcByRarityProcedure.execute(entity)) / 2);
					totalmdrequired = 2 + 2 * (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble("enchlvl");
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalitem);
						if (_enchantments.containsKey(ToamodModEnchantments.SHARPNESS.get())) {
							_enchantments.remove(ToamodModEnchantments.SHARPNESS.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalitem);
						}
					}
					(finalitem).enchant(ToamodModEnchantments.SHARPNESS.get(),
							(int) ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
									&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("enchlvl")));
					(finalitem).setDamageValue((int) ((finalitem).getDamageValue() + 0.4));
					validRecipe = true;
				} else if (((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("executing")
						&& EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.EXECUTING.get(),
								(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
										&& _splr.get() instanceof Map _slt
												? ((Slot) _slt.get(0)).getItem()
												: ItemStack.EMPTY)) == (entity instanceof ServerPlayer _plrSlotItem
														&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
																? ((Slot) _slt.get(1)).getItem()
																: ItemStack.EMPTY)
														.getOrCreateTag().getDouble("enchlvl") - 1) {
					totalcorrequired = 7500 + 1500 * (Math.pow(2,
							(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
									&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("enchlvl"))
							+ UpgradingTableCostCalcByRarityProcedure.execute(entity));
					totalmdrequired = 2 + 5 * (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble("enchlvl");
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalitem);
						if (_enchantments.containsKey(ToamodModEnchantments.EXECUTING.get())) {
							_enchantments.remove(ToamodModEnchantments.EXECUTING.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalitem);
						}
					}
					(finalitem).enchant(ToamodModEnchantments.EXECUTING.get(),
							(int) ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
									&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("enchlvl")));
					validRecipe = true;
				} else if (((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
						.getString("enchantment")).equals("lifesteel")
						&& EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.LIFE_STEEL.get(),
								(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
										&& _splr.get() instanceof Map _slt
												? ((Slot) _slt.get(0)).getItem()
												: ItemStack.EMPTY)) == (entity instanceof ServerPlayer _plrSlotItem
														&& _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
																? ((Slot) _slt.get(1)).getItem()
																: ItemStack.EMPTY)
														.getOrCreateTag().getDouble("enchlvl") - 1) {
					totalcorrequired = 25000 + 5000 * (Math.pow(2,
							(entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
									&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("enchlvl"))
							+ UpgradingTableCostCalcByRarityProcedure.execute(entity));
					totalmdrequired = 2 + 10 * (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble("enchlvl");
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(finalitem);
						if (_enchantments.containsKey(ToamodModEnchantments.LIFE_STEEL.get())) {
							_enchantments.remove(ToamodModEnchantments.LIFE_STEEL.get());
							EnchantmentHelper.setEnchantments(_enchantments, finalitem);
						}
					}
					(finalitem).enchant(ToamodModEnchantments.LIFE_STEEL.get(),
							(int) ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
									&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("enchlvl")));
					validRecipe = true;
				}
			} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == ToamodModItems.SCROLL_LIGHTNING_STRIKE.get()
					&& !((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getBoolean("hasAbility"))) {
				totalcorrequired = 10000 + 5000 * UpgradingTableCostCalcByRarityProcedure.execute(entity);
				totalmdrequired = 0;
				(finalitem).setHoverName(new TextComponent(
						(finalitem.getDisplayName().getString() + " \u00A77(\u00A76Ability: \u00A7aLightning Strike\u00A77)\u00A7r")));
				validRecipe = true;
			} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == ToamodModItems.SCROLL_WEAKNESS.get()
					&& !((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getBoolean("hasAbility"))) {
				totalcorrequired = 6000 + 4000 * UpgradingTableCostCalcByRarityProcedure.execute(entity);
				totalmdrequired = 0;
				(finalitem).setHoverName(
						new TextComponent((finalitem.getDisplayName().getString() + " \u00A77(\u00A76Ability: \u00A7fWeakness\u00A77)\u00A7r")));
				validRecipe = true;
				finalitem.getOrCreateTag().putBoolean("hasAbility", (true));
			} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == ToamodModItems.SCROLL_BERSERK.get()
					&& !((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getBoolean("hasAbility"))) {
				totalcorrequired = 25000 + 7500 * UpgradingTableCostCalcByRarityProcedure.execute(entity);
				totalmdrequired = 2;
				(finalitem).setHoverName(
						new TextComponent((finalitem.getDisplayName().getString() + " \u00A77(\u00A76Ability: \u00A75Berserk\u00A77)\u00A7r")));
				validRecipe = true;
				finalitem.getOrCreateTag().putBoolean("hasAbility", (true));
			} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY)
					.getItem() == ToamodModItems.SCROLL_BIG_SLICE.get()
					&& !((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getBoolean("hasAbility"))) {
				totalcorrequired = 55000 + 10000 * UpgradingTableCostCalcByRarityProcedure.execute(entity);
				totalmdrequired = 5;
				(finalitem).setHoverName(
						new TextComponent((finalitem.getDisplayName().getString() + " \u00A77(\u00A76Ability: \u00A75Big Slice\u00A77)\u00A7r")));
				validRecipe = true;
				finalitem.getOrCreateTag().putBoolean("hasAbility", (true));
			}
			if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).cor >= totalcorrequired) {
				(correquired).setHoverName(new TextComponent(("\u00A7aCor required: "
						+ (totalcorrequired + "" + ("/" + ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).cor + "\u00A7r"))))));
				correquired.getOrCreateTag().putBoolean("enough", (true));
				correquired.getOrCreateTag().putDouble("coramount", totalcorrequired);
			} else {
				(correquired).setHoverName(new TextComponent(("\u00A7cCor required: "
						+ (totalcorrequired + "" + ("/" + ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).cor + "\u00A7r"))))));
				correquired.getOrCreateTag().putBoolean("enough", (false));
			}
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
					&& _current.get() instanceof Map _slots) {
				ItemStack _setstack = correquired;
				_setstack.setCount(1);
				((Slot) _slots.get(3)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ToamodModVariables.PlayerVariables())).magicdust >= totalmdrequired) {
				(mdrequired).setHoverName(new TextComponent(("\u00A7aMagic Dust required: "
						+ (totalmdrequired + "" + ("/" + ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).magicdust + "\u00A7r"))))));
				mdrequired.getOrCreateTag().putBoolean("enough", (true));
				mdrequired.getOrCreateTag().putDouble("mdamount", totalmdrequired);
			} else {
				(mdrequired).setHoverName(new TextComponent(("\u00A7cMagic Dust required: "
						+ (totalmdrequired + "" + ("/" + ((entity.getCapability(ToamodModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ToamodModVariables.PlayerVariables())).magicdust + "\u00A7r"))))));
				mdrequired.getOrCreateTag().putBoolean("enough", (false));
			}
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
					&& _current.get() instanceof Map _slots) {
				ItemStack _setstack = mdrequired;
				_setstack.setCount(1);
				((Slot) _slots.get(2)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("enough")
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getBoolean("enough")) {
				if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
						&& _current.get() instanceof Map _slots) {
					ItemStack _setstack = finalitem;
					_setstack.setCount(1);
					((Slot) _slots.get(4)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if (!validRecipe) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
					&& _current.get() instanceof Map _slots) {
				((Slot) _slots.get(2)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
					&& _current.get() instanceof Map _slots) {
				((Slot) _slots.get(3)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
					&& _current.get() instanceof Map _slots) {
				((Slot) _slots.get(4)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
