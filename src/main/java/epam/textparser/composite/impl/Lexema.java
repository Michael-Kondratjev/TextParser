package epam.textparser.composite.impl;

import epam.textparser.composite.Component;

public class Lexema extends AbstractComponent {

    public Lexema(String s) {
        this.nativeString = s;
    }

    @Override
    public Lexema parse() {
        String content = nativeString.trim();
        char[] componentsArray = content.toCharArray();
        for (char c : componentsArray) {
            String s = String.valueOf(c);
            Symbol symbol = new Symbol(s);
            componentsList.add(symbol);
        }
        return this;

    }
}
