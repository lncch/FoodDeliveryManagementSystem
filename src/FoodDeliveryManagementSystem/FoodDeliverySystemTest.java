/*
===============================
- Name : Abdulmajeed Bazi
- ID : 2436780
- Sec : CS1
===============================
*/

package FoodDeliveryManagementSystem;

import java.util.*;
import java.io.*;

public class FoodDeliverySystemTest {

    public static void main(String[] args) throws FileNotFoundException {
        
        FoodDeliverySystem system = new FoodDeliverySystem();
        File input = new File("input.txt");
        File output = new File("output.txt");
        
        PrintWriter write = new PrintWriter(output);
        Scanner read = new Scanner(input);
        
        // A loop that checks if there is any word to read
        while (read.hasNextLine()) {
            
            String line = read.nextLine();
            StringBuilder str = new StringBuilder("");
            
            if (line.isEmpty()) {
                continue;
            }
            
            String[] tokens = line.split(",", 2);
            String command = tokens[0];
            
            // To use the right code for the command 
            switch (command) {
                
                case "addRegularCustomer":
                    
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    String phoneNumber = parts[3];
                    str.append(system.addRegularCustomer(id, name, phoneNumber));
                    str.append("\n");
                    
                    break;
                    
                case "addGoldenCustomer":
                    
                    parts = line.split(",");
                    id = Integer.parseInt(parts[1]);
                    name = parts[2];
                    phoneNumber = parts[3];
                    double fee = Double.parseDouble(parts[4]);
                    double discountRate = Double.parseDouble(parts[5]);
                    str.append(system.addGoldenCustomer(id, name, phoneNumber, fee, discountRate));
                    str.append("\n");
                    
                    break;
                    
                case "addDriver":
                    
                    parts = line.split(",");
                    id = Integer.parseInt(parts[1]);
                    name = parts[2];
                    phoneNumber = parts[3];
                    int driverId = Integer.parseInt(parts[4]);
                    String vehicle = parts[5];
                    str.append(system.addDriver(id, name, phoneNumber, driverId, vehicle));
                    str.append("\n");
                    
                    break;
                    
                case "addDrone":
                    
                    parts = line.split(",");
                    int droneId = Integer.parseInt(parts[1]);
                    double maxPayload = Double.parseDouble(parts[2]);
                    int batteryLevel = Integer.parseInt(parts[3]);
                    str.append(system.addDrone(droneId, maxPayload, batteryLevel));
                    str.append("\n");
                    
                    break;
                    
                case "addRestaurant":
                    
                    parts = line.split(",");
                    int restaurantId = Integer.parseInt(parts[1]);
                    String restaurantName = parts[2];
                    String address = parts[3];
                    str.append(system.addRestaurant(restaurantId, restaurantName, address));
                    str.append("\n");
                    
                    break;
                    
                case "addMenuItem":
                    
                    parts = line.split(",", 3);
                    restaurantId = Integer.parseInt(parts[1]);
                    String items = parts[2];
                    str.append(system.addMenuItem(restaurantId, items));
                    
                    break;
                    
                case "createOrder":
                    
                    parts = line.split(",", 5);
                    int customerId = Integer.parseInt(parts[1]);
                    restaurantId = Integer.parseInt(parts[2]);
                    String[] foodItems = parts[3].split("#");
                    double deliveryCost = Double.parseDouble(parts[4]);
                    Customer customer = system.getCustomerById(customerId);
                    str.append(system.createOrder(customer, restaurantId, foodItems, deliveryCost));
                    str.append("\n");
                    
                    break;
                    
                case "assignDeliverer":
                    
                    parts = line.split(",");
                    int orderId = Integer.parseInt(parts[1]);
                    int delivererId = Integer.parseInt(parts[2]);
                    Deliverable deliverer = system.getDelivererById(delivererId);
                    str.append(system.assignDeliverer(orderId, deliverer));
                    str.append("\n");
                    
                    break;
                    
                case "printOrdersByDeliverer":
                    
                    parts = line.split(",");
                    delivererId = Integer.parseInt(parts[1]);
                    deliverer = system.getDelivererById(delivererId);
                    str.append(system.printOrdersByDeliverer(deliverer));
                    str.append("\n");
                    
                    break;
                    
                case "getTotalCostByDelivererId":
                    
                    parts = line.split(",");
                    delivererId = Integer.parseInt(parts[1]);
                    str.append(system.getTotalCostByDeliverer(delivererId));
                    str.append("\n");
                    
                    break;
                    
                case "printOrdersByCustomer":
                    
                    parts = line.split(",");
                    customerId = Integer.parseInt(parts[1]);
                    str.append(system.printOrdersByCustomer(customerId));
                    str.append("\n");
                    str.append("\n");
                    
                    break;
            }
            
            write.print(str);
        }
        
        write.close();
    }
}