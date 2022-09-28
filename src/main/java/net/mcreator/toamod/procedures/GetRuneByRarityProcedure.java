package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.toamod.init.ToamodModItems;

import java.util.function.Supplier;
import java.util.Map;

public class GetRuneByRarityProcedure {
	public static ItemStack execute(Entity entity) {
		if (entity == null)
			return ItemStack.EMPTY;
		if (1 == (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("runeRarity")) {
			return new ItemStack(ToamodModItems.RUNE_UNCOMMAN.get());
		} else if (2 == (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("runeRarity")) {
			return new ItemStack(ToamodModItems.RUNE_RARE.get());
		} else if (3 == (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("runeRarity")) {
			return new ItemStack(ToamodModItems.RUNE_EPIC.get());
		} else if (4 == (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("runeRarity")) {
			return new ItemStack(ToamodModItems.RUNE_LEGENDARY.get());
		} else if (5 == (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("runeRarity")) {
			return new ItemStack(ToamodModItems.RUNE_MYTHIC.get());
		}
		return new ItemStack(ToamodModItems.RUNE_COMMAN.get());
	}
}
