package epam.textparser.writer;

import epam.textparser.composite.TextComponent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {

    public void writerInFile(TextComponent textComponent) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/main/resources/Result.txt")
        )) {
            bufferedWriter.write(textComponent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
////
    }
}
