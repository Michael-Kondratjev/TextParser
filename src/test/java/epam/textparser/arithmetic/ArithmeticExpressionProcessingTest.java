package epam.textparser.arithmetic;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticExpressionProcessingTest {
    String[] beforeProcessing = {"--i+5+(60-9)*2+","--j","test","(2+(3+(10/2-3)*4)*2)-12*","++i","time"};
    String[] afterProcessing =  {    "112",              "test", "14",                           "time"};

    ArithmeticExpressionProcessing arithmeticExpressionProcessing = new ArithmeticExpressionProcessing();

    @Test
    public void processTest() {
        List<String> listAfterProcessing = Arrays.asList(afterProcessing);
        ArrayList<String> expected = new ArrayList<>(listAfterProcessing);

        List<String> listBeforeProcessing = Arrays.asList(beforeProcessing);
        ArrayList<String> actual = new ArrayList<>(listAfterProcessing);
        arithmeticExpressionProcessing.process(actual);

        Assert.assertEquals(actual,expected);
    }

}
