/******************************************************************************
CS003B Java
Kelly Yu & Erick Bravo
06/26/20
P5.10 Roman Numeral Converter
*******************************************************************************/

public class RomanNumerals
{
    private String convertedNumeral;
    private int given;
    
    public RomanNumerals(int inputNumeral)
    {
        convertedNumeral = " ";
        given = inputNumeral;
    }
    
    public void conversionToRomanNumerals()
    {

         while (given >= 1000)
         {
             convertedNumeral = convertedNumeral +"M";
                     given = given - 1000;
         }
         
         while (given >= 900)
         {
             convertedNumeral += "CM";
             given = given - 900;
         }
         
         while (given >= 500)
         {
             convertedNumeral += "D";
             given = given - 500;
         }
         
         while (given >= 400)
         {
             convertedNumeral += "CD";
             given = - 400;
         }
         
         while (given >= 100)
         {
             convertedNumeral += "C";
             given = given - 100;                 
         }
         
         while (given >= 90)
         {
             convertedNumeral += "XC";
             given = given - 90;
         }
         
         while (given >= 50)
         {
             convertedNumeral += "L";
             given = given - 50;
         }
         
         while (given >= 10)
         {
             convertedNumeral += "X";
             given = given - 10;
         }
         
         while (given >= 1)
         {
             convertedNumeral += "I";
             given = given -1;
         }
         
         while(given >= 1 && given <= 3999)
         {
             
         }
         
        }
    
    public String getRomanNumerals()
    {
        return convertedNumeral;
    }

        
        
        
        
}



