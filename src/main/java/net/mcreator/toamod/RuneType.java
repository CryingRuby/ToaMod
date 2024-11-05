package net.mcreator.toamod;

import net.minecraft.world.item.ItemStack;

public enum RuneType {
	STR("str"), DEX("dex"), CON("con"), INT("int"), WIS("wis"), CR("cr"), CD("cd"), ELEM_DMG("elem_dmg"), AR("ar"), MR("mr");

	RuneType(String name) {
		this.Name = name;
	}

	public final String Name;

	public static RuneType getByItem(ItemStack item) {
		String type = item.getOrCreateTag().getString("type");
		return switch(type){
			case "dex" -> STR;
			case "con" -> CON;
			case "int" -> INT;
			case "wis" -> WIS;
			case "cr" -> CR;
			case "cd" -> CD;
			case "elem_dmg" -> ELEM_DMG;
			case "ar" -> AR;
			case "mr" -> MR;
			default -> STR;
		};
	}
}
