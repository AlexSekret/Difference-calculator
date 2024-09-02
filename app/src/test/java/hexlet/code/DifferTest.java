package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DifferTest {
    private static String expectedJSON;
    private static String expectedPlain;
    private static String expectedStylish;
    private static String filePathJson1;
    private static String filePathJson2;
    private static String filePathYAML1;
    private static String filePathYAML2;

    @BeforeAll
    public static void setUp() throws Exception {
        expectedJSON = Utils.getFileContent(getPath("expectedJSON.txt"));
        expectedPlain = Utils.getFileContent(getPath("expectedPlain.txt"));
        expectedStylish = Utils.getFileContent(getPath("expectedStylish.txt"));
        filePathJson1 = getPath("nested1.json");
        filePathJson2 = getPath("nested2.json");
        filePathYAML1 = getPath("nested1.yml");
        filePathYAML2 = getPath("nested2.yml");
    }

    public static String getPath(String fileName) {
        return String.format("src/test/resources/fixtures/%s", fileName);
    }

    @Test
    public void stylishDefaultGenerateTest() throws Exception {
        assertEquals(expectedStylish, Differ.generate(filePathJson1, filePathJson2));
    }

    @Test
    public void jsonStylishTest() throws Exception {
        assertEquals(expectedStylish, Differ.generate(filePathJson1, filePathJson2, "stylish"));
    }

    @Test
    public void yamlStylishTest() throws Exception {
        assertEquals(expectedStylish, Differ.generate(filePathYAML1, filePathYAML2, "stylish"));
    }

    @Test
    public void jsonPlainTest() throws Exception {
        assertEquals(expectedPlain, Differ.generate(filePathJson1, filePathJson2, "plain"));
    }

    @Test
    public void yamlPlainTest() throws Exception {
        assertEquals(expectedPlain, Differ.generate(filePathYAML1, filePathYAML2, "plain"));
    }

    @Test
    public void jsonJSONTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        var expected = objectMapper.readValue(expectedJSON, new TypeReference<List<Map<String, Object>>>() {
        });
        var actual = objectMapper.readValue(Differ.generate(filePathJson1, filePathJson2, "json"),
                new TypeReference<List<Map<String, Object>>>() {
                });
        assertEquals(expected, actual);
    }

    @Test
    public void yamlJSONTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        var expected = objectMapper.readValue(expectedJSON, new TypeReference<List<Map<String, Object>>>() {
        });
        var actual = objectMapper.readValue(Differ.generate(filePathYAML1, filePathYAML2, "json"),
                new TypeReference<List<Map<String, Object>>>() {
                });
        assertEquals(expected, actual);
    }

    @Test
    public void getFileExtensionTest() throws Exception {
        String expectedJson = "json";
        String expectedYaml = "yml";
        assertEquals(expectedJson, Utils.getFileExtension(filePathJson1));
        assertEquals(expectedYaml, Utils.getFileExtension(filePathYAML2));
    }

    @Test
    public void getObjectMapTest() {
        assertThrows(IllegalStateException.class, () -> Parser.getObjectMap(expectedJSON, "text"));
    }
}
