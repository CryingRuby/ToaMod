
package net.mcreator.toamod;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.toamod.init.ToamodModEnchantments;

import java.util.ArrayList;

public final class CustomNbtHandler {
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
		//Apply Enchant-Stats to item
		for (int i = 0; i < nbtFrom.getList("Enchantments", 10).size(); i++) {
			CompoundTag tempEnch = (CompoundTag) nbtFrom.getList("Enchantments", 10).get(i);
			ToaEnchantment ench = getEnchantByName(tempEnch.getString("id").replace("toamod:", ""));
			applyEnchantToStats(ench, tempEnch.getInt("lvl"), copyTo);
		}

		//Reforge
		if (!nbtUpgradesFrom.getString("reforge").isEmpty()) {
			ToaProperties.applyReforgeToItem(ReforgeType.getByName(nbtUpgradesFrom.getString("reforge")), copyTo, 1);
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
			for (int i = 0; i < runes.size(); i++) {
				RuneType rune = RuneType.getByID(runes.getCompound(i).getString("type"));
				if (rune == null)
					continue;
				ToaProperties.applyRuneToItem(rune, copyTo, runes.getCompound(i).getInt("rarity"), 1);
			}
			for (int i = runes.size(); i < ((ToaReforgeable) copyTo.getItem()).runeSlots.length; i++) {
				runes.add(new CompoundTag());
			}
			nbtUpgradesFrom.put("Runes", runes);

		}
		if (nbtUpgradesFrom.getInt("stars") > 0) {
			applyStarsToItem(copyTo, nbtUpgradesFrom.getInt("stars"));
		}
		copyTo.getOrCreateTag().put("Upgrades", nbtUpgradesFrom);
		System.out.println(copyTo.getOrCreateTag().getCompound("Stats").toString());
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

