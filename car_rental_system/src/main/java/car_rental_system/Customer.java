package car_rental_system;

public class Customer {
    int customerId;
    String name;
    long phoneNumber;
    String address;
    RentalHistory rentalHistory;

    Customer(int customerId, String name, long phoneNumber, String address){
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rentalHistory = new RentalHistory();
    }
}
