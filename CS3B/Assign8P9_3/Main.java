/******************************************************************************
CS003B Java
Erick Bravo
07/13/20
P9.03 Alarm Clock
*******************************************************************************/
public class Main 
{
    public static void main(String[] args)
    {
        Clock clock = new Clock();
        
        // displays Time in California
        clock.setAlarm(15,45,00);
        System.out.println("Pacific time is the time here ");
        System.out.println("Hours: "+clock.getHours());
        System.out.println("Minutes: "+clock.getMinutes());
        System.out.println("Seconds: "+clock.getSeconds());
        System.out.println("Current time: "+clock.getTime()+"\n");
        
        // displays Time in New York
        World world = new World(3);
        world.setAlarm(12,45,00);
        System.out.println("East coast time is +3 hours ahead ");
        System.out.println("Hours: "+world.getHours());
        System.out.println("Minutes: "+world.getMinutes());
        System.out.println("Seconds: "+world.getSeconds());
        System.out.println("Current time: "+world.getTime()+"\n");
        
        // displays Time in Hawaii
        World worldB = new World(-3);
        worldB.setAlarm(15,45,00);
        System.out.println("Hawaian coast time is -3 hours ahead ");
        System.out.println("Hours: "+worldB.getHours());
        System.out.println("Minutes: "+worldB.getMinutes());
        System.out.println("Seconds: "+worldB.getSeconds());
        System.out.println("Current time: "+worldB.getTime()+"\n");
    }
    
}

/*

Alarm only triggered for east coast not Hawaii or Pacific
Pacific time is the time here 
Hours: 15
Minutes: 44
Seconds: 41
Current time: 15:44:41

East coast time is +3 hours ahead 
Hours: 18
Minutes: 44
Seconds: 41
Current time: 18:44:41 Alarm

Hawaian coast time is -3 hours ahead 
Hours: 12
Minutes: 44
Seconds: 41
Current time: 12:44:41

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  0.824 s
Finished at: 2020-07-13T15:44:41-07:00
------------------------------------------------------------------------

Alarm clock set at 3:35pm or 15:45, all alarms triggered now
Pacific time is the time here 
Hours: 15
Minutes: 45
Seconds: 31
Current time: 15:45:31 Alarm

East coast time is +3 hours ahead 
Hours: 18
Minutes: 45
Seconds: 31
Current time: 18:45:31 Alarm

Hawaian coast time is -3 hours ahead 
Hours: 12
Minutes: 45
Seconds: 31
Current time: 12:45:31 Alarm

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  0.861 s
Finished at: 2020-07-13T15:45:31-07:00
------------------------------------------------------------------------
*/