	public static void applyEnchantToStats(ToaEnchantment enchant, int level, ItemStack item) {
		if (enchant.getProperties() == null || enchant.getProperties().getPresentIDs().isEmpty())
			return;
		ToaProperties.applyEnchantToItem(enchant, item, level - 1, 1);
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
		ToaRarity rarity = ToaRarity.getByID(item.getOrCreateTag().getInt("rarity"));
		CompoundTag upgrades = item.getOrCreateTag().getCompound("Upgrades");
		//Reihenfolge:
		//Reforge
		if (!upgrades.getString("reforge").isEmpty()) {
			String reforge = item.getOrCreateTag().getCompound("Upgrades").getString("reforge");
			//Adds the reforge name in front of the item name with rarity color;  Iron Sword -> Forceful Iron Sword
			System.out.println("lore reforge-string: " + reforge);
			//get the display of the item without any reforge -> otherwise the reforge prefixes will stack indefinetly
			String baseItemDisplay = (new ItemStack(item.getItem())).getDisplayName().getString().replace("[", "").replace("]", "");
			System.out.println("base item: " + item.getItem() + ", display: " + baseItemDisplay);
			System.out.println("final ItemName: " + (rarity.Prefix + ("" + reforge.charAt(0)).toUpperCase() + reforge.substring(1) + " " + baseItemDisplay));
			String finalName = rarity.Prefix + ("" + reforge.charAt(0)).toUpperCase() + reforge.substring(1) + " " + baseItemDisplay;
			lore.putString("Name", StringTag.quoteAndEscape(finalName));
			//item.setHoverName(Component.literal(finalName));
		}
		//Rune Slots
		if (!upgrades.getList("Runes", 10).isEmpty()) {
			loreLines.add(StringTag.valueOf(StringTag.quoteAndEscape(runesToLoreString(upgrades.getList("Runes", 10)))));
			loreLines.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
		}
		//Stats
		{
			ArrayList<String> lines = statsToLoreString(item);
			for (int i = 0; i < lines.size(); i++) {
				loreLines.add(StringTag.valueOf(StringTag.quoteAndEscape(lines.get(i))));
			}
			if (!lines.isEmpty())
				loreLines.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
		}
		//Enchantments
		if (!item.getOrCreateTag().getList("Enchantments", 10).isEmpty()) {
			ArrayList<String> lines = enchantsToLoreString(item.getOrCreateTag().getList("Enchantments", 10));
			for (int i = 0; i < lines.size(); i++) {
				loreLines.add(StringTag.valueOf(StringTag.quoteAndEscape(lines.get(i))));
			}
		}
		//Description (Optional)
		//loreLines.addAll(((ToaItem)item.getItem()).getDescription())   //Oder sowas ähnliches, falls überhaupt
		//Type / Rarity
		loreLines.add(StringTag.valueOf(StringTag.quoteAndEscape(" ")));
		loreLines.add(StringTag.valueOf(StringTag.quoteAndEscape("\u00A77Type: \u00A79" + item.getOrCreateTag().getString("type"))));
		loreLines.add(StringTag.valueOf(StringTag.quoteAndEscape("\u00A77Rarity: " + rarity.Prefix + rarity.Name.toUpperCase())));
		lore.put("Lore", loreLines);
		item.getOrCreateTag().put("display", lore);
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
	 * This method is called if the item has runes
	 * @param the ListTag of the runeSlots of an item
	 */
	private static String runesToLoreString(ListTag runesTag) {
		String result = "";
		for (int i = 0; i < runesTag.size(); i++) {
			if (runesTag.getCompound(i).isEmpty()) {
				result += "\u00A78[\u2718]\u00A7r ";
				continue;
			}
			ToaRarity rarity = ToaRarity.getByID(runesTag.getCompound(i).getInt("rarity"));
			RuneType rune = RuneType.getByID(runesTag.getCompound(i).getString("type"));
			result += rarity.Prefix + "[\u00A7r" + rune.symbolColor + rune.symbol + rarity.Prefix + "]\u00A7r ";
		}
		return result;
	}

	/**
	 * @param the full Nbt of an item since it needs "Stats", "Upgrades" and "Enchantments" Tags of the item
	 */
	private static ArrayList<String> statsToLoreString(ItemStack item) {
		ArrayList<String> result = new ArrayList<>();
		CompoundTag upgrades = item.getOrCreateTag().getCompound("Upgrades");
		CompoundTag stats = item.getOrCreateTag().getCompound("Stats");
		//Grob struktur
		/*  
		 * Jedem Stat in toaProperties eine id zuweisen -> Array machen oder so idk. ID dann nur für interne code effizent, nichts für game features
		 * 
		 * Enchantments: auch so was probieren, also idk ArrayList<Byte> erstellen mit der id von den stats die das item hat, dann aus enchantments-stats die id für den stat ziehen und ann stelle wo die enchtment-stat-id mit dem Stat-ID-Array übereinstimmt
		 * in die ArrayList<String> anhängen als String
		 * 
		 * Reforge: auch mit stat-ID von reforge-stats und vergleichen
		 * 
		 * Runes: Bsp Array von RuneTypes erstellen und wenn ein element von 'runes' entsprcht an der stelle im ArrayList<String> dann
		 * dazu fügen -> vorher alle anderen Elemente von 'runes' durchgehen und schauen ob es gleiche runes gibt -> dann zusammenaddieren und an ArrayList<String> anhängen. Dabei Runes von 'runes' entfernen (vermutlich zur ArrayList<RuneType> machen)
		 * 
		 * 
		 */
		ArrayList<String> statLines = new ArrayList<String>();
		ArrayList<Byte> statIdList = getAllUpgradedStats(item);
		removeAllNonUpgradedStats(item, statIdList);

		for(int i = 0; i < statIdList.size(); i++){
			//form: §7<Stat-Name> §c(+/-)<Stat-Value>
			statLines.add("\u00A77"+ToaProperties.getStatNameByID(statIdList.get(i)) + " \u00A7c" + ((stats.getFloat(ToaProperties.getStatTagNameByID(statIdList.get(i))) >= 0) ? "+" : "") + ToaFormats.floatToString(stats.getFloat(ToaProperties.getStatTagNameByID(statIdList.get(i)))));
		}

		System.out.println("statIDList: " + statIdList);
		System.out.println("stats: " + stats.toString());
		//Reforge
		ReforgeType reforge = ReforgeType.getByName(upgrades.getString("reforge"));
		System.out.println("reforge: " + reforge);
		if (reforge != null) {
			int itemRarity = item.getOrCreateTag().getInt("rarity");
			System.out.println("	rarity:" + itemRarity);
			ArrayList<Byte> reforgeStatIds = reforge.getProperties().getPresentIDs();
			for (int i = 0; i < reforgeStatIds.size(); i++) {
				System.out.println("SearchIndexOfList: Reforge");
				byte index = getIndexOfListByStatID(reforgeStatIds.get(i), statIdList);
				//if the currentStat is CR, CD, Lifesteal add "%" to the end of the stat
				String extraPostfix = (reforgeStatIds.get(i) >= 5 && reforgeStatIds.get(i) <= 7) ? "%" : "";
				//Adds the value of the specific stat of the reforge based on the itemRarity to the corresponding statLine. In From: (+34)
				float statValue = reforge.getProperties().getValueByID(reforgeStatIds.get(i))[itemRarity];
				if (statValue == 0)
					continue;
				String numberPrefix = ((statValue > 0) ? "+" : "");
				statLines.set(index, statLines.get(index) + " \u00A79(" + numberPrefix + ToaFormats.floatToString(statValue) + extraPostfix + ")");
			}
		}

		//Enchants
		{
			ListTag enchants = item.getOrCreateTag().getList("Enchantments", 10);
			for (int i = 0; i < enchants.size(); i++) {
				ToaEnchantment ench = getEnchantByName(enchants.getCompound(i).getString("id").replace("toamod:", ""));
				if (ench.getProperties() == null || ench.getProperties().getPresentIDs().isEmpty())
					continue;
				//Enchantments only have ONE or less stat
				byte id = ench.getProperties().getPresentIDs().get(0);
				byte index = getIndexOfListByStatID(id, statIdList);
				//if the currentStat is CR, CD, Lifesteal add "%" to the end of the stat
				String extraPostfix = (id >= 5 && id <= 7) ? "%" : "";
				statLines.set(index, statLines.get(index) + " \u00A79[+" + ToaFormats.floatToString(ench.getProperties().getValueByID(id)[((CompoundTag) enchants.get(i)).getInt("lvl") - 1]) + extraPostfix + "]");
			}
		}
		//Runes
		{
			RuneType[] runes = new RuneType[upgrades.getList("Runes", 10).size()];
			System.out.println("SearchIndexOfList: Runes");
			for (int i = 0; i < runes.length; i++) {
				runes[i] = RuneType.getByID(((CompoundTag) upgrades.getList("Runes", 10).get(i)).getString("type"));
				if (runes[i] == null)
					continue;
				//Runes only have one stat => presentIds.size() == 1 -> id
				byte id = runes[i].getProperties().getPresentIDs().get(0);
				byte index = getIndexOfListByStatID(id, statIdList);
				int runeRarity = upgrades.getList("Runes", 10).getCompound(i).getInt("rarity");
				//if the currentStat is CR, CD, Lifesteal add "%" to the end of the stat
				String extraPostfix = (id >= 5 && id <= 7) ? "%" : "";
				statLines.set(index, statLines.get(index) + " \u00A7d[+" + ToaFormats.floatToString(runes[i].getProperties().getValueByID(id)[runeRarity]) + extraPostfix + "]");
			}
		}
		return statLines;
	}

	/**
	 * @param the "Enchantments" ListTag from an item's nbt
	 */
	public static ArrayList<String> enchantsToLoreString(ListTag enchantsTag) {
		if (enchantsTag.size() == 0)
			return new ArrayList<String>();
		String enchants = "";
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < enchantsTag.size(); i++) {
			CompoundTag currEnch = enchantsTag.getCompound(i);
			int level = currEnch.getInt("lvl");
			ToaEnchantment toaEnch = getEnchantByName(currEnch.getString("id").replace("toamod:", ""));
			char prefix;
			if (level == toaEnch.getMaxLevel()) {
				prefix = '6';
			} else if (level >= toaEnch.getRarePrefixLevel()) {
				prefix = '5';
			} else {
				prefix = '9';
			}
			String[] temp = currEnch.getString("id").replace("toamod:", "").split("_");
			String enchName = ("" + temp[0].charAt(0)).toUpperCase() + temp[0].substring(1);
			for (int j = 1; j < temp.length; j++) {
				enchName += (" " + temp[j].charAt(0)).toUpperCase() + temp[j].substring(1);
			}
			enchants += "\u00A7" + prefix + enchName + " " + ToaFormats.RomanNumbers[level] + ((i == enchantsTag.size() - 1) ? "\u00A7r" : "\u00A77, ");
			if (enchants.length() >= 30 || i == enchantsTag.size() - 1) {
				result.add(enchants);
				enchants = "";
			}
		}
		return result;
	}

