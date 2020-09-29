package epam.textparser.parser.impl;

import epam.textparser.composite.TextComponentType;
import epam.textparser.composite.impl.Letter;
import epam.textparser.composite.impl.Punctuation;
import epam.textparser.composite.impl.TextComposite;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParagraphParserTest {

    char c1 = 'L';  char z1 = 'l'; char e1 = 'S';  char x1 = 'n'; char y1 = 't';
    char c2 = 'e';  char z2 = 'e'; char e2 = 'e';  char x2 = 'u'; char y2 = 'w';
    char c3 = 'x';  char z3 = 'x'; char e3 = 'n';  char x3 = 'm'; char y3 = 'o';
    char c4 = 'e';  char z4 = 'e'; char e4 = 't';  char x4 = 'b'; char y4 = '?';
    char c5 = 'm';  char z5 = 'm'; char e5 = 'e';  char x5 = 'e';
    char c6 = 'e';  char z6 = 'e'; char e6 = 'n';  char x6 = 'r';
    char c7 = ',';  char z7 = '!'; char e7 = 'c';
                                   char e8 = 'e';

    ParagraphParser paragraphParser;
    TextComposite paragraphExpected;

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

        TextComposite sentence1 = new TextComposite(TextComponentType.SENTENCE);
        sentence1.add(lexeme1);
        sentence1.add(lexeme2);

        TextComposite lexeme3 = new TextComposite(TextComponentType.LEXEME);
        lexeme3.add(new Letter(e1));
        lexeme3.add(new Letter(e2));
        lexeme3.add(new Letter(e3));
        lexeme3.add(new Letter(e4));
        lexeme3.add(new Letter(e5));
        lexeme3.add(new Letter(e6));
        lexeme3.add(new Letter(e7));
        lexeme3.add(new Letter(e8));

        TextComposite lexeme4 = new TextComposite(TextComponentType.LEXEME);
        lexeme4.add(new Letter(x1));
        lexeme4.add(new Letter(x2));
        lexeme4.add(new Letter(x3));
        lexeme4.add(new Letter(x4));
        lexeme4.add(new Letter(x5));
        lexeme4.add(new Letter(x6));

        TextComposite lexeme5 = new TextComposite(TextComponentType.LEXEME);
        lexeme5.add(new Letter(y1));
        lexeme5.add(new Letter(y2));
        lexeme5.add(new Letter(y3));
        lexeme5.add(new Punctuation(y4));

        TextComposite sentence2 = new TextComposite(TextComponentType.SENTENCE);
        sentence2.add(lexeme3);
        sentence2.add(lexeme4);
        sentence2.add(lexeme5);

        paragraphExpected = new TextComposite(TextComponentType.PARAGRAPH);
        paragraphExpected.add(sentence1);
        paragraphExpected.add(sentence2);

        paragraphParser = ParagraphParser.getInstance();
    }

    @Test
    public void sentenceParserTest() {
        String paragraphAsString = "Lexeme, lexeme! Sentence number two?";
        TextComposite paragraphActual = paragraphParser.parse(paragraphAsString);
        Assert.assertEquals(paragraphActual,paragraphExpected);
    }



}
