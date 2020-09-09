package epam.textparser.composite.impl;

import epam.textparser.composite.TextComponent;

import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> componentList;

    public TextComposite(List<TextComponent> componentList) {
        this.componentList = componentList;
    }
}
