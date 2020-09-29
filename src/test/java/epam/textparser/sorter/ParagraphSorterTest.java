package epam.textparser.sorter;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.TextComposite;
import epam.textparser.exception.TextParserException;
import epam.textparser.parser.impl.ParagraphParser;
import epam.textparser.parser.impl.TextParser;
import epam.textparser.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ParagraphSorterTest {
    TextComposite text;
    List<TextComponent> expected;
    ParagraphSorter paragraphSorter;

    @BeforeClass
    public void setText() throws TextParserException {
        TextReader textReader = new TextReader();
        String textAsString = textReader.textInStringReader("src/test/resources/ForParagraphSorter.txt");
        TextParser textParser = TextParser.getInstance();
        text = textParser.parse(textAsString);
        
        expected = new ArrayList<>();
        ParagraphParser paragraphParser = ParagraphParser.getInstance();
        TextComponent paragraph1 = paragraphParser.parse("First paragraph one sentence.");
        TextComponent paragraph2 = paragraphParser.parse("Second paragraph. Two sentences.");
        TextComponent paragraph3 = paragraphParser.parse("Third paragraph. Three. Sentences.");
        TextComponent paragraph4 = paragraphParser.parse("Fourth. Paragraph. Four. Sentences.");
        expected.add(paragraph1);
        expected.add(paragraph2);
        expected.add(paragraph3);
        expected.add(paragraph4);

        paragraphSorter = new ParagraphSorter();
    }

    @Test
    public void sortParagraphTest() {
        List<TextComponent> actual = paragraphSorter.sortParagraph(text);
        Assert.assertEquals(actual,expected);
    }
}
