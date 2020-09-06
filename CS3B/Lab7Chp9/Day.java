/******************************************************************************
CS003B Java
Oscar Kim & Erick Bravo
07/14/20
P9.04 Apponintment
*******************************************************************************/

public class Day extends Appointment
{
    public Day(int day,int month, int year, String description)
    {
        // forces it to be pulled from appointment
        super(day, month, year,description);
    }
    
    // checks to see if it occurs on the day specifically
    public boolean occurs(int day,int month, int year)
    {
        //checks to see if its same year or greater then current year
        if (year > getYear())
        {
            return true;
        }
        
        // after it checks for that it sees if the month & day are bigger
        if (year == getYear())
        {
            if (month > getMonth())
            {
                return true;
            }
            
            if (day >= getDay())
            {
                return true;
            }
            
        }
        
        return false;

    }
}
