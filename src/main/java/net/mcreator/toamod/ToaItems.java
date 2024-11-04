package net.mcreator.toamod;

import org.checkerframework.checker.units.qual.cd;

import net.minecraftforge.common.property.Properties;

import net.minecraft.world.item.ItemStack;

import net.mcreator.toamod.init.ToamodModItems;

public class ToaItems {
	private ToaItems() { //static class
	}

	//ToaItems - Weapons
	public static final ItemStack WOODEN_SWORD = createToaItem(new ItemStack(ToamodModItems.WOODEN_SWORD.get()), new Properties("Sword", ToaRarity.COMMAN).str(5));
	public static final ItemStack IRON_SWORD = createToaItem(new ItemStack(ToamodModItems.IRON_SWORD.get()), new Properties("Sword", ToaRarity.COMMAN).str(15));
	public static final ItemStack HARDENED_IRON_SWORD = createToaItem(new ItemStack(ToamodModItems.HARDENED_IRON_SWORD.get()), new Properties("Sword", ToaRarity.COMMAN).str(25));
	public static final ItemStack GOLDEN_SWORD = createToaItem(new ItemStack(ToamodModItems.GOLDEN_SWORD.get()), new Properties("Sword", ToaRarity.UNCOMMAN).str(30).cd(10));
	public static final ItemStack MITHRIL_SWORD = createToaItem(new ItemStack(ToamodModItems.MITHRIL_SWORD.get()), new Properties("Sword", ToaRarity.RARE).str(40)._int(5).cr(5).cd(25));
	//public static final ItemStack COPPER_1_SWORD = createToaItem(new ItemStack(ToamodModItems.COPPER_1_SWORD.get()), new Properties("Sword", ToaRarity.RARE).str(45).cr(10).cd(25));
	//public static final ItemStack COPPER_2_SWORD = createToaItem(new ItemStack(ToamodModItems.COPPER_2_SWORD.get()), new Properties("Sword", ToaRarity.EPIC).str(65).cr(15).cd(50));
	//public static final ItemStack COPPER_CLAYMORE = createToaItem(new ItemStack(ToamodModItems.COPPER_CLAYMORE.get()), new Properties("Sword", ToaRarity.LEGENDARY).str(75).cr(25).cd(80).lifesteal(5));
	//public static final ItemStack ORCHAL_CLAYMORE = createToaItem(new ItemStack(ToamodModItems.ORCHAL_CLAYMORE.get()), new Properties("Sword", ToaRarity.MYTHIC).str(90).cr(40).cd(110).lifesteal(10));
	//public static final ItemStack CELESTIAL_CLAYMORE = createToaItem(new ItemStack(ToamodModItems.CELESTIAL_CLAYMORE.get()), new Properties("Sword", ToaRarity.DIVINE).str(115).cr(55).cd(150).lifesteal(25));
	//public static final ItemStack FROSTBITE_SABER = createToaItem(new ItemStack(ToamodModItems.FROSTBITE_SABER.get()), new Properties("Sword", ToaRarity.EPIC).str(15)._int(90).element("Ice", 150));
	//public static final ItemStack FROSTSTEEL_SABER = createToaItem(new ItemStack(ToamodModItems.FROSTSTEEL_SABER.get()), new Properties("Sword", ToaRarity.LEGENDARY).str(20)._int(140).element("Ice", 240));
	//public static final ItemStack WINTERS_APPROCH = createToaItem(new ItemStack(ToamodModItems.WINTERS_APPROCH.get()), new Properties("Sword", ToaRarity.DIVINE).str(25).cr(15).cd(50)._int(230).element("Ice", 520));
	//public static final ItemStack ETERNAL_WINTER = createToaItem(new ItemStack(ToamodModItems.ETERNAL_WINTER.get()), new Properties("Sword", ToaRarity.ANCIENT).str(40).cr(25).cd(75)._int(360).element("Ice", 750));
	//public static final ItemStack MANA_INFUSED_SWORD = createToaItem(new ItemStack(ToamodModItems.MANA_INFUSED_SWORD.get()), new Properties("Sword", ToaRarity.RARE).str(20)._int(25).wis(15).element("Electricity", 30));
	//public static final ItemStack MANAFUSED_SWORD = createToaItem(new ItemStack(ToamodModItems.MANAFUSED_SWORD.get()), new Properties("Sword", ToaRarity.EPIC).str(30)._int(65).wis(50).element("Electricity", 90));
	//public static final ItemStack SEALED_HYPERION = createToaItem(new ItemStack(ToamodModItems.SEALED_HYPERION.get()), new Properties("Sword", ToaRarity.LEGENDARY).str(60).dex(25)._int(110).wis(85).cr(25).cd(120).element("Holy", 90));
	public static final ItemStack STARFALL_HYPERION = createToaItem(new ItemStack(ToamodModItems.STARFALL_HYPERION.get()), new Properties("Sword", ToaRarity.MYTHIC).str(120)._int(175).cr(10).cd(75).element("Holy", 190));
	//public static final ItemStack STARCALLER_HYPERION = createToaItem(new ItemStack(ToamodModItems.STARCALLER_HYPERION.get()), new Properties("Sword", ToaRarity.DIVINE).str(80)._int(320).cr(25).cd(180).element("Holy", 430));
	public static final ItemStack SCALDRIS_HYPERION = createToaItem(new ItemStack(ToamodModItems.SCALDRIS_HYPERION.get()), new Properties("Sword", ToaRarity.MYTHIC).str(275).dex(30).cr(50).cd(425).lifesteal(35));
	//public static final ItemStack RAGING_HYPERION = createToaItem(new ItemStack(ToamodModItems.RAGING_HYPERION.get()), new Properties("Sword", ToaRarity.ANCIENT).str(410).dex(70).cr(65).cd(630).lifesteal(45));
	//public static final ItemStack CRIMSON_HYPERION = createToaItem(new ItemStack(ToamodModItems.CRIMSON_HYPERION.get()), new Properties("Sword", ToaRarity.DIVINE).str(90)._int(360).cr(15).cd(75).element("Fire", 480).lifesteal(15));
	//public static final ItemStack INFERNAL_HYPERION = createToaItem(new ItemStack(ToamodModItems.INFERNAL_HYPERION.get()), new Properties("Sword", ToaRarity.ANCIENT).str(100)._int(450).cr(15).cd(120).element("Fire", 685).lifesteal(25));
	//public static final ItemStack VOIDSTEEL_BLADE = createToaItem(new ItemStack(ToamodModItems.VOIDSTEEL_BLADE.get()), new Properties("Sword", ToaRarity.LEGENDAR>).str(35).dex(50)._int(85).cr(5).cd(65).element("Void", 90));
	//public static final ItemStack WHISPER_OF_THE_VOID = createToaItem(new ItemStack(ToamodModItems.WHISPER_OF_THE_VOID.get()), new Properties("Sword", ToaRarity.MYTHIC).str(15).dex(120)._int(130).cr(15).cd(100).element("Void", 130));
	//public static final ItemStack ETERNAL_ECLIPSE = createToaItem(new ItemStack(ToamodModItems.ETERNAL_ECLIPSE.get()), new Properties("Sword", ToaRarity.ANCIENT).dex(210)._int(225).cr(15).cd(120).element("Void", 200).lifesteal(5));

