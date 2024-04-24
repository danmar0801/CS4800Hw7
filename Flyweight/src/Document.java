import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<Character> characters = new ArrayList<>();

    public void addCharacter(char character, CharacterProperty property) {
        characters.add(new Character(character, property));
    }

    public List<Character> getCharacters() {
        return characters;
    }
}

