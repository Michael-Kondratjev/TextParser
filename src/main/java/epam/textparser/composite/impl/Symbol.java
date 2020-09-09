package epam.textparser.composite.impl;


import epam.textparser.composite.TextComponent;

public class Symbol implements TextComponent {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }
}
