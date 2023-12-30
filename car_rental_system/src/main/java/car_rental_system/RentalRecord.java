package car_rental_system;

import java.time.LocalDate;
import java.time.Period;

public class RentalRecord {
    
    LocalDate rentalDate;
    LocalDate returnDate;
    Period difference;
    int customerId;
    String carRegistrationNumber;
    
    RentalRecord(LocalDate rentalDate, LocalDate returnDate, int customerId, String carRegistrationNumber){
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.difference = Period.between(rentalDate, returnDate);
        this.customerId = customerId;
        this.carRegistrationNumber = carRegistrationNumber;
    }
}
