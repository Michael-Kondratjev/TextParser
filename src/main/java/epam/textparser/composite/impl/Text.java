package epam.textparser.composite.impl;

public class Text extends AbstractComponent {

    public Text(String s){
        this.nativeString = s;
    }

    @Override
    public Text parse() {
        String content = nativeString.trim();
        String[] componentsArray = content.split(Delimiters.TEXT.getDelimiter());
        for (String s : componentsArray) {
            Paragraph paragraph = new Paragraph(s);
            paragraph = paragraph.parse();
            componentsList.add(paragraph);
        }
        return this;
    }

    @Override
    public String toString() {
        return componentsList.toString();
    }
}
