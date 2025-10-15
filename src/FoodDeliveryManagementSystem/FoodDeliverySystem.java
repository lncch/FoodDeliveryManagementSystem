package FoodDeliveryManagementSystem;

import java.util.*;
import java.math.*;

public class FoodDeliverySystem {
    
    // The data fields
    private ArrayList<Person> persons;
    private ArrayList<Deliverable> deliverers ;
    private ArrayList<Restaurant> restaurants ;
    private ArrayList<Order> orders ;
    private int orderCounter;

    public class FoodDeliverySystem {
        // list of all persons (customers and drivers)
        private ArrayList<Person> persons;
        // list of all deliverable entities (drivers and drones)
        private ArrayList<Deliverable> deliverers;
        // list of restaurants in the system
        private ArrayList<Restaurant> restaurants;
        // list of all orders placed
        private ArrayList<Order> orders;

        // initialize all collections
        public FoodDeliverySystem() {
            this.persons      = new ArrayList<>();
            this.deliverers   = new ArrayList<>();
            this.restaurants  = new ArrayList<>();
            this.orders       = new ArrayList<>();
        }
    // An empty constructor
    public FoodDeliverySystem(
            this.
    ) {
    }
    
    // This method add the regular customer to the persons's arrayList
    public String addRegularCustomer(int id, String name, String phoneNumber) {
        
        RegularCustomer regularCustomer = new RegularCustomer(id, name, phoneNumber);
        persons.add(regularCustomer);
        
        // The display message
        return "Regular Customer " + name + " added successfully.";
    }
    
    // This method add the golden customer to the persons's arrayList
    public String addGoldenCustomer(int id, String name, String phoneNumber, double monthlyFee, double discountRate) {
        
        GoldenCustomer goldenCustomer = new GoldenCustomer(id, name, phoneNumber, monthlyFee, discountRate);
        persons.add(goldenCustomer);
        
        // The display message
        return "Golden Customer " + name + " added successfully.";
    }

    // This method add the driver to the persons's and deliverers arrayList 
    public String addDriver(int id, String name, String phoneNumber, int driverId, String vehicleType) {
        
        Driver driver = new Driver(id, name, phoneNumber, driverId, vehicleType);
        persons.add(driver);
        deliverers.add(driver);
        
        // The display message
        return "Driver " + name + " added successfully.";
    }

    // This method add the drone to the deliverers arrayList 
    public String addDrone(int droneId, double maxPayload, int batteryLevel) {
        
        Drone drone = new Drone(droneId, maxPayload, batteryLevel);
        deliverers.add(drone);
        
        // The display message
        return "Drone " + droneId + " added successfully.";
    }
    
    // This method add the restaurant to the restaurants's arrayList 
    public String addRestaurant(int restaurantId, String name, String address) {
        
        Restaurant restaurant = new Restaurant(restaurantId, name, address);
        restaurants.add(restaurant);
        
        // The display message
        return "Restaurant " + name + " added successfully.";
    }
    
    // This method add the food into the restaurant's menu
    public String addMenuItem(int restaurantId, String menuItem) {
        
        StringBuilder menu = new StringBuilder();
        
        for (Restaurant restaurant : restaurants) {
            
            if (restaurant.getRestaurantId() == restaurantId) {
                
                // Check if the restaurant is in the list
                if (restaurant == null) { 
                    return "Restaurant ID " + restaurantId + " not found";
                }
                
                String[] items = menuItem.split("#");
                
                for (String item : items) {
                    restaurant.addMenuItems(item);
                    menu.append("Menu item '").append(item);
                    menu.append("' added to restaurant ").append(restaurant.getName());
                    menu.append("\n");
                }
            }
        }
        
        // The display message
        return menu.toString(); 
    }

    // This method to create an order 
    public String createOrder(Customer customer, int restaurantId, String[] items, double deliveryCost) {
        
        Customer customerId = getCustomerById(customer.getId());
        
        // Checks if the customer is in the list
        if (customerId == null) {
            return "Customer ID " + customerId + " not found.";
        }
        
        Restaurant restaurant = null;
        
        for (Restaurant foundRestaurant : restaurants) {
            
            if (foundRestaurant.getRestaurantId() == restaurantId) {
                
                // Checks if the restauran is in the list
                if (foundRestaurant == null) { 
                    return "Restaurant ID " + restaurantId + " not found.";
                } 
                
                else {
                    restaurant = foundRestaurant;
                }
            }
        }
        Order order = new Order(orderCounter, customer, restaurant);
        
        for (String str : items) {
            String[] food = str.split("#");
            
            for (String item : food) {
                order.addFoodItems(item);
            }
        }
        
        order.setDeliveryCost(deliveryCost);
        orders.add(order);
        int orderCount = orderCounter;
        orderCounter++;
        
        // The display message
        return "Order " + orderCount + " created successfully for " + customer.getName(); 
    }
    
