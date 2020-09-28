package epam.textparser.sorter;

import epam.textparser.composite.impl.TextComposite;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class LexemeSorter {

    public SortedSet<TextComposite> sortLexemesByLetterO(TextComposite text) {
        Set<TextComposite> lexemesSortedSet = new TreeSet<TextComposite>() {
            @Override
            public Comparator<? super TextComposite> comparator() {
                return super.comparator();
            }
        };
        return null;
    }
}
