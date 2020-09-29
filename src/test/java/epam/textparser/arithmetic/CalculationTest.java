package epam.textparser.arithmetic;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculationTest {
    String[] beforeCalculation = {"5+(60-9)*2", "(2+(3+(10/2-3)*4)*2)-12"};
    String[] afterCalculation =  {    "107",                "12"};

    Calculation calculation = new Calculation();

    @Test
    public void calculateArithmeticExpressionTest() {
        List<String> listAfterCalculation = Arrays.asList(afterCalculation);
        ArrayList<String> expected = new ArrayList<>(listAfterCalculation);

        List<String> listBeforeCalculation = Arrays.asList(beforeCalculation);
        ArrayList<String> actual = new ArrayList<>(listBeforeCalculation);
        calculation.calculateArithmeticExpression(actual);
        Assert.assertEquals(actual,expected);
    }
}
