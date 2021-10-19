import java.util.*;
import java.io.*;
/**
 * this is a test class used to test the functions of other classes
 */
public class Test
{

    public void test1()
    throws FileNotFoundException

    // this tests reading data from a file, storing it in vehicle list and then printing out the details. 
    {
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.readVehicleData();
        reservationSystem.showAllVehicles();
    }

    public void test2()
    throws FileNotFoundException

    // this tests reading data from a file, storing it in customer list and then printing out the details. 
    {
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.readCustomerData();
        reservationSystem.printCustomerData();
    }

    public void test3()
    throws FileNotFoundException

    // this tests writing the details of the customers stored in customer list to a file
    {
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.readCustomerData();
        reservationSystem.writeCustomerData();
        
        
    }
}
