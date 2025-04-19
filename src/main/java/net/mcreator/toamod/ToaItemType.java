package net.mcreator.toamod;

public enum ToaItemType {
	SWORD("Sword"), ARMOR("Armor"), PICKAXE("Pickaxe"), EQUIPMENT("Equipment"), ARTEFACT("Artefact");

	private final String name;

	ToaItemType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public static ToaItemType getByName(String name) {
	System.out.println("return ToaItemType with name:"+ name);
		return switch (name) {
			case "Sword" -> SWORD;
			case "Armnor" -> ARMOR;
			case "Pickaxe" -> PICKAXE;
			case "Equipment" -> EQUIPMENT;
			case "Artefact" -> ARTEFACT;
			default -> null;
		};
	}
}
