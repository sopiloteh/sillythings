/******************************************************************************
CS003B Java
Erick Bravo
06/25/20
P6.10 Number Discard
*******************************************************************************/

import java.util.Scanner;

public class dataTest 
{
    public static void main(String[] args)
    {
        double value;
        
        // allows input so that user can punch in numbers
        Scanner scanner = new Scanner(System.in);
        
        dataSet data = new dataSet();
        System.out.println("Enter a value or 0 to quit");
        
        // dumps in the inputted value into dataSet
        value = scanner.nextDouble();
        
        // keeps the program running foreever as long as there is no 0 inputted
        while(value!=0)
        {
            data.add(value);
            System.out.println("Enter a value or 0 to quit");
            value = scanner.nextDouble();
        }
        
        // prints out both the average and the standard dev
        System.out.println("Average of values " + data.getAve());
        System.out.println("Standard deviation " + data.getStanDev());
    }
    
}
