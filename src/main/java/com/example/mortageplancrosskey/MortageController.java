package com.example.mortageplancrosskey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class MortageController {

    CalculateMortage calculateMortage = new CalculateMortage();
    FileOperator fileOperator = new FileOperator();

    @GetMapping("/mortageplan")
    public String mortageData(Model model) {
        model.addAttribute("mortageplan", new Mortage());
        return "mortageplan";
    }

    @PostMapping("/mortageplan")
    public String mortagePlan(@ModelAttribute Mortage mortage, Model model) {
        model.addAttribute("mortageplan", mortage);
        mortage.setMonthlyPayment(calculateMortage.mortageFormula(mortage.getLoan(), mortage.getInterest(), mortage.getYears()));
        fileOperator.writeFile(mortage.getName(), mortage.getLoan(), mortage.getYears(), mortage.getMonthlyPayment());
        return "mortageplan";
    }
}
