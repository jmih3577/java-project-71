package hexlet.code;

/* import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;*/

public class Differ {
    public static Object mapOperations;
    private static String diffResult;
    public static String generate(String fp1, String fp2, String format)  throws Exception {
        return Formatter.format(Parser.parse(fp1, fp2), format);
    }
    public static String generate(String fp1, String fp2)  throws Exception {
        return Formatter.format(Parser.parse(fp1, fp2), "stylish");
    }
}
