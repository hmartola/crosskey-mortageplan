package com.example.mortageplancrosskey;

public class CalculateMortage {

    private double E; // fixed monthly payment
    private double b; // interest
    private double U; // loan
    private double p; // nr of payments
    private double numerator;
    private double denominator;

    public double mortageFormula(double loan, double interest, double years) {
        U = loan;
        b = (interest / 100);
        p = years * 12;
        numerator = (U * b) * (pwr((1 + b), p));    // U[ b(1 + b) ^ p ]
        //System.out.println("Num " + numerator);
        denominator = (pwr(((1 + b)), p) - 1);      // [ (1 + b) ^ p - 1]
        //System.out.println("Den " + denominator);
        E = round((numerator / denominator));
        //System.out.println(E);
        return E;
    }

    // Helper methods, public because of testing purposes

    public double pwr(double n, double p) {     // n^p
        double pow = 1;
        for (int i = 1; i <= p; i++) {
            pow *= n;
        }
        return pow;
    }

    public double round(double num) {       // rounds to two decimals
        double x = num * 100.0;
        double y = x + 0.5;
        long z = (long) y;
        double res = z / 100.0;

        return res;
    }


}
