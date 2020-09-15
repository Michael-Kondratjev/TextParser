package epam.textparser.parser.impl;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.Symbol;
import epam.textparser.composite.impl.TextComposite;
import epam.textparser.parser.BasicParser;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser implements BasicParser {

    static final String DELIMITER_INTO_SENTENCES = "(?<=[.!?])\\s+";
    //static final char DELIMITER_BEFORE_PARAGRAPH = '\t';
    //static final char DELIMITER_AFTER_PARAGRAPH = '\n';

    @Override
    public TextComposite parse(String paragraph) {
        SentenceParser sentenceParser = new SentenceParser();
        List<TextComposite> sentenceList = new ArrayList<>();
        //sentenceList.add(new Symbol(DELIMITER_BEFORE_PARAGRAPH));
        String[] sentenceArray = paragraph.split(DELIMITER_INTO_SENTENCES);
        for (String sentenceString : sentenceArray) {
            TextComposite sentence = sentenceParser.parse(sentenceString);
            sentenceList.add(sentence);
        }
        //sentenceList.add(new Symbol(DELIMITER_AFTER_PARAGRAPH));
        TextComposite paragraphComposite = new TextComposite();
        paragraphComposite.setCompositeList(sentenceList);
        return paragraphComposite;
    }
}