	//ToaItems - Armor
	public static final ItemStack IRON_ARMOR_HELMET = createToaItem(new ItemStack(ToamodModItems.IRON_ARMOR_HELMET.get()), new Properties("Armor", ToaRarity.COMMAN).ar(5).dex(3));
	public static final ItemStack IRON_ARMOR_CHESTPLATE = createToaItem(new ItemStack(ToamodModItems.IRON_ARMOR_CHESTPLATE.get()), new Properties("Armor", ToaRarity.COMMAN).ar(8).dex(2));
	public static final ItemStack IRON_ARMOR_LEGGINGS = createToaItem(new ItemStack(ToamodModItems.IRON_ARMOR_LEGGINGS.get()), new Properties("Armor", ToaRarity.COMMAN).ar(7).dex(3));
	public static final ItemStack IRON_ARMOR_BOOTS = createToaItem(new ItemStack(ToamodModItems.IRON_ARMOR_BOOTS.get()), new Properties("Armor", ToaRarity.COMMAN).ar(3).dex(5));
	public static final ItemStack HARDENED_IRON_ARMOR_HELMET = createToaItem(new ItemStack(ToamodModItems.HARDENED_IRON_ARMOR_HELMET.get()), new Properties("Armor", ToaRarity.COMMAN).ar(10).dex(3));
	public static final ItemStack HARDENED_IRON_ARMOR_CHESTPLATE = createToaItem(new ItemStack(ToamodModItems.HARDENED_IRON_ARMOR_CHESTPLATE.get()), new Properties("Armor", ToaRarity.COMMAN).ar(16).con(10));
	public static final ItemStack HARDENED_IRON_ARMOR_LEGGINGS = createToaItem(new ItemStack(ToamodModItems.HARDENED_IRON_ARMOR_LEGGINGS.get()), new Properties("Armor", ToaRarity.COMMAN).ar(14).con(5));
	public static final ItemStack HARDENED_IRON_ARMOR_BOOTS = createToaItem(new ItemStack(ToamodModItems.HARDENED_IRON_ARMOR_BOOTS.get()), new Properties("Armor", ToaRarity.COMMAN).ar(7).dex(5));
	public static final ItemStack GOLD_ARMOR_HELMET = createToaItem(new ItemStack(ToamodModItems.GOLD_ARMOR_HELMET.get()), new Properties("Armor", ToaRarity.UNCOMMAN).ar(15).mr(8).wis(10));
	public static final ItemStack GOLD_ARMOR_CHESTPLATE = createToaItem(new ItemStack(ToamodModItems.GOLD_ARMOR_CHESTPLATE.get()), new Properties("Armor", ToaRarity.UNCOMMAN).ar(24).mr(15).con(15));
	public static final ItemStack GOLD_ARMOR_LEGGINGS = createToaItem(new ItemStack(ToamodModItems.GOLD_ARMOR_LEGGINGS.get()), new Properties("Armor", ToaRarity.UNCOMMAN).ar(21).mr(13).hp(10));
	public static final ItemStack GOLD_ARMOR_BOOTS = createToaItem(new ItemStack(ToamodModItems.GOLD_ARMOR_BOOTS.get()), new Properties("Armor", ToaRarity.UNCOMMAN).ar(12).mr(6).dex(8));
	//ToaItems - Artefacts
	public static final ItemStack GOBLIN_OMLETTE = createToaItem(new ItemStack(ToamodModItems.GOBLIN_OMLETTE.get()), new Properties("Artefact", ToaRarity.COMMAN).hp(15));
	public static final ItemStack PESTO_GOBLIN_OMLETTE = createToaItem(new ItemStack(ToamodModItems.PESTO_GOBLIN_OMLETTE.get()), new Properties("Artefact", ToaRarity.UNCOMMAN).hp(20).con(10));
	//public static final ItemStack SPICY_GOBLIN_OMLETTE = createToaItem(new ItemStack(ToamodModItems.SPICY_GOBLIN_OMLETTE.get()), new Properties("Artefact", 2).hp(35).con(20));
	//public static final ItemStack GOURMET_GOBLIN_OMLETTE = createToaItem(new ItemStack(ToamodModItems.GOURMET_GOBLIN_OMLETTE.get()), new Properties("Artefact", 4).hp(45).con(35));
	//public static final ItemStack PHEONIX_HEART = createToaItem(new ItemStack(ToamodModItems.PHEONIX_HEART.get()), new Properties("Artefact", 4)._int(10));
	//public static final ItemStack FIERY_PHEONIX_HEART = createToaItem(new ItemStack(ToamodModItems.FIERY_PHEONIX_HEART.get()), new Properties("Artefact", 5)._int(20).dex(5));
	//public static final ItemStack BLAZING_PHEONIX_HEART = createToaItem(new ItemStack(ToamodModItems.BLAZING_PHEONIX_HEART.get()), new Properties("Artefact", 7)._int(30).dex(10).wis(5));
	//public static final ItemStack DRAGON_EVIL_EYE = createToaItem(new ItemStack(ToamodModItems.DRAGON_EVIL_EYE.get()), new Properties("Artefact", 4).cr(2).cd(20).lifesteal(1.5));
	//public static final ItemStack SAPPHIRE_CRYSTAL = createToaItem(new ItemStack(ToamodModItems.SAPPHIRE_CRYSTAL.get()), new Properties("Artefact", 3)._int(15).wis(5));
	//public static final ItemStack DOROTHYS_SPELLBOOK = createToaItem(new ItemStack(ToamodModItems.PHEONIX_HEART.get()), new Properties("Artefact", 4)._int(45));
	//public static final ItemStack DEMONIC_SKULL_1 = createToaItem(new ItemStack(ToamodModItems.PHEONIX_HEART.get()), new Properties("Artefact", 0).str(5).con(5).lifesteal(0.5));
	//public static final ItemStack DEMONIC_SKULL_2 = createToaItem(new ItemStack(ToamodModItems.PHEONIX_HEART.get()), new Properties("Artefact", 1).str(10).con(10).lifesteal(1));
	//public static final ItemStack DEMONIC_SKULL_3 = createToaItem(new ItemStack(ToamodModItems.PHEONIX_HEART.get()), new Properties("Artefact", 2).str(15).con(15).lifesteal(1.5));
	//public static final ItemStack DEMONIC_SKULL_4 = createToaItem(new ItemStack(ToamodModItems.PHEONIX_HEART.get()), new Properties("Artefact", 3).str(20).con(15).lifesteal(2));
	//public static final ItemStack DEMONIC_SKULL_5 = createToaItem(new ItemStack(ToamodModItems.PHEONIX_HEART.get()), new Properties("Artefact", 4).str(25).con(20).lifesteal(2.5).cr(0.5));
	//public static final ItemStack DEMONIC_SKULL_6 = createToaItem(new ItemStack(ToamodModItems.PHEONIX_HEART.get()), new Properties("Artefact", 5).str(30).con(20).lifesteal(3).cr(1).cd(5));
	//public static final ItemStack DEMONIC_SKULL_7 = createToaItem(new ItemStack(ToamodModItems.PHEONIX_HEART.get()), new Properties("Artefact", 6).str(35).con(25).lifesteal(3.5).cr(1.5).cd(7.5));
	//public static final ItemStack DEMONIC_SKULL_8 = createToaItem(new ItemStack(ToamodModItems.PHEONIX_HEART.get()), new Properties("Artefact", 7).str(40).con(30).lifesteal(4).cr(2).cd(10));
	//public static final ItemStack ROTTING_FLESH = createToaItem(new ItemStack(ToamodModItems.ROTTING_FLESH.get()), new Properties("Artefact", 3).lifesteal(4).con(10));
	//public static final ItemStack DECAYED_FLESH = createToaItem(new ItemStack(ToamodModItems.DECAYED_FLESH.get()), new Properties("Artefact", 5).lifesteal(8).con(30));

