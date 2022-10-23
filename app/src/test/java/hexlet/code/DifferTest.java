package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String pathToJson1 = "src/test/resources/file1.json";
    private static String pathToJson2 = "src/test/resources/file2.json";
    private static String pathToYaml1 = "src/test/resources/file1.yml";
    private static String pathToYaml2 = "src/test/resources/file2.yml";

    private final String expectedStylish = """
{
    chars1: [a, b, c]
  - chars2: [d, e, f]
  + chars2: false
  - checked: false
  + checked: true
  - default: null
  + default: [value1, value2]
  - id: 45
  + id: null
  - key1: value1
  + key2: value2
    numbers1: [1, 2, 3, 4]
  - numbers2: [2, 3, 4, 5]
  + numbers2: [22, 33, 44, 55]
  - numbers3: [3, 4, 5]
  + numbers4: [4, 5, 6]
  + obj1: {nestedKey=value, isNested=true}
  - setting1: Some value
  + setting1: Another value
  - setting2: 200
  + setting2: 300
  - setting3: true
  + setting3: none
}               """;

    private final String expectedPlain = "Property 'chars2' was updated. From [complex value] to false\n"
            + "Property 'checked' was updated. From false to true\n"
            + "Property 'default' was updated. From 'null' to [complex value]\n"
            + "Property 'id' was updated. From 45 to 'null'\n"
            + "Property 'key1' was removed\n"
            + "Property 'key2' was added with value: 'value2'\n"
            + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
            + "Property 'numbers3' was removed\n"
            + "Property 'numbers4' was added with value: [complex value]\n"
            + "Property 'obj1' was added with value: [complex value]\n"
            + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
            + "Property 'setting2' was updated. From 200 to 300\n"
            + "Property 'setting3' was updated. From true to 'none'";

    private final String expectedJson = "{\"key\":\"chars1\",\"status\":\"unchanged\",\"value1\":[\"a\",\"b\",\"c\"]}"
            + "{\"key\":\"chars2\",\"status\":\"changed\",\"value1\":[\"d\",\"e\",\"f\"],\"value2\":false}"
            + "{\"key\":\"checked\",\"status\":\"changed\",\"value1\":false,\"value2\":true}"
            + "{\"key\":\"default\",\"status\":\"changed\",\"value1\":\"null\",\"value2\":[\"value1\",\"value2\"]}"
            + "{\"key\":\"id\",\"status\":\"changed\",\"value1\":45,\"value2\":\"null\"}"
            + "{\"key\":\"key1\",\"status\":\"removed\",\"value1\":\"value1\"}"
            + "{\"key\":\"key2\",\"status\":\"added\",\"value2\":\"value2\"}"
            + "{\"key\":\"numbers1\",\"status\":\"unchanged\",\"value1\":[1,2,3,4]}"
            + "{\"key\":\"numbers2\",\"status\":\"changed\",\"value1\":[2,3,4,5],\"value2\":[22,33,44,55]}"
            + "{\"key\":\"numbers3\",\"status\":\"removed\",\"value1\":[3,4,5]}"
            + "{\"key\":\"numbers4\",\"status\":\"added\",\"value2\":[4,5,6]}"
            + "{\"key\":\"obj1\",\"status\":\"added\",\"value2\":{\"nestedKey\":\"value\",\"isNested\":true}}"
            + "{\"key\":\"setting1\",\"status\":\"changed\",\"value1\":\"Some value\",\"value2\":\"Another value\"}"
            + "{\"key\":\"setting2\",\"status\":\"changed\",\"value1\":200,\"value2\":300}"
            + "{\"key\":\"setting3\",\"status\":\"changed\",\"value1\":true,\"value2\":\"none\"}";


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
