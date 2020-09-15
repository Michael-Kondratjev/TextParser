package epam.textparser.parser.impl;

import epam.textparser.arithmetic.ArithmeticExpressionProcessing;
import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.TextComposite;
import epam.textparser.parser.BasicParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceParser implements BasicParser {

    static final String DELIMITER_INTO_LEXEMES = "\\s+";


    @Override
    public TextComposite parse(String sentence) {
        List<TextComposite> lexemeList = new ArrayList<>();
        LexemeParser lexemeParser = new LexemeParser();
        ArithmeticExpressionProcessing arithmeticExpressionProcessing = new ArithmeticExpressionProcessing();

        sentence = sentence.trim();
        String[] lexemeAsStringArray = sentence.split(DELIMITER_INTO_LEXEMES);
        List<String> lexemeAsStringList = Arrays.asList(lexemeAsStringArray);
        ArrayList<String> lexemeAsStringArrayList = new ArrayList<>(lexemeAsStringList);
        arithmeticExpressionProcessing.process(lexemeAsStringArrayList);
        for (String lexemeAsString : lexemeAsStringArrayList) {
            TextComposite lexeme = lexemeParser.parse(lexemeAsString);
            lexemeList.add(lexeme);
        }
        TextComposite sentenceComposite = new TextComposite();
        sentenceComposite.setCompositeList(lexemeList);
        return sentenceComposite;
    }
}
