import java.io.Serializable;

public class Character implements Serializable {
    private static final long serialVersionUID = 1L;
    private final char character;
    private final CharacterProperty property;

    public Character(char character, CharacterProperty property) {
        this.character = character;
        this.property = property;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterProperty getProperty() {
        return property;
    }
}

