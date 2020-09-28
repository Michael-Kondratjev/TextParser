package epam.textparser.arithmetic;

import epam.textparser.arithmetic.VariableReplacement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VariableReplacementTest {

    String[] stringArray = {"3*i++", "2 + i--", "(4-2)*--i", "5 - ++i",
                            "++j*28", "(j--)", "--j / 8", "(22-15)*j++"};
    String[] stringArrayWithoutI = {"3*2", "2 + 3", "(4-2)*1", "5 - 2",
                            "++j*28", "(j--)", "--j / 8", "(22-15)*j++"};
    String[] stringArrayWithoutJ = {"3*i++", "2 + i--", "(4-2)*--i", "5 - ++i",
                                  "6*28", "(6)", "4 / 8", "(22-15)*4"};
    VariableReplacement variableReplacement;

    @BeforeClass
    void setUp() {
        variableReplacement = new VariableReplacement();
    }

    @Test
    public void replaceVariableITest(){
        List<String> expected = Arrays.asList(stringArrayWithoutI.clone());
        List<String> actual = Arrays.asList(stringArray.clone());
        variableReplacement.replaceVariableI(actual);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void replaceVariableJTest(){
        List<String> expected = Arrays.asList(stringArrayWithoutJ.clone());
        List<String> actual = Arrays.asList(stringArray.clone());
        variableReplacement.replaceVariableJ(actual);
        Assert.assertEquals(actual,expected);
    }
}
