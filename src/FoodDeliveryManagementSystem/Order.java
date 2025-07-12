package FoodDeliveryManagementSystem;

import java.util.*;

public class Order {
    
    // The data fields
    private int orderId;
    private Customer customer;
    private Restaurant restaurant;
    private ArrayList<String> foodItem = new ArrayList<>();
    private double deliveryCost;
    private Deliverable deliverer;
    
    // A constructor that takes order ID, the customer, and the restaurant he ordered from
    public Order(int orderId, Customer customer, Restaurant restaurant) {
        
        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
    }
    
    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ArrayList<String> getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(ArrayList<String> foodItem) {
        this.foodItem = foodItem;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Deliverable getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Deliverable deliverer) {
        this.deliverer = deliverer;
    }
    
    // This's a method to add the food that the customer ordered
    public void addFoodItems(String items) {
        foodItem.add(items);
    }
}