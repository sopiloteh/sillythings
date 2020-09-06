/******************************************************************************
CS003B Java
Erick Bravo
07/08/20
P8.5 Uber
*******************************************************************************/
import java.util.ArrayList;

public class Station 
{
    // variables
    private ArrayList<Uber> cars;
    private ArrayList<Passenger> passengers;
    private int totalRevenueGenerated;
    private int totalMiles;
    private final int stationNumber;
    
    // this is a dump to set up new stations and miles to and form and such
    public Station(int stationNumber)
    {
        cars = new ArrayList<>();
        passengers = new ArrayList<>();
        totalRevenueGenerated = 0;
        totalMiles = 0;
        this.stationNumber = stationNumber;
    }
    
    // this assigns each station an individual number and returns that number
    public int getStationNumber()
    {
        return stationNumber;
    }
    
    // this adds in another car when prompted by the random function in the other java files
    public void addCar(Uber car)
    {
        cars.add(car);
    }
    
    // this pulls from the array list and the
    public void addCars(ArrayList<Uber> cars)
    {
        for(Uber current: cars)
        {
            this.cars.add(current);
        }
    }
    
    // this adds another passeneger if a passnger already exisits
    public void addPassenger(Passenger pass)
    {
        passengers.add(pass);
    }
    
    // full milelage for the day for the simulation
    public int getTotalMiles()
    {
        return totalMiles;
    }
    
    // full total mileage for the day for the simulation
    public int getTotalRevenueGenerated()
    {
        return totalRevenueGenerated;
    }
    
    // collects the days totals from the cars
    public void collectRevenue()
    {
        // runs for how many people were inside the car and adds to the totals
        for (int idx = 0; idx < cars.size(); idx++)
        {
            Uber current = cars.get(idx);
            
            if (current.isDestinationReached())
            {
                totalRevenueGenerated += current.getRevenue();
                totalMiles+= current.getMilesDriven();
                cars.remove(idx--);
            }
        }
    }
    
    // loads users and then dumps them out once a place is reached
    public void loadUnloadPassengers()
    {
        // runs a loop to see how many passengers are iniside
        for (int idx = 0; idx < cars.size(); idx++)
        {
            cars.get(idx).dropPassenger();
        }
        
        // if empty returns the car
        if (passengers.isEmpty())
        {
            return;
        }
        
        // if there are users, checks to see if its full
        for (int idx = 0; idx < cars.size(); idx++)
        {
            Uber current = cars.get(idx);
        
            if (!current.spaceAvalible())
            {
                continue;
            }
            
            int requiredPassengers = 3 - current.getCurrentPassengers();
            
            // runs a loop to see the users going from and to destinations
            for (int jdx = 0; jdx < requiredPassengers; jdx++)
            {
                for (int kdx = 0; kdx < passengers.size(); kdx++)
                {
                    if (passengers.get(kdx).getDestination().getStationNumber() 
                            <= current.getDestination().getStationNumber())
                            {
                                current.pickPassenger(passengers.get(kdx));
                                passengers.remove(kdx--);
                                break;
                            }
                }
                
                // if there is space avalible or if there is all the space
                if (!current.spaceAvalible() || passengers.isEmpty())
                {
                    break;
                }
                
                if (passengers.isEmpty())
                {
                    break;
                }
            }
        
    }
    }
    
   // moves cars in the array
   public ArrayList<Uber>moveCars()
   {
        return cars;
   }
   
   // override suggested by ide, allows the station to get a number and have it placed properly in array
   @Override
   public boolean equals(Object obj)
   {
        Station rhs = (Station)obj;
        return getStationNumber() == rhs.getStationNumber();
   }
    
   //  shows all cars
   public void printAllCars()
   {
        for (Uber current : cars)
        {
            System.out.println(current);
        }
   }
        
  
}
    
        
        
        
        
        
        


