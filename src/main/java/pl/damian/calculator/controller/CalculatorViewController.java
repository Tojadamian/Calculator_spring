package pl.damian.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.damian.calculator.service.CalculatorService;

@Controller
public class CalculatorViewController {
    private final CalculatorService calculatorService;

    public CalculatorViewController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String showCalculator(){
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(
        @RequestParam double a,
        @RequestParam(required = false) Double b,
        @RequestParam String operation,
        Model model){
        double result = 0;
        String error = null;
        try{
            switch (operation){
                case "add" -> result = calculatorService.add(a, b);
                case "subtract" -> result = calculatorService.subtract(a, b);
                case "multiply" -> result = calculatorService.multiply(a, b);
                case "divide" -> result = calculatorService.divide(a, b);
                case "power" -> result = calculatorService.power(a, b != null ? b.doubleValue() : 0);
                case "square" -> result = calculatorService.square(a);
                default -> error = "Invalid operation";
            }
        } catch (IllegalArgumentException e) {
            error = e.getMessage();
        }
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);
        model.addAttribute("error", error);
        return "calculator";
    }
}
