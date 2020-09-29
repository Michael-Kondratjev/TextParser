package epam.textparser.reader;

import epam.textparser.exception.TextParserException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextReaderTest {

    TextReader textReader;

    @BeforeClass
    public void setTextReader() {
        textReader = new TextReader();
    }

    @Test
    public void textInStringReaderTest() throws TextParserException {
        String expected = "Hello world!\nLong life Belarus!\n";
        String actual = textReader.textInStringReader("src/test/resources/ForReaderTest.txt");
        Assert.assertEquals(actual,expected);
    }

    @Test(expectedExceptions = TextParserException.class)
    public void textInStringReaderExceptionTest() throws TextParserException {
        String expected = "Hello world!\nLong life Belarus!\n";
        String actual = textReader.textInStringReader("wrong path");
        Assert.assertEquals(actual,expected);
    }


}
