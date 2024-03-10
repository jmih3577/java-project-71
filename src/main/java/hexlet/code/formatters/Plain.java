package hexlet.code.formatters;

import hexlet.code.Parser;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Plain {
    public static String format(Map<String, Object> diffMap) {
        StringBuilder sb = new StringBuilder();
        SortedSet<String> keySetDiff = new TreeSet<>(diffMap.keySet());
        for (var key : keySetDiff) {
            List list = (List) diffMap.get(key);
            if (list.get(2) == Parser.MapOperations.SAME) {
                continue;
            } else if (list.get(2) == Parser.MapOperations.CHNG) {
                sb.append(String.format(
                        "Property '%1$s' was updated. From %2$s to %3$s\n",
                        key,
                        getComplexValueType(list.get(0)),
                        getComplexValueType(list.get(1))));
            } else if (list.get(2) == Parser.MapOperations.DEL) {
                sb.append(String.format(
                        "Property '%1$s' was removed.\n",
                        key));
            } else {
                sb.append(String.format(
                        "Property '%1$s' was added with value: %2$s\n",
                        key,
                        getComplexValueType(list.get(1))));
            }
        }
        if (!sb.isEmpty()) {
            sb = sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
    public static Object getComplexValueType(Object obj) {
        Object res = obj;
        if (!(obj == null
                || obj.getClass() == String.class
                || obj.getClass() == Integer.class
                || obj.getClass() == Boolean.class)) {
            res = "[complex value]";
        } else if (!(obj == null) && obj.getClass() == String.class) {
            res = "'" + obj + "'";
        }
        return res;
    }
}
