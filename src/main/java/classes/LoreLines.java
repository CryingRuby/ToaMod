package classes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;

public class LoreLines {
	public static void setLoreLines(ItemStack item, String[] lines) {

		CompoundTag lore = new CompoundTag(); //"display"-Tag with "Lore"-Tag as value
		ListTag loreValues = new ListTag(); //"Lore"-Tag mit LoreValues / Textlines
		for (int i = 0; i < lines.length; i++) {
			loreValues.add(StringTag.valueOf(StringTag.quoteAndEscape(lines[i])));
		}

		lore.put("Lore", loreValues);

		item.getOrCreateTag().put("display", lore);
	}

	public static void addLoreLines(ItemStack item, String[] lines) {

		CompoundTag display = (CompoundTag) item.getOrCreateTag().get("display");
		ListTag lore = (ListTag) display.get("Lore");
		
		for (int i = 0; i < lines.length; i++) {
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(lines[i])));
		}

	}
}
