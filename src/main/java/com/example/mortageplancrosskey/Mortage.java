package com.example.mortageplancrosskey;

public class Mortage {

    private String name;
    private double interest;
    private double loan;
    private double nrOfPayments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getNrOfPayments() {
        return nrOfPayments;
    }

    public void setNrOfPayments(double nrOfPayments) {
        this.nrOfPayments = nrOfPayments;
    }

}
