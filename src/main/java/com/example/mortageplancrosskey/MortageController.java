package com.example.mortageplancrosskey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MortageController {

    @GetMapping("/mortageplan")
    public String mortageData(Model model) {
        model.addAttribute("mortageplan", new Mortage());
        return "mortageplan";
    }

    @PostMapping("/mortageplan")
    public String mortagePlan(@ModelAttribute Mortage mortage, Model model) {
        model.addAttribute("mortageplan", mortage);
        return "result";
    }
}
