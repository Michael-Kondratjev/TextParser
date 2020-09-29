package epam.textparser.parser.impl;

import epam.textparser.composite.TextComponentType;
import epam.textparser.composite.impl.Letter;
import epam.textparser.composite.impl.Punctuation;
import epam.textparser.composite.impl.TextComposite;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SentenceParserTest {
    char c1 = 'L';  char z1 = 'l';
    char c2 = 'e';  char z2 = 'e';
    char c3 = 'x';  char z3 = 'x';
    char c4 = 'e';  char z4 = 'e';
    char c5 = 'm';  char z5 = 'm';
    char c6 = 'e';  char z6 = 'e';
    char c7 = ',';  char z7 = '!';

    SentenceParser sentenceParser;
    TextComposite sentenceExpected;

    @BeforeClass
    public void setUp() {
        TextComposite lexeme1 = new TextComposite(TextComponentType.LEXEME);
        lexeme1.add(new Letter(c1));
        lexeme1.add(new Letter(c2));
        lexeme1.add(new Letter(c3));
        lexeme1.add(new Letter(c4));
        lexeme1.add(new Letter(c5));
        lexeme1.add(new Letter(c6));
        lexeme1.add(new Punctuation(c7));

        TextComposite lexeme2 = new TextComposite(TextComponentType.LEXEME);
        lexeme2.add(new Letter(z1));
        lexeme2.add(new Letter(z2));
        lexeme2.add(new Letter(z3));
        lexeme2.add(new Letter(z4));
        lexeme2.add(new Letter(z5));
        lexeme2.add(new Letter(z6));
        lexeme2.add(new Punctuation(z7));

        sentenceExpected = new TextComposite(TextComponentType.SENTENCE);
        sentenceExpected.add(lexeme1);
        sentenceExpected.add(lexeme2);

        sentenceParser = SentenceParser.getInstance();
    }

    @Test
    public void sentenceParserTest() {
        String sentenceAsString = "Lexeme, lexeme!";
        TextComposite sentenceActual = sentenceParser.parse(sentenceAsString);
        Assert.assertEquals(sentenceActual,sentenceExpected);
    }



}
