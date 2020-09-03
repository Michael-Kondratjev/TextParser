package epam.textparser.main;

import epam.textparser.exception.TextParserException;
import epam.textparser.parser.StringParser;
import epam.textparser.reader.TextReader;
import epam.textparser.writer.ResultWriter;

public class Main {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        ResultWriter resultWriter = new ResultWriter();
        StringParser stringParser = new StringParser();
        String s = "";
        try {
            s = textReader.textInStringReader("src/main/resources/Data.txt");
        } catch (TextParserException e) {
            e.printStackTrace();
        }
        resultWriter.writerInFile(stringParser.parseStringToText(s));
    }

}
