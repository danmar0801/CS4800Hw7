import java.util.HashMap;
import java.util.Map;

public class CharacterPropertyFactory {
    private static final Map<String, CharacterProperty> properties = new HashMap<>();

    public static CharacterProperty getProperty(String font, int size, String color) {
        String key = font + size + color;
        CharacterProperty property = properties.get(key);
        if (property == null) {
            property = new CharacterProperty(font, size, color);
            properties.put(key, property);
        }
        return property;
    }
}

