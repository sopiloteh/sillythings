/******************************************************************************
CS003B Java
Yonas Adamu & Erick Bravo
07/16/20
P10.7 Lambada
*******************************************************************************/
public class BankAccount 
{
    //variable
    private double balance;
    
    // starts the bank account at 0
    public BankAccount()
    {
        balance = 0;
    }
    
    // creates a starter account
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }
    
    // lets the user deposit ill gotten monies
    public void deposit(double amount)
    {
        balance = balance + amount;
    }
    
    // lets the user withdraw monies for a burger
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }
    
    // lets the user check how much has after spending
    public double getBalance()
    {
        return balance;
    }
    
    //increasres the balance of the account by adding a small dividend
    public void addIntrest(double rate)
    {
        balance = balance + balance * rate/100;
    }
    
}
