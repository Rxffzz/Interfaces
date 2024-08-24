package services;

import model.CarRental;
import model.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;
    private TaxService TaxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService TaxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.TaxService = TaxService;
    }

    public void processInvoices(CarRental carRental){

       double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
       double hours = minutes / 60;

       double basicPayment;

       if (hours <= 12){
           basicPayment = pricePerHour * Math.ceil(hours);
       }else{
           basicPayment = pricePerDay * Math.ceil(hours / 24);
       }

       double tax = TaxService.tax(basicPayment);

       carRental.setInvoice(new Invoice(basicPayment, tax));

    }
}
