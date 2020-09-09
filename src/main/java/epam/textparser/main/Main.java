package epam.textparser.main;

import epam.textparser.exception.TextParserException;
import epam.textparser.parser.TextParser;
import epam.textparser.reader.TextReader;
import epam.textparser.writer.ResultWriter;

public class Main {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        ResultWriter resultWriter = new ResultWriter();
        TextParser stringParser = new TextParser();
        String s = "";
        try {
            s = textReader.textInStringReader("src/main/resources/Data.txt");
        } catch (TextParserException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

}
