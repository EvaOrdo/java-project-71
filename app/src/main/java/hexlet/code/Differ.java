package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

import static hexlet.code.DiffBuilder.buildDifference;

public class Differ {
    private static String getExtension(String filename) {
        if (!filename.contains(".")) {
            return "";
        }
        return filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
    }

    private static String getContent(String filepath) throws IOException {
        Path path = Paths.get(filepath).toAbsolutePath();
        return Files.readString(path);
    }
    public static String generate(String filepath1, String filepath2, String formatName)
            throws Exception {

        Map<String, Object> map1 = Parser.parseString(getContent(filepath1), getExtension(filepath1));
        Map<String, Object> map2 = Parser.parseString(getContent(filepath2), getExtension(filepath2));

        Set<Map> diff = buildDifference(map1, map2);

        return Formatter.format(diff, formatName);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
