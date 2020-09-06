/******************************************************************************
CS003B Java
Erick Bravo
07/20/20
Final Project Planner
*******************************************************************************/

/**
 * This is a subclass of ClassRoom which is a subclass of CollegeBuilding
 * @author erickbravo
 */
public class Seats extends ClassRoom
{
    public int Chair;
    private boolean ok;
 
    /**
     * checks to see if option 1 or whatever is choosen
     * if option 1 on the radio bttn then comfey seats
     * else nothing avalible
     */
    public Seats()
    {
        
        if (Chair == 1)
        {
            ok = true;
        }
        
        else
        {
            ok = false;
        }
        
    }
    
}
