package epam.textparser.composite.impl;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.TextComponentType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Letter implements TextComponent {
    private final char letter;
    private final TextComponentType type = TextComponentType.LETTER;
    Logger logger = LogManager.getLogger();

    public Letter(char letter) {
        this.letter = letter;
    }

    @Override
    public void add(TextComponent composite) {
        logger.log(Level.WARN, "Component type LETTER don't support operation \"add\"");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent composite) {
        logger.log(Level.WARN, "Component type LETTER don't support operation \"add\"");
        throw new UnsupportedOperationException();
    }

    public char getContent() {
        return letter;
    }

    @Override
    public TextComponentType getType() { return type; }

    @Override
    public String toString() {
        return Character.toString(letter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter that = (Letter) o;
        return letter == that.getContent() &&
                type == that.getType();
    }

    @Override
    public int hashCode() {
        return type.hashCode()* (int) letter;
    }

}
