package endpoints;

import entity.RideRequest;
import entity.Rides;
import enums.Location;
import enums.Status;
import persistence.RideRequestsDao;
import persistence.RidesDao;

import java.util.Date;
import java.util.List;

public class RideEndpoint {

    RidesDao ridesDao = new RidesDao();
    RideRequestsDao rideRequestsDao = new RideRequestsDao();

    public Rides createARide(int vehicleId, int userId, int space, Location startLocation, Location endLocation, Date dateTime ) {

        Rides ride = new Rides();
        ride.setVehicleId(vehicleId);
        ride.setUserId(userId);
        ride.setSpace(space);
        ride.setStartLocation(startLocation);
        ride.setEndLocation(endLocation);
        ride.setStatus(Status.CREATED);
        ride.setDateTime(dateTime);

        int id = ridesDao.createARide(ride);

        return ridesDao.getARide(id);

    }


    public List<Rides> getRideByDate(Date dateTime, Location startLocation, Location endLocation) {
        return ridesDao.getRidesByDateTime(dateTime, startLocation, endLocation);
    }

    public void createRideRequest(int rideId, int userId, int space) {
        RideRequest rideRequest = new RideRequest();
        rideRequest.setRideId(rideId);
        rideRequest.setUserId(userId);
        rideRequest.setSpace(space);

        rideRequestsDao.createARideRequest(rideRequest);
    }
}
