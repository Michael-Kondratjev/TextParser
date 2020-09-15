package epam.textparser.sorter;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.TextComposite;

import java.util.*;

public class ParagraphSorter {

    public List<TextComposite> sortParagraph(TextComposite text) {
        List<TextComposite> paragraphList = text.getCompositeList();

        for (int i = 0; i < paragraphList.size() - 1 ; i++) {
            for (int j = i+1; j < paragraphList.size(); j++) {
                TextComposite left = paragraphList.get(i);
                TextComposite right = paragraphList.get(j);
                if(left.getCompositeList().size() >
                        right.getCompositeList().size()) {
                    paragraphList.set(i,right);
                    paragraphList.set(j, left);
                }
            }
        }
        return paragraphList;
    }
}

