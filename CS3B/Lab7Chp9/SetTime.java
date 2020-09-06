/******************************************************************************
CS003B Java
Oscar Kim & Erick Bravo
07/14/20
P9.04 Apponintment
*******************************************************************************/

public class SetTime extends Appointment
{
    // this only sets the time once in the appointment book so its not repeating
    public SetTime (int day,int month, int year, String description)
    {
        //SUPER forces it back to the Appointment 
        super(day, month, year,description);
    }  
}
