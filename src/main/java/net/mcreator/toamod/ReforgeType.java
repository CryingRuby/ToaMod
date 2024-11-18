package net.mcreator.toamod;

public enum ReforgeType {
	FORCEFUL("forceful", new ToaProperties[]{
		(new ToaProperties()).str(),
		(new ToaProperties()).str(25),
		(new ToaProperties()).str(35),
		(new ToaProperties()).str(50),
		(new ToaProperties()).str(75),
		(new ToaProperties()).str(105),
		(new ToaProperties()).str(145),
		(new ToaProperties()).str(200)
		});

	private ToaProperties[] stats;
	public final String name;

	private ReforgeType(String name, ToaProperties[] stats) {
		this.name = name;
		this.stats = stats
	}

	public ReforgeType getByName(String name) {
		return FORCEFUL;
	}

	public void applyReforgeToItem(ItemStack item){
		
	}
}
