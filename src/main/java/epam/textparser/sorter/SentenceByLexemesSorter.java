package epam.textparser.sorter;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.Letter;
import epam.textparser.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class SentenceByLexemesSorter {


    public List<TextComponent> sortSentencesByLexemes(TextComposite text) {
        List<TextComponent> sentenceList = new ArrayList<>();

        List<TextComponent> paragraphList = text.getContent();
        for (TextComponent paragraph : paragraphList) {
            List<TextComponent> sentenceUnsortedList = paragraph.getContent();
            sentenceList.addAll(sentenceUnsortedList);
        }

        for (int i = 0; i < sentenceList.size() - 1 ; i++) {
            for (int j = i+1; j < sentenceList.size(); j++) {
                TextComponent left = sentenceList.get(i);
                TextComponent right = sentenceList.get(j);
                if(sentenceLengthByLexemes(left) >
                        sentenceLengthByLexemes(right)) {
                    sentenceList.set(i,right);
                    sentenceList.set(j, left);
                }
            }
        }
        return sentenceList;
    }

    private int sentenceLengthByLexemes(TextComponent sentence) {
        List<TextComponent> lexemeList = sentence.getContent();
        int length = 0;
        for (TextComponent lexeme : lexemeList) {
            length += lexeme.getContent().size();
        }
        return length;
    }

}
