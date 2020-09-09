package epam.textparser.parser;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser implements Parser {

    static final String DELIMITER_INTO_LEXEMES = "\\s+";


    @Override
    public TextComposite parse(String sentence) {
        List<TextComponent> lexemaList = new ArrayList<>();
        LexemaParser lexemaParser = new LexemaParser();

        sentence = sentence.trim();
        String[] lexemaArray = sentence.split(DELIMITER_INTO_LEXEMES);
        for (String lexemaString : lexemaArray) {
            TextComponent lexema = lexemaParser.parse(lexemaString);
            lexemaList.add(lexema);
        }
        return new TextComposite(lexemaList);
    }
}
