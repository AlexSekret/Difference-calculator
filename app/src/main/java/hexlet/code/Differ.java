package hexlet.code;

import hexlet.code.formatters.DiffFormat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = Utils.getFileContent(filepath1);
        String content2 = Utils.getFileContent(filepath2);

        var extension1 = Utils.getFileExtension(filepath1);
        var extension2 = Utils.getFileExtension(filepath2);

        Map<String, Object> firstData = Parser.getObjectMap(content1, extension1);
        Map<String, Object> secondData = Parser.getObjectMap(content2, extension2);
        var diff = getFilesDiff(firstData, secondData);
        DiffFormat formater = Formatter.getFormatter(format);
        return formater.getFormatedString(diff);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    private static List<Map<String, Object>> getFilesDiff(Map<String, Object> firstData,
                                                          Map<String, Object> secondData) {
        Set<String> setOfKeys = new TreeSet<>(firstData.keySet());
        setOfKeys.addAll(secondData.keySet());
        List<Map<String, Object>> diff = new ArrayList<>();
        for (var s : setOfKeys) {
            Object value1 = firstData.get(s);
            Object value2 = secondData.get(s);
            Map<String, Object> mapDif = new LinkedHashMap<>();
            mapDif.put("key", s);
            if (firstData.containsKey(s) && !secondData.containsKey(s)) {
                mapDif.put("type", "removed");
                mapDif.put("value", value1);
            } else if (!firstData.containsKey(s) && secondData.containsKey(s)) {
                mapDif.put("type", "added");
                mapDif.put("value", value2);
            } else if (Objects.equals(value1, value2)) {
                mapDif.put("type", "not-changed");
                mapDif.put("value", value1);
            } else {
                mapDif.put("type", "updated");
                mapDif.put("value1", value1);
                mapDif.put("value2", value2);
            }
            diff.add(mapDif);
        }
        return diff;
    }
}
