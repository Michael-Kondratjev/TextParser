package epam.textparser.composite.impl;

public class Paragraph extends AbstractComponent {

    public Paragraph(String s) {
        this.nativeString = s;
    }

    @Override
    public Paragraph parse() {
        String content = nativeString.trim();
        String[] componentsArray = content.split(Delimiters.PARAGRAPH.getDelimiter());
        for (String s : componentsArray) {
            Sentence sentence = new Sentence(s);
            sentence = sentence.parse();
            componentsList.add(sentence);
        }
        return this;

    }
}
