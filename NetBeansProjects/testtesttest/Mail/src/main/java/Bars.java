import java.util.Scanner;

 
public class Bars 
{
    public static void main(String[] args) 
    {
        System.out.print("Enter a zip code: \n");
        Scanner input = new Scanner(System.in);
        
        int zipcode = input.nextInt();
        input.close();
        int checkDigitone = to_checkDigit(zipcode);

 
        String barcode = "|";
        barcode = convert_digitToBarCode(checkDigitone) + barcode;
        
        for (int i = 0; i < 5; i++) 
        {
            barcode = convert_digitToBarCode(checkDigitone) + barcode;
            zipcode/= 10;
        }
        
        barcode = "|" + barcode;
        System.out.println(barcode);
    }

 
    public static int to_checkDigit(int zipcode) 
    {
        int remainder = zipcode;
        int sum_here = 0;
        while (remainder > 0) {
            sum_here += remainder % 10;
            remainder /= 10;
        }
        return 10 - (sum_here % 10);
    }

 
    public static String convert_digitToBarCode(int digit) 
    {
        if (digit == 1) 
        {
            return ":::||";
        }
        if (digit == 2) 
        {
            return "::|:|";
        }
        if (digit == 3) 
        {
            return "::||:";
        }
        if (digit == 4) 
        {
            return ":|::|";
        }
        if (digit == 5) 
        {
            return ":|:|:";
        }
        if (digit == 6) 
        {
            return ":||::";
        }
        if (digit == 7) 
        {
            return "|:::|";
        }
        if (digit == 8) 
        {
            return "|::|:";
        }
        if (digit == 9) 
        {
            return "|:|::";
        }
        return "||:::";
    }
}
