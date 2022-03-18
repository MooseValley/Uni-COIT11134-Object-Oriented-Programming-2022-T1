/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loancomparision;

/**
 *
 * @author uvenu
 */
public class Loan implements Comparable {
    double loanAmount;     
    double annualInterestRatePercent;
    int numberOfMonthlyPayments;
    double annualFeesCharges;
    //constructors
    public Loan(double loanAmount, double annualInterestRatePercent, int numberOfMonthlyPayments, double annualFeesCharges) {
        this.loanAmount = loanAmount;
        this.annualInterestRatePercent = annualInterestRatePercent;
        this.numberOfMonthlyPayments = numberOfMonthlyPayments;
        this.annualFeesCharges = annualFeesCharges;
    }

    public Loan() {
    }
    //getters and setters
    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getAnnulInterestRatePercent() {
        return annualInterestRatePercent;
    }

    public void setAnnulInterestRatePercent(double annulInterestRatePercent) {
        this.annualInterestRatePercent = annualInterestRatePercent;
    }

    public int getNumberOfMonthlyPayments() {
        return numberOfMonthlyPayments;
    }

    public void setNumberOfMonthlyPayments(int numberOfMonthlyPayments) {
        this.numberOfMonthlyPayments = numberOfMonthlyPayments;
    }
    // get value from the method that calculates monthly payment value
    public double getMonthlyPaymentAmount() {
        return calculatetMonthlyPaymentAmount();
    }

    public double calculatetMonthlyPaymentAmount() {
        return this.loanAmount*this.annualInterestRatePercent/100/12*Math.pow((1+annualInterestRatePercent/100/12), this.numberOfMonthlyPayments)/(Math.pow((1+annualInterestRatePercent/100/12), this.numberOfMonthlyPayments)-1);     
    }
    // get value from the method that calculates monthly payment value
     public double getToalPayableAmount(){
         return calculatetToalPayableAmount();
     }
     
    public double calculatetToalPayableAmount(){
        int numYears = numberOfMonthlyPayments%12 == 0 ? numberOfMonthlyPayments/12:numberOfMonthlyPayments/12+1;
        return calculatetMonthlyPaymentAmount()*numberOfMonthlyPayments + numYears*this.annualFeesCharges;
        
    }
    @Override
    public String toString() {
        return  String.format("Number Of Monthly Payments : %d\nMonthly Payment Amount : $%.2f\nTotal Amount Payable : $%.2f\n", numberOfMonthlyPayments,  this.getMonthlyPaymentAmount(),this.getToalPayableAmount());
    }
    // implementing compareTo method of interface Comparable
    @Override
    public int compareTo(Object o) {
        if(this.getToalPayableAmount()< ((Loan)o).getToalPayableAmount())
                return -1;
       if(this.getToalPayableAmount()> ((Loan)o).getToalPayableAmount()) 
                  return 1;
       return 0;
    }  
    
}
