package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppTest {

    @BeforeEach
    @Test
    public void bothAbsolutePath() throws Exception {
        var expect = """
                {
                  -follow: false
                  host: hexlet.io
                  -proxy: 123.234.53.22
                  -timeout: 50
                  +timeout: 20
                  +verbose: true
                }""";
        var actual = Differ.generate("/home/dev/projects/java-project-71/app/src/test/resources/json1.json",
                "/home/dev/projects/java-project-71/app/src/test/resources/json2.json");

        assertEquals(expect,
                actual);
    }
    public void bothRelativePath() throws Exception {
        var expect = """
                {
                  -follow: false
                  host: hexlet.io
                  -proxy: 123.234.53.22
                  -timeout: 50
                  +timeout: 20
                  +verbose: true
                }""";
        var actual = Differ.generate("../../../jsons/json1.json",
                "../../../jsons/json2.json");

        assertEquals(expect,
                actual);
    }
    /*public void testMethodThrowsException() {
        assertThrows(FileExis.class, () -> {
            Differ.generate("../../../jsons/json1.json",
                    "../../../jsons/json2.json");
        });
    }*/
}
