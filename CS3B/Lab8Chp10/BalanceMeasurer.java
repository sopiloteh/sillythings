/******************************************************************************
CS003B Java
Yonas Adamu & Erick Bravo
07/16/20
P10.7 Lambada
*******************************************************************************/

public class BalanceMeasurer implements Measurer
{
    //measures how big the account is really
    public double measure(Object object)
    {
        return ((BankAccount) object).getBalance();
    }
    
}
