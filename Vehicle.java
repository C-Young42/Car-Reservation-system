import java.awt.*;
import java.util.*;
import java.io.*;
/**
 * This is a class that represents a vehicle
 *
 */
public abstract class Vehicle
{
    // the group the car is assigned too - determines the cost of the car
    private String group;
    //the unique vichile id number 
    private String vehId;
    // the reg number of the car
    private String regNo;
    // the make of the vehicle
    private String make;
    // the modle of the car
    private String model;
    // if the car has aircon or not 
    private boolean aircon;
    // the engine size
    private double engine;
    // the fuel type
    private String fuelType;
    // the gearbox the car has
    private String gearBox;
    // the transmission the car has
    private String transmission;
    // the miles the car has driven
    private int mileage;
    // the data the car was first registered
    private String dateFirstRegistered;

    private ReservationSystem reservationSystem;

    //No parameter constructor for objects of class Vehicle
    public Vehicle()
    {
        
    }

    //  prints the cars details
    public void printDetails()
    {
        System.out.println(make + " " +  model + "\t" + "\t" + "\t" + "group " + group + " vehicle id " + vehId);
        System.out.println("air con/climate control " + aircon);
        System.out.println("engine size " + engine + " fuel " + fuelType);
        System.out.println("gearbox" + gearBox + " transmission " + transmission);
        System.out.println("mileage " + mileage + " dateFirstRegistered " + dateFirstRegistered);
    }
    // returns the group the vehicle is in          
    public String getGroup()
    {
        return group;
    }
    // returns the vehicle id 
    public String getVehichleID()
    {
        return vehId;
    }
    // returns the vehicle reg number
    public String getRegNumber()
    {
        return regNo;
    }
    // returns the make of the vehicle
    public String getMake()
    {
        return make;
    }
    // reads data from the scanner and creates a vehicle object which is then stored in vehicle list
    public void readData(Scanner secondScanner)
    { 
        group = secondScanner.next(); 
        vehId = secondScanner.next();    
        regNo = secondScanner.next();      
        model =  secondScanner.next();  
        make =  secondScanner.next();              
        String airC = secondScanner.next();
        if(airC.equalsIgnoreCase("yes"))
        {
            aircon = true;
        }
        else
        {
            aircon = false;
        }
        engine =  secondScanner.nextDouble();   
        fuelType =  secondScanner.next();    
        gearBox =  secondScanner.next();     
        transmission =  secondScanner.next();   
        mileage =  secondScanner.nextInt();    
        dateFirstRegistered =  secondScanner.next();    

    }
}