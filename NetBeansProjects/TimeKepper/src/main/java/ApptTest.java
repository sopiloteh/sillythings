/******************************************************************************
CS003B Java
Tuan Tran & Erick Bravo
07/14/20
P9.04 Apponintment
*******************************************************************************/

import java.util.Scanner;
public class ApptTest 
{
    public static void main(String[] args)
    {
        
        // this sets up a simple array of three appointments
        Appointment[] appt = new Appointment[3];
        appt[0] = new Day(27,7,2020,"Final Java Presentations");
        appt[1] = new Day(28,7,2020,"Java Final");
        appt[2] = new Day(29,7,2020,"Linear Algebra Starts");
        
        System.out.println("Please enter a date \n"
                + "Follow this order: Day,Month,Year: ");
        
        // allows the user to look up dates by entering a date
        Scanner in = new Scanner(System.in);
        System.out.println("Day: ");
        int day = in.nextInt();
        System.out.println("Month: ");
        int month = in.nextInt();
        System.out.println("Year: ");
        int year = in.nextInt();
        System.out.println("The Appointment Book will now look\n Searching... \n"
                + " Searching... \n Searching... \n");
        
        // this loop goes through the array to see if any of the dates are avalible
        for(int i = 0; i < appt.length; i++)
        {
            // checks with boolean in Appointment.java
            
            if (appt[i].occurs(day, month, year))
            {
                System.out.println(appt[i].toString());
            }
        }
    }
}

/*
Please enter a date 
Follow this order: Day,Month,Year: 
Day: 
27
Month: 
7
Year: 
2020
The Appointment Book will now look
 Searching... 
 Searching... 
 Searching... 

Final Java Presentations
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  13.055 s
Finished at: 2020-07-14T14:27:41-07:00
------------------------------------------------------------------------
*/

