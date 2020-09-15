package epam.textparser.parser.impl;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.TextComposite;
import epam.textparser.parser.BasicParser;

import java.util.ArrayList;
import java.util.List;

public class TextParser implements BasicParser {

    static final String DELIMITER_INTO_PARAGRAPHS = "\\n {4}";

    @Override
    public TextComposite parse(String text) {
        text = text.trim();
        ParagraphParser paragraphParser = new ParagraphParser();
        List<TextComposite> paragraphList = new ArrayList<>();
        String[] paragraphArray = text.split(DELIMITER_INTO_PARAGRAPHS);
        for (String paragraphString : paragraphArray) {
            TextComposite paragraph = paragraphParser.parse(paragraphString);
            paragraphList.add(paragraph);
        }
        TextComposite textComposite = new TextComposite();
        textComposite.setCompositeList(paragraphList);
        return textComposite;
    }
}
