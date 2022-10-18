package hexlet.code;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {
    public static String generate(Map<String, Object> map1, Map<String, Object> map2, String formatName)
            throws Exception {
        Set<String> commonKeys = new TreeSet<>();
        commonKeys.addAll(map1.keySet());
        commonKeys.addAll(map2.keySet());

        Set<Map> diff = new LinkedHashSet<>();

        for (var key : commonKeys) {
            Object value1 = map1.get(key) != null ? map1.get(key) : "null";
            Object value2 = map2.get(key) != null ? map2.get(key) : "null";
            Map<String, Object> map = new TreeMap<>();
            if (!map1.containsKey(key)) {
                map.put("status", "added");
                map.put("key", key);
                map.put("value2", value2);
            } else if (!map2.containsKey(key)) {
                map.put("status", "removed");
                map.put("key", key);
                map.put("value1", value1);
            } else {
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
            }
            diff.add(map);
        }
        System.out.println(Formatter.format(diff, formatName));
        return Formatter.format(diff, formatName);
    }
}
