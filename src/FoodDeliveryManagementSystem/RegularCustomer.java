package FoodDeliveryManagementSystem;

public class RegularCustomer extends Customer {
    
    // A constructor that takes person's ID, person's name, and the phone number
    public RegularCustomer(int id, String name, String phoneNumber) {
        
        super(id, name, phoneNumber); // inherited from Customer Class
    }
}