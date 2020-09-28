package epam.textparser.sorter;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.impl.TextComposite;
import epam.textparser.exception.TextParserException;
import epam.textparser.parser.impl.TextParser;
import epam.textparser.reader.TextReader;
import epam.textparser.writer.ResultWriter;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        TextReader textReader = new TextReader();
        ResultWriter resultWriter = new ResultWriter();
        TextParser textParser = TextParser.getInstance();
        String s = "";
        try {
            s = textReader.textInStringReader("src/main/resources/Data.txt");
        } catch (TextParserException e) {
            e.printStackTrace();
        }
        TextComposite text = textParser.parse(s);

        SentenceByLexemesSorter sentencesByWordsSorter = new SentenceByLexemesSorter();
        List<TextComponent> list = sentencesByWordsSorter.sortSentencesByLexemes(text);
        for (TextComponent textComponent : list) {
            System.out.println(textComponent);
        }
    }
}