	//ToaItems - Equipment
	//public static final ItemStack RING_OF_PROTECTION_1 = createToaItem(new ItemStack(ToamodModItems.RING_OF_PROTECTION_1.get()), new Properties("Equipment", 0).subType("Ring").ar(15).mr(15));
	//public static final ItemStack RING_OF_PROTECTION_2 = createToaItem(new ItemStack(ToamodModItems.RING_OF_PROTECTION_2.get()), new Properties("Equipment", 1).subType("Ring").ar(40).mr(40));
	//public static final ItemStack RING_OF_PROTECTION_3 = createToaItem(new ItemStack(ToamodModItems.RING_OF_PROTECTION_3.get()), new Properties("Equipment", 2).subType("Ring").ar(75).mr(75));
	//public static final ItemStack RING_OF_PROTECTION_4 = createToaItem(new ItemStack(ToamodModItems.RING_OF_PROTECTION_4.get()), new Properties("Equipment", 3).subType("Ring").ar(115).mr(115));
	//public static final ItemStack RING_OF_PROTECTION_5 = createToaItem(new ItemStack(ToamodModItems.RING_OF_PROTECTION_5.get()), new Properties("Equipment", 4).subType("Ring").ar(155).mr(155));
	//public static final ItemStack RING_OF_PROTECTION_6 = createToaItem(new ItemStack(ToamodModItems.RING_OF_PROTECTION_6.get()), new Properties("Equipment", 5).subType("Ring").ar(200).mr(200));
	//public static final ItemStack EYES_OF_FORTUNE = createToaItem(new ItemStack(ToamodModItems.EYES_OF_FORTUNE.get()), new Properties("Equipment", 2).subType("Eyes").wis(50)); 
	//public static final ItemStack BELT_OF_STRENGTH_1 = createToaItem(new ItemStack(ToamodModItems.BELT_OF_STRENGTH_1.get()), new Properties("Equipment", 2).subType("Belt").str(30));
	//public static final ItemStack BELT_OF_STRENGTH_2 = createToaItem(new ItemStack(ToamodModItems.BELT_OF_STRENGTH_2.get()), new Properties("Equipment", 4).subType("Belt").str(70));
	//public static final ItemStack BELT_OF_STRENGTH_3 = createToaItem(new ItemStack(ToamodModItems.BELT_OF_STRENGTH_3.get()), new Properties("Equipment", 6).subType("Belt").str(120));
	//public static final ItemStack BELT_OF_DEXTERITY_1 = createToaItem(new ItemStack(ToamodModItems.BELT_OF_DEXTERITY_1.get()), new Properties("Equipment", 2).subType("Belt").dex(30));
	//public static final ItemStack BELT_OF_DEXTERITY_2 = createToaItem(new ItemStack(ToamodModItems.BELT_OF_DEXTERITY_2.get()), new Properties("Equipment", 4).subType("Belt").dex(70));
	//public static final ItemStack BELT_OF_DEXTERITY_3 = createToaItem(new ItemStack(ToamodModItems.BELT_OF_DEXTERITY_3.get()), new Properties("Equipment", 6).subType("Belt").dex(120));
	//public static final ItemStack BELT_OF_CONSTITUTION_1 = createToaItem(new ItemStack(ToamodModItems.BELT_OF_CONSTITUTION_1.get()), new Properties("Equipment", 2).subType("Belt").con(30));
	//public static final ItemStack BELT_OF_CONSTITUTION_2 = createToaItem(new ItemStack(ToamodModItems.BELT_OF_CONSTITUTION_2.get()), new Properties("Equipment", 4).subType("Belt").con(70));
	//public static final ItemStack BELT_OF_CONSTITUTION_3 = createToaItem(new ItemStack(ToamodModItems.BELT_OF_CONSTITUTION_3.get()), new Properties("Equipment", 6).subType("Belt").con(120));
	//public static final ItemStack HEADBAND_OF_INTELLIGENCE_1 = createToaItem(new ItemStack(ToamodModItems.HEADBAND_OF_INTELLIGENCE_1.get()), new Properties("Equipment", 2).subType("Head")._int(30));
	//public static final ItemStack HEADBAND_OF_INTELLIGENCE_2 = createToaItem(new ItemStack(ToamodModItems.HEADBAND_OF_INTELLIGENCE_2.get()), new Properties("Equipment", 4).subType("Head")._int(70));
	//public static final ItemStack HEADBAND_OF_INTELLIGENCE_3 = createToaItem(new ItemStack(ToamodModItems.HEADBAND_OF_INTELLIGENCE_3.get()), new Properties("Equipment", 6).subType("Head")._int(120));
	//public static final ItemStack HEADBAND_OF_WISDOM_1 = createToaItem(new ItemStack(ToamodModItems.HEADBAND_OF_WISDOM_1.get()), new Properties("Equipment", 2).subType("head").wis(30));
	//public static final ItemStack HEADBAND_OF_WISDOM_2 = createToaItem(new ItemStack(ToamodModItems.HEADBAND_OF_WISDOM_2.get()), new Properties("Equipment", 4).subType("head").wis(70));
	//public static final ItemStack HEADBAND_OF_WISDOM_3 = createToaItem(new ItemStack(ToamodModItems.HEADBAND_OF_WISDOM_3.get()), new Properties("Equipment", 6).subType("head").wis(120));
	//public static final ItemStack DRAGONHIDE_SHIRT = createToaItem(new ItemStack(ToamodModItems.DRAGONHIDE_SHIRT.get()), new Properties("Equipment", 5).subType("Body").con(200));
	//public static final ItemStack PHEONIX_INSPIRATION = createToaItem(new ItemStack(ToamodModItems.PHEONIX_INSPIRATION.get()), new Properties("Equipment", 6).subType("Charm").dex(15));
	//public static final ItemStack DWARRFS_NECKLACE = createToaItem(new ItemStack(ToamodModItems.DWARFS_NECKLACE.get()), new Properties("Equipment", 2).subType("Necklace").wis(30));
	//public static final ItemStack GROWTH_BELT_1 = createToaItem(new ItemStack(ToamodModItems.GROWTH_BELT_1.get()), new Properties("Equipment", 1).subType("Belt").hp(25));
	//public static final ItemStack GROWTH_BELT_1 = createToaItem(new ItemStack(ToamodModItems.GROWTH_BELT_1.get()), new Properties("Equipment", 2).subType("Belt").hp(50));
	//public static final ItemStack GROWTH_BELT_1 = createToaItem(new ItemStack(ToamodModItems.GROWTH_BELT_1.get()), new Properties("Equipment", 4).subType("Belt").hp(100).con(25));
	//public static final ItemStack GROWTH_BELT_1 = createToaItem(new ItemStack(ToamodModItems.GROWTH_BELT_1.get()), new Properties("Equipment", 5).subType("Belt").hp(150).con(50));
	//public static final ItemStack TOOTH_NECKLACE_1 = createToaItem(new ItemStack(ToamodModItems.TOOTH_NECKLACE_1.get()), new Properties("Equipment", 0).subType("Necklace").cr(2).cd(5));
	//public static final ItemStack TOOTH_NECKLACE_2 = createToaItem(new ItemStack(ToamodModItems.TOOTH_NECKLACE_2.get()), new Properties("Equipment", 1).subType("Necklace").cr(4).cd(10));
	//public static final ItemStack TOOTH_NECKLACE_3 = createToaItem(new ItemStack(ToamodModItems.TOOTH_NECKLACE_3.get()), new Properties("Equipment", 2).subType("Necklace").cr(6).cd(15));
	//public static final ItemStack TOOTH_NECKLACE_4 = createToaItem(new ItemStack(ToamodModItems.TOOTH_NECKLACE_4.get()), new Properties("Equipment", 3).subType("Necklace").cr(8).cd(25));
	//public static final ItemStack TOOTH_NECKLACE_5 = createToaItem(new ItemStack(ToamodModItems.TOOTH_NECKLACE_5.get()), new Properties("Equipment", 4).subType("Necklace").cr(10).cd(35));
	//public static final ItemStack TOOTH_NECKLACE_6 = createToaItem(new ItemStack(ToamodModItems.TOOTH_NECKLACE_6.get()), new Properties("Equipment", 5).subType("Necklace").cr(13).cd(50));
	//public static final ItemStack TOOTH_NECKLACE_7 = createToaItem(new ItemStack(ToamodModItems.TOOTH_NECKLACE_7.get()), new Properties("Equipment", 6).subType("Necklace").cr(16).cd(65));
	//public static final ItemStack TOOTH_NECKLACE_8 = createToaItem(new ItemStack(ToamodModItems.TOOTH_NECKLACE_8.get()), new Properties("Equipment", 7).subType("Necklace").cr(20).cd(90));

