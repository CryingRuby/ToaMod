package net.mcreator.toamod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.toamod.init.ToamodModItems;

import java.util.function.Supplier;
import java.util.Map;

public class GetGemstoneByTypeProcedure {
	public static ItemStack execute(Entity entity) {
		if (entity == null)
			return ItemStack.EMPTY;
		if (("Forceful").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			return new ItemStack(ToamodModItems.GEMSTONE_AMBER.get());
		} else if (("Wise").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			return new ItemStack(ToamodModItems.GEMSTONE_TANZANITE.get());
		} else if (("Magical").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			return new ItemStack(ToamodModItems.GEMSTONE_AMETHYST.get());
		} else if (("Hardened").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			return new ItemStack(ToamodModItems.GEMSTONE_SAPHIRE.get());
		} else if (("Bulletproof").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			return new ItemStack(ToamodModItems.GEMSTONE_TOPAZ.get());
		} else if (("Mystic").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			return new ItemStack(ToamodModItems.GEMSTONE_AQUAMARINE.get());
		} else if (("Balanced").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			return new ItemStack(ToamodModItems.GEMSTONE_PEARL.get());
		} else if (("Superior").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			return new ItemStack(ToamodModItems.GEMSTONE_OPAL.get());
		} else if (("Empowered").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			return new ItemStack(ToamodModItems.GEMSTONE_EMERALD.get());
		} else if (("Miraculous").equals(
				(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY).getOrCreateTag().getString("gemstoneType"))) {
			return new ItemStack(ToamodModItems.GEMSTONE_DIAMOND.get());
		}
		return new ItemStack(ToamodModItems.GEMSTONE_RUBY.get());
	}
}
