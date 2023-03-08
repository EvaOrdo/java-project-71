package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Plain {
    public static String render(Set<Map> diff) {
        StringBuilder result = new StringBuilder();
        for (Map map : diff) {
            String status = (String) map.get("status");
            String key = (String) map.get("key");
            Object value1 = valueProcessing(map.get("value1"));
            Object value2 = valueProcessing(map.get("value2"));

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

    public static Object valueProcessing(Object val) {
        if (val instanceof List<?> || val instanceof Map<?, ?>) {
            return "[complex value]";
        } else if (val instanceof String) {
            return "'%s'".formatted(val);
        }
        return val;
    }
}
