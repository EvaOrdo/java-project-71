package hexlet.code;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DiffBuilder {
    public static Set<Map> buildDifference(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> commonKeys = new TreeSet<>();

        commonKeys.addAll(map1.keySet());
        commonKeys.addAll(map2.keySet());

        Set<Map> difference = new LinkedHashSet<>();

        for (var key : commonKeys) {
            Map<String, Object> map = new TreeMap<>();

            if (!map1.containsKey(key)) {
                map.put("status", "added");
                map.put("key", key);
                map.put("value2", map2.get(key));
            } else if (!map2.containsKey(key)) {
                map.put("status", "removed");
                map.put("key", key);
                map.put("value1", map1.get(key));
            } else {
                Object value1 = map1.get(key);
                Object value2 = map2.get(key);
                compareValues(map, key, value1, value2);
            }
            difference.add(map);
        }
        return difference;
    }

    public static void compareValues(Map<String, Object> map, String key, Object value1, Object value2) {
        if (Objects.equals(value1, value2)) {
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
}
