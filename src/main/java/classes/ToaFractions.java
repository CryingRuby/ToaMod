package classes;

import java.util.ArrayList;

public class ToaFractions {
	private ToaFractions() { //static-class
	}

	public static class Fraction {
		private final String Name;
		private final String Style; //Combat, Exploring, Farming
		private final String[] Titles;
		private final String[] Perks;
		private final int[] XPRequired = {100, 250, 600, 1500, 5000, 10000, 25000, 50000, 100000};

		public Fraction(String name, String style, String[] titles, String[] perks) {
			this.Name = name;
			this.Style = style;
			this.Titles = titles;
			this.Perks = perks;
		}

		public String getName() {
			return this.Name;
		}

		public String getStyle() {
			return this.Style;
		}

		public String[] getTitles() {
			return this.Titles;
		}

		public String[] getPerks() {
			return this.Perks;
		}

		public int[] getXPRequired() {
			return this.XPRequired;
		}
	}

	private static final String[] Titles1 = {
		"\u00A77Novice\u00A7r",
		"\u00A7fMember\u00A7r",
		"\u00A7bEldest\u00A7r",
		"\u00A72Commander\u00A7r",
		"\u00A74General\u00A7r",
		};
	private static final String[] Perks1 = {
		"\u00A78- \u00A7a+50% \u00A77Combat XP\u00A7r",
		"\u00A78- \u00A7a+1% \u00A77Dmg per Fraction-Level\u00A7r",
		"\u00A78- \u00A7a+2.5% \u00A77Life Steal per Fraction-Title\u00A7r",
		"\u00A78- \u00A7a+10% \u00A77Cor from killing Mobs\u00A7r",
		//"\u00A78- \u00A7c-25% \u00A77Mining XP\u00A7r",  //->Only when other Fractions are available on Game-Start
	};

	public static final ToaFractions.Fraction BLOOD_HUNTERS = new Fraction("\u00A7cBlood Hunters\u00A7r", "Combat", Titles1, Perks1);
	//To Be Added:
	private static final ToaFractions.Fraction CELESTIAL_GUARDIANS = new Fraction("\u00A7bCelestial Guardians\u00A7r", "Exploring", new String[5], new String[7]);
	private static final ToaFractions.Fraction IRON_BEARDS = new Fraction("\u00A7aIron Beards\u00A7r", "Mining", new String[5], new String[7]);
	private static final ToaFractions.Fraction THE_CURSED_CREW = new Fraction("\u00A73The Cursed Crew\u00A7r", "Combat", new String[5], new String[7]); //Secret Fraction
	private static final ToaFractions.Fraction INFERNAL_DEMONS = new Fraction("\u00A74Infernal Demons\u00A7r", "Combat", new String[5], new String[7]); //Secret Fraction
	private static final ToaFractions.Fraction ROYAL_GUARDS = new Fraction("\u00A76Royal Guards\u00A7r", "Combat", new String[5], new String[7]);
	private static final ToaFractions.Fraction SCHOLARS_OF_THE_VOID = new Fraction("\u00A75Scholar Of The Void\u00A7r", "Skills/XP-Gain", new String[5], new String[7]); //Secret Fraction
	private static final ToaFractions.Fraction NOCTURNAL_BROTHERHOOD = new Fraction("\u00A75Nocturnal Brotherbood\u00A7r", "Combat", new String[5], new String[7]); //Secret Fraction

	public static ToaFractions.Fraction getFraction(String name) {
		return switch (name) {
			case "\u00A7cBlood Hunters\u00A7r" -> BLOOD_HUNTERS;
			//case "\u00A7bCelestial Guardians\u00A7r" -> CELESTIAL_GUARDIANS;
			//case "\u00A7aIron Beards\u00A7r" -> IRON_BEARDS;
			//case "\u00A73The Cursed Crew\u00A7r" -> THE_CURSED_CREW;
			//case "\u00A74Infernal Demons\u00A7r" -> INFERNAL_DEMONS;
			//case "\u00A76Royal Guards\u00A7r" -> ROYAL_GUARDS;
			//case "\u00A75Nocturnal Brotherbood\u00A7r" -> NOCTURNAL_BROTHERHOOD;
			default -> BLOOD_HUNTERS;
		};
	}

	public static ArrayList<ToaFractions.Fraction> getFractionByStyle(String style) {
		ArrayList<ToaFractions.Fraction> result = new ArrayList<>();

		switch (style) {
			case "Combat" :
				result.add(BLOOD_HUNTERS);
				//result.add(THE_CURSED_CREW);
				//result.add(INFERNAL_DEMONS);
				//result.add(ROYAL_GUARDS);
				//result.add(NOCTURNAL_BROTHERHOOD);
				break;
			case "Exploring" :
				//result.add(CELESTIAL_GUARDIANS);
				break;
			case "Mining" :
				//result.add(IRON_BEARDS);
				break;
			case "Skills/XP-Gain":
				//result.add(SCHOLARS_OF_THE_VOID);
				break;
			default :
				result.add(BLOOD_HUNTERS);
				//result.add(THE_CURSED_CREW);
				//result.add(INFERNAL_DEMONS);
				//result.add(ROYAL_GUARDS);
				//result.add(CELESTIAL_GUARDIANS);
				//result.add(IRON_BEARDS);
				//result.add(SCHOLARS_OF_THE_VOID);
				//result.add(NOCTURNAL_BROTHERHOOD);
				break;
		}
		return result;
	}
}

