// Bravo, Erick & Yu, Kelly
// P5.10

/**
	A class that can convert a positive integer between 1 and 3,999 into a Roman numeral.
 */
public class RomanNumerals {
	private String convertedNumeral;
	private int given;

	/**
	Constructs an empty string for the Roman Numeral to be outputted, and intakes an integer input 
by the user.
	@param inputNumeral the integer that the user will input in; this integer will be converted into a 
Roman numeral
	 */
	public RomanNumerals(int inputNumeral) 
	{
		given = inputNumeral;
		convertedNumeral = "";	
	}

	/**
	Converts the given integer input into Roman numerals.
	 */
	public void conversionToRomanNumerals()
	{
		while (given >= 1000) {
			convertedNumeral = convertedNumeral + "M";
			given = given - 1000;
		}
		while (given >= 900) {
			convertedNumeral += "CM";
			given = given - 900; 
		}
		while (given >= 500) {
			convertedNumeral += "D"; 	
			given = given - 500;
		}
		while (given >= 400) {
			convertedNumeral += "CD";
			given = given - 400;
		} 
		while (given >= 100) {
			convertedNumeral += "C";
			given = given - 100;
		}
		while (given >= 90) {
			convertedNumeral += "XC";
			given = given - 90;
		} 
		while (given >=50) {
			convertedNumeral += "L";
			given = given - 50;
		}
		while (given >=40) {
			convertedNumeral += "XL";
			given = given - 40;
		} 
		while (given >= 10) {
			convertedNumeral += "X";
			given = given - 10;
		}
		while (given >= 9) {
			convertedNumeral += "IX";
			given = given - 9;
		}
		while (given >= 5) {
			convertedNumeral += "V";
			given = given - 5;
		}
		while (given >=4) {
			convertedNumeral += "IV";
			given = given - 4;
		}
		while (given >= 1) {
			convertedNumeral += "I";
			given = given - 1;
		}
	}


	/**
	Returns the resulting Roman numeral.
	@return the Roman numeral string.
	 */
	public String getRomanNumerals() {
		return convertedNumeral;
	}
}