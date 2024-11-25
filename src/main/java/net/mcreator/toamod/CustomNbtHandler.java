
package net.mcreator.toamod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.toamod.init.ToamodModEnchantments;

import java.util.ArrayList;

public class CustomNbtHandler {
	private CustomNbtHandler() {
	}

	/**
	 * copies all upgrades like enchantments, reforge, stars, etc...
	 * @param item the upgrades get copied from
	 * @param item the upgrades get copied to
	 */
	public static void copyUpgrades(ItemStack copyFrom, ItemStack copyTo) {
		System.out.println("CustomNbtHandler - copyUpgrades called");
		System.out.println("	copyFrom is Reforgeable?: " + (copyFrom.getItem() instanceof ToaReforgeable) + ",	copyTo is Reforgeable?: " + (copyTo.getItem() instanceof ToaReforgeable));
		if (!(copyFrom.getItem() instanceof ToaReforgeable) || !(copyTo.getItem() instanceof ToaReforgeable))
			return;
		CompoundTag nbtTo = copyTo.getOrCreateTag();
		//ToaProperties baseStats = (copyTo.getItem() instanceof ToaReforgeable ref)? ref.toaProperties : null;
		CompoundTag nbtFrom = copyFrom.getOrCreateTag();
		//Enchantments:
		System.out.println("Try copy Enchantments");
		System.out.println("Enchantments: " + nbtFrom.getList("Enchantments", 10));
		nbtTo.put("Enchantments", nbtFrom.getList("Enchantments", 10));
		CompoundTag nbtUpgradesFrom = nbtFrom.getCompound("Upgrades");
		if (!nbtUpgradesFrom.getString("reforge").isEmpty()) {
			ToaProperties.applyReforgeToItem(ReforgeType.getByName(nbtUpgradesFrom.getString("reforge")), copyTo);
		}
		/*
		if (nbtFrom.getInt("stackable") > 0) {
			nbtTo.putInt("stackable", nbtFrom.get("stackable"));
			//apply stackable to item
		}
		if (nbtFrom.getString("prestige").isEmpty()) {
			nbtTo.putString("prestige", nbtFrom.getString("prestige"));
			//apply prestige to item
		}
		*/
		if (!nbtUpgradesFrom.getList("Runes", 10).isEmpty()) {
			ListTag runes = nbtUpgradesFrom.getList("Runes", 10);
			for (int i = runes.size(); i < ((ToaReforgeable) copyTo.getItem()).runeSlots.length; i++) {
				runes.add(new CompoundTag());
			}
			nbtUpgradesFrom.put("Runes", runes);
		}
		if (nbtUpgradesFrom.getInt("stars") > 0) {
			applyStarsToItem(copyTo, nbtUpgradesFrom.getInt("stars"));
		}
		copyTo.getOrCreateTag().put("Upgrades", nbtUpgradesFrom);
	}

	/**
	 * 
	 */
	public static void applyItemBaseStats(ItemStack item) {
		if (!(item.getItem() instanceof ToaReforgeable))
			return;
		ToaProperties prop = ((ToaWeapon) item.getItem()).toaProperties;
		prop.addBaseInfoToNbt(item.getOrCreateTag());
		item.getOrCreateTag().put("Stats", prop.statsToNbt());
		//Hiding Enchantments, Modifiers
		item.getOrCreateTag().putInt("HideFlags", 3);
	}

	/**
	 * applies the stat-boost of the new stars
	 * @param newStars are the stars that were on the item before the upgrade
	 */
	public static void applyStarsToItem(ItemStack item, int newStars) {
		if (!(item.getItem() instanceof ToaReforgeable))
			return;
		((ToaReforgeable) item.getItem()).toaProperties.multiplyAllFlat(newStars * 0.02f).addStatsToItem(item);
	}

