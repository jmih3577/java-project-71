package hexlet.code;

//import java.util.*;

import hexlet.code.formatters.JSON;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

//import java.util.List;
import java.util.Map;
//import java.util.SortedSet;
//import java.util.TreeSet;

public class Formatter {
    public static String format(Map<String, Object> diffMap, String format)  throws Exception {
        String result = "";
        //System.out.println(format);
        switch (format) {
            case "plain" -> {
                result = Plain.format(diffMap);
            }
            case "json" -> {
                result = JSON.format(diffMap);
            }
            default -> {
                result = Stylish.format(diffMap);
                //result = JSON.format(diffMap);
            }
        }
                //result = Plain.format(diffMap);
        return result;
    }
}
