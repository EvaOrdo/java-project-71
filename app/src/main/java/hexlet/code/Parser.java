package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parseJSON(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        map = mapper.readValue(json,
                map.getClass());
        return map;
    }

    public static Map<String, Object> parseYAML(String yaml) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        Map<String, Object> map = new HashMap<>();
        map = mapper.readValue(yaml, map.getClass());
        return map;
    }

    public static Map<String, Object> parseString(String content, String extension) throws Exception {

        Map<String, Object> map = switch (extension) {
            case "json" -> parseJSON(content);
            case "yml", "yaml" -> parseYAML(content);
            default -> throw new Exception("unknown extension " + extension);
        };
        return map;
    }
}
