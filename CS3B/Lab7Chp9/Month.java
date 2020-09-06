/******************************************************************************
CS003B Java
Oscar Kim & Erick Bravo
07/14/20
P9.04 Apponintment
*******************************************************************************/

public class Month extends Appointment
{
    // pulls variables from appointment
    public Month(int day,int month, int year, String description)
    {
        super(day, month, year, description);
    }
    
    // checks to see if it occurs on that month specifically
    public boolean occurs(int day,int month, int year)
    {
        if (year < getYear())
        {
            return false;
        }
        
        if (month < getMonth() && year == getYear())
        {
            return false;
        }
        
        return day == getDay();
    }
}
