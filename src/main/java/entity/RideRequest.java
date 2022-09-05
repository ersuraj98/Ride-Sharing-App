package entity;

public class RideRequest {

    private int id;
    private int userId;
    private int rideId;
    private int space;


    public RideRequest() {
    }

    public RideRequest(int id, int userId, int rideId, int space) {
        this.id = id;
        this.userId = userId;
        this.rideId = rideId;
        this.space = space;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    @Override
    public String toString() {
        return "RideRequest{" +
                "id=" + id +
                ", userId=" + userId +
                ", rideId=" + rideId +
                ", space=" + space +
                '}';
    }
}

