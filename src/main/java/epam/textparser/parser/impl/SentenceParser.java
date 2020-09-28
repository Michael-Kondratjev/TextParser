package epam.textparser.parser.impl;

import epam.textparser.arithmetic.ArithmeticExpressionProcessing;
import epam.textparser.composite.TextComponent;
import epam.textparser.composite.TextComponentType;
import epam.textparser.composite.impl.TextComposite;
import epam.textparser.parser.BasicParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceParser implements BasicParser {
    private static SentenceParser instance = new SentenceParser();

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        return instance;
    }

    static final String LEXEME_DELIMITER = "\\s+";


    @Override
    public TextComposite parse(String sentenceAsString) {
        TextComposite sentence = new TextComposite(TextComponentType.SENTENCE);
        LexemeParser lexemeParser = LexemeParser.getInstance();
        ArithmeticExpressionProcessing arithmeticProcessing = new ArithmeticExpressionProcessing();

        sentenceAsString = sentenceAsString.trim();
        String[] lexemeAsStringArray = sentenceAsString.split(LEXEME_DELIMITER);
        List<String> lexemeAsStringList = Arrays.asList(lexemeAsStringArray);
        ArrayList<String> lexemeAsStringArrayList = new ArrayList<>(lexemeAsStringList);
        arithmeticProcessing.process(lexemeAsStringArrayList);
        for (String lexemeAsString : lexemeAsStringArrayList) {
            TextComposite lexeme = lexemeParser.parse(lexemeAsString);
            sentence.add(lexeme);
        }
        return sentence;
    }
}
