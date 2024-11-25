package net.mcreator.toamod;

public enum ToaElement {
	HOLY("Holy"), UNHOLY("Unholy"), FIRE("Fire"), ICE("Ice"), THUNDER("Thunder"), VOID("Void");

	ToaElement(String _name) {
		this.name = _name;
	}

	public final String name;

	public static ToaElement getByName(String name){
		return switch(name){
			case "Holy" -> HOLY;
			case "Unholy" -> UNHOLY;
			case "Fire" -> FIRE;
			case "Ice" -> ICE;
			case "Thunder" -> THUNDER;
			case "Void" -> VOID;
			default -> null;
		};
	}
}
