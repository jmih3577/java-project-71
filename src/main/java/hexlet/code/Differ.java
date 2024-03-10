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
        /*String resultStr = "";
        ObjectMapper objectMapper = new ObjectMapper();
        Path path1 = Paths.get(fp1).toAbsolutePath().normalize();
        Path path2 = Paths.get(fp2).toAbsolutePath().normalize();
        Map<String, Object> mapDiff = new HashMap<>();
        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        } else if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }
        if (fp1.endsWith(".json") && fp2.endsWith(".json")) {
            Map<String, Object> map1
                    = objectMapper.readValue(Files.readString(path1), new TypeReference<Map<String, Object>>() { });
            Map<String, Object> map2
                    = objectMapper.readValue(Files.readString(path2), new TypeReference<Map<String, Object>>() { });
            SortedSet<String> keySet1 = new TreeSet<>(map1.keySet());
            SortedSet<String> keySet2 = new TreeSet<>(map2.keySet());
            keySet1.addAll(keySet2);
            for (var key: keySet1) {
                if (map1.containsKey(key) && map2.containsKey(key)) {
                    if (Objects.equals(map1.get(key),map2.get(key))) {
                        mapDiff.put(key, Arrays.asList(map1.get(key), map2.get(key), mapOperations.SAME));
                    } else {
                        mapDiff.put(key, Arrays.asList(map1.get(key), map2.get(key), mapOperations.CHNG));
                    }
                } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                    mapDiff.put(key, Arrays.asList(map1.get(key), map2.get(key), mapOperations.DEL));
                } else {
                    mapDiff.put(key, Arrays.asList(map1.get(key), map2.get(key), mapOperations.ADD));
                }
            }
            //resultStr = Formatter.format(mapDiff);
        } else if (fp1.endsWith(".yml") && fp2.endsWith(".yml")) {
            ObjectMapper mapperYAML = new YAMLMapper();
            Map<String, Object> mapYAML1
                    = mapperYAML.readValue(Files.readString(path1), new TypeReference<Map<String, Object>>() { });
            Map<String, Object> mapYAML2
                    = mapperYAML.readValue(Files.readString(path2), new TypeReference<Map<String, Object>>() { });
            SortedSet<String> keySet1 = new TreeSet<>(mapYAML1.keySet());
            SortedSet<String> keySet2 = new TreeSet<>(mapYAML2.keySet());
            keySet1.addAll(keySet2);
            for (var key: keySet1) {
                if (mapYAML1.containsKey(key) && mapYAML2.containsKey(key)) {
                    if (Objects.equals(mapYAML1.get(key),mapYAML2.get(key))) {
                        mapDiff.put(key, Arrays.asList(mapYAML1.get(key), mapYAML2.get(key), mapOperations.SAME));
                    } else {
                        mapDiff.put(key, Arrays.asList(mapYAML1.get(key), mapYAML2.get(key), mapOperations.CHNG));
                    }
                } else if (mapYAML1.containsKey(key) && !mapYAML2.containsKey(key)) {
                    mapDiff.put(key, Arrays.asList(mapYAML1.get(key), mapYAML2.get(key), mapOperations.DEL));
                } else {
                    mapDiff.put(key, Arrays.asList(mapYAML1.get(key), mapYAML2.get(key), mapOperations.ADD));
                }
            }
            //resultStr = Formatter.format(mapDiff);
        }
        //System.out.println(mapDiff);
        //return resultStr;*/
        return Formatter.format(Parser.parse(fp1, fp2), format);
    }
}
