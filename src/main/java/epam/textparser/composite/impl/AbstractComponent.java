package epam.textparser.composite.impl;

import epam.textparser.composite.Component;

import java.util.List;

public abstract class AbstractComponent implements Component {

    protected String nativeString;
    List<Component> componentsList;

    public abstract Component parse();
}
