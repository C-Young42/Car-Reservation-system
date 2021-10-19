import java.util.*;
import java.io.*;
/**
 *This is a class that represents a van and is a subclass of commercial
 */
public class Van extends Commercial
{
    // the volume of the van
    private double loadVolume;
    // if the van has a sliding door or not
    private boolean slidingDoor;


    // Constructor for objects of class Van
    public Van()
    {
        super();
    }

    public void printDetails()
    {
        super.printDetails();
        System.out.println("load volume " + loadVolume + "sliding door? " + slidingDoor);
        System.out.println("**************************"); // this is used to seperate the data as it can be hard to read
    }
    
    public void readData(Scanner secondScanner)
    {
        super.readData(secondScanner);
        loadVolume = secondScanner.nextDouble();
        if(secondScanner.next().contains("yes"))
        {
            slidingDoor = true;
        }
        else
        {
            slidingDoor = false;
        }
    }
}