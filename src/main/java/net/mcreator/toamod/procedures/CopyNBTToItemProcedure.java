package net.mcreator.toamod.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.toamod.init.ToamodModEnchantments;

import java.util.function.Supplier;
import java.util.Map;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CopyNBTToItemProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
				: ItemStack.EMPTY).getOrCreateTag().getString("type")).equals("Artefact")
				&& !(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getString("runeType")).equals("-"))) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble(
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getOrCreateTag().getString("runeType")),
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
									? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
									: ItemStack.EMPTY).getOrCreateTag().getString("runeType")))
							+ (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
									? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
									: ItemStack.EMPTY).getOrCreateTag().getDouble("runeValue")));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("runeRarity",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getOrCreateTag().getDouble("runeRarity")));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("runeValue",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getOrCreateTag().getDouble("runeValue")));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putString("runeType",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getOrCreateTag().getString("runeType")));
		}
		if (!(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
				: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals(""))) {
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Strong")) {
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
						((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD") + 5
								+ 10 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
										? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
										: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
			} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Forceful")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 1) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD") + 5
									+ 5 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD")
									+ 5 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 2) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CR") + 2
									+ 3 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CR")
									+ 5 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 3));
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") == 0) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD") + 7));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 3) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD") + 5
									+ 10 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
									+ 15 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 0));
				}
			} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Wise")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 1) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MANA",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MANA") + 20
									+ 15 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 3) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MANA",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MANA")
									+ 40 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 50));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MANA",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MANA") + 5
									+ 25 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				}
			} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Hardened")) {
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AR",
						((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AR") + 25
								+ 25 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
										? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
										: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MR",
						((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MR") + 25
								+ 25 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
										? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
										: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
			} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Bulletproof")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 1) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AR") + 50
									+ 36 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 3) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AR") + 5
									+ 60 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AR")
									+ 125 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 225));
				}
			} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Mystic")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 1) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MR") + 50
									+ 36 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 3) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MR") + 5
									+ 60 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MR")
									+ 125 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 225));
				}
			} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Magical")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 1) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MP",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MP") + 10
									+ 10 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 4) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MP",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MP")
									+ 20 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 10));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MP",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MP")
									+ 100));
				}
			} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Balanced")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 1) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD") + 5
									+ 5 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD")
									+ 5 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MP",
						((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MP") + 10
								+ 10 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
										? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
										: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
			} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Superior")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 2) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD") + 2
									+ 2 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD")
									+ 4 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 3));
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") == 0) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MP",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MP") + 5));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 3) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MP",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MP") + 4
									+ 3 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MP",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MP")
									+ 7 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 10));
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 2) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CR") + 1
									+ (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") == 3) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CR") + 5));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CR")
									+ 2 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 2));
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 2) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD") + 4
									+ 4 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 4) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
									+ 6 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 1));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
									+ 30));
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MANA",
						((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MANA") + 5
								+ 5 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
										? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
										: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
			} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Empowered")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 2) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD") + 5
									+ 5 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 4) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD")
									+ 8 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 2));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD")
									+ 40));
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AR",
						((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AR") + 5
								+ 5 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
										? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
										: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") == 0) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CR") + 1));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CR")
									+ 2 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 2) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD") + 4
									+ 2 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 4) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
									+ 4 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 1));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
									+ 20));
				}
			} else if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
					? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
					: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")).equals("Miraculous")) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 1) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD") + 10
									+ 10 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 4) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
									+ 15 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 5));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
									+ 75));
				}
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MR",
						((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MR") + 5
								+ 5 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
										? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
										: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") == 0) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CR") + 1));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CR",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CR")
									+ 2 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				}
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 2) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD") + 4
									+ 2 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity") <= 4) {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
									+ 4 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
											? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
											: ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")
									- 1));
				} else {
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
									+ 20));
				}
			}
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putString("gemstoneType",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType")));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).setHoverName(Component.literal(("\u00A7r"
					+ (Component.translatable(("rarity.prefix." + (new java.text.DecimalFormat("##").format(
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("rarity")))))
							.getString())
					+ ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))
					+ " " + ((((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getDisplayName().getString())
							.replace("]", "")).replace("[", "")))));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.SHARPNESS.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get()));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AD",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AD")
							+ 4 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(ToamodModEnchantments.SHARPNESS.get())));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.EXECUTING.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.EXECUTING.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.EXECUTING.get()));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.LIFESTEAL.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.LIFESTEAL.get()));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.CRITICAL.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.CRITICAL.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.CRITICAL.get()));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("CD",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("CD")
							+ 10 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(ToamodModEnchantments.CRITICAL.get())));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.SCAVENGER.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.SCAVENGER.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.SCAVENGER.get()));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.MANAFLOW.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get()));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MANA",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MANA")
							+ 20 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(ToamodModEnchantments.MANAFLOW.get())));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.POWERFUL.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.POWERFUL.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get()));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MP",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MP")
							+ 6 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get())));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.PROTECTION.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.PROTECTION.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.PROTECTION.get()));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("AR",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("AR")
							+ 8 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(ToamodModEnchantments.POWERFUL.get())));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.STICKYFEET.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.STICKYFEET.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.STICKYFEET.get()));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.SPIKES.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.SPIKES.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.SPIKES.get()));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.MAGICSHIELD.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get()));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MR",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MR")
							+ 8 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(ToamodModEnchantments.MAGICSHIELD.get())));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.IGNITE.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.IGNITE.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.IGNITE.get()));
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(ToamodModEnchantments.FORTUNE.get(),
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
						? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
						: ItemStack.EMPTY)) != 0) {
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).enchant(ToamodModEnchantments.FORTUNE.get(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
							? ((Slot) _slt.get((int) DoubleArgumentType.getDouble(arguments, "copyFromSlot"))).getItem()
							: ItemStack.EMPTY).getEnchantmentLevel(ToamodModEnchantments.FORTUNE.get()));
			(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MINF",
					((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MINF")
							+ 15 * (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(ToamodModEnchantments.FORTUNE.get())));
		}
	}
}
