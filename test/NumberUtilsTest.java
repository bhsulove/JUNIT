import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {
    @Test
    void testIsNumberEven() {
        int number1 = 4;
        int number2 = 5;
        boolean result1 = NumberUtils.isNumberEven(number1);
        boolean result2 = NumberUtils.isNumberEven(number2);
        assertTrue(result1);
        assertFalse(result2);

        assertFalse(NumberUtils.isNumberEven(3));
        assertTrue(NumberUtils.isNumberEven(2));
    }
}
