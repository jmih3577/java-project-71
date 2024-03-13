package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @BeforeEach
    @Test
    public void bothAbsolutePathJSONDefault() throws Exception {
        var expect = """
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
                }""";
        var actual = Differ.generate(System.getProperty("user.dir") + "/src/test/resources/complexjson1.json",
                System.getProperty("user.dir") + "/src/test/resources/complexjson2.json", "stylish");

        assertEquals(expect,
                actual);
    }
    @Test
    public void bothRelativePathJSONDefault() throws Exception {
        var expect = """
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
                }""";
        var actual = Differ.generate(System.getProperty("user.dir") + "/src/test/resources/complexjson1.json",
                System.getProperty("user.dir") + "/src/test/resources/complexjson2.json", "stylish");

        assertEquals(expect,
                actual);
    }
    @Test
    public void bothAbsolutePathYAMLDefault() throws Exception {
        var expect = """
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
                }""";
        var actual = Differ.generate(System.getProperty("user.dir") + "/src/test/resources/complexyaml1.yml",
                System.getProperty("user.dir") + "/src/test/resources/complexyaml2.yml", "stylish");

        assertEquals(expect,
                actual);
    }
    @Test
    public void bothRelativePathYAMLDefault() throws Exception {
        var expect = """
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
                }""";
        var actual = Differ.generate(System.getProperty("user.dir") + "/src/test/resources/complexyaml1.yml",
                System.getProperty("user.dir") + "/src/test/resources/complexyaml2.yml", "stylish");

        assertEquals(expect,
                actual);
    }
    @Test
    public void bothRelativePathJSONFormatPlain() throws Exception {
        var expect = """
                    Property 'chars2' was updated. From [complex value] to false
                    Property 'checked' was updated. From false to true
                    Property 'default' was updated. From null to [complex value]
                    Property 'id' was updated. From 45 to null
                    Property 'key1' was removed
                    Property 'key2' was added with value: 'value2'
                    Property 'numbers2' was updated. From [complex value] to [complex value]
                    Property 'numbers3' was removed
                    Property 'numbers4' was added with value: [complex value]
                    Property 'obj1' was added with value: [complex value]
                    Property 'setting1' was updated. From 'Some value' to 'Another value'
                    Property 'setting2' was updated. From 200 to 300
                    Property 'setting3' was updated. From true to 'none'""";
        var actual = Differ.generate(System.getProperty("user.dir") + "/src/test/resources/complexjson1.json",
                System.getProperty("user.dir") + "/src/test/resources/complexjson2.json", "plain");

        assertEquals(expect,
                actual);
    }
    @Test
    public void bothRelativePathYAMLFormatPlain() throws Exception {
        var expect = """
                    Property 'chars2' was updated. From [complex value] to false
                    Property 'checked' was updated. From false to true
                    Property 'default' was updated. From null to [complex value]
                    Property 'id' was updated. From 45 to null
                    Property 'key1' was removed
                    Property 'key2' was added with value: 'value2'
                    Property 'numbers2' was updated. From [complex value] to [complex value]
                    Property 'numbers3' was removed
                    Property 'numbers4' was added with value: [complex value]
                    Property 'obj1' was added with value: [complex value]
                    Property 'setting1' was updated. From 'Some value' to 'Another value'
                    Property 'setting2' was updated. From 200 to 300
                    Property 'setting3' was updated. From true to 'none'""";
        var actual = Differ.generate(System.getProperty("user.dir") + "/src/test/resources/complexyaml1.yml",
                System.getProperty("user.dir") + "/src/test/resources/complexyaml2.yml", "plain");

        assertEquals(expect,
                actual);
    }
    @Test
    public void bothRelativePathJSONFormatJSON() throws Exception {
        Path path = Paths.get("./src/test/resources/jsonexpect.txt");
        String expect = Files.readAllLines(path).get(0);
        var actual = Differ.generate(System.getProperty("user.dir") + "/src/test/resources/complexjson1.json",
                System.getProperty("user.dir") + "/src/test/resources/complexjson2.json", "json");

        assertEquals(expect,
                actual);
    }
    @Test
    public void bothRelativePathYAMLFormatJSON() throws Exception {
        Path path = Paths.get(System.getProperty("user.dir") + "/src/test/resources/jsonexpect.txt");
        String expect = Files.readAllLines(path).get(0);
        var actual = Differ.generate(System.getProperty("user.dir") + "/src/test/resources/complexyaml1.yml",
                System.getProperty("user.dir") + "/src/test/resources/complexyaml2.yml", "json");
        assertEquals(expect,
                actual);
    }
}
