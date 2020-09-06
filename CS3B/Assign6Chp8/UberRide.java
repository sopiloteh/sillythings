/******************************************************************************
CS003B Java
Erick Bravo
07/08/20
P8.5 Combo Lock
*******************************************************************************/
import java.util.ArrayList;
import java.util.Random;

public class UberRide
{
    // variables
    private ArrayList<Station> stations;
    private int currentStationIndex;
    private int miles;
    private int revenue;
    
    // blanks out the arrays list for uber rides to hail
    public UberRide()
    {
        stations = new ArrayList<>();
        currentStationIndex = 0;
    }
    
    // lets passengers create new stations
    public void addStation(Station station)
    {
        stations.add(station);
    }
    
    // shows a list of potential destinations
    public Station getStation(int index)
    {
        return stations.get(index);
    }
    
    // creates a random amount of uber cars
    public void generateCars(Station station)
    {
       Random randomGenerator = new Random();
       
       // sets the random cap at 30
       int numCars = randomGenerator.nextInt(30);
       
       // runs a loop for cars tallying each instance
       for (int idx = 1; idx <= numCars; idx++)
       {
           // as the destinations keep being entered, the stations increase
           Uber car = null;
           int destination = randomGenerator.nextInt(30 - station.getStationNumber() +1);
           
           car = new Uber(station, station, new Station(destination + station.getStationNumber()-1));
           
           station.addCar(car);
           
       }
    }
    
    // allows miles to be represented
    public int getMiles()
    {
        return miles;
    }
    
    // allows the riders to pay stuff
    public int getRevenue()
    {
        return revenue;
    }
    
    // creates virtual users!
    public void generatePassengers(Station station)
    {
        Random randomGenerator = new Random();
        
        // at least two riders per car so its 60
        int numPassengers = randomGenerator.nextInt(60);
        
        // keeps looping untill its 60 runs
        for (int idx = 1; idx <= numPassengers; idx++)
        {
            Passenger passenger = null;
            
            
            // allows the passenger to create a destination and then adds it to the ubers iteinary
           int destination = randomGenerator.nextInt(30 -station.getStationNumber() +1);
           passenger = new Passenger(station, new Station(destination + station.getStationNumber() -1));
           station.addPassenger(passenger);
           
        }
        
    }
    
    // moves the uber from one place to the next after it drops off a passenger
    public void moveToNextStation()
    {
        // pulls from the inedex and keeps the next station blank untill its called for
        Station currentStation = stations.get(currentStationIndex++);
        Station nextStation = null;
        
        // if there is a next station then add it
        try
        {
            nextStation = stations.get(currentStationIndex);
        }
        
        // if there isnta  next station then it keeps it null
        catch (Exception except)
        {
            nextStation = null;
        }
        
        if (currentStationIndex == 0)
        {
            currentStation.collectRevenue();
        }
        
        else
        {
            currentStation.loadUnloadPassengers();
            currentStation.collectRevenue();
        }
        
        //adds monies to the pot for uber
        // adds miles to the pot for uber
        revenue += currentStation.getTotalRevenueGenerated();
        miles += currentStation.getTotalMiles();
        
        // if the next destition is avalible then use an enchanced loop to  push the cars forward
        if (nextStation != null)
        {
            ArrayList<Uber> carsToMove = currentStation.moveCars();
            
            for (Uber current : carsToMove)
            {
                current.moveToNextStation(nextStation);
                nextStation.addCars(carsToMove);
            }
        }
    }
    
    // main code here
    
    public static void main(String[] args)
    {
        
        // rides start out blank
        // all revenue is blank at first
        UberRide uberride = null;
        double totalRevenuePerMile = 0;
        
        
        // loop for 1000 runs!
        for (int jdx = 1; jdx <= 1000; jdx++)
        {
            // sets the variable holder here
            uberride = new UberRide();
        
            for (int idx = 1; idx <= 30; idx++)
            {
                uberride.addStation(new Station(idx));
            }
            
            //  this runs the loop for 30 times that gets a rider to the car then to the station
            for (int idx = 1; idx < 30; idx++)
            {
                uberride.generateCars(uberride.getStation(idx));
               uberride.generatePassengers(uberride.getStation(idx));
                
            }
            
            // this moves the uber to the next station for 30 times
            for (int idx = 1; idx <= 30; idx++)
            {
                uberride.moveToNextStation();
                
            }
            
            // finally this finds the actual ratio or price per mile 
            double revenuePerMile = ((double) uberride.getRevenue()) / uberride.getMiles();
            //System.out.println(revenuePerMile);
            totalRevenuePerMile += revenuePerMile;
            
        }
        
        // prints out the results of 1000 "random" situations
        System.out.println("Average revenue per per mile in 1000 situations is: \n"
                +totalRevenuePerMile/1000);
    }
    
}

/*
--- exec-maven-plugin:1.5.0:exec (default-cli) @ FakeUber ---
Average revenue per per mile in 1000 situations is: 
0.0
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  0.819 s
Finished at: 2020-07-09T20:25:52-07:00
------------------------------------------------------------------------
*/
