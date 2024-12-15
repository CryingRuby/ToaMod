package net.mcreator.toamod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

public enum ReforgeType {
	FORCEFUL("forceful", "Sword", (new ToaProperties("Reforge", ToaRarity.UNCOMMON)).str(new float[]{10, 20, 30, 45, 60, 75, 95}).cr(1).cd(1)), 
	STRONG("strong", "Sword", (new ToaProperties("Reforge", ToaRarity.COMMON)).str(new float[]{25, 40, 55, 75, 100, 135, 200})), WISE("wise", "Sword", (new ToaProperties("Reforge", ToaRarity.RARE)).wis(new float[]{20, 35, 55, 80, 110, 150, 200})), 
	FLEXIBLE("flexible","Armor",(new ToaProperties("Reforge", ToaRarity.COMMON)).dex(new float[]{10, 20, 30, 40, 50, 70, 90})), 
	BULLETPROOF("bulletproof", "Armor", (new ToaProperties("Reforge", ToaRarity.UNCOMMON)).hp(new float[]{15, 30, 45, 60, 75, 95, 125}).ar(new float[]{20, 40, 60, 80, 100, 140, 180})),
	MYSTIC("mystic", "Armor", (new ToaProperties("Reforge", ToaRarity.UNCOMMON)).hp(new float[]{15, 30, 45, 60, 75, 95, 125}).mr(new float[]{20, 40, 60, 80, 100, 140, 180})),
	MAGICAL("magical", "Sword", (new ToaProperties("Reforge", ToaRarity.COMMON))._int(new float[]{20, 35, 55, 80, 110, 150, 200})),
	BALANCED("balanced", "Sword",(new ToaProperties("Reforge", ToaRarity.UNCOMMON)).str(new float[]{10, 20, 30, 40, 55, 75, 100})._int(new float[]{10, 20, 30, 40, 55, 75, 100})),
	SUPERIOR("superior", "Sword",(new ToaProperties("Reforge", ToaRarity.LEGENDARY)).str(new float[]{10, 20, 30, 40, 50, 60, 70})._int(new float[]{10, 20, 30, 40, 50, 60, 70}).mf(new float[]{0, 0, 6, 8, 10, 12, 15})),
	EMPOWERED("empowered", "Armor",(new ToaProperties("Reforge", ToaRarity.EPIC)).str(new float[]{5, 10, 15, 20, 25, 30, 35}).ar(new float[]{5, 10, 20, 30, 40, 50, 65}).cr(new float[]{1, 2, 4, 6, 8, 10, 12}).cd(new float[]{4, 8, 12, 18, 22, 28, 35})),
	GIANT("giant", "Armor",(new ToaProperties("Reforge", ToaRarity.RARE)).hp(new float[]{50, 100, 150, 200, 275, 350, 450}).ar(new float[]{4, 8, 12, 16, 20, 24, 28}).mr(new float[]{4, 8, 12, 16, 20, 24, 28})), 
	MIRACULOUS("miraculous","Armor",(new ToaProperties("Reforge", ToaRarity.EPIC))._int(new float[]{5, 10, 15, 20, 25, 30, 35}).mr(new float[]{5, 10, 20, 30, 40, 50, 65}).cr(new float[]{1, 2, 4, 6, 8, 10, 12}).cd(new float[]{4, 8, 12, 18, 22, 28, 35})),
	VAMPIRIC("vampiric", "Sword",(new ToaProperties("Reforge", ToaRarity.EPIC)).str(new float[]{5, 5, 10, 10, 15, 15, 20}).lifesteal(new float[]{2, 4, 6, 9, 12, 15, 18})), 
	PRECISE("precise", "Sword",(new ToaProperties("Reforge", ToaRarity.LEGENDARY)).cr(new float[]{5, 8, 12, 16, 20, 25, 33}).cd(new float[]{30, 65, 100, 140, 185, 235, 300}).str(new float[]{0, -5, -10, -20, -30, -45, -60})),
	RICH("rich","Pickaxe",(new ToaProperties("Reforge", ToaRarity.UNCOMMON)).minf(new float[]{10, 20, 35, 50, 70, 95, 130})),
	HEATED("heated", "Pickaxe",(new ToaProperties("Reforge", ToaRarity.RARE)).minf(new float[]{6, 15, 27, 40, 55, 70, 90}).wis(new float[]{9, 18, 27, 36, 45, 54, 64})),
	SHINY("shiny", "Armor",(new ToaProperties("Reforge", ToaRarity.RARE)).ar(new float[]{4, 8, 12, 16, 20, 25, 30}).mr(new float[]{4, 8, 12, 16, 20, 25, 30}).minf(new float[]{5, 10, 20, 30, 45, 60, 80}).wis(new float[]{2, 4, 6, 8, 10, 12, 14})), 
	SPARKLING("sparkling","Equipment",(new ToaProperties("Reforge", ToaRarity.EPIC)).hp(new float[]{2, 4, 6, 8, 10, 12, 15}).mf(new float[]{0, 1, 1, 1, 2, 3, 4}));

	private ToaProperties stats;
	public final String itemTypes;
	public final String name;

	/**
	 * @param itemType are the types of items this reforge can be used for
	 */
	private ReforgeType(String name, String itemTypes, ToaProperties stats) {
		this.name = name;
		this.itemTypes = itemTypes;
		this.stats = stats;
	}

	public static ReforgeType getByName(String name) {
		return switch (name) {
			case "forceful" -> FORCEFUL;
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

			default -> STRONG;
		};
	}

	public ToaProperties getProperties(){
		return this.stats;
	}
	
	//APPLY Methods are in ToaProperties combined
}
