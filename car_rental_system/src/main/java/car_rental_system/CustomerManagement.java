package car_rental_system;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerManagement {

    static final int UPDATE_NAME= 1;
    static final int UPDATE_PHONE_NUMBER = 2;
    static final int UPDATE_ADDRESS = 3;

    static int customerId = 1;

    static Scanner scannerObject = new Scanner(System.in);

    static Map<Integer, Customer> allCustomers = new HashMap<Integer, Customer>();

    static Customer getCustomerDetails(){

        System.out.println("Enter your name: ");
        String name = scannerObject.next();
        System.out.println("Enter your phone number: ");
        long phoneNumber = scannerObject.nextLong();
        System.out.println("Enter your address: ");
        String address = scannerObject.next();
        
        Customer newCustomer = new Customer(customerId, name, phoneNumber, address);
        customerId++;

        return newCustomer;
    }

    static void addCustomer(){
        Customer newCustomer = getCustomerDetails();

        allCustomers.put(newCustomer.customerId, newCustomer);
        System.out.println("Customer has been added to the database.");

        System.out.println();
        return;
    }

    static int getCustomerUpdateFieldChoice(){
        System.out.println("1.] Update Name");
        System.out.println("2.] Update Phone Number");
        System.out.println("3.] Update Address");

        int choice = scannerObject.nextInt();

        return choice;
    }

    static void updateCustomerField(int customerId, int updateFieldChoice){
        switch (updateFieldChoice) {
            case UPDATE_NAME:
                System.out.println("Enter the updated name: ");
                String name = scannerObject.next();
                allCustomers.get(customerId).name = name;
                break;
            case UPDATE_PHONE_NUMBER:
                System.out.println("Enter the updated phone number: ");
                long phoneNumber = scannerObject.nextLong();
                allCustomers.get(customerId).phoneNumber = phoneNumber;
                break;
            case UPDATE_ADDRESS:
                System.out.println("Enter the updated address: ");
                String address = scannerObject.next();
                allCustomers.get(customerId).address = address;
                break;
        }
    }

    static void updateCustomerDetails(){

        System.out.println("Enter your Customer ID: ");
        int updateCustomerId = scannerObject.nextInt();

        if(allCustomers.containsKey(updateCustomerId)){

            int updateFieldChoice = getCustomerUpdateFieldChoice();
            updateCustomerField(updateCustomerId, updateFieldChoice);
            
            System.out.println("Customer details updated.");

        }else{
            System.out.println("No such customer exists in our database.");
        }

        System.out.println();
        return;
    }

    static void deleteCustomer(){
        System.out.println("Enter the customerId of the user you wish to delete: ");
        int deleteCustomerId= scannerObject.nextInt();

        if(allCustomers.containsKey(deleteCustomerId)){
            allCustomers.remove(deleteCustomerId);
            System.out.println("Customer deleted");
        }else{
            System.out.println("No such Customer exists.");
        }
        System.out.println();
    }

    static void displayAllCustomers(){
        if(allCustomers.size() == 0){
            System.out.println("List is empty.");
            System.out.println();
            return;
        }
        for (Map.Entry<Integer, Customer> entry : allCustomers.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().name + " " + entry.getValue().phoneNumber + " " + entry.getValue().address);
          }
          System.out.println();
        
    }
}