	//public static final ItemStack IMMORTAL_REACTOR = createToaItem(new ItemStack(ToamodModItems.IMMORTAL_REACTOR.get()), new Properties("Equipment", 7).subType("Charm").hp(50).str(110).con(150)._int(130));
	//public static final ItemStack HALO_OF_ETERNAL_LIGHT = createToaItem(new ItemStack(ToamodModItems.HALO_OF_ETERNAL_LIGHT.get()), new Properties("Equipment", 7).subType("Head").hp(75).ar(50).mr(150)._int(150).wis(150));

	private static class Properties {
		public ToaRarity rarity;
		public String type;
		public String subType;
		//stats for the weapon in format {flat, percentage}
		public float[] STR;
		public float[] DEX;
		public float[] CON;
		public float[] INT;
		public float[] WIS;
		public float CR;
		public float CD;
		public String ELEMENT;
		public float[] ELEMENTAL_DAMAGE;
		public float LIFESTEAL;

		public float[] HP;
		public float[] AR;
		public float[] MR;

		Properties(String type, ToaRarity rarity) {
			this.type = type;
			this.rarity = rarity;
		}

		Properties(String type, ToaRarity rarity, String subType, float[] _str, float[] _dex, float[] _con, float[] _int, float[] _wis, String element, float[] elemental_damage, float lifesteal, float[] _hp, float[] _ar, float[] _mr) {
			this.type = type;
			this.rarity = rarity;
			this.subType = subType;
			this.STR = _str;
			this.DEX = _dex;
			this.CON = _con;
			this.INT = _int;
			this.WIS = _wis;
			this.ELEMENT = element;
			this.ELEMENTAL_DAMAGE = elemental_damage;
			this.LIFESTEAL = lifesteal;
			this.HP = _hp;
			this.AR = _ar;
			this.MR = _mr;
		}

