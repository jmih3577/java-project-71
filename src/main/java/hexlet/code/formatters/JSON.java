package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import hexlet.code.Parser;

//import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class JSON {
    public static String format(Map<String, Object> diffMap) throws JsonProcessingException {
        StringBuilder sb = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        SortedSet<String> keySetDiff = new TreeSet<>(diffMap.keySet());
        String carAsString = objectMapper.writeValueAsString(diffMap);
        return carAsString;
    }
}
