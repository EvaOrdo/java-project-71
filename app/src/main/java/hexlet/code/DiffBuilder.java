package hexlet.code;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DiffBuilder {
    public static Set<Map> buildDifference(Set<String> keys, Map<String, Object> map1, Map<String, Object> map2) {
        Set<Map> difference = new LinkedHashSet<>();

        for (var key : keys) {
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
            difference.add(map);
        }
        return difference;
    }
}
