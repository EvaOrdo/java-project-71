package hexlet.code;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2, String formatName)
            throws Exception {
        Map<String, Object> map1 = Parser.parseString(filepath1);
        Map<String, Object> map2 = Parser.parseString(filepath2);

        Set<String> commonKeys = new TreeSet<>();

        commonKeys.addAll(map1.keySet());
        commonKeys.addAll(map2.keySet());

        Set<Map> diff = new LinkedHashSet<>();

        for (var key : commonKeys) {
            Map<String, Object> map = new TreeMap<>();

            if (!map1.containsKey(key)) {
                map.put("status", "added");
                map.put("key", key);
                map.put("value2", map2.get(key));
            }

            if (!map2.containsKey(key)) {
                map.put("status", "removed");
                map.put("key", key);
                map.put("value1", map1.get(key));
            }
            if (map1.containsKey(key) && map2.containsKey(key)) {
                Object value1 = map1.get(key);
                Object value2 = map2.get(key);
                if (value1 != null) {
                    if (value1.equals(value2)) {
                        map.put("status", "unchanged");
                        map.put("key", key);
                        map.put("value1", value1);
                    } else {
                        map.put("status", "changed");
                        map.put("key", key);
                        map.put("value1", value1);
                        map.put("value2", value2);
                    }
                } else if (value1 == null) {
                    if (value2 != null) {
                        map.put("status", "changed");
                        map.put("key", key);
                        map.put("value1", null);
                        map.put("value2", value2);
                    } else {
                        map.put("status", "unchanged");
                        map.put("key", key);
                        map.put("value1", null);
                    }
                }
            }
            diff.add(map);
        }
        System.out.println(Formatter.format(diff, formatName));
        return Formatter.format(diff, formatName);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
