package FoodDeliveryManagementSystem;

public abstract class Person { // Abstract Class
    
    // The data fields
    private int id;
    private String name;
    private String phoneNumber;

    // A constructor that takes person's id, person's name, and the phone number
    public Person(int id, String name, String phoneNumber) {
        
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}