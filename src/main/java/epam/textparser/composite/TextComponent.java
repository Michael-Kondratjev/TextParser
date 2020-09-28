package epam.textparser.composite;


public interface TextComponent {

    void add(TextComponent composite);

    void remove(TextComponent composite);

    TextComponentType getType();

}
