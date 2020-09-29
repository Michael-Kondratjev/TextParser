package epam.textparser.reader;

import epam.textparser.exception.TextParserException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

    private static final Logger logger = LogManager.getLogger();

    public String textInStringReader(String filePath) throws TextParserException {
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((str = br.readLine()) != null) {
                stringBuilder.append(str).append("\n");
            }
        } catch (IOException e) {
                logger.log(Level.ERROR, "Reading file error");
                throw new TextParserException("Reading file error", e);
        }
        return stringBuilder.toString();
    }
}
