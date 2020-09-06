/******************************************************************************
CS003B Java
Erick Bravo
06/22/20
P3.09 Battery
*******************************************************************************/

// creates a public class to encompass all that is needed for the battery
// tester to work
public class Battery 
{
    // sets variable for capacity
    private double batteryCapacity;
    
    // sets a variable for the og capacity thats hardcoded
    private double originalCapacity;
    
    // sets placeholders so that both can be called
    public Battery(double capacity)
    {
        batteryCapacity = capacity;
        originalCapacity = capacity;
    }
    
    // runs a function to remove whatever amount to cut from bat capacity
    public void drain(double amount)
    {
        batteryCapacity = batteryCapacity - amount;
    }
    
    // replaces og cacpacity with the new capacity
    public void charge()
    {
        batteryCapacity = originalCapacity;
    }
    
    // this function dumps it back into the main BatteryTest.java code
    public double getRemaniningCapacity()
    {
        return batteryCapacity;
    }
        
}
