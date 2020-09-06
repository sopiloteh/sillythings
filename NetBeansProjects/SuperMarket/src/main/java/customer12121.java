/******************************************************************************
CCS003B Java
Erick Bravo Luis Fernando Lopez
07/03/20
P7.14 Supermarche
*******************************************************************************/
public class customer 
{
    private String name;
    private double purchase;
    
    public customer(String name, double purchase)
    {
        this.name = name;
        this.purchase = purchase;
    }
    
    // returns customer name
    public String getName()
    {
        return name;
    }
    
    //returns customer purchase
    public double getPurchase()
    {
        return purchase;
    }
    
    // returns combo of name and purchase
    public String toString()
    {
        return getName()+"\t"+ getPurchase();
    }
    
}
