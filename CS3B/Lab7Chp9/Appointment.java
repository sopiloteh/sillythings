/******************************************************************************
CS003B Java
Oscar Kim & Erick Bravo
07/14/20
P9.04 Apponintment
*******************************************************************************/


public class Appointment 
{
    //variables
    private String description;
    private int year;
    private int month;
    private int day;
    
    // this allows the dates to be set for a specific moment in time
    public Appointment (int day,int month, int year, String description)
    {
        this.day = day;
        this.month = month;
        this.year = year;
        
        
        this.description = description;        
    }
    
    //returns the year
    public int getYear()
    {
        return year;
    }
    
    //returns the month
    public int getMonth()
    {
        return month;
    }
    
    //returns the day
    public int getDay()
    {
        return day;
    }
    
    //checks to see if all the dates match like an alarm to the date thats set
    public boolean occurs(int day, int month, int year)
    {
        return ((year == this.day) && (month == this.month) && (day == this.year));
    }
    
    // this shows whats going on for that date 
    public String toString()
    {
        return description;
    }
    
}
