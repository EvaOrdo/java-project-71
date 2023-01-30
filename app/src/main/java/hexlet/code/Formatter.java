package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;
import java.util.Set;

public class Formatter {
    public static String format(Set<Map> diff, String formatName) throws Exception {
        switch (formatName) {
            case ("plain"):
                return Plain.render(diff);
            case ("json"):
                return Json.render(diff);
            default:
                return Stylish.render(diff);
        }
    }
}
