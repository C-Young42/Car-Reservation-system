import java.util.*;
/**
 * Write a description of class VehicleReservation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VehicleReservation
{
    String reservationNo;
    String vehID;
    String customerID;
    Date startDate;
    int noOfDays;
    
    public VehicleReservation(String reservationNo, String vehID, String customerID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.vehID = vehID;
        this.customerID = customerID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }
    
    public String getReservationNo()
    {
        return reservationNo;
    }
    public String getvehID()
    {
        return vehID;
    }
    public String getCustomerID()
    {
        return customerID;
    }
    public Date getDate()
    {
        return startDate;
    }
    public int getDays()
    {
        return noOfDays;
    }
}
