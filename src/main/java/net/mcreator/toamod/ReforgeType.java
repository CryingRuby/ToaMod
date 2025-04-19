package net.mcreator.toamod;

public enum ReforgeType {
	FORCEFUL(0, "forceful", ToaItemType.SWORD, 2500, (new ToaProperties("Reforge", ToaRarity.UNCOMMON)).str(new float[]{10, 20, 30, 45, 60, 75, 95}).cr(1).cd(1)), 
	STRONG(1, "strong", ToaItemType.SWORD, 1000, (new ToaProperties("Reforge", ToaRarity.COMMON)).str(new float[]{25, 40, 55, 75, 100, 135, 200})), 
	WISE(2, "wise", ToaItemType.SWORD, 5000, (new ToaProperties("Reforge", ToaRarity.RARE)).wis(new float[]{20, 35, 55, 80, 110, 150, 200})), 
	FLEXIBLE(3, "flexible", ToaItemType.ARMOR, 2000, (new ToaProperties("Reforge", ToaRarity.COMMON)).dex(new float[]{10, 20, 30, 40, 50, 70, 90})), 
	BULLETPROOF(4, "bulletproof", ToaItemType.ARMOR, 1000, (new ToaProperties("Reforge", ToaRarity.UNCOMMON)).hp(new float[]{15, 30, 45, 60, 75, 95, 125}).ar(new float[]{20, 40, 60, 80, 100, 140, 180})), 
	MYSTIC(5, "mystic", ToaItemType.ARMOR, 1000, (new ToaProperties("Reforge", ToaRarity.UNCOMMON)).hp(new float[]{15, 30, 45, 60, 75, 95, 125}).mr(new float[]{20, 40, 60, 80, 100, 140, 180})), 
	MAGICAL(6, "magical", ToaItemType.SWORD, 2000, (new ToaProperties("Reforge", ToaRarity.COMMON))._int(new float[]{20, 35, 55, 80, 110, 150, 200})), 
	BALANCED(7, "balanced", ToaItemType.SWORD, 5000, (new ToaProperties("Reforge", ToaRarity.UNCOMMON)).str(new float[]{10, 20, 30, 40, 55, 75, 100})._int(new float[]{10, 20, 30, 40, 55, 75, 100})), 
	SUPERIOR(8, "superior", ToaItemType.SWORD, 10000, (new ToaProperties("Reforge", ToaRarity.LEGENDARY)).str(new float[]{10, 20, 30, 40, 50, 60, 70})._int(new float[]{10, 20, 30, 40, 50, 60, 70}).mf(new float[]{0, 0, 6, 8, 10, 12, 15})), 
	EMPOWERED(9, "empowered", ToaItemType.ARMOR, 7500, (new ToaProperties("Reforge", ToaRarity.EPIC)).str(new float[]{5, 10, 15, 20, 25, 30, 35}).ar(new float[]{5, 10, 20, 30, 40, 50, 65}).cr(new float[]{1, 2, 4, 6, 8, 10, 12}).cd(new float[]{4, 8, 12, 18, 22, 28, 35})), 
	GIANT(10, "giant", ToaItemType.ARMOR, 5000, (new ToaProperties("Reforge", ToaRarity.RARE)).hp(new float[]{50, 100, 150, 200, 275, 350, 450}).ar(new float[]{4, 8, 12, 16, 20, 24, 28}).mr(new float[]{4, 8, 12, 16, 20, 24, 28})), 
	MIRACULOUS(11, "miraculous", ToaItemType.ARMOR, 7500, (new ToaProperties("Reforge", ToaRarity.EPIC))._int(new float[]{5, 10, 15, 20, 25, 30, 35}).mr(new float[]{5, 10, 20, 30, 40, 50, 65}).cr(new float[]{1, 2, 4, 6, 8, 10, 12}).cd(new float[]{4, 8, 12, 18, 22, 28, 35})), 
	VAMPIRIC(12, "vampiric", ToaItemType.SWORD, 8000, (new ToaProperties("Reforge", ToaRarity.EPIC)).str(new float[]{5, 5, 10, 10, 15, 15, 20}).lifesteal(new float[]{2, 4, 6, 9, 12, 15, 18})), 
	PRECISE(13, "precise", ToaItemType.SWORD, 10000, (new ToaProperties("Reforge", ToaRarity.LEGENDARY)).str(new float[]{0, -5, -10, -20, -30, -45, -60}).cr(new float[]{5, 8, 12, 16, 20, 25, 33}).cd(new float[]{30, 65, 100, 140, 185, 235, 300})), 
	RICH(14, "rich", ToaItemType.PICKAXE, 2500, (new ToaProperties("Reforge", ToaRarity.UNCOMMON)).minf(new float[]{10, 20, 35, 50, 70, 95, 130})), 
	HEATED(15, "heated", ToaItemType.PICKAXE, 5000, (new ToaProperties("Reforge", ToaRarity.RARE)).minf(new float[]{6, 15, 27, 40, 55, 70, 90}).wis(new float[]{9, 18, 27, 36, 45, 54, 64})), 
	SHINY(16, "shiny", ToaItemType.ARMOR, 7500, (new ToaProperties("Reforge", ToaRarity.RARE)).ar(new float[]{4, 8, 12, 16, 20, 25, 30}).mr(new float[]{4, 8, 12, 16, 20, 25, 30}).minf(new float[]{5, 10, 20, 30, 45, 60, 80}).wis(new float[]{2, 4, 6, 8, 10, 12, 14})), 
	SPARKLING(17, "sparkling", ToaItemType.EQUIPMENT, 6000, (new ToaProperties("Reforge", ToaRarity.EPIC)).hp(new float[]{2, 4, 6, 8, 10, 12, 15}).mf(new float[]{0, 1, 1, 1, 2, 3, 4}));

