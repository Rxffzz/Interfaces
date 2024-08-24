package exercicie.services;

import exercicie.model.Contract;
import exercicie.model.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){
            double basicfraction = contract.getTotalValue() / months;
    for (int i = 1; i <= months; i++){
        LocalDate dueDate = contract.getDate().plusMonths(i);
        double interest = onlinePaymentService.interest(basicfraction, i);
        double fee = onlinePaymentService.paymentFee(basicfraction + interest);
        double fraction = basicfraction + interest + fee;
        contract.getInstallments().add(new Installment(dueDate, fraction));
    }
    }

}
