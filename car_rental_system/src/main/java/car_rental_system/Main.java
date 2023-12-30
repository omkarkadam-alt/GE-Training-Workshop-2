package car_rental_system;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static final int ADD_CAR = 1;
    static final int UPDATE_CAR_DETAILS = 2;
    static final int DELETE_CAR = 3;
    static final int DISPLAY_ALL_CARS = 4;
    static final int DISPLAY_AVAILABLE_CARS = 5;
    static final int ADD_CUSTOMER = 6;
    static final int UPDATE_CUSTOMER_DETAILS = 7;
    static final int DELETE_CUSTOMER = 8;
    static final int DISPLAY_ALL_CUSTOMERS = 9;
    static final int RENT_CAR = 10;
    static final int RETURN_CAR = 11;
    static final int DISPLAY_RENTAL_HISTORY_BY_CAR = 12;
    static final int DISPLAY_RENTAL_HISTORY_BY_CUSTOMER = 13;
    static final int EXIT = 14;

    static Scanner scannerObject = new Scanner(System.in);

    static int displayChoices(){

        System.out.println("--------------------------------------");
        System.out.println("1.] Add a new Car");
        System.out.println("2.] Update Car Details");
        System.out.println("3.] Delete a Car");
        System.out.println("4.] Display all Cars");
        System.out.println("5.] Display available Cars");
        System.out.println("6.] Add a new Customer");
        System.out.println("7.] Update Customer Details");
        System.out.println("8.] Delete a Customer");
        System.out.println("9.] Display all Customers");
        System.out.println("10.] Rent a Car");
        System.out.println("11.] Return a Car");
        System.out.println("12.] Display Rental History by Car");
        System.out.println("13.] Display Rental History by Customer");
        System.out.println("14.] Exit");

        int choice = scannerObject.nextInt();
        System.out.println("--------------------------------------");
        System.out.println();

        return choice;
    }

    static void rentCar(){
        System.out.println("Enter your Customer ID: ");
        int customerId = scannerObject.nextInt();

        if(CustomerManagement.allCustomers.containsKey(customerId)){
            System.out.println("Enter the registration Number of the car you wish to rent:");
            String carRegistrationNumber = scannerObject.next();

            if(CarRentalSystem.allCars.containsKey(carRegistrationNumber)){
                
                if(CarRentalSystem.isAvailable.get(carRegistrationNumber) == true){

                    System.out.println("Enter Rental Day:");
                    int day = scannerObject.nextInt();
                    System.out.println("Enter Rental Month:");
                    int month = scannerObject.nextInt();
                    System.out.println("Enter Rental Year:");
                    int year = scannerObject.nextInt();

                    LocalDate rentalDate = LocalDate.of(year, month, day);
                    LocalDate returnDate = LocalDate.of(2100, 1, 1);
                    
                    CarRentalSystem.allCars.get(carRegistrationNumber).rentalHistory.addRentalRecord(rentalDate, returnDate, customerId, carRegistrationNumber);

                    CustomerManagement.allCustomers.get(customerId).rentalHistory.addRentalRecord(rentalDate, returnDate, customerId, carRegistrationNumber);

                    CarRentalSystem.isAvailable.put(carRegistrationNumber, false);

                }else{
                    System.out.println("This car has been currently rented out by another customer.");;
                }
            } else{
                System.out.println("No such car exists.");
            }
        }else{
            System.out.println("Customer with the given CustomerID does not exist.");
        }

        System.out.println();
    }

    static void returnCar(){
        System.out.println("Enter your Customer ID: ");
        int customerId = scannerObject.nextInt();

        if(CustomerManagement.allCustomers.containsKey(customerId)){
            System.out.println("Enter the registration Number of the car you wish to return:");
            String carRegistrationNumber = scannerObject.next();

            if(CarRentalSystem.allCars.containsKey(carRegistrationNumber)){
                
                if(CarRentalSystem.isAvailable.get(carRegistrationNumber) == false){

                    System.out.println("Enter Return Day:");
                    int day = scannerObject.nextInt();
                    System.out.println("Enter Return Month:");
                    int month = scannerObject.nextInt();
                    System.out.println("Enter Return Year:");
                    int year = scannerObject.nextInt();

                    LocalDate returnDate = LocalDate.of(year, month, day);
                    
                    CarRentalSystem.allCars.get(carRegistrationNumber).rentalHistory.updateRentalRecord(returnDate, customerId, carRegistrationNumber);

                    CustomerManagement.allCustomers.get(customerId).rentalHistory.updateRentalRecord(returnDate, customerId, carRegistrationNumber);

                    CarRentalSystem.isAvailable.put(carRegistrationNumber, true);

                }else{
                    System.out.println("This car was not rented out.");;
                }
            } else{
                System.out.println("No such car exists.");
            }
        }else{
            System.out.println("Customer with the given CustomerID does not exist.");
        }

        System.out.println();
    }

    static void rentalHistoryByCar(String registrationNumber){
        RentalHistory carRentalHistory = CarRentalSystem.allCars.get(registrationNumber).rentalHistory;

        if(carRentalHistory.allRecords.size() > 0){
            System.out.println("-----------");
            for(RentalRecord currRentalRecord: carRentalHistory.allRecords){
                System.out.println();
                System.out.println("Customer Id: " + currRentalRecord.customerId);
                System.out.println("Car Registration Number: " + currRentalRecord.carRegistrationNumber);
                System.out.println("Car Rental Date: " + currRentalRecord.rentalDate);
                System.out.println("Car Return Date: " + currRentalRecord.returnDate);
                System.out.println("Car has been rented for " + currRentalRecord.difference.getDays() + " days, " + currRentalRecord.difference.getMonths() + " months and " + currRentalRecord.difference.getYears() + "years.");
                System.out.println();
            }
            System.out.println("-----------");
            System.out.println();
        }else{
            System.out.println("Car has not been rented in the past.");
            System.out.println();
        }
    }

    static void rentalHistoryByCustomer(int customerID){
        RentalHistory customerRentalHistory = CustomerManagement.allCustomers.get(customerID).rentalHistory;

        if(customerRentalHistory.allRecords.size() > 0){
            System.out.println("-----------");
            for(RentalRecord currRentalRecord: customerRentalHistory.allRecords){
                System.out.println();
                System.out.println("Customer Id: " + currRentalRecord.customerId);
                System.out.println("Car Registration Number: " + currRentalRecord.carRegistrationNumber);
                System.out.println("Car Rental Date: " + currRentalRecord.rentalDate);
                System.out.println("Car Return Date: " + currRentalRecord.returnDate);
                System.out.println("Car has been rented for " + currRentalRecord.difference.getDays() + " days, " + currRentalRecord.difference.getMonths() + " months and " + currRentalRecord.difference.getYears() + "years.");
                System.out.println();
            }
            System.out.println("-----------");
            System.out.println();
        }else{
            System.out.println("Customer has not rented any car in the past.");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to car rental system.");

        while(true){
            int choice = displayChoices();

            switch (choice) {
                case ADD_CAR:
                    CarRentalSystem.addCar();
                    break;

                case UPDATE_CAR_DETAILS:
                    CarRentalSystem.updateCarDetails();
                    break;

                case DELETE_CAR:
                    CarRentalSystem.deleteCar();
                    break;

                case DISPLAY_ALL_CARS:
                    CarRentalSystem.displayAllCars();
                    break;

                case DISPLAY_AVAILABLE_CARS:
                    CarRentalSystem.displayAvailableCars();
                    break;

                case ADD_CUSTOMER:
                    CustomerManagement.addCustomer();
                    break;

                case UPDATE_CUSTOMER_DETAILS:
                    CustomerManagement.updateCustomerDetails();
                    break;

                case DELETE_CUSTOMER:
                    CustomerManagement.deleteCustomer();
                    break;

                case DISPLAY_ALL_CUSTOMERS:
                    CustomerManagement.displayAllCustomers();
                    break;

                case RENT_CAR:
                    rentCar();
                    break;

                case RETURN_CAR:
                    returnCar();
                    break;

                case DISPLAY_RENTAL_HISTORY_BY_CAR:
                    System.out.println("Enter the Car Registration Number: ");
                    String registrationNumber = scannerObject.next();
                    
                    if(CarRentalSystem.allCars.containsKey(registrationNumber)){
                        rentalHistoryByCar(registrationNumber);
                    } else{
                        System.out.println("No such car exists");
                    }
                    break;

                case DISPLAY_RENTAL_HISTORY_BY_CUSTOMER:
                    System.out.println("Enter CustomerID: ");
                    int customerID = scannerObject.nextInt();
                    
                    if(CustomerManagement.allCustomers.containsKey(customerID)){
                        rentalHistoryByCustomer(customerID);
                    } else{
                        System.out.println("No such customer exists");
                    }
                    break;

                case EXIT:
                    scannerObject.close();
                    return;
            }
        }
    }
}
