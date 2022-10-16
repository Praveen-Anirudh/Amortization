package com.ults.amortization.amortization.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ults.amortization.amortization.model.MonthlyAmortizationSchedule;
import com.ults.amortization.amortization.repository.DataRepository;
import com.ults.amortization.amortization.service.AmortizationService;

@RestController
public class MortgageCalculatorController {

    @Autowired
    private AmortizationService amortizationService;
    @Autowired
    private DataRepository dataRepository;

    /**
     * Default values are loaded into form from method argument
     * 'monthlyAmortizationSchedule', loaded with default values.
     * 
     * @param monthlyAmortizationSchedule a MonthlyAmortizationSchedule object,
     *                                    auto-loaded by Spring MVC
     * @return a string identifier for which .jsp view to redirect to
     */
    @RequestMapping(path = { "/index", "/" }, method = RequestMethod.GET)
    public String loadInitialFormInput(@ModelAttribute MonthlyAmortizationSchedule monthlyAmortizationSchedule) {
        return "form";
    }

    @RequestMapping(value = "/showSchedule", method = RequestMethod.POST)
    public String calculatePayments(@ModelAttribute MonthlyAmortizationSchedule monthlyAmortizationSchedule,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("There are errors! " + bindingResult.getAllErrors().toString());
        }
        amortizationService.initializeUnknownFields(monthlyAmortizationSchedule);
        model.addAttribute(monthlyAmortizationSchedule);

        return "schedule";
    }

    @PostMapping("/loan")
    public MonthlyAmortizationSchedule addDetails(@RequestBody MonthlyAmortizationSchedule schedule) {
        return dataRepository.save(schedule);
    }

}
