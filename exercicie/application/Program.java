package exercicie.application;

import exercicie.model.Contract;
import exercicie.model.Installment;
import exercicie.services.ContractService;
import exercicie.services.PaypalService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter with data of contract: ");
        System.out.println("Number of the contract: ");
        int number = sc.nextInt();
        System.out.println("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), dtf);
        System.out.println("Value of the contract: ");
        double value = sc.nextDouble();

        Contract contract = new Contract(number, date, value);

        System.out.println("Enter with the number of installment: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract,n);

        System.out.println("Installments: ");
        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }

        sc.close();
    }
}
