package pl.damian.calculator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.damian.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/calculator")
public class CalculatorController{
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;

    }
    @GetMapping("add")
    public double add(@RequestParam double a, @RequestParam double b) {
        return calculatorService.add(a, b);
    }
    @GetMapping("subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
        return calculatorService.subtract(a, b);
    }
    @GetMapping("multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        return calculatorService.multiply(a, b);
    }
    @GetMapping("divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        return calculatorService.divide(a, b);
    }
    @GetMapping("power")
    public double power(@RequestParam double base, @RequestParam int exponent) {
        return calculatorService.power(base, exponent);
    }
    @GetMapping("square")
    public double square(@RequestParam double number) {
        return calculatorService.square(number);
    }
}

