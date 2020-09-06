/******************************************************************************
CCS003B Java
Erick Bravo Luis Fernando Lopez
07/03/20
P7.14 Supermarche
*******************************************************************************/

import java.util.*;

public class store
{
    public static void main(String[] args)
    {
        // makes arrays to put in customers sales costs and the best customer
        ArrayList<String>customers = new ArrayList<>();
        ArrayList<Double>sales = new ArrayList<>();
        ArrayList<String>topNames = new ArrayList<>();
        
        // allows user input
        Scanner input = new Scanner(System.in);
        
        //variables used for customer name, a top N list and a spending number
        String name;
        int top;
        double sale;
        
        // while loop to break the code, this will only be false if x is entered
        while(true)
        {
            System.out.println("Enter the customer name (Enter X to end): ");
            name = input.nextLine();
            
            // if they enter in a 0 it breaks the code and sends them to the end
            
            if ("x".equalsIgnoreCase(name))
            {
                break;
            }
            
            
            // adds customers to an array
            customers.add(name);
            
            // prints out customers name so it can be visually tagged to the sales
            System.out.println("Enter the "+name+"'s sales: $");
            sale = input.nextDouble();
            
            // add its to the array list
            sales.add(sale);
            // continues to the next blank array list space avalible
            input.nextLine();
        }
        System.out.println("\nEnter the number of top customers to display: ");
        top = input.nextInt();
        
        // variables pushed into the function
        topNames = nameofBest(sales, customers, top);
        
        // after being pushed into function
        // out comes how many top customers there are
        System.out.println("\n\nTop "+top+"customers: ");
        System.out.println("...............................");
        
        // the actual print out
        for(int j = 0; j < topNames.size(); j++)
        {
            System.out.println((j+1)+". "+topNames.get(j));
        }    
    }
    
    // this years 2020 best of list of customers
    public static ArrayList nameofBest(ArrayList<Double> sales,ArrayList<String> customers, int topN)
    {
        ArrayList<String>topCustomers = new ArrayList<>();
        double tempSale;
        String tempCustomer;
        
        //double loop to look at 2d array and pull items out
        for (int i = 0; i < sales.size(); i++)
        {
            for (int j = i+1; j < sales.size(); j++)
            {
                if (sales.get(i) < sales.get(j))
                {
                    tempSale = sales.get(i);
                    sales.set(i, sales.get(j));
                    sales.set(j, tempSale);
                    
                    tempCustomer = customers.get(i);
                    customers.set(i, customers.get(j));
                    customers.set(j, tempCustomer);
                }
            }
        }
        
        // comparing the size of the customers top spending list
        if (topN > sales.size())
        {
            return customers;
        }
        
        // filtering for moving the top customer to the top while keeping the
        // others in line
        for (int j = 0; j < topN; j++)
        {
            topCustomers.add(customers.get(j));
            
        }
        return topCustomers;
    }
    /*
Enter the customer name (Enter X to end): 
erick
Enter the erick's sales: $
32131
Enter the customer name (Enter X to end): 
bob
Enter the bob's sales: $
32131
Enter the customer name (Enter X to end): 
tony
Enter the tony's sales: $
321313
Enter the customer name (Enter X to end): 
don
Enter the don's sales: $
2131231
Enter the customer name (Enter X to end): 
sar
Enter the sar's sales: $
213213
Enter the customer name (Enter X to end): 
joe
Enter the joe's sales: $
213123
Enter the customer name (Enter X to end): 
x

Enter the number of top customers to display: 
6


Top 6customers: 
...............................
1. don
2. tony
3. sar
4. joe
5. erick
6. bob
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  24.431 s
Finished at: 2020-07-02T16:37:05-07:00
------------------------------------------------------------------------
    */
    
}