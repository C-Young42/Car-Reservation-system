import java.awt.*;
import java.util.*;
import java.io.*;
/**
 * This is a class that represents a car and is a subclass of vehicle
 */
public class Car extends Vehicle
{
    // the number of doors the car has
    private int noOfDoors;
    // the number of seats the car has
    private int noOfSeats;
    // the type of body the car has
    private String bodyType;

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        super();
    }
    // prints all the details of the car
    public void printDetails()
    {
        super.printDetails();
        System.out.println("number of doors " + noOfDoors + " number of seats " + noOfSeats);
        System.out.println("body type" + bodyType);
        System.out.println("**************************"); // this is used to seperate the data as it can be hard to read
    }
    // reads the data for the cars
    public void readData(Scanner secondScanner)
    { 
        super.readData(secondScanner);
        bodyType = secondScanner.next();    
        noOfDoors =  secondScanner.nextInt();    
        noOfSeats =  secondScanner.nextInt();    
    }
}
