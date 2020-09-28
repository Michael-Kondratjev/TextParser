package epam.textparser.composite;


import java.util.List;

public interface TextComponent {

    void add(TextComponent composite);

    void remove(TextComponent composite);

    TextComponentType getType();

    List<TextComponent> getContent();

}
