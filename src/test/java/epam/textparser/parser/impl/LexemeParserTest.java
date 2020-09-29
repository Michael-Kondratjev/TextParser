package epam.textparser.parser.impl;

import epam.textparser.composite.TextComponentType;
import epam.textparser.composite.impl.Letter;
import epam.textparser.composite.impl.Punctuation;
import epam.textparser.composite.impl.TextComposite;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LexemeParserTest {
    char c1 = 'l';
    char c2 = 'e';
    char c3 = 'x';
    char c4 = 'e';
    char c5 = 'm';
    char c6 = 'e';
    char c7 = ',';

    LexemeParser lexemeParser;
    TextComposite lexemeExpected;

    @BeforeClass
    public void setUp() {
        lexemeExpected = new TextComposite(TextComponentType.LEXEME);
        lexemeExpected.add(new Letter(c1));
        lexemeExpected.add(new Letter(c2));
        lexemeExpected.add(new Letter(c3));
        lexemeExpected.add(new Letter(c4));
        lexemeExpected.add(new Letter(c5));
        lexemeExpected.add(new Letter(c6));
        lexemeExpected.add(new Punctuation(c7));

        lexemeParser = LexemeParser.getInstance();
    }

    @Test
    public void lexemeParserTest() {
        String lexemeAsString = "lexeme,";
        TextComposite lexemeActual = lexemeParser.parse(lexemeAsString);
        Assert.assertEquals(lexemeActual,lexemeExpected);
    }



}
