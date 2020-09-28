package epam.textparser.parser.impl;

import epam.textparser.composite.TextComponentType;
import epam.textparser.composite.impl.TextComposite;
import epam.textparser.parser.BasicParser;

public class TextParser implements BasicParser {
    private static TextParser instance = new TextParser();

    private TextParser() {
    }

    public static TextParser getInstance() {
        return instance;
    }

    static final String PARAGRAPH_DELIMITER = "\\n {4}";

    @Override
    public TextComposite parse(String textAsString) {
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        textAsString = textAsString.trim();
        ParagraphParser paragraphParser = ParagraphParser.getInstance();
        String[] paragraphArray = textAsString.split(PARAGRAPH_DELIMITER);
        for (String paragraphAsString : paragraphArray) {
            TextComposite paragraph = paragraphParser.parse(paragraphAsString);
            text.add(paragraph);
        }
        return text;
    }
}
