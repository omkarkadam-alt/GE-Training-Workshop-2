package car_rental_system;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarRentalSystem {

    static final int UPDATE_MAKE = 1;
    static final int UPDATE_MODEL = 2;
    static final int UPDATE_COLOR = 3;
    static final int UPDATE_YEAR = 4;
    static final int UPDATE_PRICE = 5;

    static Scanner scannerObject = new Scanner(System.in);

    static Map<String, Car> allCars = new HashMap<String, Car>();
    static Map<String, Boolean> isAvailable = new HashMap<String, Boolean>();

    static Car getCarDetails(){

        System.out.println("Enter the make of the car: ");
        String make = scannerObject.next();
        System.out.println("Enter the model of the car: ");
        String model = scannerObject.next();
        System.out.println("Enter the color of the car: ");
        String colour = scannerObject.next();
        System.out.println("Enter the year the car was manufactured: ");
        int year = scannerObject.nextInt();
        System.out.println("Enter the price of the car: ");
        double price = scannerObject.nextDouble();
        System.out.println("Enter the registration number of the car: ");
        String registrationNumber = scannerObject.next();
        
        Car newCar = new Car(make, model, year, colour, price, registrationNumber);

        return newCar;
    }

    static void displayIsAvailable(){
        if(isAvailable.size() == 0){
            System.out.println("List is empty.");
            System.out.println();
            return;
        }
        for (Map.Entry<String, Boolean> entry : isAvailable.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
          }
          System.out.println();
    }


    static void addCar(){
        Car newCar = getCarDetails();
        if(allCars.containsKey(newCar.registrationNumber)){
            System.out.println("Car is already present in the database.");
        }else{
            allCars.put(newCar.registrationNumber, newCar);
            isAvailable.put(newCar.registrationNumber, true);
            System.out.println("Car has been added to the database.");

            System.out.println("----------");
            System.out.println("Displaying all cars: ");
            displayAllCars();
            System.out.println("----------");

            System.out.println();
            System.out.println();
            
            System.out.println("----------");
            System.out.println("Displaying all Cars with Availability: ");
            displayIsAvailable();
            System.out.println("----------");
            
        }

        System.out.println();
        return;
    }

    static int getCarUpdateFieldChoice(){
        System.out.println("1.] Update Make");
        System.out.println("2.] Update Model");
        System.out.println("3.] Update Color");
        System.out.println("4.] Update Year");
        System.out.println("5.] Update Price");

        int choice = scannerObject.nextInt();

        return choice;
    }

    static void updateCarField(String registrationNumber, int updateFieldChoice){
        switch (updateFieldChoice) {
            case UPDATE_MAKE:
                System.out.println("Enter the updated make for the car");
                String make = scannerObject.next();
                allCars.get(registrationNumber).make = make;
                break;

            case UPDATE_MODEL:
                System.out.println("Enter the updated model for the car");
                String model = scannerObject.next();
                allCars.get(registrationNumber).model = model;
                break;

            case UPDATE_COLOR:
                System.out.println("Enter the updated colour for the car");
                String colour = scannerObject.next();
                allCars.get(registrationNumber).colour = colour;
                break;

            case UPDATE_YEAR:
                System.out.println("Enter the updated year for the car");
                int year = scannerObject.nextInt();
                allCars.get(registrationNumber).year = year;
                break;

            case UPDATE_PRICE:
                System.out.println("Enter the updated price for the car");
                double price = scannerObject.nextDouble();
                allCars.get(registrationNumber).price = price;
                break;
        }
    }

    static void updateCarDetails(){

        System.out.println("Enter the car's Registration Number: ");
        String carRegistrationNumber = scannerObject.next();

        if(allCars.containsKey(carRegistrationNumber)){

            int updateFieldChoice = getCarUpdateFieldChoice();
            updateCarField(carRegistrationNumber, updateFieldChoice);
            
            System.out.println("Car details updated.");

        }else{
            System.out.println("Car is not present in the database.");
        }

        System.out.println();
        return;
    }

    static void deleteCar(){
        System.out.println("Enter the registration number of the car you wish to delete: ");
        String deleteRegistrationNumber = scannerObject.next();

        if(allCars.containsKey(deleteRegistrationNumber)){
            allCars.remove(deleteRegistrationNumber);
            isAvailable.remove(deleteRegistrationNumber);
            System.out.println("Car deleted");
        }else{
            System.out.println("No such Car exists.");
        }
        System.out.println();
    }

    static void displayAllCars(){
        if(allCars.size() == 0){
            System.out.println("List is empty.");
            System.out.println();
            return;
        }
        for (Map.Entry<String, Car> entry : allCars.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().make + " " + entry.getValue().model + " " + entry.getValue().colour + " " + entry.getValue().year + " " + entry.getValue().price);
          }

          System.out.println();
        
    }

    static void displayAvailableCars(){

        boolean isEmpty = true;

        for (Map.Entry<String, Car> entry : allCars.entrySet()) {
            if(isAvailable.get(entry.getKey()) == true){
                isEmpty = false;
                System.out.println(entry.getKey() + ": " + entry.getValue().make + " " + entry.getValue().model + " " + entry.getValue().colour + " " + entry.getValue().year + " " + entry.getValue().price);
          }
        }

        if(isEmpty == true){
            System.out.println("List is empty.");
            System.out.println();
            return;
        }

          System.out.println();
        
    }

}