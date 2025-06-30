package pl.damian.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double add(double a, double b){
        return a + b;
    }
    public double subtract(double a, double b){
        return a - b;
    }
    public double multiply(double a, double b){
        return a * b;
    }
    public double divide(double a, double b){
        if (b == 0){
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        if (a == 0) {

            return 0;
        }
        return a / b;
    }
    public double power(double base, double exponent){
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be a non-negative integer.");
        }
        if (exponent < 1) {
            throw new IllegalArgumentException("Exponent must be a non-negative integer.");
        }
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
    public double square(double number){
        double t;
        double squareroot = number / 2;
        if (number == 0) {
            return 0;
        }
        if (number < 0){
            throw new IllegalArgumentException("Square root of negative number is not allowed.");
        }
        else {
            do {
                t = squareroot;
                squareroot = (t + (number / t)) / 2;
            } while ((t - squareroot) != 0);
            return squareroot;
        }
    }
}
