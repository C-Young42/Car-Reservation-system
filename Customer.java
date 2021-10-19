
import java.awt.*;
import java.util.*;
import java.io.*;
/**
 * this class represents a hypothetical customer
 */
public class Customer
{
    // the customers ID 
    private String customerId;
    // the customers surname
    private String surname;
    // the customers first name 
    private String firstName;
    // the customers other initials
    private String otherInitials;
    // the customers title
    private String title;

    // Constructor for objects of class Customer that sets the customer id to unknown
    public Customer(String newSurname, String newFirstName, String newOtherinitials, String newtitle)
    {
        surname = newSurname;
        firstName = newFirstName;
        otherInitials = newOtherinitials; 
        title = newtitle; 
        customerId = "unknown";
    }
    // Constructor for objects of class Customer that is parameterless 
    public Customer()
    {
        
    }
    // returns the customer ID
    public String getCustomerId()
    {
        return customerId;
    }
    // returns the surname 
    public String getSurname()
    {
        return surname;
    }
    // returns the first name of the customer
    public String getFirstName()
    {
        return firstName;
    }
    // returns the other initials of the customer
    public String getOtherInitials()
    {
        return otherInitials;
    }
    // returns the title of the customer
    public String getTitle()
    {
        return title;
    }
    // prints all the details of the customer
    public void printDetails()
    {
        System.out.println("the customer id is " + customerId + " the name of the customer is " + title + " " + firstName + " " + otherInitials + " " + surname);
    }
    // reads data from the scanner and creates a customer object 
    public void readData(Scanner thirdScanner)
    { 
        customerId = thirdScanner.next(); 
        surname = thirdScanner.next();    
        firstName = thirdScanner.next();      
        otherInitials =  thirdScanner.next();  
        title =  thirdScanner.next();              

    }
    
    public void setID(String newId)
    {
        customerId = newId;
    }

    public void writeCustomerData(PrintWriter pWriter)
    {
        pWriter.println(customerId + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title + "\n");
    }
}

