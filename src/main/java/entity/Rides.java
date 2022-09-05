package entity;

import enums.Location;
import enums.Status;

import java.util.Date;

public class Rides {

    private int id;
    private int userId;
    private int space;
    private int vehicleId;
    private Location startLocation;
    private Location endLocation;
    private Date dateTime;
    private Status status;

    public Rides() {
    }

    public Rides(int id, int userId, int space, int vehicleId, Location startLocation, Location endLocation, Date dateTime, Status status) {
        this.id = id;
        this.userId = userId;
        this.space = space;
        this.vehicleId = vehicleId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.dateTime = dateTime;
        this.status = status;
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

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rides{" +
                "id=" + id +
                ", userId=" + userId +
                ", space=" + space +
                ", vehicleId=" + vehicleId +
                ", startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                ", dateTime=" + dateTime +
                ", status=" + status +
                '}';
    }
}
