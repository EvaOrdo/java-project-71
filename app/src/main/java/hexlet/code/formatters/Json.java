package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Set;

public class Json {
    public static String render(Set<Map> diff) throws Exception {
        String result = new String();
        ObjectMapper mapper = new ObjectMapper();
        for (Map map : diff) {
            String mapToJsonString = mapper.writeValueAsString(map);
            result += mapToJsonString;
        }
        return result;
    }
}
