package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Differ {
    private static String diffResult;
    public static String generate(String fp1, String fp2)  throws Exception {
        String resultStr = "";
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        Path path1 = Paths.get(fp1).toAbsolutePath().normalize();
        Path path2 = Paths.get(fp2).toAbsolutePath().normalize();
        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        } else if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }
        if (fp1.endsWith(".json") && fp2.endsWith(".json")) {
            //Differ diff1 = objectMapper.readValue(Files.readString(path1), Differ.class);
            Map<String, Object> map1
                    = objectMapper.readValue(Files.readString(path1), new TypeReference<Map<String, Object>>() { });
            //Differ diff2 = objectMapper.readValue(Files.readString(path2), Differ.class);
            Map<String, Object> map2
                    = objectMapper.readValue(Files.readString(path2), new TypeReference<Map<String, Object>>() { });
            ///List<String> myList1 = map1.keySet().stream().toList();
            //List<String> myList2 = map2.keySet().stream().toList();
            SortedSet<String> keySet1 = new TreeSet<>(map1.keySet());
            SortedSet<String> keySet2 = new TreeSet<>(map2.keySet());
            keySet1.addAll(keySet2);
            sb.append("{").append("\n");
            for (var key: keySet1) {
                if (map1.containsKey(key) && map2.containsKey(key)) {
                    if (map1.get(key).equals(map2.get(key))) {
                        sb.append("  ").append(key).append(": ").append(map1.get(key)).append("\n");
                    } else {
                        sb.append("  ").append("-").append(key).append(": ").append(map1.get(key)).append("\n");
                        sb.append("  ").append("+").append(key).append(": ").append(map2.get(key)).append("\n");
                    }
                } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                    sb.append("  ").append("-").append(key).append(": ").append(map1.get(key)).append("\n");
                } else {
                    sb.append("  ").append("+").append(key).append(": ").append(map2.get(key)).append("\n");
                }
            }
            sb.append("}");
            resultStr = sb.toString();
        } else if (fp1.endsWith(".yml") && fp2.endsWith(".yml")) {
            ObjectMapper mapperYAML = new YAMLMapper();
            Map<String, Object> mapYAML1
                    = mapperYAML.readValue(Files.readString(path1), new TypeReference<Map<String, Object>>() { });
            Map<String, Object> mapYAML2
                    = mapperYAML.readValue(Files.readString(path2), new TypeReference<Map<String, Object>>() { });
            SortedSet<String> keySet1 = new TreeSet<>(mapYAML1.keySet());
            SortedSet<String> keySet2 = new TreeSet<>(mapYAML2.keySet());
            keySet1.addAll(keySet2);
            sb.append("{").append("\n");
            for (var key: keySet1) {
                if (mapYAML1.containsKey(key) && mapYAML2.containsKey(key)) {
                    if (mapYAML1.get(key).equals(mapYAML2.get(key))) {
                        sb.append("  ").append(key).append(": ").append(mapYAML1.get(key)).append("\n");
                    } else {
                        sb.append("  ").append("-").append(key).append(": ").append(mapYAML1.get(key)).append("\n");
                        sb.append("  ").append("+").append(key).append(": ").append(mapYAML1.get(key)).append("\n");
                    }
                } else if (mapYAML1.containsKey(key) && !mapYAML2.containsKey(key)) {
                    sb.append("  ").append("-").append(key).append(": ").append(mapYAML1.get(key)).append("\n");
                } else {
                    sb.append("  ").append("+").append(key).append(": ").append(mapYAML2.get(key)).append("\n");
                }
            }
            sb.append("}");
            resultStr = sb.toString();
        }
        return resultStr;
    }
}
