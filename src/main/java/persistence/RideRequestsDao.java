package persistence;

import entity.RideRequest;
import entity.Rides;

import java.util.*;

public class RideRequestsDao {

    public static int rideRequestId = 0;

    Map<Integer, RideRequest> rideRequests = new HashMap<>();
    Map<Integer, List<RideRequest>> rideRequestsByRideId = new HashMap<>();


    public int createARideRequest(RideRequest rideRequest) {
        rideRequest.setId(rideRequestId++);
        rideRequests.put(rideRequestId, rideRequest);

        if (rideRequestsByRideId.containsKey(rideRequest.getRideId())) {
            List<RideRequest> listOfRideRequest = rideRequestsByRideId.get(rideRequest.getRideId());
            listOfRideRequest.add(rideRequest);
            rideRequestsByRideId.put(rideRequest.getRideId(), listOfRideRequest);
        } else {
            List<RideRequest> listOfRideRequest = new ArrayList<>();
            listOfRideRequest.add(rideRequest);
            rideRequestsByRideId.put(rideRequest.getRideId(), listOfRideRequest);
        }

        return rideRequest.getId();
    }


}
