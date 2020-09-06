/******************************************************************************
CS003B Java
Erick Bravo
06/23/20
P3.05 Microwave
*******************************************************************************/
public class Microwave 
{
    public static void main(String[] args)
    {
        // creates a variable to hold the functions
        microOven microoven = new microOven();
        
        // this starts at 0 then goes up manually to 3
        // increases time to 30 seconds then resets or clears it out to go to
        // next level of cooking
        microoven.increase();
        microoven.reset();
        microoven.start();
        microoven.increase();
        microoven.set(1);
        microoven.start();
        microoven.reset();
        microoven.increase();
        microoven.set(2);
        microoven.start();   
        microoven.reset();
        microoven.increase();
        microoven.set(3);
        microoven.start();

    }    
}

/*
Code ran in NetBeans
Cooking for 0 seconds at level 0
Cooking for 30 seconds at level 1
Cooking for 30 seconds at level 2
Cooking for 30 seconds at level 3
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  0.853 s
Finished at: 2020-06-23T11:46:29-07:00
*/

