package car_rental_system;

public class Car {
    String make;
    String model;
    int year;
    String colour;
    double price;
    String registrationNumber;
    RentalHistory rentalHistory;

    Car(String make, String model, int year, String colour, double price, String registrationNumber){
        this.make = make;
        this.model = model;
        this.year = year;
        this.colour = colour;
        this.price = price;
        this.registrationNumber = registrationNumber;
        this.rentalHistory = new RentalHistory();
    }

}
