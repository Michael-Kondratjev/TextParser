package epam.textparser.sorter;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.TextComposite;

import java.util.*;

public class ParagraphSorter {

    public List<TextComponent> sortParagraph(TextComposite text) {
        List<TextComponent> paragraphList = text.getContent();

        for (int i = 0; i < paragraphList.size() - 1 ; i++) {
            for (int j = i+1; j < paragraphList.size(); j++) {
                TextComponent left = paragraphList.get(i);
                TextComponent right = paragraphList.get(j);
                if(left.getContent().size() >
                        right.getContent().size()) {
                    paragraphList.set(i,right);
                    paragraphList.set(j, left);
                }
            }
        }
        return paragraphList;
    }
}

