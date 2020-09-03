package epam.textparser.parser;

import epam.textparser.composite.impl.Text;

public class StringParser {

    public Text parseStringToText(String rawText) {
        Text text = new Text(rawText);
        return text.parse();
    }
}
