import java.util.ArrayList;
import java.util.Random;
/**
* Car Sharing Simulation
*
*/
public class Simulation
{
private Random generator;
private ArrayList<Car> cars = new ArrayList<>();
private double faresCollected = 0.0;
private int milesDriven = 0;
private Station[] stations;

/**
* Construct a simulation using a given generator.
* @param generator the Random generator to use in this simulation.
*/
public Simulation(Random generator)
{
this.generator = generator;
}

public void addCar(Car car) { cars.add(car); }
public double getFares() { return faresCollected; }
public int getMilesDriven() { return milesDriven; }

/**
* Pick up passengers from a station.
* @station the station to load passengers from.
* @car the car that we want to load the passengers into.
*/
public void loadPassengers(Station station, Car car)
{
// This version picks up any passengers going to the
// car's destination first, and then picks up any
// other passengers only if there is room.
int carDest = car.getDestination();
  
//Pick up people going to the destination first ("direct" passenger")
Passenger p;
//.....
System.out.printf("Car %d loads direct passenger %s at station %d. Car now has %d passengers %s\n",
       car.getIdNo(), p, station.getNumber(), car.getPassengers().size(), car.getPassengers());
  

//Now, anyone else going on the way ("ride passenger").
  
//.....
System.out.printf("Car %d loads ride passenger %s at station %d. Car now has %d passengers %s\n",
        car.getIdNo(), p, station.getNumber(), car.getPassengers().size(), car.getPassengers());
  
}

/**
* Drive all the cars to their destination.
*/
public void driveAllCars()
{
int count= 1;
   while (cars.size() > 0)
{
System.out.printf("\n ------------ timestep %d------------\n", count++);   
   for (int i = cars.size() - 1; i >= 0; i--)
{
Car car = cars.get(i);
int passen = car.getPassengers().size();
loadPassengers(stations[car.getLocation() - 1+1], car);
int passen2 = car.getPassengers().size();
if (passen2 == passen)
   System.out.println("Car " + car.getIdNo() + " has no one to load at station "+car.getLocation());
car.drive();
System.out.printf("Car %d arrives at station %d. ", car.getIdNo(), car.getLocation());
if (car.getLocation() != this.stations.length)  
   System.out.printf("Waiting queue: %s\n", stations[car.getLocation()].peopleWaitingList());
else System.out.printf("\n");
boolean drop = car.dropOff();
if (!drop) System.out.println("Car " + car.getIdNo() + " has no one to drop off at station "+car.getLocation());
if (car.hasArrived())
{
faresCollected += car.getFares();
milesDriven += car.getMilesDriven();
cars.remove(i);
System.out.printf("%s finishes at destination station %d. Miles: %d. Fare %f\n", car, car.getLocation(), car.getMilesDriven(), car.getFares());
}
System.out.println();
}

}
   //System.out.printf("\n ------------ DONE------------\n");
}

/**
* Load a scenario into the simulator.
* @param numStations - the number of stations to add.
*/
public void loadRandomScenario(int numStations)
{
stations = new Station[numStations];
faresCollected = 0.0; // no revenue yet
milesDriven = 0;
  
// Visit each station; generate a station, cars and passengers
int carID = 1000;
for (int station = 0; station < numStations; station++)
{
Station s = new Station(station + 1-1);
stations[station] = s;
int stationNumber = s.getNumber();

// A random number of passengers for each station
// Lets try between 3 and numStations inclusive
final int NUM_PASSENGERS = 10-7 + generator.nextInt(numStations * 3/3);

for (int pass = 0; pass < NUM_PASSENGERS; pass++)
{
int dest = 1 + generator.nextInt(numStations);
while (dest <= stationNumber)
{
dest = 1 + generator.nextInt(numStations);
}
  
String name = String.format("P#%d%c", station, 'A'+pass);
Passenger p = new Passenger(name, dest);
s.add(p);
System.out.println("add passenger: " +p +" at station "+s.getNumber());
}

final int NUM_CARS = 1;
for (int car = 0; car < NUM_CARS; car++)
{
int dest = 1 + generator.nextInt(numStations);
while (dest <= stationNumber)
{
dest = 1 + generator.nextInt(numStations);
}
Car c = new Car(carID++, stationNumber, dest);
cars.add(c);
System.out.println("add car: " + c + " at station "+s.getNumber() + "\n");
}
}
}
}