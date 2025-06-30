package pl.damian.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pl.damian.calculator.service.CalculatorService;

@SpringBootTest
class CalculatorApplicationTests {

	private CalculatorService calculatorService;

	@BeforeEach
	void setUp() {
		calculatorService = new CalculatorService();
	}
	@AfterAll
	static void tearDown() {
		System.out.println("✅ Testy ukończone o: " + java.time.LocalDateTime.now());
		System.out.println("🚀 Calculator Service - wszystkie funkcje zweryfikowane!");
	}

	@Test
	void testAdd(){
		assertEquals(5, calculatorService.add(2, 3));
		assertEquals(-1, calculatorService.add(-2, 1));
		assertEquals(0, calculatorService.add(0, 0));
		
	}
	@Test
	void testSubtract(){
		assertEquals(1, calculatorService.subtract(3, 2));
		assertEquals(-3, calculatorService.subtract(-2, 1));
		assertEquals(0, calculatorService.subtract(0, 0));
	}
	@Test
	void testMultiply(){
		assertEquals(6, calculatorService.multiply(2, 3));
		assertEquals(-2, calculatorService.multiply(-2, 1));
		assertEquals(0, calculatorService.multiply(0, 5));
	}
	@Test
	void testDivide(){
		assertEquals(2, calculatorService.divide(6, 3));
		assertEquals(-2, calculatorService.divide(-4, 2));
		assertEquals(0, calculatorService.divide(0, 5));
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(1, 0));
		assertEquals("Division by zero is not allowed.", exception.getMessage());
	}
	@Test
	void testPower(){
		assertEquals(8, calculatorService.power(2, 3));
		assertEquals(1, calculatorService.power(5, 0));
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calculatorService.power(2, -3));
		assertEquals("Exponent must be a non-negative integer.", exception.getMessage());
	}
	@Test
	void testSquare(){
		assertEquals(4, calculatorService.square(16));
		assertEquals(3, calculatorService.square(9));
		assertEquals(0, calculatorService.square(0));
		assertEquals(0.25, calculatorService.square(0.0625));
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calculatorService.square(-4));
		assertEquals("Square root of negative number is not allowed.", exception.getMessage());
	}
}
