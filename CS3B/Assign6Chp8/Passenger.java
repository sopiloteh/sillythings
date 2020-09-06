
import java.util.ArrayList;

/******************************************************************************
CS003B Java
Erick Bravo
07/08/20
P8.5 Combo Lock
*******************************************************************************/

public class Passenger 
{
    // variables
    private Station destination;
    private Station startStation;
    
    // adding station functions
    public Passenger(Station startStation, Station destination)
    {
        this.startStation = startStation;
        this.destination = destination;
    }
    
    // returning variable from getDestination
    public Station getDestination()
    {
        return destination;
    }
    
    // returning variable from getStartStation
    public Station getStartStation()
    {
        return startStation;
    }
    
    // returning  if it passes truth test for the staion
    public boolean checkDestinationReached(Station currentStation)
    {
        return destination.equals(currentStation);
    }
    
    // calculates how much user pays and returns that value
    public int payFare()
    {
        return destination.getStationNumber() - startStation.getStationNumber();
    }
    
    // connects the dots so to speak
    @Override
    public String toString()
    {
        return "Start Station: "+startStation+" Destination: "+destination;
    }
    

    
}
