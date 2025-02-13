package net.mcreator.toamod;


public interface ToaSellable {
	/**
	 * @return the sell value of the item in "Cor" (in-game currency)
	 */
	public int getSellValue();

	/**
	 * Basically only used by items with nbt that makes it hard to determine the price.
	 * If the item is one of that kind Override it and return false.
	 * 
	 * @default is for items that can't have nbt or just simple nbt that don't change the price.
	 * 
	 * @return whether the item is sellable if it has additional custom nbt data
	 */
	 default public boolean isSellableWithNBT(){
		return true;
	}
}
