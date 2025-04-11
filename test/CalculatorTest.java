import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @BeforeAll
    public static void callBeforeAnyMethodsExecute() {
        //this would execute before any method @Test and @BeforeEach execute
        System.out.println("1st method to be called ..Before any method is executed");
    }
    @BeforeEach
    public void callBeforeEachTestMethod(){
        //this would execute before each method with @Test
        System.out.println("This method runs before all test methods");
    }
    @Test
    void multiplyShouldReturnProductOfTwoNumbers() {
        Calculator calculator = new Calculator();
        double result = calculator.multiply(2, 3);
        assertEquals(6,result);

    }
    @AfterEach
    public void callAfterEachTestMethod(){
        //this would execute after each method with @Test completes
        System.out.println("This method runs after each test method");
    }
    @AfterAll
    public static void callAfterAllMethodsExecute() {
        // Finally, the @AfterAll annotation is used for cleaning up resources like cleaning up data and
        // logs after all tests in the test class have been completed.
        System.out.println("Last method.. After all methods are executed");
    }
}
