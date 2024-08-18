package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DifferTest {

    @Test
    public void jsonStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/file1.json";
        var filePath2 = "src/test/resources/fixtures/file2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedStylishJSON.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    public void jsonStylishDefaultTest() throws Exception {
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
                Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    public void jsonNestedStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.json";
        var filePath2 = "src/test/resources/fixtures/nested2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedNested.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    public void yamlNestedStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.yml";
        var filePath2 = "src/test/resources/fixtures/nested2.yml";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedNested.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    public void invalidExtensionFile() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.yzml";
        var filePath2 = "src/test/resources/fixtures/nested2.ygml";
        assertThrows(IllegalStateException.class,
                () -> Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    public void fileDoesNotExist() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nes.yml";
        var filePath2 = "src/test/resources/fixtures/nes55.yml";
        assertThrows(Exception.class,
                () -> Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    public void simplePlainTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/file1.json";
        var filePath2 = "src/test/resources/fixtures/file2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedPlain.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, "plain"));
    }

    @Test
    public void nestedPlainTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.json";
        var filePath2 = "src/test/resources/fixtures/nested2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedNestedPlain.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, "plain"));
    }

    @Test
    public void jsonOutputTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/rawString1.json";
        var filePath2 = "src/test/resources/fixtures/rawString2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedJSON.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, "json"));
    }

    @Test
    public void emptyFileTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/empty.json";
        var filePath2 = "src/test/resources/fixtures/rawString2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedStylishEmptyFirst.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2));
    }
}
