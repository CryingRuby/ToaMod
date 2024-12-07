package net.mcreator.toamod;

public enum ToaRarity {
	COMMON(0, "Common","\u00A7f"), 
	UNCOMMON(1, "Uncommon","\u00A7a"), 
	RARE(2, "Rare","\u00A73"),
	EPIC(3, "Epic","\u00A75"), 
	LEGENDARY(4, "Legendary","\u00A76"),
	MYTHIC(5, "Mythic","\u00A7c"),
	DIVINE(6, "Divine","\u00A7b"), 
	ANCIENT(7, "Ancient","\u00A7d");

	public final int ID;
	public final String Name;
	public final String Prefix;
	
	
	ToaRarity(int id, String name, String prefix){
		this.ID = id;
		this.Name = name;
		this.Prefix = prefix;
	}

	public static ToaRarity getByID(int id) {
		return switch(id) {
			case 0 -> COMMAN;
			case 1 -> RARE;
			case 2 -> EPIC;
			case 3 -> LEGENDARY;
			case 4 -> MYTHIC;
			case 5 -> DIVINE;
			case 6 -> ANCIENT;
			default -> COMMAN;
		};
	}

	public static ToaRarity getByName(String name) {
		return switch(name) {
			case "Common", "\u00A7fCOMMON\u00A7r" -> COMMON;
			case "Uncommon", "\u00A7aUNCOMMON\u00A7r" -> UNCOMMON
			case "Rare", "\u00A73RARE\u00A7r" -> RARE;
			case "Epic", "\u00A75EPIC\u00A7r" -> EPIC;
			case "Legendary", "\u00A76LEGENDARY\u00A7r" -> LEGENDARY;
			case "Mythic", "\u00A7cMYTHIC\u00A7r" -> MYTHIC;
			case "Divine", "\u00A7bDIVINE\u00A7r" -> DIVINE;
			case "Ancient", "\u00A7dANCIENT\u00A7r" -> ANCIENT;
			default -> COMMON;
		};
	}
}