		public Properties subType(String subType) {
			this.subType = subType;
			return this;
		}

		public Properties str(float[] _str) {
			this.STR = _str;
			return this;
		}

		public Properties str(float _str) {
			this.STR = new float[]{_str, 0};
			return this;
		}

		public Properties dex(float[] _dex) {
			this.DEX = _dex;
			return this;
		}

		public Properties dex(float _dex) {
			this.DEX = new float[]{_dex, 0};
			return this;
		}

		public Properties con(float[] _con) {
			this.CON = _con;
			return this;
		}

		public Properties con(float _con) {
			this.CON = new float[]{_con, 0};
			return this;
		}

		public Properties _int(float[] _int) {
			this.INT = _int;
			return this;
		}

		public Properties _int(float _int) {
			this.INT = new float[]{_int, 0};
			return this;
		}

		public Properties wis(float[] _wis) {
			this.WIS = _wis;
			return this;
		}

		public Properties wis(float _wis) {
			this.WIS = new float[]{_wis, 0};;
			return this;
		}

		public Properties cr(float cr) {
			this.CR = cr;
			return this;
		}

		public Properties cd(float cd) {
			this.CD = cd;
			return this;
		}

		public Properties element(String element, float[] elemental_damage) {
			this.ELEMENT = element;
			this.ELEMENTAL_DAMAGE = elemental_damage;
			return this;
		}

