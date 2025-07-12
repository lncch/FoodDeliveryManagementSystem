package FoodDeliveryManagementSystem;

public abstract class Customer extends Person { // Abstract Class
    
    // A constructor that takes person's ID, person's name, and the phone number
    public Customer(int id, String name, String phoneNumber) {
        
        super(id, name, phoneNumber); // inherited from Person Class
    }
}