// Bravo, Erick & Yu, Kelly
// P5.10

/**
A class to test the RomanNumerals class.
 */
import java.util.Scanner;

public class RomanNumeralsTester
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Please input a number between 1 and 3,999: ");
		int input = in.nextInt();
		if (input < 1 || input > 3999)
		{
			System.out.print("That is not within the range of Roman Numerals.");
		}
		else if (input >= 1 && input <= 3999)
		{
			RomanNumerals number = new RomanNumerals(input);
			number.conversionToRomanNumerals();
			System.out.print("In Roman Numerals: ");
			System.out.print(number.getRomanNumerals());
		}

	}
}

/* Sample Run
Please input a number between 1 and 3,999: 100
In Roman Numerals: C
Please input a number between 1 and 3,999: 23
In Roman Numerals: XXIII
Please input a number between 1 and 3,999: 3999
In Roman Numerals: MMMCMXCIX
Please input a number between 1 and 3,999: 1978
In Roman Numerals: MCMLXXVIII
Please input a number between 1 and 3,999: 4000
That is not within the range of Roman Numerals.
*/