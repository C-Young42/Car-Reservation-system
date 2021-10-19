import java.util.*;
/**
This is a class that represents a truck and is a subclass of commercial
 */
public class Truck extends Commercial
{
    // the attributes that the truck has
    private ArrayList<String> attributes;

    /**
     * Constructor for objects of class Truck
     */
    public Truck()
    {
        super();
        attributes = new ArrayList<String>();
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.print("attributes ");
        for(String string : attributes)
        {
            System.out.print(string + " ");
        }
        System.out.println("**************************"); // this is used to seperate the data as it can be hard to read
    }
    
    public void readData(Scanner secondScanner){
        super.readData(secondScanner);
        while(secondScanner.hasNext())
        {
            attributes.add(secondScanner.next());
        }
    }
    
}