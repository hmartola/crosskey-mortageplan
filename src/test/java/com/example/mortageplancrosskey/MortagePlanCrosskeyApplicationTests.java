package com.example.mortageplancrosskey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MortagePlanCrosskeyApplicationTests {

    CalculateMortage calculateMortage = new CalculateMortage();

    @Test
    void contextLoads() {
    }

    @Test
    void mortageCalculatorIsCorrect()  {

        double loan = 1337;
        double interest = 2.5;
        double years = 3;

        double payment = calculateMortage.mortageFormula(loan, interest, years);
        assertTrue(payment == 56.76);

    }

    @Test
    void powerMethodIsCorrect() {
        double pow = calculateMortage.pwr(2,3); // 2^3
        assertTrue(pow == 8);
    }

    @Test
    void roundMethodIsCorrect() {
        double round1 = calculateMortage.round(43.44374);
        double round2 = calculateMortage.round(55.49554);
        double round3 = calculateMortage.round(209.98674);

        assertTrue(round1 == 43.44);
        System.out.println(round2);
        assertTrue(round2 == 55.50);
        assertTrue(round3 == 209.99);
    }

}
