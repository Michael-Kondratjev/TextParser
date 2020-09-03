package epam.textparser.composite.impl;

import epam.textparser.composite.Component;

public class Symbol extends AbstractComponent {

    public Symbol(String s) {
        this.nativeString = s;
    }

    @Override
    public Component parse() {
        return null;
    }
}
