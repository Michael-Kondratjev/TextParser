package epam.textparser.parser;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.Symbol;
import epam.textparser.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class LexemaParser implements Parser {


    @Override
    public TextComposite parse(String lexema) {
        List<TextComponent> symbolList = new ArrayList<>();

        char[] symbolArray = lexema.toCharArray();
        for (char symbolChar : symbolArray) {
            TextComponent symbol = new Symbol(symbolChar);
            symbolList.add(symbol);
        }
        return new TextComposite(symbolList);
    }
}
