import java.io.*;
import java.util.*;
/**
 * This is a class that represents a commercial vehicle and is a subclass of vehicle
 */
public abstract class Commercial extends Vehicle
{
    // the payload the vehicle can carry
    private int payLoad;

    /**
     * Constructor for objects of class Commercial
     */
    public Commercial()
    {
        
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.println("payload " + payLoad);
    }
    
    public void readData(Scanner secondScanner)
    {
        super.readData(secondScanner);
        payLoad = secondScanner.nextInt();
    }

}