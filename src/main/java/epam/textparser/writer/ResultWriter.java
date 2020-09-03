package epam.textparser.writer;

import epam.textparser.composite.impl.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {
    public void writerInFile(Text text) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("src/main/resources/Result.txt")
        )) {
            bufferedWriter.write(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
////
    }
}
