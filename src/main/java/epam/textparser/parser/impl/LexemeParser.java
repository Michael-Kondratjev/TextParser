package epam.textparser.parser.impl;

import epam.textparser.composite.TextComponentType;
import epam.textparser.composite.impl.Letter;
import epam.textparser.composite.impl.Punctuation;
import epam.textparser.composite.impl.TextComposite;
import epam.textparser.parser.BasicParser;

public class LexemeParser implements BasicParser {
    private static LexemeParser instance = new LexemeParser();

    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        return instance;
    }

    @Override
    public TextComposite parse(String lexemeAsString) {
        TextComposite lexeme = new TextComposite(TextComponentType.LEXEME);

        char[] symbolArray = lexemeAsString.toCharArray();
        for (char symbol : symbolArray) {
            if (Character.isLetterOrDigit(symbol)) {
                Letter letter = new Letter(symbol);
                lexeme.add(letter);
            } else {
                lexeme.add(new Punctuation(symbol));
            }
        }
        return lexeme;
    }
}
