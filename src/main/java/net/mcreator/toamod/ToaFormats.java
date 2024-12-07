package net.mcreator.toamod;

public final class ToaFormats {
	private ToaFormats() { 
	}

	//Dedicated to get different String-Formats from static methods => bsp Time: 56s; 2min

	//Roman Numbers from (0)1 to 50 (using with RomanNumbers[<number>])
	public static final String[] RomanNumbers = { "0", "I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L"};

	/*
	 * converts a float number to a String. Cuts all the decimals
	 */
	public static String floatToString(float number){
		return doubleToString(number);

	}

	/*
	 * converts a float number to a String. Cuts all the decimals
	 */
	public static String doubleToString(double number){
		return "" + (new java.text.DecimalFormat("##")).format(number);

	}
}
 
