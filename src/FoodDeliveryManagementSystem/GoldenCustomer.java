package FoodDeliveryManagementSystem;

public class GoldenCustomer extends Customer {
    
    // The data fields
    private double monthlySubscriptionFee;
    private double discountRate;
    
    // A constructor that takes person's ID, person's name, person's phone number, monthly subscription Fee, and his discount rate
    public GoldenCustomer(int id, String name, String phoneNumber, double monthlySubscriptionFee, double discountRate) {
        
        super(id, name, phoneNumber);
        this.monthlySubscriptionFee = monthlySubscriptionFee;
        this.discountRate = discountRate;
    }
    
    // Getters and setters
    public double getMonthlySubscriptionFee() {
        return monthlySubscriptionFee;
    }

    public void setMonthlySubscriptionFee(double monthlySubscriptionFee) {
        this.monthlySubscriptionFee = monthlySubscriptionFee;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}