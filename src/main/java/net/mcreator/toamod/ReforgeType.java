package net.mcreator.toamod;

public enum ReforgeType {
	FORCEFUL();

	private ToaProperties stats;

	private ReforgeType() {
	}

	public ReforgeType getByString() {
		return FORCEFUL;
	}
}
