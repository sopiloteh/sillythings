/******************************************************************************
CS003B Java
Erick Bravo
06/23/20
P3.05 Microwave
*******************************************************************************/


// holds the function for the microwave
public class microOven
{
    // so the variables arent touched dramatically
    private int seconds;
    private int level;
    
    // sets the variables at 0
    public microOven()
    {
        seconds = 0;
        level  = 0;
    }
    
    // this adds some time by pushing it up by 30 seconds
    public void increase()
    {
        seconds = seconds + 30;
    }
    
    // allows the level to show
    public void set(int level)
    {
        this.level = level;
    }
    
    // this outputs the actual start time and cook level
    public void start()
    {
        System.out.println("Cooking for "+seconds+" seconds at level "+level);
    }
    
    // blanks it all out and sets it to 0
    public void reset()
    {
        seconds = 0;
        level = 0;
    }
}
