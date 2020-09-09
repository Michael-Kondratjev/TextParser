package epam.textparser.parser;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser implements Parser {

    static final String DELIMITER_INTO_SENTENCES = "(?<=!|\\.|/?)(\\s+)";

    @Override
    public TextComposite parse(String paragraph) {
        SentenceParser sentenceParser = new SentenceParser();
        List<TextComponent> sentenceList = new ArrayList<>();
        String[] sentenceArray = paragraph.split(DELIMITER_INTO_SENTENCES);
        for (String sentenceString : sentenceArray) {
            TextComponent sentence = sentenceParser.parse(sentenceString);
            sentenceList.add(sentence);
        }
        return new TextComposite(sentenceList);
    }
}
