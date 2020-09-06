/******************************************************************************
CS003B Java
Erick Bravo
07/02/20
P7.12 Pet Store
*******************************************************************************/
import java.util.Scanner;

public class pets 
{
  public static void main(String[] args)
  {
      Invoice invoice = new Invoice();
      System.out.println("Price and Quantity for an item, press -1 to quit");
      
      // allows input for an item
      Scanner in = new Scanner(System.in);
      double price = in.nextDouble();
            
     
      // the -1 is a sentinal to stop the loop
      while (price != -1)
      {
          // lets user input if its a pet or no
          int quantity = in.nextInt();
          System.out.println("\nIs the item a pet (Y or N)");
          
          // repeats the loop forever more
          String input = in.next();
          System.out.println("Price and Quantity for an item, press -1 to quit");
         
          
          // yes or no
          boolean isPet;
          
          // feeds information to the boolean if its a yes or no
          if (input.equalsIgnoreCase("Y"))
          {
              isPet = true;
          }
          
          else
          {
              isPet = false;
          }
          
          // adds to item file
          Item anItem = new Item(price, isPet, quantity);
          invoice.add(anItem);
          
          price = in.nextDouble();
      }
      
      
      // this dumps out the discount if the requirements are met
      double discount = invoice.getDiscount();
      System.out.printf("\nTotal discount $%.2f\n",discount);
  }
}

/*
Price and Quantity for an item, press -1 to quit
10.90 2

Is the item a pet (Y or N)
n
Price and Quantity for an item, press -1 to quit
200.90 1

Is the item a pet (Y or N)
y
Price and Quantity for an item, press -1 to quit
-1

Total discount $0.00
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  29.829 s
Finished at: 2020-07-02T12:23:12-07:00
------------------------------------------------------------------------

*/