    // This method to assign the deliverer to the order
    public String assignDeliverer(int orderId, Deliverable deliverer) {
        Order order = null;

        for (Order foundOrder : orders) {
            if (foundOrder.getOrderId() == orderId) {
                order = foundOrder;
                break;
            }
        }

        // Checks if the order is in the list
        if (order == null) { 
            return "Order ID " + orderId + " not found.";
        }

        // Checks if the deliverer is in the list
        if (deliverer == null) { 
            return "Deliverer is null.";
        }

        order.setDeliverer(deliverer); 
        
        if (deliverer instanceof Driver) {
            Driver driver = (Driver) deliverer;
            
            // The driver display message
            return "Driver " + driver.getName() + " assigned to Order " + orderId;
        } 
        
        else if (deliverer instanceof Drone) {
            Drone drone = (Drone) deliverer;
            
            // The drone display message
            return "Drone " + drone.getDroneId() + " assigned to Order " + orderId;
        }
        
        // This display message appears if there is no deliverer
        return "Unknown deliverer assigned to Order " + orderId;
    }
    
    // This method to display the order by the deliverer
    public String printOrdersByDeliverer(Deliverable deliverer) {
        
        StringBuilder str = new StringBuilder();
        String name = "";
        int delivererId = 0;
        double total = 0.0;
        
        // Checks if the deliverer is in the list
        if (deliverer == null) { 
            return "Deliverer ID " + deliverer + " not found.";
        }

        if (deliverer instanceof Driver) {
            
            Driver driver = (Driver) deliverer;
            name = "Driver " + driver.getName();
            delivererId = driver.getDriverId();
        } 
        
        else if (deliverer instanceof Drone) {
            
            Drone drone = (Drone) deliverer;
            name = "Drone";
            delivererId = drone.getDroneId();
        }
        
        str.append("-----Orders delivered by ").append(name);
        str.append(" (ID: ").append(delivererId);
        str.append(")--------");
        str.append("\n");
        
        for (Order order : orders) {
            
            if (order.getDeliverer() != null) {
                Deliverable assigned = order.getDeliverer();
                int assignedId = 0;
                
                // Checks which deliverer will deliver the order 
                if (assigned instanceof Driver) { 
                    assignedId = ((Driver) assigned).getDriverId();
                } 
                
                else if (assigned instanceof Drone) { 
                    assignedId = ((Drone) assigned).getDroneId();
                }
                
                if (assignedId == delivererId) {
                    
                    Customer customer = order.getCustomer();
                    double baseCost = order.getDeliveryCost();
                    double discount = 0.0;
                    
                    // Checks if the customer is a golden customer to apply the discount
                    if (customer instanceof GoldenCustomer) { 
                        discount = ((GoldenCustomer) customer).getDiscountRate();
                    }
                    
                    double Cost = baseCost * (1 - discount);
                    total += Cost;
                    
                    // The display message
                    str.append("===============================================================");
                    str.append("\n");
                    str.append(String.format("%-11s%-16s%-21s%-15s", "Order ID", "Customer", "Restaurant", "Delivery Cost"));
                    str.append("\n");
                    str.append(String.format("%-11d%-16s%-21s%-15.2f", order.getOrderId(), order.getCustomer().getName(), order.getRestaurant().getName(), total));
                    str.append("\n");
                    str.append("-----------------------------Items---------------------------");
                    str.append("\n");
                    
                    int count = 1;
                    
                    for (String item : order.getFoodItem()) {
                        str.append(count).append("-").append(item);
                        str.append("\n");
                        count++;
                    }
                    
                    str.append("==============================End==============================");
                    str.append("\n");
                    total = 0.0;
                }
            }
        }
        
        // The display message
        return str.toString(); 
    }
    
