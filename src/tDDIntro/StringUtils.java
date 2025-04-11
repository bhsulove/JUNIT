package tDDIntro;

public class StringUtils {
    public String reverseString(String input) {
        if(input.isEmpty()) return input;
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString();
    }
}
