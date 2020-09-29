package epam.textparser.arithmetic;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class VariableReplacementTest {

    String[] stringArrayWithI =    {"3*i++", "2 + i--", "(4-2)*--i", "5 - ++i"};
    String[] stringArrayWithoutI = {"3*2",   "2 + 3",   "(4-2)*1",   "5 - 2"};

    String[] stringArrayWithJ =    {"++j*28", "(j--)", "--j / 8", "(22-15)*j++"};
    String[] stringArrayWithoutJ = { "6*28",  "(6)",   "4 / 8",   "(22-15)*4"};

    VariableReplacement variableReplacement;

    @BeforeClass
    void setUp() {
        variableReplacement = new VariableReplacement();
    }

    @Test
    public void replaceVariableITest(){
        List<String> expected = Arrays.asList(stringArrayWithoutI);
        List<String> actual = Arrays.asList(stringArrayWithI);
        variableReplacement.replaceVariableI(actual);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void replaceVariableJTest(){
        List<String> expected = Arrays.asList(stringArrayWithoutJ);
        List<String> actual = Arrays.asList(stringArrayWithJ);
        variableReplacement.replaceVariableJ(actual);
        Assert.assertEquals(actual,expected);
    }
}
