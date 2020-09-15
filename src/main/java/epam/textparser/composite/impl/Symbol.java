package epam.textparser.composite.impl;


import epam.textparser.composite.TextComponent;

public class Symbol extends TextComposite {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
