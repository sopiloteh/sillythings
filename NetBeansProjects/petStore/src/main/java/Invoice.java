/******************************************************************************
CS003B Java
Erick Bravo
07/02/20
P7.12 Pet Store
*******************************************************************************/
import java.util.ArrayList;

public class Invoice 
{
    //creates an array to list the items and such
    private ArrayList<Item> items;
    
    // creates a function to add items to a list
    public Invoice()
    {
        items = new ArrayList<Item>();
    }
    
    // adds items to a list
    public void add(Item anItem)
    {
        items.add(anItem);
    }
    
    // enables a discount if asked for
    public double getDiscount()
    {
        
        // variables
        int pets = 0;
        int otherItems = 0;
        double rate = 0.2;
        double totalDiscount = 0;
        
        // runs an enhanced loop
        for (Item i : items)
        {
            // adds if its a pet
            if (i.isAPet())
            {
                pets++;
            }
            
            // adds if its an item
            else
            {
                otherItems++;
            }
        }
        
        // if no pets or less then 5 items, no discount
        if (pets < 1 || otherItems < 5 )
        {
            return 0;
        }
        
        // runs an enhanced loop  to get the discounts
        
        for (Item i : items)
        {
            if (!i.isAPet())
            {
                double discount = i.getPrice() * i.getQuantity() * rate;
                totalDiscount = totalDiscount + discount;
            }               
        }
        
        // returns a discount IF this function is called for
        return totalDiscount;
    }
    
}


