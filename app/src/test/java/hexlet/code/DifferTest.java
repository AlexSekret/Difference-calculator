package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DifferTest {
    String stylishFormat = "stylish";
    String plainFormat = "plain";

    @Test
    public void jsonStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/file1.json";
        var filePath2 = "src/test/resources/fixtures/file2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedStylishJSON.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, stylishFormat));
    }

    @Test
    public void yamlStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/file1.yml";
        var filePath2 = "src/test/resources/fixtures/file2.yml";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedStylishYAML.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, stylishFormat));
    }

    @Test
    public void jsonNestedStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.json";
        var filePath2 = "src/test/resources/fixtures/nested2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedNested.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, stylishFormat));
    }

    @Test
    public void yamlNestedStylishTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.yml";
        var filePath2 = "src/test/resources/fixtures/nested2.yml";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedNested.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, stylishFormat));
    }

    @Test
    public void invalidExtensionFile() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.yzml";
        var filePath2 = "src/test/resources/fixtures/nested2.ygml";
        assertThrows(IllegalStateException.class,
                () -> Differ.generate(filePath1, filePath2, stylishFormat));
    }

    @Test
    public void fileDoesNotExist() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nes.yml";
        var filePath2 = "src/test/resources/fixtures/nes55.yml";
        assertThrows(Exception.class,
                () -> Differ.generate(filePath1, filePath2, stylishFormat));
    }

//    @Test
//    public void getFilesDiffTest() {
//        Map<String, Object> first = Map.of("b", 2, "c", 3);
//        Map<String, Object> second = Map.of("d", 1, "b", 2, "c", 3);
//        var expected = new TreeMap<String, Object>();
//        expected.put("b", new Difference<Integer>("not-changed", 2));
//        expected.put("c", new Difference<Integer>("not-changed", 3));
//        expected.put("d", new Difference<Integer>("added", 1));
//        assertEquals(expected.toString(), (Differ.getFilesDiff(first, second)).toString());
//    }

//    @Test
//    public void getFilesDiffTest2() {
//        Map<String, Object> first = Map.of("a", 1, "b", 2);
//        Map<String, Object> second = Map.of("b", 2);
//        var expected = new TreeMap<String, Object>();
//        expected.put("a", new Difference<Integer>("removed", 1));
//        expected.put("b", new Difference<Integer>("not-changed", 2));
//        assertEquals(expected.toString(), (Differ.getFilesDiff(first, second)).toString());
//    }

    @Test
    public void simpleRawStringFormatTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/rawString1.json";
        var filePath2 = "src/test/resources/fixtures/rawString2.json";
        var expected = new TreeMap<String, Object>();
        expected.put("c", new Difference<Integer>("not-changed", 3));
        expected.put("b", new Difference<Integer>("not-changed", 2));
        expected.put("d", new Difference<Integer>("added", 1));
        assertEquals(expected.toString(), (Differ.generate(filePath1, filePath2, "string")));
    }

    @Test
    public void simplePlainTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/file1.json";
        var filePath2 = "src/test/resources/fixtures/file2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedPlain.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, plainFormat));
    }

    @Test
    public void nestedPlainTest() throws Exception {
        var filePath1 = "src/test/resources/fixtures/nested1.json";
        var filePath2 = "src/test/resources/fixtures/nested2.json";
        var expectedPath = Paths.get("src/test/resources/fixtures/expectedNestedPlain.txt")
                .toAbsolutePath().normalize();
        var expected = Files.readString(expectedPath);
        assertEquals(expected,
                Differ.generate(filePath1, filePath2, plainFormat));
    }
}
