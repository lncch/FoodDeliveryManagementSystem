package FoodDeliveryManagementSystem;

public class Driver extends Person implements Deliverable { // implemented from Deliverable Interface class
    
    // The data fields
    private int driverId;
    private String vehicleType;

    // A constructor that takes person's ID, person's name, phone number, driver's ID, and the vehicle type
    public Driver(int id, String name, String phoneNumber, int driverId, String vehicleType) {
        
        super(id, name, phoneNumber);
        this.driverId = driverId;
        this.vehicleType = vehicleType;
    }

    // Getters and setters
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    // This's a method that caculate the driver earnings based on a base fee and a per-distance charge
    public double caculateEarnings(double base, double distance) {
        return 0;
    }
}