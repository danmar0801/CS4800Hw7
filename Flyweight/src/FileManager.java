import java.io.*;

public class FileManager {
    public static void saveDocument(Document doc, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(doc);
        }
    }

    public static Document loadDocument(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Document) in.readObject();
        }
    }
}
