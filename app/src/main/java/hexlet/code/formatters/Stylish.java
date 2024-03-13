package hexlet.code.formatters;

import hexlet.code.Parser;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Stylish {
    public static String format(Map<String, Object> diffMap) {
        StringBuilder sb = new StringBuilder();
        SortedSet<String> keySetDiff = new TreeSet<>(diffMap.keySet());
        sb.append("{").append("\n");
        for (var key : keySetDiff) {
            List list = (List) diffMap.get(key);
            if (list.get(2) == Parser.MapOperations.SAME) {
                sb.append("  ").append(key).append(": ").append(list.get(0)).append("\n");
            } else if (list.get(2) == Parser.MapOperations.CHNG) {
                sb.append("  ").append("-").append(key).append(": ").append(list.get(0)).append("\n");
                sb.append("  ").append("+").append(key).append(": ").append(list.get(1)).append("\n");
            } else if (list.get(2) == Parser.MapOperations.DEL) {
                sb.append("  ").append("-").append(key).append(": ").append(list.get(0)).append("\n");
            } else {
                sb.append("  ").append("+").append(key).append(": ").append(list.get(1)).append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
