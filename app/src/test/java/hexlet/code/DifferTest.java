package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    String stylishFormat = "stylish";

    @Test
    public void jsonStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/file1.json";
        var filePath2 = "src/test/resources/fixtures/file2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedStylishJSON.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                StringConstructor.getStringDiff(filePath1, filePath2, stylishFormat));
    }

    @Test
    public void yamlStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/file1.yml";
        var filePath2 = "src/test/resources/fixtures/file2.yml";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedStylishYAML.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                StringConstructor.getStringDiff(filePath1, filePath2, stylishFormat));
    }

    @Test
    public void jsonNestedStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.json";
        var filePath2 = "src/test/resources/fixtures/nested2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedNested.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                StringConstructor.getStringDiff(filePath1, filePath2, stylishFormat));
    }

    @Test
    public void yamlNestedStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.yml";
        var filePath2 = "src/test/resources/fixtures/nested2.yml";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedNested.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                StringConstructor.getStringDiff(filePath1, filePath2, stylishFormat));
    }
}
