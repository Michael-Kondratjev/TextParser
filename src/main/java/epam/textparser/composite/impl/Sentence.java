package epam.textparser.composite.impl;

import epam.textparser.composite.Component;

public class Sentence extends AbstractComponent {

    public Sentence(String s) {
        this.nativeString = s;
    }

    @Override
    public Sentence parse() {
        String content = nativeString.trim();
        String[] componentsArray = content.split(Delimiters.SENTENCE.getDelimiter());
        for (String s : componentsArray) {
            Lexema lexema = new Lexema(s);
            lexema = lexema.parse();
            componentsList.add(lexema);
        }
        return this;
    }
}
