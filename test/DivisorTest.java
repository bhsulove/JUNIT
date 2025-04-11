import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisorTest {
    Divisor divisor;
    @BeforeEach
    public void setUp() {
        divisor = new Divisor();
    }
    @Test
    public void testDivisor() {
        assertEquals(2,divisor.divisor(10,5));
    }
    @DisplayName("Dividing by zero throws exception.")
    @Test
    public void testDivisor_withDivisorZero() {
        assertThrows(IllegalArgumentException.class,()->{
            divisor.divisor(10,0);
        });
    }
}
