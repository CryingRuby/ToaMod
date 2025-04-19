package net.mcreator.toamod;

public final class ToaFormats {
	private ToaFormats() {
	}
	//Dedicated to get different String-Formats from static methods => bsp Time: 56s; 2min

	//Roman Numbers from (0)1 to 50 (using with RomanNumbers[<number>])
	public static final String[] RomanNumbers = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
			"XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L"};
	public static final int XpForNormLvl = 100;

	/**
	 * converts a float number to a String. Cuts all the decimals
	 */
	public static String floatToString(float number) {
		return doubleToString(number);
	}

	/**
	 * converts a float number to a String. Max 2 decimals (remove last zeros)
	 */
	public static String doubleToString(double number) {
		return "" + (new java.text.DecimalFormat("##.##")).format(number);
	}

	/**
	 * @param a string that has at least 2 chars
	 * 
	 * @return the string with the first char being upper-case
	 */
	public static String firstCharToUpper(String string){
		return (""+string.charAt(0)).toUpperCase() + string.substring(1);
	}
	
	/**
	 * Symbole based on the condition:
	 * 	- Green Check if condition is true
	 * 	- Red Cross if false
	 */
	public static String indicatorByBool(boolean condition){
		return ((condition)? "§2\u2714" : "§4\u2718");
	}

	/**
	 * Normalize the xp gained to make each level require same amount of original xp.
	 * 
	 * @return the modified xpAmount that needs to be added to the player to match the xpNeeded so every level requires the same xp amount
	 */
	public static int normXpGained(int xpGained, int xpNeeded){
		return xpGained * xpNeeded / XpForNormLvl;
	}
}
