/******************************************************************************
CS003B Java
Erick Bravo
07/06/20
P8.01 Combo Lock
*******************************************************************************/

public class comboLock 
{
    //variables
    boolean turnRight = true;
    int secretA, secretB, secretC;
    int secA, secB, secC;
    int count = 0;
    int dial = 0;
    
    // this sets the combonation lock for the lock
    public comboLock(int secretA, int secretB, int secretC)
    {
        this.secretA = secretA;
        this.secretB = secretB;
        this.secretC = secretC;
        /*
        System.out.print(secretA);
        System.out.print(secretB);
        System.out.print(secretC);
        */
    }
       // this allows the user to turn the dial right
    public void turnRight(int ticks)
    {
        if (count == 0)
        {
            // makes the "dial" turn 
            int tempdial = this.dial + ticks;
            
            // but does not let it go past 40
            if (tempdial > 40)
            {
                this.dial = tempdial - 40;
            }
            
            // less then 40 it gets put into the variable
            else
            {
                this.dial = tempdial; 
                secretA = this.dial;
            }
            
        }
        
        // for dial 2 aka secret code b repeats as above
        if (count == 2)
        {
            int tempdial = this.dial + ticks;
            
            if (tempdial > 40)
            {
                this.dial = tempdial - 40;
            }
            
            else
            {
                this.dial = tempdial;
                secretB = this.dial;
            }
            
        }
        
        
    }
    
    
    // this casuses the lock to relock after its been opened
    public void reset()
    {
        this.secA = 0;
        this.secB = 0;
        this.secC = 0;
        this.dial = 0;
        
    }
    
    // this allows the user to turn the dial left same as turnRight fucntion
    public void turnLeft(int ticks)
    {
        if (count == 1)
        {
            int tempdial = this.dial - ticks;
            
            if (tempdial < 0)
            {
                this.dial = 40 + tempdial;
            }
            
            else
            {
                this.dial = tempdial;
            }
        }
        
        /*
        else 
        {
            secB = this.dial;
        }
        */
    }
    
 
    // this checks to see if the code inputted matches the code to open
    public boolean open()
    {
        
        // if the lock is equal to the inputted lock code and the submitted one
        if (secA == secretA)
        {
            if (secB == secretB)
            {
                if (secC == secretC)
                {
                    return true;
                }
                
                else 
                {
                    // this makes the lock close right away
                    count = 2;
                }
            }
            
            // adds one to the counter
            count = 1;
        }
        
        // adds nothing
        else
        {
            count = 0;
            
        }
        
    // if it wasnt matched it stays locked    
return false;
        
    }   
}
