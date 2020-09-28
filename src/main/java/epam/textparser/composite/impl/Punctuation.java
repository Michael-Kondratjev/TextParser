package epam.textparser.composite.impl;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.TextComponentType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Punctuation implements TextComponent {
    private char symbol;
    private TextComponentType type = TextComponentType.SYMBOL;
    Logger logger = LogManager.getLogger();

    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(TextComponent composite) {
        logger.log(Level.WARN, "Component type SYMBOL don't support operation \"add\"");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent composite) {
        logger.log(Level.WARN, "Component type SYMBOL don't support operation \"add\"");
        throw new UnsupportedOperationException();
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public TextComponentType getType() { return type; }

    @Override
    public List<TextComponent> getContent() {
        logger.log(Level.WARN, "Component type SYMBOL don't support operation \"getContent\"");
        throw new UnsupportedOperationException();
    }


    @Override
    public String toString() {
        return Character.toString(symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punctuation that = (Punctuation) o;
        return symbol == that.getSymbol() &&
                type == that.getType();
    }

    @Override
    public int hashCode() {
        return type.hashCode()* (int) symbol;
    }

}