	/**
	 * Resets current Lore of item.
	 * Sets Lore with all Stats, Upgrades, basic Information (rarity, item, etc...)
	 */
	public static void setLoreOfItem(ItemStack item) {
		CompoundTag lore = new CompoundTag();
		ListTag loreLines = new ListTag();

		//Reihenfolge:
		
		//Rune Slots
		//Stats
		//Enchantments
		//Description (Optional)
		//Type / Rarity
	}

	/**
	 * Sets Lore of an item to the String[] given
	 */
	private static void setLoreLines(ItemStack item, ArrayList<String> lines) {
		CompoundTag lore = new CompoundTag(); //"display"-Tag with "Lore"-Tag as value
		ListTag loreValues = new ListTag(); //"Lore"-Tag mit LoreValues / Textlines
		for (int i = 0; i < lines.size(); i++) {
			loreValues.add(StringTag.valueOf(StringTag.quoteAndEscape(lines.get(i))));
		}
		lore.put("Lore", loreValues);
		item.getOrCreateTag().put("display", lore);
	}

	/**
	 * Adds all lines of the given String[] to the existing Lore of an item
	 */
	public static void addLoreLines(ItemStack item, ArrayList<String> lines) {
		CompoundTag display = (CompoundTag) item.getOrCreateTag().get("display");
		ListTag lore = (ListTag) display.get("Lore");
		for (int i = 0; i < lines.size(); i++) {
			lore.add(StringTag.valueOf(StringTag.quoteAndEscape(lines.get(i))));
		}
	}

	/**
	 * @param the "Enchantments" ListTag from an item's nbt
	 */ 
	private static ArrayList<String> enchantsToLoreString(ListTag enchantsTag){
		if(enchatnsTag.size() == 0)
			return new String[0];
		String enchants = "";
		ArrayList<String> result = new ArrayList<>();
		for(int i = 0; i < enchantsTag.size(); i++){
			CompoundTag currEnch = enchantsTag.getCompound(i);
			int level = currEnch.getInt("lvl");
			ToaEnchantment toaEnch = getEnchantByName(currEnch.getString("id"));
			char prefix;
			if(level == toaEnch.getMaxLevel()){
				prefix = '6';
			}
			else if(level >= toaEnch.getRarePrefixLevel()){
				prefix = '5';
			}
			else{
				prefix = '9';
			}
			enchants += "§" + prefix +""+ CurrEnch.getString("id") +""+ ToaFormats.RomanNumbers[level-1] +"" + ((i == enchantsTag.size()-1)? "§r" : "§7, "); 
			if(enchants.length() >= 18){
				result.add(enchants);
				enchants = "";
			}
		}
		return enchants.split("\n");
	}

	/**
	 * @param the full Nbt of an item since it needs "Stats", "Upgrades" and "Enchantments" Tags of the item
	 * 
	 */
	private static ArrayList<String> statsToLoreString(CompoundTag itemTag) {
		ArrayList<String> result = new ArrayList<>();
		String temp = "";
		CompoundTag upgrades = itemTag.getCompound("Upgrades");
		CompoundTag stats = itemTag.getCompound("Stats");
		ListTag enchants = itemTag.getList("Enchantments", 10);
		//Grob struktur
		/*if(stats.getFloat("str_f") != 0)
		 * 		temp += "§7Str §c"+stats.getFloat("str_f") + ""  //enchants and other modifiers like [+23], (+20), etc...
		 *if(stats.getFloat("str_p") != 0)																						=> OR put them together like:  "Str +45 | +8% [+34] (+24) [+6%]"   or something like that
		 * 		temp += "§7Str §c"+stats.getFloat("str_p") + "% "  //enchants and other modifiers like [+23], (+20), etc...
		 * 
		 *
		 */

	}

	private static ToaEnchantment getEnchantByName(String name){
		return switch(name){
			case "sharpness" -> ToamodModEnchantments.SHARPNESS.get();
			case "executing" -> ToamodModEnchantments.EXECUTING.get();
			case "protection" -> ToamodModEnchantments.PROTECTION.get()
			default -> null;
		};
	}
}
