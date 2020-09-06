import java.util.Scanner;
public class Bars
{
    public static void main(String[] args)
    {
        Scanner choice = new Scanner(System.in);
        System.out.print("Barcode(1) or Zipcode(2): \n");
        int menu = choice.nextInt();
        
        if (menu == 1)
        {
            System.out.println("Please enter the Barcode:\n");
            Scanner input = new Scanner(System.in);
            String zipcode = input.next();
            input.close();
        
        
            //String checkDigitone = to_checkDigit(zipcode);
            String barcode = "|";
           // barcode = convert_digitToBarCode(checkDigitone) + barcode;
                for (int i = 0; i < 5; i++)
                {
                    //barcode = convert_barcodeToZipcode(checkDigitone) + barcode;
                    //zipcode/= 10;
                }
            
            System.out.println(barcode);
        }
        
        else if (menu == 2)
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
    
    public static String convert_barcodeToZipcode(String digit)
    {
        if (":::||".equals(digit))
        {
            return "1";
        }
        if ("::|:|".equals(digit))
        {
            return "2";
        }
        if ("::||:".equals(digit))
        {
            return "3";
        }
        if (":|::|".equals(digit))
        {
            return "4";
        }
        if (":|:|:".equals(digit))
        {
            return "5";
        }
        if (":||::".equals(digit))
        {
            return "6";
        }
        if ("|:::|".equals(digit))
        {
            return "7";
        }
        if ("|::|:".equals(digit))
        {
            return "8";
        }
        if ("|:|::".equals(digit))
        {
            return "9";
        }
        return "0";
    }
}





