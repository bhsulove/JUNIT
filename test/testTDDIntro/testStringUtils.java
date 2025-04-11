package testTDDIntro;

import org.junit.jupiter.api.Test;
import tDDIntro.StringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testStringUtils {
    @Test
    public void testReverseString(){
        StringUtils stringUtils = new StringUtils();
        String result = stringUtils.reverseString("hello");
        assertEquals("olleh",result);
    }
}
