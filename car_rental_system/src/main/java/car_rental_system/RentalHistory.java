package car_rental_system;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalHistory {

    static Scanner scannerObject = new Scanner(System.in);

    ArrayList<RentalRecord> allRecords = new ArrayList<RentalRecord>();

    void addRentalRecord(LocalDate rentalDate, LocalDate returnDate, int customerId, String carRegistrationNumber){
        
        RentalRecord newRecord = new RentalRecord(rentalDate, returnDate, customerId, carRegistrationNumber);

        allRecords.add(newRecord);
    }

    void updateRentalRecord(LocalDate returnDate, int customerId, String carRegistrationNumber){

        for(int i = 0; i < allRecords.size(); i++){
            if(allRecords.get(i).customerId == customerId && allRecords.get(i).carRegistrationNumber.equals(carRegistrationNumber)){
                
                allRecords.get(i).returnDate = returnDate;
                allRecords.get(i).difference = Period.between(allRecords.get(i).rentalDate, returnDate);
                
                break;
            }
        }
    }

    void printAllRecords(){
         if(allRecords.size() == 0){
            System.out.println("List is empty.");
            System.out.println();
            return;
        }
        for (RentalRecord currRecord: allRecords) {
            System.out.println("---------");
            System.out.println("Customer Id: " + currRecord.customerId);
            System.out.println("Car Registration Number: " + currRecord.carRegistrationNumber);
            System.out.println("Rental Date: " + currRecord.rentalDate);
            System.out.println("Return Date: " + currRecord.returnDate);
            System.out.println("Car has been rented for " + currRecord.difference.getDays() + " days, " + currRecord.difference.getMonths() + " months and " + currRecord.difference.getYears() + "years.");
            System.out.println("---------");
            System.out.println();
          }
          System.out.println();
    }
    
}
