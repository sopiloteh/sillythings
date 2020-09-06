/******************************************************************************
CS003B Java
Yonas Adamu & Erick Bravo
07/16/20
P10.7 Lambada
*******************************************************************************/
public class DataSet 
{
    // this is what actually measures the accounts and makes sure they are fit
    public static double average(Object[] objects, Measurer meas, Filter filt)
    {
        double sum = 0;
        double avg = 0;
        int count = 0;
        
        // this sums up the accounts to get the average
        for (Object ob : objects)
        {
            if (filt.accept(ob))
            {
                sum += meas.measure(ob);
                count++;
            }
        }
        
        // if the accounts are 1 dollar or more then it shows up
        if (count > 0)
        {
            avg = (double)sum/count;
        }
        
        return avg;
    }
    
    // prints our the display
    public static void main (String[] args)
    {
        // creates an array for random bankaccounts
        //all of them at 0 and +/- 10000 bucks
        BankAccount accounts[] = new BankAccount[]
        {
            new BankAccount(200),
            new BankAccount(1500),
            new BankAccount(1000),
            new BankAccount(2000),
            new BankAccount(3000),
            new BankAccount(0),
            new BankAccount(50),
        };
        
        // this feeds the above array into the mentioned classes
        BalanceMeasurer measurer = new BalanceMeasurer();
        BalanceFilter filter = new BalanceFilter();
        
        double avg = average(accounts, measurer, filter);
        System.out.println("Average is "+avg);
    }   
}

/*
running below WITHOUT lambda function/expression
Average is 1875.0
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  2.344 s
Finished at: 2020-07-16T18:39:36-07:00
------------------------------------------------------------------------
*/
