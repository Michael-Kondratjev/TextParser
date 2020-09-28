package epam.textparser.composite.impl;

import epam.textparser.composite.TextComponent;
import epam.textparser.composite.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> content = new ArrayList<>();
    private TextComponentType type;

    public TextComposite(TextComponentType type) {
        this.type = type;
    }

    @Override
    public void add(TextComponent composite) {
        if (composite != null) {
            content.add(composite);
        }
    }

    @Override
    public void remove(TextComponent composite) {
        content.remove(composite);
    }
    @Override
    public List<TextComponent> getContent() {
        return content;
    }

    @Override
    public TextComponentType getType() { return type; }

    private StringBuilder contentToPrint(TextComponent textComponent) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (TextComponent child : content) {
            stringBuilder.append(child.toString());
        }
        return stringBuilder;
    }

    static final String BEFORE_PARAGRAPH = "\t";
    static final String AFTER_PARAGRAPH = "\n";
    static final String LEXEME_DELIMITER = " ";
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent child : content) {
            if (child.getType() == TextComponentType.PARAGRAPH) {
                stringBuilder.append(BEFORE_PARAGRAPH);
            }
            stringBuilder.append(child.toString());
            if (child.getType() == TextComponentType.PARAGRAPH) {
                stringBuilder.append(AFTER_PARAGRAPH);
            }
            if (child.getType() == TextComponentType.LEXEME) {
                stringBuilder.append(LEXEME_DELIMITER);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComposite that = (TextComposite) o;
        return content.equals(that.content) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        int result = (content != null ? content.hashCode() : 0);
        result += 31 * type.hashCode();
        return result;
    }
}
