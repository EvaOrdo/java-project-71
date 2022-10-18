package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static Map<String, Object> parseString(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath();
        String content = Files.readString(path);
        Map<String, Object> map;
        if (filepath.endsWith("json")) {
            map = parseJSON(content);
        } else {
            map = parseYAML(content);
        }
        return map;
    }
}
