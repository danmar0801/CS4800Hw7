import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Document doc = new Document();
        String text = "HelloWorldCS5800";
        String[] fonts = {"Arial", "Calibri", "Verdana", "Arial"};
        int[] sizes = {12, 14, 16, 12};
        String[] colors = {"Red", "Blue", "Black", "Blue"};

        for (int i = 0; i < text.length(); i++) {
            CharacterProperty prop = CharacterPropertyFactory.getProperty(fonts[i % 4], sizes[i % 4],
                    colors[i % 4]);
            doc.addCharacter(text.charAt(i), prop);
        }

        FileManager.saveDocument(doc, "testDoc.txt");
        Document loadedDoc = FileManager.loadDocument("testDoc.txt");

        // Output loaded document
        for (Character c : loadedDoc.getCharacters()) {
            System.out.println(c.getCharacter() + " " + c.getProperty().getFont() + " " +
                    c.getProperty().getSize() + " " + c.getProperty().getColor());
        }
    }
}
