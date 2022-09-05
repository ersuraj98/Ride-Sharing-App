import endpoints.RideEndpoint;
import entity.Rides;
import enums.Location;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/*
@author Suraj Kumar Jha (surajjha1998@gmail.com)
@version v1

Interviewer : Sohitpal Singh ( sohitpal.singh@clear.in )
*/
public class RideShare {

    public static void main(String[] args) throws ParseException {
        RideEndpoint rideEndpoint = new RideEndpoint();

        // Creating rides
        rideEndpoint.createARide(1700, 1998, 3, Location.DELHI, Location.GURUGRAM, getDate());
        rideEndpoint.createARide(1701, 1999, 3, Location.DELHI, Location.FARIDABAD, getDate());
        rideEndpoint.createARide(1702, 2000, 3, Location.FARIDABAD, Location.NOIDA, getDate());
        rideEndpoint.createARide(1703, 2001, 3, Location.GHAZIABAD, Location.GURUGRAM, getDate());
        rideEndpoint.createARide(1704, 1997, 3, Location.DELHI, Location.GURUGRAM, getDate());
        rideEndpoint.createARide(1705, 2001, 3, Location.FARIDABAD, Location.NOIDA, getDate());

        // Getting rides by date and location
        List<Rides> rides = rideEndpoint.getRideByDate(getDate(), Location.DELHI, Location.GURUGRAM);
        printRide(rides);

        rides = rideEndpoint.getRideByDate(getDate(), Location.DELHI, Location.FARIDABAD);
        printRide(rides);

        rides = rideEndpoint.getRideByDate(getDate(), Location.FARIDABAD, Location.NOIDA);
        printRide(rides);


    }

    public static void printRide(List<Rides> rides) {
        for (Rides ride : rides) {
            System.out.println(ride);
        }
    }

    public static Date getDate() throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        return formatter.parse(formatter.format(today));

    }
}
