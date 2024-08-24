package model;

import java.util.function.DoubleUnaryOperator;

public class Invoice {

    private Double basicPayment;
    private Double tax;

    public Invoice(){}

    public Invoice(double basicPayment, double tax){
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public double getBasicPayment() {
        return basicPayment;
    }


    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Double getTotalPayment(){
        return getBasicPayment() + getTax();
    }
}
