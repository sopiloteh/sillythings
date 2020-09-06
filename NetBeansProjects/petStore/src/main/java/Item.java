/******************************************************************************
CS003B Java
Erick Bravo
07/02/20
P7.12 Pet Store
*******************************************************************************/
public class Item
{
    private double price;
    private boolean isPet;
    private int quantity;
    
    // sets the function inputs
    public Item(double price, boolean isPet, int quantity)
    {
        this.price = price;
        this.isPet = isPet;
        this.quantity = quantity;
    }
    
    // reads the price
    public double getPrice()
    {
        return price;
    }
    
    // if its a pet
    public boolean isAPet()
    {
        return isPet;
    }
    
    // reads the total
    public int getQuantity()
    {
        return quantity;
    }
}