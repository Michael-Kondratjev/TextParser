package epam.textparser.parser.impl;

import epam.textparser.composite.TextComponentType;
import epam.textparser.composite.impl.TextComposite;
import epam.textparser.parser.BasicParser;

public class ParagraphParser implements BasicParser {
    private static ParagraphParser instance = new ParagraphParser();

    private ParagraphParser() {
    }

    public static ParagraphParser getInstance() {
        return instance;
    }

    static final String SENTENCE_DELIMITER = "(?<=[.!?])\\s+";

    @Override
    public TextComposite parse(String paragraphAsString) {
        TextComposite paragraph = new TextComposite(TextComponentType.PARAGRAPH);
        SentenceParser sentenceParser = SentenceParser.getInstance();

        String[] sentenceArray = paragraphAsString.split(SENTENCE_DELIMITER);
        for (String sentenceAsString : sentenceArray) {
            TextComposite sentence = sentenceParser.parse(sentenceAsString);
            paragraph.add(sentence);
        }
        return paragraph;
    }
}