	public static ToaEnchantment getEnchantByName(String name) {
		Enchantment ench = switch (name) {
			case "sharpness" -> ToamodModEnchantments.SHARPNESS.get();
			case "executing" -> ToamodModEnchantments.EXECUTING.get();
			case "protection" -> ToamodModEnchantments.PROTECTION.get();
			case "spikes" -> ToamodModEnchantments.SPIKES.get();
			case "ignite" -> ToamodModEnchantments.IGNITE.get();
			case "powerful" -> ToamodModEnchantments.POWERFUL.get();
			case "fortune" -> ToamodModEnchantments.FORTUNE.get();
			case "critical" -> ToamodModEnchantments.CRITICAL.get();
			case "scavengar" -> ToamodModEnchantments.SCAVENGER.get();
			case "stickyfeet" -> ToamodModEnchantments.STICKYFEET.get();
			case "manaflow" -> ToamodModEnchantments.MANAFLOW.get();
			case "focus" -> ToamodModEnchantments.FOCUS.get();
			case "divine_gift" -> ToamodModEnchantments.DIVINE_GIFT.get();
			case "growth" -> ToamodModEnchantments.GROWTH.get();
			case "shiny" -> ToamodModEnchantments.SHINY.get();
			case "vampirism" -> ToamodModEnchantments.VAMPIRISM.get();
			case "magic_protection" -> ToamodModEnchantments.MAGIC_PROTECTION.get();
			case "chimera" -> ToamodModEnchantments.CHIMERA.get();
			default -> null;
		};
		return (ToaEnchantment) ench;
	}

