package epam.textparser.main;

import epam.textparser.composite.impl.TextComposite;
import epam.textparser.exception.TextParserException;
import epam.textparser.parser.impl.TextParser;
import epam.textparser.reader.TextReader;
import epam.textparser.sorter.SentencesByLexemesSorter;
import epam.textparser.writer.ResultWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        ResultWriter resultWriter = new ResultWriter();
        TextParser textParser = new TextParser();
        String s = "";
        try {
            s = textReader.textInStringReader("src/main/resources/Data.txt");
        } catch (TextParserException e) {
            e.printStackTrace();
        }
        TextComposite text = textParser.parse(s);

        System.out.println(text);
    }

}
