package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

//import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.Map;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Objects;
//import java.util.*;
//import java.util.*;
//import java.util.*;

public class Parser {
    public enum MapOperations {
        CHNG,
        ADD,
        DEL,
        SAME
    }
    public static Map<String, Object> parse(String fp1, String fp2) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> mapDiff = new HashMap<>();
        Path path1 = Paths.get(fp1).toAbsolutePath().normalize();
        Path path2 = Paths.get(fp2).toAbsolutePath().normalize();
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
                    if (Objects.equals(map1.get(key), map2.get(key))) {
                        mapDiff.put(key, Arrays.asList(map1.get(key), map2.get(key), MapOperations.SAME));
                    } else {
                        mapDiff.put(key, Arrays.asList(map1.get(key), map2.get(key), MapOperations.CHNG));
                    }
                } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                    mapDiff.put(key, Arrays.asList(map1.get(key), map2.get(key), MapOperations.DEL));
                } else {
                    mapDiff.put(key, Arrays.asList(map1.get(key), map2.get(key), MapOperations.ADD));
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
                    if (Objects.equals(mapYAML1.get(key), mapYAML2.get(key))) {
                        mapDiff.put(key, Arrays.asList(mapYAML1.get(key), mapYAML2.get(key), MapOperations.SAME));
                    } else {
                        mapDiff.put(key, Arrays.asList(mapYAML1.get(key), mapYAML2.get(key), MapOperations.CHNG));
                    }
                } else if (mapYAML1.containsKey(key) && !mapYAML2.containsKey(key)) {
                    mapDiff.put(key, Arrays.asList(mapYAML1.get(key), mapYAML2.get(key), MapOperations.DEL));
                } else {
                    mapDiff.put(key, Arrays.asList(mapYAML1.get(key), mapYAML2.get(key), MapOperations.ADD));
                }
            }
            //resultStr = Formatter.format(mapDiff);
        }
        return mapDiff;
    }
}
