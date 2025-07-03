package pl.damian.calculator.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RestController;


import pl.damian.DTO.ConversionResult;
import pl.damian.calculator.model.CurrencyModel;
import pl.damian.calculator.service.CurrenciesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class CurrencyController {
    private final CurrenciesService currenciesService;

    public CurrencyController(CurrenciesService currenciesService) {
        this.currenciesService = currenciesService;
    }
    @GetMapping("/api/currencies")
    public List<CurrencyModel> getCurrencies() {
        return currenciesService.getCurrencies();
    }
    @GetMapping("/api/currencies/search")
    public List<CurrencyModel> searchCurrencies(@RequestParam String q) {
        return currenciesService.getCurrencies().stream()
            .filter(c -> c.getCode().toLowerCase().contains(q.toLowerCase()) ||
                         c.getCurrency().toLowerCase().contains(q.toLowerCase()))
                         .toList();
    }
    @PostMapping("/api/currencies/convert")
    public ResponseEntity<ConversionResult> convertCurrency(
        @RequestParam("amount") Double amount,
        @RequestParam("from") String fromC,
        @RequestParam("to") String toC) {
        Double result = currenciesService.convertCurrency(amount, fromC, toC);
        if (result == null) {
            return ResponseEntity.badRequest().body(new ConversionResult("Invalid currency codes"));
        }

        ConversionResult conversionResult = new ConversionResult(result);
        return ResponseEntity.ok(conversionResult);
    }
        
    
}