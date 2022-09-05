package persistence;

import entity.Rides;
import enums.Location;

import java.util.*;

public class RidesDao {

    public static int ride_id = 0;

    Map<Integer, Rides> rides = new HashMap<>();
    Map<String, List<Rides>> locationBaseRides = new HashMap<>();

    public int createARide(Rides ride) {
      ride.setId(ride_id);
      rides.put(ride_id, ride);
      String startEndLocation = ride.getStartLocation().toString() + ride.getEndLocation().toString();

      if (locationBaseRides.containsKey(startEndLocation)) {
          List<Rides> rides = locationBaseRides.get(startEndLocation);
          rides.add(ride);
          locationBaseRides.put(startEndLocation, rides);
      } else {
         List<Rides> rides = new ArrayList<>();
         rides.add(ride);
         locationBaseRides.put(startEndLocation, rides);
      }

      ride_id++;
      return ride.getId();
    }

    public Rides getARide(int ride_id) {
        return rides.get(ride_id);
    }

    public List<Rides> getRidesByDateTime(Date date, Location startLocation, Location endLocation) {

        List<Rides> rides = locationBaseRides.get(startLocation.toString() + endLocation.toString());

        List<Rides> matchedRides = new ArrayList<>();

        for (Rides ride : rides) {
            if (ride.getDateTime().equals(date))
            matchedRides.add(ride);
        }

        return matchedRides;
    }

}
