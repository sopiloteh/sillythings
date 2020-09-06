/******************************************************************************
CS003B Java
Erick Bravo
07/19/20
P8.7 Post Office
*******************************************************************************/

import java.util.Scanner;
public class Bars
{

    // String variable to contain the barcode font
    static String [] codes = {"||:::",":::||","::|:|","::||:", ":|::|",":|:|:",":||::","|:::|", "|::|:","|:|::"};

    // this encapsulates the zipcode into a barcode
    public static String encode (String zipCode)
    {
        // if numbers less then 5, error out
        if (zipCode.length() != 5)
        {
            return "Invalid! Please reenter";
        }
        
        // this adds a divider between each number thats translated
        String encodedValue = "|";
        int sum = 0;
        
        // looks at each number and sees where the conversion to replace is
        for (int i = 0; i < zipCode.length(); i++)
        {
            sum += (zipCode.charAt(i) - '0');
            encodedValue += codes[zipCode.charAt(i) -'0'];
        }
        
        sum %= 10;
        sum = 10 - sum;
        
        encodedValue += codes[sum] + "|";
        
        return encodedValue;
    }
    
    // this looks at the digits and takes them from barcode to digits
    private static String searchDigit(String code)
    {
        for (int i = 0; i < codes.length; i++)
        {
            if (codes[i].equals(code))
            {
                return i + " ";
            }
            
            
        }
        return " ";
    }
        
    
    // this actually takes the barcode and reveses the encryption so to speak
        public static String decode(String encodedValue)
        {
            String newEncodedValue = encodedValue.substring(1, encodedValue.length() -1);
            String decodedValue = " ";
            
            // if the inputted barcode numbers are short or longer then 5 it errors
            if (newEncodedValue.length()%5 != 0)
            {
                return "Error, Error, Error";
            }
            
            int previous = 0;
            
            // looks for barcode length and then using the string variable replaces them back with numbers
            for (int i = 5; i < newEncodedValue.length(); i+=5)
            {
                String digit = searchDigit(newEncodedValue.substring(previous, i));
                
                if (!digit.equals(" "))
                {
                    decodedValue += digit;
                }
            
                else 
                {
                    return "Wrong Digit!!";
                }
            
                previous = i;
            }
            

            return decodedValue;
        }
        
        
        // main place to show it all
        public static void main(String[] args)
        {

            // allows user to enter in some zipcodes
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a zipcode please");
            String zipCode = sc.nextLine();
            
            // this dumps in the zipcode
            String encodedValue = encode(zipCode);
            String decodedValue = decode(encodedValue);

            
            // this shows values
            System.out.println("Encoded value of "+zipCode+ " is: \n"+encodedValue+"\n");
            System.out.println("Decoded value of "+encodedValue+" is: \n"+decodedValue+"\n");
 
            
        }
}

/*
Enter a zipcode please
12345
Encoded value of 12345 is: 
|:::||::|:|::||::|::|:|:|::|:|:|

Decoded value of |:::||::|:|::||::|::|:|:|::|:|:| is: 
 1 2 3 4 5 

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  4.058 s
Finished at: 2020-07-18T20:13:38-07:00
------------------------------------------------------------------------

*/





