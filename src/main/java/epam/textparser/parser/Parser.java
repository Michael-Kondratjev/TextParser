package epam.textparser.parser;

import epam.textparser.composite.impl.TextComposite;

public interface Parser {
    TextComposite parse(String s);
}
