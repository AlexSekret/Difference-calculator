package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DifferTest {
    private static String expectedJSON;
    private static String expectedPlain;
    private static String expectedStylish;

    @BeforeAll
    public static void setUp() throws Exception {
        expectedJSON = Utils.getFileContent("src/test/resources/fixtures/expectedJSON.txt");
        expectedPlain = Utils.getFileContent("src/test/resources/fixtures/expectedPlain.txt");
        expectedStylish = Utils.getFileContent("src/test/resources/fixtures/expectedStylish.txt");
    }

    @Test
    public void stylishDefaultGenerateTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.json";
        var filePath2 = "src/test/resources/fixtures/nested2.json";
        assertEquals(expectedStylish,
                Differ.generate(filePath1, filePath2));
    }

    @Test
    public void jsonStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.json";
        var filePath2 = "src/test/resources/fixtures/nested2.json";
        assertEquals(expectedStylish,
                Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    public void yamlStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.yml";
        var filePath2 = "src/test/resources/fixtures/nested2.yml";
        assertEquals(expectedStylish,
                Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    public void jsonPlainTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.json";
        var filePath2 = "src/test/resources/fixtures/nested2.json";
        assertEquals(expectedPlain,
                Differ.generate(filePath1, filePath2, "plain"));
    }

    @Test
    public void yamlPlainTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.yml";
        var filePath2 = "src/test/resources/fixtures/nested2.yml";
        assertEquals(expectedPlain,
                Differ.generate(filePath1, filePath2, "plain"));
    }

    @Test
    public void jsonJSONTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.json";
        var filePath2 = "src/test/resources/fixtures/nested2.json";
        assertEquals(expectedJSON,
                Differ.generate(filePath1, filePath2, "json"));
    }

    @Test
    public void yamlJSONTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.yml";
        var filePath2 = "src/test/resources/fixtures/nested2.yml";
        assertEquals(expectedJSON,
                Differ.generate(filePath1, filePath2, "json"));
    }

    @Test
    public void getFileExtensionTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.json";
        var filePath2 = "src/test/resources/fixtures/nested1.yml";
        String expectedJson = "json";
        String expectedYaml = "yml";
        assertEquals(expectedJson, Utils.getFileExtension(filePath1));
        assertEquals(expectedYaml, Utils.getFileExtension(filePath2));
    }
    @Test
    public void getObjectMapTest() {
        assertThrows(IllegalStateException.class, () -> Parser.getObjectMap(expectedJSON, "text"));
    }
}
