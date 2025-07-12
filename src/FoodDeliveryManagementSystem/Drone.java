package FoodDeliveryManagementSystem;

public class Drone implements Deliverable { // implemented from Deliverable Interface class
    
    // The data fields
    private int droneId;
    private double maxPayLoad;
    private int batteryLevel;

    // A constructor that takes drone's ID, max pay load, and the battery level of that drone
    public Drone(int droneId, double maxPayLoad, int batteryLevel) {
        
        this.droneId = droneId;
        this.maxPayLoad = maxPayLoad;
        this.batteryLevel = batteryLevel;
    }
    
    //Getters and setters
    public int getDroneId() {
        return droneId;
    }

    public void setDroneId(int droneId) {
        this.droneId = droneId;
    }

    public double getMaxPayLoad() {
        return maxPayLoad;
    }

    public void setMaxPayLoad(double maxPayLoad) {
        this.maxPayLoad = maxPayLoad;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}