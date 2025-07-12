package FoodDeliveryManagementSystem;

import java.util.*;

public class Restaurant {
    
    // The data fields
    private int restaurantId;
    private String name;
    private String address;
    private ArrayList<String> menuItems = new ArrayList<>();

    // A constructor that takes restaurant's ID, restaurant's name, and the address of that restaurant
    public Restaurant(int restaurantId, String name, String address) {
        
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
    }
    
    // Getters and setters 
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<String> menuItems) {
        this.menuItems = menuItems;
    }
    
    // This's a method to add the food into the menu of the restaurant
    public void addMenuItems(String items) {
        menuItems.add(items);
    }
}