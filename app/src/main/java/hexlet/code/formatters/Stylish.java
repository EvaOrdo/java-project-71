package hexlet.code.formatters;

import java.util.Map;
import java.util.Set;

public class Stylish {
    public static String render(Set<Map> diff) {
        String result = "{\n";
        for (Map map : diff) {
            String status = (String) map.get("status");
            String key = (String) map.get("key");
            Object value1 = map.get("value1");
            Object value2 = map.get("value2");
            /*if (value1 instanceof Array) {
                value1.toString();
            }
            if (value2 instanceof Array) {
                value2.toString();
            }*/
            switch (status) {
                case "added":
                    result += "  + " + key + ": " + value2 + "\n";
                    break;
                case "removed":
                    result += "  - " + key + ": " + value1 + "\n";
                    break;
                case "changed":
                    result += "  - " + key + ": " + value1 + "\n" + "  + " + key + ": " + value2 + "\n";
                    break;
                case "unchanged":
                    result += "    " + key + ": " + value1 + "\n";
                    break;
                default:
                    return result;
            }
        }
        return result + "}";
    }
}
