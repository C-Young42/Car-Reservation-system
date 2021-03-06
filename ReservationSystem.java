import java.awt.*;
import java.util.*;
import java.io.*; 
/**
 * Write a description of class ReservationSystem here.
 */
public class ReservationSystem
{


    private Map<String, Vehicle> vehicleMap;
    
    private Map<String, Customer> customerMap;
    
    private Map<String, VehicleReservation> reservationMap;
    
    private boolean firstCallToGenerateReservationNo;
    private int lastReservationNumber;
    private String lastNumberGeneratedFileName ;
     
    /**
     * Constructor for objects of class ReservationSystem
     */
    public ReservationSystem()
    {
        vehicleMap = new HashMap<String, Vehicle>();
        
        customerMap = new HashMap<String, Customer>();
        
        reservationMap = new HashMap<String, VehicleReservation>();
        
        firstCallToGenerateReservationNo = true;
        lastReservationNumber = 0;
        lastNumberGeneratedFileName  = "LastNumberGenerated.txt" ;
    }
    // adds vehicles to the vehicle list
    public void addVehicle(Vehicle vehicle)
    {
        vehicleMap.put(vehicle.getVehichleID(), vehicle);
    }
    //add vehicle reservation to the list
    public void addVehicleReservation(VehicleReservation vehiclereservation)
    {
        reservationMap.put(vehiclereservation.getReservationNo(), vehiclereservation);
    }
    //generate reservation number
    public String generateReservationNumber()
    {
        File reservationFile = new File(lastNumberGeneratedFileName );
        String number = "";
        if(firstCallToGenerateReservationNo == true && reservationFile.exists())
        {
            Scanner scanner = null;
            try 
            {
                scanner = new Scanner(reservationFile);
            }
            catch(FileNotFoundException exception){}
            
            firstCallToGenerateReservationNo = false;
            if(scanner.hasNextInt())
            {
                lastReservationNumber = scanner.nextInt();
            }
        }
        else
        {
            PrintWriter pWriter = null;
            try
            {
                pWriter = new PrintWriter(reservationFile);
            }
            catch(FileNotFoundException exception){}
            
            number = "000" + lastReservationNumber;
            lastReservationNumber++;
            pWriter.println(lastReservationNumber);
        }
        return number;
    }
    // shows all the vehicles in the vehcile list 
    public void showAllVehicles()
    {
        ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>(vehicleMap.values());
        if(vehicleList.isEmpty()){
            System.out.println("No Vehicles Stored");
        }
        else{
            for(Vehicle vehicle : vehicleList){
                vehicle.printDetails();
            }
        }
    }
    // reads data from a given file about vehicles and stores them in the vehhicle list
    public void readVehicleData()
    {
        Frame myFrame = null;
        FileDialog fileBox = new FileDialog(myFrame, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);

        String filename = fileBox.getFile();
        File vehicleData = new File(filename);
        Scanner scanner = null; 
        try 
        {
            scanner = new Scanner(vehicleData);
        }
        catch(FileNotFoundException exception){}

        if(scanner != null)
        {
            String typeOfData = " ";

            while( scanner.hasNext() )
            {
                String lineOfText = scanner.nextLine();
                if(lineOfText.length() == 0 || lineOfText.startsWith("//"))
                {
                    continue;
                }   
                else if( lineOfText.startsWith("["))
                {
                    lineOfText = lineOfText.toLowerCase();
                    if (lineOfText.contains("car"))
                    {
                        typeOfData = "car";
                    }
                    else if (lineOfText.contains("van"))
                    {
                        typeOfData = "van";
                    }
                    else if (lineOfText.contains("truck"))
                    {
                        typeOfData = "truck";
                    }

                }

                else
                {
                    Scanner secondScanner = new Scanner(lineOfText);

                    Vehicle newVehicle = null;

                    if(typeOfData.equals("car"))
                    {
                        newVehicle = new Car();
                    }
                    else if(typeOfData.equals("van"))
                    {
                        newVehicle = new Van();
                    }
                    else if(typeOfData.equals("truck"))
                    {
                        newVehicle = new Truck();
                    }

                    secondScanner.useDelimiter("[ ]*,[ ]*"); 
                    newVehicle.readData(secondScanner);
                    addVehicle(newVehicle);

                }

            }
            scanner.close();
        }

    }
    // adds the customer to the customer list
    public void addCustomer(Customer customer)
    {
        if(customer.getCustomerId().equals("unknown"))
        {
            String newID = generateCustomerID("FL", 10);
            customer.setID(newID);
        }
        customerMap.put(customer.getCustomerId(), customer);
    }
    // prints all the customers data
    public void printCustomerData()
    {
        ArrayList<Customer> customerList = new ArrayList<Customer>(customerMap.values());
        if(customerList.isEmpty()){
            System.out.println("No customers");
        }
        else{
            for(Customer customer : customerList)
            {
                customer.printDetails();
            }
        }
    }
    // generate a random customer id
    public String generateCustomerID(String letters, int digits)
    {
        Random random = new Random();
        int[] numbers = new int[digits];
        for(int i = 0; i < digits; i++)
        {
            numbers[i] = random.nextInt(10);
        }
        
        return letters + numbers.toString();
    }
    // reads all the customers data 
    public void readCustomerData()
    {
        Frame myFrame = null;
        FileDialog fileBox = new FileDialog(myFrame, "Open", FileDialog.LOAD);
        fileBox.setVisible(true);

        String filename = fileBox.getFile();
        File customerData = new File(filename);

        Scanner scanner = null;
        try 
        {
            scanner = new Scanner(customerData);
        }
        catch(FileNotFoundException exception){}

        if(scanner != null)
        {
            while( scanner.hasNext() )
            {

                String lineOfText = scanner.nextLine();
                if(lineOfText.length() == 0 || lineOfText.startsWith("//"))
                {
                    continue;
                }
                else
                {
                    Scanner secondScanner = new Scanner(lineOfText);
                    Customer newCustomer = new Customer();

                    secondScanner.useDelimiter("[ ]*,[ ]*"); 
                    newCustomer.readData(secondScanner);
                    addCustomer(newCustomer);
                }
            }
            scanner.close();
        }
    }
    // writes the customer data to a txt file
    public void writeCustomerData()
    {
        Frame myFrame = null;
        FileDialog fileBox = new FileDialog(myFrame, "Save", FileDialog.SAVE);
        fileBox.setVisible(true);

        File customerFile = new File(fileBox.getFile());
        PrintWriter pWriter = null;
        try 
        {
            pWriter = new PrintWriter(customerFile);
        }
        catch(FileNotFoundException exception){}

        ArrayList<Customer> customerList = new ArrayList<Customer>(customerMap.values());
        if(pWriter != null)
        {
            for(Customer customer : customerList)
            {
                customer.writeCustomerData(pWriter);
            }
            pWriter.close();
        }
    }

}  