	private final ToaProperties stats;
	private final int id;
	private final int applyCost; //cost of the reforge to apply multiplied with (rarity+1) squared
	private final ToaItemType itemType;
	private final String name;

	/**
	 * @param itemType are the types of items this reforge can be used for
	 */
	private ReforgeType(int id, String name, ToaItemType itemType, int applyCost, ToaProperties stats) {
		this.name = name;
		this.itemType = itemType;
		this.applyCost = applyCost;
		this.stats = stats;
		this.id = id;
	}

	public static ReforgeType getByName(String name) {
		return switch (name) {
			case "forceful" -> FORCEFUL;
			case "strong" -> STRONG;
			case "wise" -> WISE;
			case "flexible" -> FLEXIBLE;
			case "bulletproof" -> BULLETPROOF;
			case "mystic" -> MYSTIC;
			case "magical" -> MAGICAL;
			case "balanced" -> BALANCED;
			case "superior" -> SUPERIOR;
			case "empowered" -> EMPOWERED;
			case "giant" -> GIANT;
			case "miraculous" -> MIRACULOUS;
			case "vampiric" -> VAMPIRIC;
			case "precise" -> PRECISE;
			case "rich" -> RICH;
			case "heated" -> HEATED;
			case "shiny" -> SHINY;
			case "sparkling" -> SPARKLING;
			default -> null;
		};
	}

	public ToaProperties getProperties() {
		return this.stats;
	}

	public int getID(){
		return this.id;
	}

	public ToaItemType getItemType(){
		return this.itemType;
	}

	public String getName(){
		return this.name;
	}

	/**
	 * @param of an item 0: Comman; 7: Ancient
	 */
	public int getApplyCost(int rarity){
		rarity++;
		return this.applyCost * rarity * rarity;
	}

	public static ReforgeType[] getAllByType(ToaItemType type){
		return switch(type){
			case SWORD -> new ReforgeType[]{FORCEFUL,STRONG,WISE,MAGICAL,BALANCED,SUPERIOR,VAMPIRIC,PRECISE};
			case ARMOR -> new ReforgeType[]{FLEXIBLE,BULLETPROOF,MYSTIC,EMPOWERED,GIANT,MIRACULOUS,SHINY};
			case PICKAXE -> new ReforgeType[]{RICH,HEATED};
			case EQUIPMENT -> new ReforgeType[]{SPARKLING};
			default -> null;
		};
	}

	//APPLY Methods are in ToaProperties combined
}
