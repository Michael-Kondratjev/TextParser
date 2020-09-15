package epam.textparser.sorter;

import epam.textparser.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class SentencesByLexemesSorter {

    public List<TextComposite> sortSentencesByLexemes(TextComposite text) {
        List<TextComposite> sentenceList = new ArrayList<>();

        List<TextComposite> paragraphList = text.getCompositeList();
        for (TextComposite paragraph : paragraphList) {
            List<TextComposite> rawSentenceList = paragraph.getCompositeList();
            sentenceList.addAll(rawSentenceList);
        }

        for (int i = 0; i < sentenceList.size() - 1 ; i++) {
            for (int j = i+1; j < sentenceList.size(); j++) {
                TextComposite left = sentenceList.get(i);
                TextComposite right = sentenceList.get(j);
                if(sentenceLength(left) >
                        sentenceLength(right)) {
                    sentenceList.set(i,right);
                    sentenceList.set(j, left);
                }
            }
        }
        return sentenceList;
    }

    private int sentenceLength(TextComposite sentence) {
        List<TextComposite> lexemeList = sentence.getCompositeList();
        int length = 0;
        for (TextComposite lexeme : lexemeList) {
            length += lexeme.getCompositeList().size();
        }
        return length;
    }

}
