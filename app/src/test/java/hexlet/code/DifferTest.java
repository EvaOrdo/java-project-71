package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String pathToJson1 = "src/test/resources/file1.json";
    private static String pathToJson2 = "src/test/resources/file2.json";
    private static String pathToYaml1 = "src/test/resources/file1.yml";
    private static String pathToYaml2 = "src/test/resources/file2.yml";

    private static String pathToStylish = "src/test/resources/stylish.txt";

    private static String pathToPlain = "src/test/resources/plain.txt";

    private static String pathToJsonFormat = "src/test/resources/json.txt";
    private final String expectedStylish = Files.readString(Paths.get(pathToStylish));
    private final String expectedPlain = Files.readString(Paths.get(pathToPlain));
    private final String expectedJson = Files.readString(Paths.get(pathToJsonFormat));

    public DifferTest() throws IOException {
    }

    @Test
    public void generateStylishTest() throws Exception {
        assertEquals(expectedStylish, Differ.generate(pathToJson1, pathToJson2, "stylish"));
        assertEquals(expectedStylish, Differ.generate(pathToYaml1, pathToYaml2, "stylish"));
    }

    @Test
    public void generatePlainTest() throws Exception {
        assertEquals(expectedPlain, Differ.generate(pathToJson1, pathToJson2, "plain"));
        assertEquals(expectedPlain, Differ.generate(pathToYaml1, pathToYaml2, "plain"));
    }

    @Test
    public void generateYamlJsonTest() throws Exception {
        assertEquals(expectedJson, Differ.generate(pathToJson1, pathToJson2, "json"));
        assertEquals(expectedJson, Differ.generate(pathToYaml1, pathToYaml2, "json"));
    }
}
