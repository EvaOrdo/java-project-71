package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Set;

public class Json {
    public static String render(Set<Map> diff) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(diff);
    }
}
