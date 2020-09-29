package epam.textparser.arithmetic;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GluingTest {

    String[] beforeGluing = {"2+3*", "5-3", "time", "32*", "(5-2)", "/2", "test"};
    String[] afterGluing = {"2+3*5-3",      "time", "32*(5-2)/2",         "test"};

    Gluing gluing = new Gluing();

    @Test
    public void glueArithmeticExpressionsTest(){
        List<String> listAfterGluing = Arrays.asList(afterGluing);
        ArrayList<String> expected = new ArrayList<>(listAfterGluing);
        List<String> listBeforeGluing = Arrays.asList(beforeGluing);
        ArrayList<String> actual = new ArrayList<>(listBeforeGluing);

        gluing.glueArithmeticExpressions(actual);
        Assert.assertEquals(actual,expected);
    }

}
