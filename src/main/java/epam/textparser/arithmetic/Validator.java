package epam.textparser.arithmetic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String ARITHMETIC_EXPRESSION = "\\d+|[/*+]";

    static boolean isArithmeticExpression(String string) {
        Pattern pattern = Pattern.compile(ARITHMETIC_EXPRESSION);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
