package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Plain {
    public static String render(Set<Map> diff) {
        StringBuilder result = new StringBuilder();
        for (Map map : diff) {
            String status = (String) map.get("status");
            String key = (String) map.get("key");
            Object value1 = map.get("value1");
            Object value2 = map.get("value2");

            if (value1 instanceof List<?> || value1 instanceof Map<?, ?>) {
                value1 = "[complex value]";
            } else if (value1 instanceof String) {
                value1 = "'%s'".formatted(value1);
            }

            if (value2 instanceof List<?> || value2 instanceof Map<?, ?>) {
                value2 = "[complex value]";
            } else if (value2 instanceof String) {
                value2 = "'%s'".formatted(value2);
            }
            switch (status) {
                case "added" -> result
                        .append("Property '%s' was added with value: %s\n".formatted(key, value2));
                case "removed" -> result
                        .append("Property '%s' was removed\n".formatted(key));
                case "changed" -> result
                        .append("Property '%s' was updated. From %s to %s\n".formatted(key, value1, value2));
                default -> {
                }
            }
        }
        return result.toString().trim();
    }
}
