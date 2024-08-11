package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    static String relFilepath1;
    static String relFilepath2;
    static String expected;

    @BeforeAll
    public static void setUp() {
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
    public void generateRelativePathTest() throws Exception {
        assertEquals(expected, Differ.generate(relFilepath1, relFilepath2));
    }
}
