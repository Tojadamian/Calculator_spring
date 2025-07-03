package pl.damian.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

import pl.damian.DTO.ConversionRequest;
import pl.damian.calculator.service.CurrenciesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyViewController {
    private final CurrenciesService currenciesService;
    public CurrencyViewController(CurrenciesService currenciesService) {
        this.currenciesService = currenciesService;
    }
    
    @GetMapping("/currencies")
    public String showCurrencies(Model model) {
        model.addAttribute("currencies", currenciesService.getCurrencies());
        model.addAttribute("conversionRequest", new ConversionRequest());
        return "currencies";
    }
    @PostMapping("/currencies")
    public String convertCurrency(
        @RequestParam double amount,
        @RequestParam String from,
        @RequestParam String to,
        Model model) {
        Double result = currenciesService.convertCurrency(amount, from, to);
        if (result == null) {
            model.addAttribute("error", "Invalid currency codes");
        } else {
            model.addAttribute("result", result);
        }

        return "currencies";
    }
    
}
