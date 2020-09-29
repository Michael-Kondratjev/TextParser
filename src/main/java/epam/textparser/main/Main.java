package epam.textparser.main;

import epam.textparser.composite.impl.TextComposite;
import epam.textparser.exception.TextParserException;
import epam.textparser.parser.impl.TextParser;
import epam.textparser.reader.TextReader;
import epam.textparser.writer.ResultWriter;

public class Main {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        ResultWriter resultWriter = new ResultWriter();
        TextParser textParser = TextParser.getInstance();
        String s = "";
        try {
            s = textReader.textInStringReader("src/main/resources/Text_for_parsing.txt");
        } catch (TextParserException e) {
            e.printStackTrace();
        }
        System.out.println(s);
        TextComposite text = textParser.parse(s);
        System.out.println(text);
    }
}
