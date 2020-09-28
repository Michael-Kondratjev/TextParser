package epam.textparser.sorter;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.Letter;
import epam.textparser.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class SentenceByWordsSorter {
    public List<TextComponent> sortSentencesByLexemes(TextComposite text) {
        List<TextComponent> sentenceList = new ArrayList<>();

        List<TextComponent> paragraphList = text.getContent();
        for (TextComponent paragraph : paragraphList) {
            List<TextComponent> SentenceUnsortedList = paragraph.getContent();
            sentenceList.addAll(SentenceUnsortedList);
        }

        for (int i = 0; i < sentenceList.size() - 1 ; i++) {
            for (int j = i+1; j < sentenceList.size(); j++) {
                TextComponent left = sentenceList.get(i);
                TextComponent right = sentenceList.get(j);
                if(sentenceLengthByWords(left) >
                        sentenceLengthByWords(right)) {
                    sentenceList.set(i,right);
                    sentenceList.set(j, left);
                }
            }
        }
        return sentenceList;
    }

    private int sentenceLengthByWords(TextComponent sentence) {
        int length = 0;
        List<TextComponent> lexemeList = sentence.getContent();
        for (TextComponent lexeme : lexemeList) {
            List<TextComponent> symbolsList = lexeme.getContent();
            for (TextComponent symbol : symbolsList) {
                if (symbol instanceof Letter) {
                    length++;
                }
            }
        }
        return length;
    }

}
