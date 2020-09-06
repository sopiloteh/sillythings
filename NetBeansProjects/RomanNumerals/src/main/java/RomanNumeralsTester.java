/******************************************************************************
CS003B Java
Kelly Yu & Erick Bravo
06/26/20
P5.10 Roman Numeral Converter
*******************************************************************************/

import java.util.Scanner;

public class RomanNumeralsTester
{
public static void main (String[] args)
{
Scanner in = new Scanner(System.in);
System.out.print("Please input a number: ");
int input = in.nextInt();

if (input <1 || input > 3999)
{
    System.out.println("That is not in range of Roman Numerals:");
}

else if (input >= 1 && input <= 3999)
{
    RomanNumerals number = new RomanNumerals(input);
    number.conversionToRomanNumerals();
    System.out.print("In Roman Numerals: ");
    System.out.print(number.getRomanNumerals());
}
RomanNumerals given = new RomanNumerals(input);


}
}

/*
100
Enter a number from 0 to 3999: In Roman Numerals:  C
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  2.872 s
Finished at: 2020-06-26T13:55:23-07:00
------------------------------------------------------------------------
23
Enter a number from 0 to 3999: In Roman Numerals:  XXIII
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  1.853 s
Finished at: 2020-06-26T13:55:41-07:00
------------------------------------------------------------------------
3999
Please input a number: In Roman Numerals:  MMMCMXCIIIIIIIII
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  4.874 s
Finished at: 2020-06-26T14:01:57-07:00
------------------------------------------------------------------------


*/
