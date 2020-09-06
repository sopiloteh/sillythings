/******************************************************************************
CS003B Java
Erick Bravo
07/13/20
P9.03 Alarm Clock
*******************************************************************************/

import java.time.LocalTime;

public class Clock 
{
    // variables
    protected int alarmMinutes;
    protected int alarmHours;
    protected int alarmSeconds;
    
    // sets the alarm with 
    public void setAlarm(int hours, int minutes, int seconds)
    {
        alarmSeconds = seconds;
        alarmMinutes = minutes;
        alarmHours = hours;
    }
    
    // pulls the computers time to get the hour
    public int getHours()
    {
        LocalTime currentTime = LocalTime.now();
        String nowTimeStr = currentTime.toString();
        return Integer.parseInt(nowTimeStr.substring(0,2));
    }
    
    // pulls the computers time to get the minute
    public int getMinutes()
    {
        LocalTime currentTime = LocalTime.now();
        String nowTimeStr = currentTime.toString();
        return Integer.parseInt(nowTimeStr.substring(3,5));
        
    }
    
    // pulls the computers time to get the second
    public int getSeconds()
    {
        LocalTime currentTime = LocalTime.now();
        String nowTimeStr = currentTime.toString();
        return Integer.parseInt(nowTimeStr.substring(6,8));
    }
    
    //strings all the methods toghether and claims alarm if its alarm time
    public String getTime()
    {
        String currentTime = getHours()+":"+getMinutes()+":"+getSeconds();
        String alarmTime = alarmHours+":"+alarmMinutes+":"+alarmSeconds;
        
        // if the alarm matches the current time
        if (currentTime.compareTo(alarmTime) >= 0)
        {
            alarmHours = 999;
            alarmMinutes = 999;
            alarmSeconds = 999;
            
            return getHours()+":"+getMinutes()+":"+getSeconds()+" Alarm";
        }
        return getHours()+":"+getMinutes()+":"+getSeconds();
    }
    
    
    
}
