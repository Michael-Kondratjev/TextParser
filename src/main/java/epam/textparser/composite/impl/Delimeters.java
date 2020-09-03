package epam.textparser.composite.impl;

enum Delimiters {
    TEXT("\\t"), PARAGRAPH("[?!\\.]"), SENTENCE("\\s");

    private final String delimiter;

   Delimiters(String del){
        delimiter = del;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
