# Calculator Spring Boot Application

## Description
A web calculator application built with Spring Boot. Enables performing basic mathematical operations through a web interface.

## Features
- ➕ Addition
- ➖ Subtraction  
- ✖️ Multiplication
- ➗ Division
- 🔢 Exponentiation
- √ Square root

## Technologies
- **Java 17+**
- **Spring Boot 3.x**
- **Spring MVC**
- **Thymeleaf** (template engine)
- **JUnit 5** (unit testing)
- **Maven** (build tool)

## Project Structure
```
calculator/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── pl/damian/calculator/
│   │   │       ├── CalculatorApplication.java
│   │   │       ├── controller/
│   │   │       │   └── CalculatorViewController.java
│   │   │       └── service/
│   │   │           └── CalculatorService.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   └── calculator.html
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── pl/damian/calculator/
│               └── CalculatorApplicationTests.java
└── pom.xml
```

## Running the Application

### Requirements
- Java 17 or higher
- Maven 3.6+

### Steps to Run
1. Clone the repository:
```bash
git clone https://github.com/Tojadamian/Calculator_spring.git
cd Calculator_spring
```

2. Compile and run the application:
```bash
mvn spring-boot:run
```

3. Open your browser and navigate to:
```
http://localhost:8081
```

## Running Tests

### All tests:
```bash
mvn test
```

### In PowerShell (Windows):
```powershell
.\mvnw.cmd test
```

### Test Coverage:
- ✅ Addition operations
- ✅ Subtraction operations
- ✅ Multiplication operations
- ✅ Division operations (with division by zero handling)
- ✅ Exponentiation operations (with negative exponent handling)
- ✅ Square root operations

## API Endpoints

### GET /
Displays the main calculator page

### POST /calculate
Performs calculations
- **Parameters:**
  - `a` (double) - first number
  - `b` (double, optional) - second number
  - `operation` (string) - operation type
    - `add` - addition
    - `subtract` - subtraction
    - `multiply` - multiplication
    - `divide` - division
    - `power` - exponentiation
    - `square` - square root

## Error Handling
- 🚫 Division by zero
- 🚫 Square root of negative numbers
- 🚫 Negative exponents in exponentiation
- 🚫 Invalid operations

## Usage Example
```bash
curl -X POST http://localhost:8081/calculate \
  -d "a=10&b=2&operation=power"
```

## Author
Damian

## License
Educational project - created for learning Spring Boot

---

*Application created for learning Spring Boot and unit testing.*
