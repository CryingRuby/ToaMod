package net.mcreator.toamod;

public interface ToaMob {
	public int getCorReward();
	public int getComXpReward();
	default public int getMdReward() {return 0;};
}
