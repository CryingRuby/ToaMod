package classes;

public class ToaDifficulties {
	private ToaDifficulties() { //static class
	}

	public static class Difficulty {
		private final int ID;
		private final String Name;
		private final String[] Description;
		private final int StartingCor;
		private final int StartingMD;
		private final double DmgTakenFactor;
		private final double DmgDealtFactor;
		private final double MobHPFactor;
		private final double NaturalHPRegenFactor;

		public Difficulty(int id, String name, String[] description, int startingCor, int startingMD, double dmgTakenF, double dmgDealtF, double mobHPF, double natHPRegenF) {
			this.ID = id;
			this.Name = name;
			this.Description = description;
			this.StartingCor = startingCor;
			this.StartingMD = startingMD;
			this.DmgTakenFactor = dmgTakenF;
			this.DmgDealtFactor = dmgDealtF;
			this.MobHPFactor = mobHPF;
			this.NaturalHPRegenFactor = natHPRegenF;
		}

		public int getID() {
			return this.ID;
		}

		public String getName() {
			return this.Name;
		}

		public String[] getDescription() {
			return this.Description;
		}

		public int getStartingCor() {
			return this.StartingCor;
		}

		public int getStartingMD() {
			return this.StartingMD;
		}

		public double getDmgTakenFactor() {
			return this.DmgTakenFactor;
		}

		public double getDmgDealtFactor() {
			return this.DmgDealtFactor;
		}

		public double getMobHPFactor() {
			return this.MobHPFactor;
		}

		public double getNaturalHPRegenFactor() {
			return this.NaturalHPRegenFactor;
		}
	}

	private static final String[] Diff1Descr = {
		"\u00A78- \u00A77Cor (Coins):\u00A79 10000",
		"\u00A78- \u00A77Magic Dust:\u00A79 50",
		"\u00A78- \u00A77Dmg from Mobs:\u00A7a -15%",
		"\u00A78- \u00A77Dmg to Mobs:\u00A7a +10%",
		"\u00A78- \u00A77Mob Health:\u00A7a -20%",
		"\u00A78- \u00A77Natural HP-Regen:\u00A7a +10%",
		};
	private static final String[] Diff2Descr = {
		"\u00A78- \u00A77Cor (Coins):\u00A79 5000",
		"\u00A78- \u00A77Magic Dust:\u00A79 20",
		"\u00A78- \u00A77Dmg from Mobs:\u00A7e +0%",
		"\u00A78- \u00A77Dmg to Mobs:\u00A7e +0%",
		"\u00A78- \u00A77Mob Health:\u00A7e +0%",
		"\u00A78- \u00A77Natural HP-Regen:\u00A7e +0%",
		};
	private static final String[] Diff3Descr = {
		"\u00A78- \u00A77Cor (Coins):\u00A79 1000",
		"\u00A78- \u00A77Magic Dust:\u00A79 0",
		"\u00A78- \u00A77Dmg from Mobs:\u00A7c +15%",
		"\u00A78- \u00A77Dmg to Mobs:\u00A7e +0%",
		"\u00A78- \u00A77Mob Health:\u00A7c +20%",
		"\u00A78- \u00A77Natural HP-Regen:\u00A7c -75%",
		};
	//Constructor(int id, String name, String[] description, int startingCor, int startingMD, double dmgTakenF, double dmgDealtF, double mobHPF, double natNPRegenF)
	public static final ToaDifficulties.Difficulty EASY = new Difficulty(0, "Easy", Diff1Descr, 10000, 50, 0.85, 1.1, 0.8, 1.1);
	public static final ToaDifficulties.Difficulty NORMAL = new Difficulty(1, "Normal", Diff2Descr, 5000, 20, 1, 1, 1, 1);
	public static final ToaDifficulties.Difficulty HARD = new Difficulty(2, "Hard", Diff3Descr, 1000, 0, 1.15, 1, 1.2, 0.25);

	public static ToaDifficulties.Difficulty getDifficulty(int difficulty) {
		return switch (difficulty) {
			case 1 -> NORMAL;
			case 2 -> HARD;
			default -> EASY;
		};
	}

	public static ToaDifficulties.Difficulty getDifficulty(String difficulty) {
		return switch (difficulty) {
			case "Normal" -> NORMAL;
			case "Hard" -> HARD;
			default -> EASY;
		};
	}
}
