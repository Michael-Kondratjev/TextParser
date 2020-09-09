package epam.textparser.parser;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class TextParser implements Parser {

    static final String DELIMITER_INTO_PARAGRAPHS = "\t";

    @Override
    public TextComposite parse(String text) {
        ParagraphParser paragraphParser = new ParagraphParser();
        List<TextComponent> paragraphList = new ArrayList<>();
        String[] paragraphArray = text.split(DELIMITER_INTO_PARAGRAPHS);
        for (String paragraphString : paragraphArray) {
            TextComponent paragraph = paragraphParser.parse(paragraphString);
            paragraphList.add(paragraph);
        }
        return new TextComposite(paragraphList);
    }
}
