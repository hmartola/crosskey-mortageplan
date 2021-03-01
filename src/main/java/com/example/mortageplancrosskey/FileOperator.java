package com.example.mortageplancrosskey;

import java.io.*;

public class FileOperator {

    public void readFile() {
        CalculateMortage calculateMortage = new CalculateMortage();

        try {
            FileReader fr = new FileReader("prospects.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                if (line.startsWith("\"")) {
                    line = line.replace("\"", "");
                    line = line.replaceFirst("(?:,)+", " ");
                }
                //System.out.println(line);

                if (line.contains(",")) {
                    String[] customer = line.split(",");
                    Mortage mortage = new Mortage();

                    mortage.setName(customer[0]);
                    mortage.setLoan(Double.parseDouble(customer[1]));
                    mortage.setInterest(Double.parseDouble(customer[2]));
                    mortage.setYears(Double.parseDouble(customer[3]));

                    mortage.setMonthlyPayment(calculateMortage.mortageFormula(mortage.getLoan(), mortage.getInterest(), mortage.getYears()));
                    writeFile(mortage.getName(), mortage.getLoan(), mortage.getYears(), mortage.getMonthlyPayment());
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String name, double loan, double years, double payment) {
        try {
            File file = new File("prospects.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write("\n" + name + " wants to borrow " + loan + " € for a period of " + years + " years and pay " + payment + " € each month" + "\n");
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