	/**
	 * Searches a stat-id in an array of existing stat-ids
	.
	 * Used in statsToLoreString to apply Reforge, Enchantments, Runes, etc stats to the fitting statLine of the stats-ArrayList
	.
	 * 
	 * Since the given idList from the statsToLoreString-method is ascending this search algorithmen halves the list to search -> Runtime O(log(n))
	.
	 * 
	 * @param id: the stat-id that will be searched in the list
	 * @param idList: the list the given stat-id will be searched in (ascending)
	 * 
	 * @return gives the index at which the given stat-id is in the given idList OR -1 if it's not included (the -1 shouldn't really happen)
	 */
	private static byte getIndexOfListByStatID(byte id, ArrayList<Byte> idList) {
		for (int i = 0; i < idList.size(); i++) {
			System.out.print(idList.get(i) + " ");
		}
		System.out.println();
		int left = 0;
		int right = idList.size() - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (idList.get(middle) == id) {
				return (byte) middle;
			} else if (idList.get(middle) < id) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return (byte) -1;
	}

	/**
	 * Collects all statIds of stats that are part of an items base stats OR modified by any upgrade (reforge, runes, etc...)
	 */
	public static ArrayList<Byte> getAllUpgradedStats(ItemStack item){
		CompoundTag stats = item.getOrCreateTag().getCompound("Stats");
		CompoundTag upgrades = item.getOrCreateTag().getCompound("Upgrades");
		//add Base stats to id-list
		ArrayList<Byte> statIds = ((ToaReforgeable) item.copy().getItem()).getProperties().getPresentIDs();
		//END if there are no upgrades
		if(item.getOrCreateTag().contains("Upgrades") || upgrades.isEmpty())
			return statIds;

			
		//Reforge
		{
			ReforgeType reforge = ReforgeType.getByName(upgrades.getString("reforge"));
			if(reforge != null){
				for(int i = 0; i < reforge.getProperties().getPresentIDs().size(); i++){
					if(statIds.contains(reforge.getProperties().getPresentIDs().get(i))){
						continue;
					}
					statIds.add(reforge.getProperties().getPresentIDs().get(i));
				}
			}
		}
		//Runes
		{
			ListTag runes = upgrades.getList("Runes", 10);
			for(int i = 0; i < runes.size(); i++){
				RuneType rune = RuneType.getByID(runes.getCompound(i).getString("type"));
				if(statIds.contains(rune.getProperties().getPresentIDs().get(0)))
					continue;
				statIds.add(rune.getProperties().getPresentIDs().get(0));
			}
		}
		//Enchants
		{
			ListTag enchants = item.getOrCreateTag().getList("Enchantments", 10);
			for (int i = 0; i < enchants.size(); i++) {
				ToaEnchantment ench = getEnchantByName(enchants.getCompound(i).getString("id").replace("toamod:", ""));
				if (ench.getProperties() == null || ench.getProperties().getPresentIDs().isEmpty())
					continue;
				//Enchantments only have ONE or less stat
				byte id = ench.getProperties().getPresentIDs().get(0);
				if(statIds.contains(id))
					continue;
				statIds.add(id);
			}

		}
			
		return statIds;
	}

	public static void removeAllNonUpgradedStats(ItemStack item, ArrayList<Byte> statIds){
		CompoundTag stats = item.getOrCreateTag().getCompound("Stats");
		for(byte i = 0; i < ToaProperties.statCount; i++){
			float statValue = stats.getFloat(ToaProperties.getStatTagNameByID(i));
			if(!statIds.contains(i) && statValue < 10e-5 && statValue > -10e-5){
				stats.remove(ToaProperties.getStatTagNameByID(i));
			}
		}
	}
}
