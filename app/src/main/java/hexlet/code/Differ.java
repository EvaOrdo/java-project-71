package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> map1 = Parser.parseString(filepath1);
        Map<String, Object> map2 = Parser.parseString(filepath2);

        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        String result = "{\n";

        for (String key : keys) {
            Object value1 = map1.get(key) != null ? map1.get(key) : "null";
            Object value2 = map2.get(key) != null ? map2.get(key) : "null";
            if (!map1.containsKey(key)) {
                result += "  + " + key + ": " + value2 + "\n";
            } else if (!map2.containsKey(key)) {
                result += "  - " + key + ": " + value1 + "\n";
            } else {
                if (value1.equals(value2)) {
                    result += "    " + key + ": " + value1 + "\n";
                } else {
                    result += "  - " + key + ": " + value1 + "\n"
                            + "  + " + key + ": " + value2 + "\n";
                }
            }
        }
        System.out.println(result + "}");
        return result + "}";
    }
}