    // This method to calculate the total cost for deliverer that will take it from the customer
    public String getTotalCostByDeliverer(int delivererId) {
        
        Deliverable deliverer = getDelivererById(delivererId);
        double total = 0.0;
        
        for (Order order : orders) {
            
            Deliverable assigned = order.getDeliverer();
            if (assigned != null) {
                int assignedId = -1;
                
                // Checks which deliverer will deliver the order 
                if (assigned instanceof Driver) { 
                    assignedId = ((Driver) assigned).getDriverId();
                } 
                
                else if (assigned instanceof Drone) { 
                    assignedId = ((Drone) assigned).getDroneId();
                }

                if (assignedId == delivererId) {
                    Customer customer = order.getCustomer();
                    double baseCost = order.getDeliveryCost();
                    double discount = 0.0;
                    
                    // Checks if the customer is a golden customer to apply the discount
                    if (customer instanceof GoldenCustomer) { 
                        discount = ((GoldenCustomer) customer).getDiscountRate();
                    }
                    
                    double Cost = baseCost * (1 - discount);
                    total += Cost;
                }
            }
        }
        
        // Round the total to two decimals
        StringBuilder earn = new StringBuilder (String.format("%.2f", total));
        String type = "";
         
        // Which deliverer is assigned to the order
        if (deliverer instanceof Driver) { 
            type = "Driver";
        } 
        
        else if (deliverer instanceof Drone) {
            type = "Drone";
        }
        
        // The display message
        return "The " + type + " with ID " + delivererId + " has earned $" + earn.toString() + " for deliveries.";
    }

    // This method to display the order by the customer
    public String printOrdersByCustomer(int customerId) {
        
        Customer customer = getCustomerById(customerId);
        StringBuilder str = new StringBuilder();
        double total = 0.0;
        
        // Checks if the customer is in the list
        if (customer == null) {
            return "Customer ID " + customerId + " not found.";
        }
        
        str.append("------------- Orders for Customer: ").append(customer.getName());
        str.append(" (ID: ").append(customerId);
        str.append(")------------");
        
        for (Order order : orders) {
            
            if (order.getCustomer().getId() == customerId) {
                
                // The display message
                str.append("\n");
                str.append("-------------------------------------------------------------");
                str.append("\n");
                str.append("Order ID      : ").append(order.getOrderId());
                str.append("\n");
                
                String customerType = (customer instanceof GoldenCustomer) ? "Golden" : "Regular";
                
                str.append("Customer Type : ").append(customerType);
                str.append("\n");
                str.append("Restaurant    : ").append(order.getRestaurant().getName());
                str.append("\n");

                double discount = 0.0;
                
                // Checks if the customer is a golden customer to apply the discount
                if (customer instanceof GoldenCustomer) {
                    discount = ((GoldenCustomer) customer).getDiscountRate();
                }
                
                double baseCost = order.getDeliveryCost();
                                
                double Cost = baseCost * (1 - discount);
                total += Cost;
                
                str.append("Discount Rate : ").append(discount);
                str.append("\n");
                str.append("Delivery Cost : ").append(String.format("%.2f", total));
                str.append("\n");
                str.append("Items:");
                str.append("\n");
                
                total = 0.0;
                int count = 1;
                
                for (String item : order.getFoodItem()) {
                    
                    str.append("   ").append(count);
                    str.append(". ").append(item);
                    str.append("\n");
                    count++;
                }
                
                if (order.getDeliverer() != null) {
                    str.append("Delivered by  : ");
                    
                    if (order.getDeliverer() instanceof Driver) {
                        
                        Driver driver = (Driver) order.getDeliverer();
                        str.append("Driver ").append(driver.getName());
                        str.append(" (ID: ").append(driver.getDriverId());
                        str.append(")");
                    } 
                    
                    else if (order.getDeliverer() instanceof Drone) {
                        
                        Drone drone = (Drone) order.getDeliverer();
                        str.append("Drone (ID: ").append(drone.getDroneId());
                        str.append(")");
                    }
                    
                    str.append("\n");
                }
                
                str.append("-------------------------------------------------------------");
            }
        }
        
        // The display message
        return str.toString();
    }

    // This method to find the customer by his ID
    public Customer getCustomerById(int customerId) {
        
        for (Person person : persons) {
            if (person instanceof Customer && person.getId() == customerId) {
                return (Customer) person;
            }
        }
        
        return null;
    }

    // This method to find the deliverer by his ID
    public Deliverable getDelivererById(int delivererId) {
        
        for (Deliverable deliverer : deliverers) {
            
            if (deliverer instanceof Driver) {
                if (((Driver) deliverer).getDriverId() == delivererId) {
                    return deliverer;
                }
            }
            
            else if (deliverer instanceof Drone) {
                if (((Drone) deliverer).getDroneId() == delivererId) {
                    return deliverer;
                }
            }
        }
        
        return null;
    }
    
    // A helper method
    public ArrayList<Person> getPersons() {
        return persons;
    }
    
    // A helper method
    public ArrayList<Deliverable> getDeliverers() {
        return deliverers;
    }
}
