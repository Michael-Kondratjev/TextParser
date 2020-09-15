package epam.textparser.arithmetic;

import static epam.textparser.arithmetic.Variable.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VariableReplacement {

    void replaceVariableJ(List<String> strings) {
        Pattern pattern = Pattern.compile("(-{2}|\\+{2})j|j(-{2}|\\+{2})");
        for (int k = 0; k < strings.size(); k++) {
            String lexeme = strings.get(k);
            Matcher matcher = pattern.matcher(lexeme);
            if (matcher.find()) {
                String forReplacement = matcher.group();
                if (forReplacement.equals("++j")) {
                    ++J;
                    lexeme = lexeme.replace(forReplacement, J.toString());
                }
                if (forReplacement.equals("j++")) {
                    lexeme = lexeme.replace(forReplacement, J.toString());
                    J++;
                }
                if (forReplacement.equals("--j")) {
                    --J;
                    lexeme = lexeme.replace(forReplacement, J.toString());
                }
                if (forReplacement.equals("j--")) {
                    lexeme = lexeme.replace(forReplacement, J.toString());
                    J--;
                }
            }
            strings.set(k,lexeme);
        }
    }

    void replaceVariableI(List<String> strings) {
        Pattern pattern = Pattern.compile("(-{2}|\\+{2})i|i(-{2}|\\+{2})");
        for (int k = 0; k < strings.size(); k++) {
            String lexeme = strings.get(k);
            Matcher matcher = pattern.matcher(lexeme);
            if (matcher.find()) {
                String forReplacement = matcher.group();
                if (forReplacement.equals("++i")) {
                    ++I;
                    lexeme = lexeme.replace(forReplacement, I.toString());
                }
                if (forReplacement.equals("i++")) {
                    lexeme = lexeme.replace(forReplacement, I.toString());
                    I++;
                }
                if (forReplacement.equals("--i")) {
                    --I;
                    lexeme = lexeme.replace(forReplacement, I.toString());
                }
                if (forReplacement.equals("i--")) {
                    lexeme = lexeme.replace(forReplacement, I.toString());
                    I--;
                }
            }
            strings.set(k,lexeme);
        }
    }
}