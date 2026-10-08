package net.mcreator.toamod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public final class ToaFormats {
	private ToaFormats() {
	}

	//Dedicated to get different String-Formats from static methods => bsp Time: 56s; 2min
	//Roman Numbers from (0)1 to 50 (using with RomanNumbers[<number>])
	public static final String[] RomanNumbers = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
			"XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L"};
	public static final int XpForNormLvl = 100;
	//symbols representing larger numbers k: 1_000 | m: 1_000_000 | b: 1_000_000_000 | 
	public static final String[] NumberSymbols = {"K", "M", "B"};

	/**
	 * converts a float number to a String. Max 2 decimals
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
	public static String firstCharToUpper(String string) {
		return ("" + string.charAt(0)).toUpperCase() + string.substring(1);
	}

	/**
	 * Shortens larger whole numbers into smaller with extra symbols.
	 * 10_000 -> 10k (für number >= 10_000) !!!
	 * 1_000_000 -> 1m (für number >= 1_000_000)
	 * 1_000_000_000 -> 1b (für number >= 1_000_000_000)
	 */
	public static String formatWholeNumber(int number){
		double[] prec = {1e9, 1e6, 1e4};
		for(int i = 0; i < prec.length; i++){
			if(number / prec[i] > 1-4e-14)
				return (new java.text.DecimalFormat("##.##")).format(number / prec[i]) + NumberSymbols[prec.length-i];
		}
		
		return ""+number;
	}

	/**
	 * Symbole based on the condition:
	 * 	- Green Check if condition is true
	 * 	- Red Cross if false
	 */
	public static String indicatorByBool(boolean condition) {
		return ((condition) ? "§2\u2714" : "§4\u2718");
	}

	
	

	/**
	 * Produces a line of '-' with 2 colors represenbting a bapercentage filled bar.
	 * @param the percentage to which the bar is filled. Should be within [0, 1].
	 * @param the amount of '-' the bar should be long
	 * @param the color the '-' gets if it's inside the percentage value.
	 * @param the color the '-' gets if it's outside the percentage value.
	 */
	public static String getPercentageLine(double percentage, int lineLength, char unlockedColor, char lockedColor){
		if(percentage > 1 || percentage < 0)
			return "";
		String result = "§"+unlockedColor;
		int indexFirstLocked = (int) Math.floor(lineLength * percentage);
		for(int i = 0; i < indexFirstLocked; i++){
			result += "-";
		}
		
		result += "§"+lockedColor;
		
		for(int i = indexFirstLocked; i < lineLength; i++){
			result += "-";
		}

		return result;
	}

	public static String getPercentageLine(double percentage, int lineLength) {
		return getPercentageLine(percentage, lineLength, 'a', '7');
	}

	/**
	 * Normalize the xp gained to make each level require same amount of original xp.
	 * 
	 * @return the modified xpAmount that needs to be added to the player to match the xpNeeded so every level requires the same xp amount
	 */
	public static int normXpGained(int xpGained, int xpNeeded) {
		return xpGained * xpNeeded / XpForNormLvl;
	}

	public static void printSeperationLine(Player player) {
		player.displayClientMessage(Component.literal("§3-----------------------------------------------------"), false); //54x '-'
	}

	public static void printEmptyLine(Player player) {
		player.displayClientMessage(Component.literal(" "), false);
	}
}