		public Properties element(String element, float elemental_damage) {
			this.ELEMENT = element;
			this.ELEMENTAL_DAMAGE = new float[] {elemental_damage, 0};
			return this;
		}


		public Properties lifesteal(float lifesteal) {
			this.LIFESTEAL = lifesteal;
			return this;
		}

		public Properties hp(float[] hp) {
			this.HP = hp;
			return this;
		}

		public Properties hp(float hp) {
			this.HP = new float[]{hp, 0};
			return this;
		}

		public Properties ar(float[] ar) {
			this.AR = ar;
			return this;
		}

		public Properties ar(float ar) {
			this.AR = new float[]{ar, 0};
			return this;
		}

		public Properties mr(float[] mr) {
			this.MR = mr;
			return this;
		}

		public Properties mr(float mr) {
			this.MR = new float[]{mr, 0};
			return this;
		}
	}

	private static ItemStack createToaItem(ItemStack item, ToaItems.Properties prop) {
		item.getOrCreateTag().putDouble("rarity", (double) prop.rarity.ID);
		if (!prop.type.equals(""))
			item.getOrCreateTag().putString("type", prop.type);
		if (!prop.subType.equals(""))
			item.getOrCreateTag().putString("subType", prop.subType);
		if (prop.STR[0] != 0)
			item.getOrCreateTag().putFloat("str", prop.STR[0]);
		if (prop.INT[0] != 0)
			item.getOrCreateTag().putFloat("int", prop.INT[0]);
		if (prop.HP[0] != 0)
			item.getOrCreateTag().putFloat("hp", prop.HP[0]);
		if (prop.AR[0] != 0)
			item.getOrCreateTag().putFloat("ar", prop.AR[0]);
		if (prop.MR[0] != 0)
			item.getOrCreateTag().putFloat("mr", prop.MR[0]);
		if (prop.CR != 0)
			item.getOrCreateTag().putFloat("cr", prop.CR);
		if (prop.CD != 0)
			item.getOrCreateTag().putFloat("cd", prop.CD);
		if (prop.CON[0] != 0)
			item.getOrCreateTag().putFloat("con", prop.CON[0]);
		if (prop.WIS[0] != 0)
			item.getOrCreateTag().putFloat("wis", prop.WIS[0]);
		if (prop.DEX[0] != 0)
			item.getOrCreateTag().putFloat("dex", prop.DEX[0]);
		if (!prop.ELEMENT.equals(""))
			item.getOrCreateTag().putString("element", prop.ELEMENT);
		if (prop.ELEMENTAL_DAMAGE[0] != 0)
			item.getOrCreateTag().putFloat("elemtal_damage", prop.ELEMENTAL_DAMAGE[0]);
		if (prop.LIFESTEAL != 0)
			item.getOrCreateTag().putFloat("lifesteal", prop.LIFESTEAL);
		item.getOrCreateTag().putBoolean("forgeable", true);

		item.setCount(1);
		return item;
	}

