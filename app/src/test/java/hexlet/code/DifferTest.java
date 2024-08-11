package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    String absFilepath1 = "";
    String absFilepath2 = "";
    String relFilepath1 = "";
    String relFilepath2 = "";
    String expected = "";

    @BeforeEach
    public void setUp() {
        absFilepath1 = "/home/alex/IdeaProjects/java-project-71/app/src/test/resources/fixtures/file1.json";
        absFilepath2 = "/home/alex/IdeaProjects/java-project-71/app/src/test/resources/fixtures/file2.json";
        relFilepath1 = "src/test/resources/fixtures/file1.json";
        relFilepath2 = "src/test/resources/fixtures/file2.json";
        expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
    }

    @Test
    public void generateAbsolutePathTest() throws Exception {
        assertEquals(expected, Differ.generate(absFilepath1, absFilepath2));
    }

    @Test
    public void generateRelativePathTest() throws Exception {
        assertEquals(expected, Differ.generate(relFilepath1, relFilepath2));
    }
}
