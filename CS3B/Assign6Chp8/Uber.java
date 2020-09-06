/******************************************************************************
CS003B Java
Erick Bravo
07/08/20
P8.5 Combo Lock
*******************************************************************************/

import java.util.ArrayList;

public class Uber
{
    
    // variables
   private Station destination;
   private Station currentStation;
   private Station startStation;
   private int currentPassengers;
   private static final int capacity = 3;
   private ArrayList<Passenger> passengers;
   private int revenueCollected;
   
   // sets the car as basic starter values
   public Uber(Station startStation, Station currentStation, Station destination)
   {
       this.startStation = startStation;
       this.currentStation = currentStation;
       this.destination = destination;
       currentPassengers = 0;
       revenueCollected = 0;
       passengers = new ArrayList<>();
       
   }
   
   // checks to see if a passenger can hail a ride
   public boolean pickPassenger(Passenger passenger)
   {
       if (!spaceAvalible())
       {
           return false;
       }
       
       passengers.add(passenger);
       currentPassengers++;
       return true;
       
   }
   
   // drops off the passenger once destination is arrived
   public void dropPassenger()
   {
       // if the cars empty then leave
       if (passengers.isEmpty())
       {
           return;
       }
       
       // dumps remaining passengers untill the cars empty
       for (int idx = 0; idx < passengers.size(); idx++)
       {
           Passenger currentPassenger = passengers.get(idx);
           
           if (currentPassenger.checkDestinationReached(currentStation))
           {
               revenueCollected += currentPassenger.payFare();
               passengers.remove(idx--);
               currentPassengers--;
           }
       }
   }
   
   // checks to see if there is still space and returns the empty seats
   public boolean spaceAvalible()
   {
       return currentPassengers<capacity;
   }
   
   // gets the  revenue made and returns it
   public int getRevenue()
   {
       return revenueCollected;
   }
   
   // gets how many miles the uber has gone for each passennger
   public int getMilesDriven()
   {
       return destination.getStationNumber() - startStation.getStationNumber();
   }
   
   // once the passenger is dropped off, moves to next location
   public void moveToNextStation(Station next)
   {
       currentStation = next;
   }
   
   // verifiys if the passenger has reached the place they want to go to\
   
   public boolean isDestinationReached()
   {
       return currentStation.equals(destination);
   }
   
   // override since ide suggested it and this string is tied together 
   //with all above public functions
   @Override
   public String toString()
   {
       StringBuilder sb = new StringBuilder();
       sb.append("Start Station: "+startStation+"; Current Station: "
               +currentStation+"; Destination: "+destination+"; Current Number "
                       + "of Passengers: "+currentPassengers+"; Revenue collected"
               +revenueCollected);
       return sb.toString();
   }
   
   // finds current passengers to drive around
   public int getCurrentPassengers()
   {
       return currentPassengers;
   }
   
   // gets the passengers destination
   public Station getDestination()
   {
       return destination;
   }
   
   //adds to the list of users to drive around
   public ArrayList<Passenger>getPassengers()
   {
       return passengers;
   }
   

   
}