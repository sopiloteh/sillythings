/******************************************************************************
CS003B Java
Yonas Adamu & Erick Bravo
07/16/20
P10.7 Lambada
*******************************************************************************/

public class  BalanceFilter implements Filter
{
    // filters out accounts less then 1000 bucks
    @Override
    public boolean accept(Object object)
    {
        return ((BankAccount) object).getBalance() >= 1000;
    }
}
    
