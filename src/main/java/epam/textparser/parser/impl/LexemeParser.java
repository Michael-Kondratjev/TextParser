package epam.textparser.parser.impl;

import epam.textparser.composite.impl.Symbol;
import epam.textparser.composite.impl.TextComposite;
import epam.textparser.parser.BasicParser;

import java.util.ArrayList;
import java.util.List;

public class LexemeParser implements BasicParser {

    static final char DELIMITER_BETWEEN_LEXEMES = ' ';

    @Override
    public TextComposite parse(String lexema) {
        List<TextComposite> symbolList = new ArrayList<>();

        char[] symbolArray = lexema.toCharArray();
        for (char symbolChar : symbolArray) {
            TextComposite symbol = new Symbol(symbolChar);
            symbolList.add(symbol);
        }
        symbolList.add(new Symbol(DELIMITER_BETWEEN_LEXEMES));

        TextComposite lexemeComposite = new TextComposite();
        lexemeComposite.setCompositeList(symbolList);
        return lexemeComposite;
    }
}
