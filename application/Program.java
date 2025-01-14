package application;

import model.CarRental;
import model.Vehicle;
import services.BrazilTaxService;
import services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter with the data of rent: ");
        System.out.println("Car model:");
        String carModel = sc.nextLine();
        System.out.println("Removal (dd/MM/yyyy) hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Devolution (dd/MM/yyyy) hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.println("Enter with the price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.println("Enter with the price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoices(cr);

        System.out.println("INVOICE: ");
        System.out.println("Basic payment: " + cr.getInvoice().getBasicPayment());
        System.out.println("tax: " + cr.getInvoice().getTax());
        System.out.println("Total payment: " + cr.getInvoice().getTotalPayment());


        sc.close();
    }
}
