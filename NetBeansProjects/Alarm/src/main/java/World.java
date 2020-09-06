/******************************************************************************
CS003B Java
Erick Bravo
07/13/20
P9.03 Alarm Clock
*******************************************************************************/

import java.time.LocalTime;

public class World extends Clock
{
    // this allows any time zone to be showen
    private final long offset;
    World(long offset)
    {
        this.offset = offset;
    }
    
    // same as clock but with the hour pushed
    @Override
    public int getHours()
    {
        LocalTime currentTime = LocalTime.now();
        currentTime = currentTime.plusHours(offset);
        String nowTimeStr = currentTime.toString();
        return Integer.parseInt(nowTimeStr.substring(0,2));
    }
    
    // same as clock but with the minutes pushed
    @Override
    public int getMinutes()
    {
        LocalTime currentTime = LocalTime.now();
        currentTime = currentTime.plusHours(offset);
        String nowTimeStr = currentTime.toString();
        return Integer.parseInt(nowTimeStr.substring(3,5));
    }
    
    // same as clock but with the seconds pushed
    @Override
    public int getSeconds()
    {
        LocalTime currentTime = LocalTime.now();
        currentTime = currentTime.plusHours(offset);
        String nowTimeStr = currentTime.toString();
        return Integer.parseInt(nowTimeStr.substring(6,8));
    }
    
    // allows an alarm to be set but with the hour pushed or minused
    public void setAlarm(int hours, int minutes, int seconds)
    {
        super.setAlarm((hours + (int)offset),minutes,seconds);
    }
    
}
