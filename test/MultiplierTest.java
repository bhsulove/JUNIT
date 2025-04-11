import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplierTest {
    @Test
    public void testMultiply() {
        Multiplier multiplier = new Multiplier();
        assertEquals(10,multiplier.multiply(2,5));
    }
}
