package epam.textparser.composite.impl;

import epam.textparser.composite.TextComponent;

import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComposite> compositeList;

    public List<TextComposite> getCompositeList() {
        return compositeList;
    }

    public void setCompositeList(List<TextComposite> compositeList) {
        this.compositeList = compositeList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (TextComponent textComponent : compositeList) {
            stringBuilder.append(textComponent.toString());
        }
        return stringBuilder.toString();
    }
}
