package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    @Test
    public void jsonStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/file1.json";
        var filePath2 = "src/test/resources/fixtures/file2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedStylishJSON.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2));
    }

    @Test
    public void yamlStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/file1.yml";
        var filePath2 = "src/test/resources/fixtures/file2.yml";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedStylishYAML.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2));
    }
}
