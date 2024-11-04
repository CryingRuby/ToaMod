package classes;

public class ToaQuestTexts {

	public static int getQuestTextLength(String qKey, String txtNum) {
		return switch(qKey) {
			case "qIntro" -> getIntroLength(txtNum);

			default -> 0;
		};
	}

	private static int getIntroLength(String txtNum) {
		return switch(txtNum.charAt(0)) {
			case '1' -> 5;
			case '2' -> 2;

			default -> 0;
		};
	}






	

	public static String getQuestText(String qKey, String txtNum) {
		return switch(qKey) {
			case "qIntro" -> getIntro(txtNum);
			case "qMiningIntro" -> getMiningIntro(txtNum);
			case "qMiningUpgrade1" -> getMiningUpgrade1(txtNum);
			case "qMiningUpgrade2" -> getMiningUpgrade1(txtNum);
			case "qMiningUpgrade3" -> getMiningUpgrade1(txtNum);
			case "qMiningUpgrade4" -> getMiningUpgrade1(txtNum);
			case "qMiningUpgrade5" -> getMiningUpgrade1(txtNum);

			default -> "!EXCEPTION: invalid quest-key!";
		};
	}



	private static String getIntro(String txtNum){
		return switch(txtNum) {
			case "1.0" -> "Hello there traveler...";
			case "1.1" -> "...1...";
			case "1.2" -> "...2...";
			case "1.3" -> "...3...";
			case "1.4" -> "...4...";

			case "2.0" -> "Here have this!";
			case "2.1" -> "We need to defent Tamadura!";

			default -> "";
		};
	}

	private static String getMiningIntro(String txtNum){
		return switch(txtNum) {
			case "1.0" -> "Gimme Coal...";
			case "1.1" -> "...1...";
			case "1.2" -> "...2...";
			case "1.3" -> "...3...";
			case "1.4" -> "...4...";

			case "2.0" -> "Here have this!";
			case "2.1" -> "Gimme more Coal!";
			
			default -> "";
		};
	}

	private static String getMiningUpgrade1(String txtNum){
		return switch(txtNum) {
			case "1.0" -> "Hello there traveler...";
			case "1.1" -> "...1...";
			case "1.2" -> "...2...";
			case "1.3" -> "...3...";
			case "1.4" -> "...4...";

			case "2.0" -> "Here have this!";
			case "2.1" -> "We need to defent Tamadura!";
			
			default -> "";
		};
	}
	private static String getMiningUpgrade2(String txtNum){
		return switch(txtNum) {
			case "1.0" -> "Hello there traveler...";
			case "1.1" -> "...1...";
			case "1.2" -> "...2...";
			case "1.3" -> "...3...";
			case "1.4" -> "...4...";

			case "2.0" -> "Here have this!";
			case "2.1" -> "We need to defent Tamadura!";
			
			default -> "";
		};
	}
	private static String getMiningUpgrade3(String txtNum){
		return switch(txtNum) {
			case "1.0" -> "Hello there traveler...";
			case "1.1" -> "...1...";
			case "1.2" -> "...2...";
			case "1.3" -> "...3...";
			case "1.4" -> "...4...";

			case "2.0" -> "Here have this!";
			case "2.1" -> "We need to defent Tamadura!";
			
			default -> "";
		};
	}
	private static String getMiningUpgrade4(String txtNum){
		return switch(txtNum) {
			case "1.0" -> "Hello there traveler...";
			case "1.1" -> "...1...";
			case "1.2" -> "...2...";
			case "1.3" -> "...3...";
			case "1.4" -> "...4...";

			case "2.0" -> "Here have this!";
			case "2.1" -> "We need to defent Tamadura!";
			
			default -> "";
		};
	}
	private static String getMiningUpgrade5(String txtNum){
		return switch(txtNum) {
			case "1.0" -> "Hello there traveler...";
			case "1.1" -> "...1...";
			case "1.2" -> "...2...";
			case "1.3" -> "...3...";
			case "1.4" -> "...4...";

			case "2.0" -> "Here have this!";
			case "2.1" -> "We need to defent Tamadura!";
			
			default -> "";
		};
	}
}