	public static ItemStack getItemByID(String id) {
		return switch (id) {
			//Weapons
			case "toamod:wooden_sword" -> WOODEN_SWORD;
			case "toamod:iron_sword" -> IRON_SWORD;
			case "toamod:hardened_iron_sword" -> HARDENED_IRON_SWORD;
			case "toamod:golden_sword" -> GOLDEN_SWORD;
			case "toamod:mithril_sword" -> MITHRIL_SWORD;
			//case "toamod:copper_1_sword" -> COPPER_1_SWORD;
			//case "toamod:copper_2_sword" -> COPPER_2_SWORD;
			//case "toamod:copper_claymore" -> COPPER_CLAYMORE;
			//case "toamod:orchal_claymore" -> ORCHAL_CLAYMORE;
			//case "toamod:celestial_claymore" -> CELESTIAL_CLAYMORE;
			//Armors
			case "toamod:iron_armor_helmet" -> IRON_ARMOR_HELMET;
			case "toamod:iron_armor_chestplate" -> IRON_ARMOR_CHESTPLATE;
			case "toamod:iron_armor_leggings" -> IRON_ARMOR_LEGGINGS;
			case "toamod:iron_armor_boots" -> IRON_ARMOR_BOOTS;
			case "toamod:hardened_iron_armor_helmet" -> HARDENED_IRON_ARMOR_HELMET;
			case "toamod:hardened_iron_armor_chestplate" -> HARDENED_IRON_ARMOR_CHESTPLATE;
			case "toamod:hardened_iron_armor_leggings" -> HARDENED_IRON_ARMOR_LEGGINGS;
			case "toamod:hardened_iron_armor_boots" -> HARDENED_IRON_ARMOR_BOOTS;
			case "toamod:gold_armor_helmet" -> GOLD_ARMOR_HELMET;
			case "toamod:gold_armor_chestplate" -> GOLD_ARMOR_CHESTPLATE;
			case "toamod:gold_armor_leggings" -> GOLD_ARMOR_LEGGINGS;
			case "toamod:gold_armor_boots" -> GOLD_ARMOR_BOOTS;
			//Artefacts
			case "toamod:goblin_omlette" -> GOBLIN_OMLETTE;
			case "toamod:pesto_goblin_omlette" -> PESTO_GOBLIN_OMLETTE;
			//case "toamod:spicy_goblin_omlette" -> SPICY_GOBLIN_OMLETTE;
			//case "toamod:pesto_goblin_omlette" -> GOURMET_GOBLIN_OMLETTE;
			default -> new ItemStack(ToamodModItems.COAL.get());//ItemStack.EMPTY;
		};
	}

}
