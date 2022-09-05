package entity;

public class Vehicle {

    public int id;
    public String type;
    public String name;
    public String totalSpace;

    public Vehicle(int id, String type, String name, String totalSpace) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.totalSpace = totalSpace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(String totalSpace) {
        this.totalSpace = totalSpace;
    }
}
