/******************************************************************************
CS003B Java
Erick Bravo
06/22/20
P3.09 Battery
*******************************************************************************/
/*
this is the main piece of code that will pull in all the functions from
battery.java
*/
public class BatteryTest 
{
    public static void main(String[] args)
    {
        //sets a variable for the battery
        Battery mahBattery = new Battery(2000);
        // prints out the disclaimer of what its capacity at
        System.out.println("Battery\nCapacity :2000mAh\nDischarge 500mAhr");
        // calls in the function to set the drain rate
        mahBattery.drain(500);
        System.out.println("Remaning Capacity: " +mahBattery.getRemaniningCapacity());
        // prints out remaining charge
        mahBattery.charge();
        System.out.println("Full Recharge battery: " +mahBattery.getRemaniningCapacity());
    }    
}
/*
Test results below using Apache NetBeans
Battery
Capacity :2000mAh
Discharge 500mAhr
Remaning Capacity: 1500.0
Full Recharge battery: 2000.0
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  4.489 s
Finished at: 2020-06-22T15:51:02-07:00
*/