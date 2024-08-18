package hexlet.code;

import hexlet.code.formatters.DiffFormat;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();
        Map<String, Object> firstData = Parser.getObjectMap(path1);
        Map<String, Object> secondData = Parser.getObjectMap(path2);
        var diff = getFilesDiff(firstData, secondData);
        DiffFormat formater = Formatter.getFormatter(format);
        return formater.getFormatedString(diff);
    }

    private static TreeMap<String, Object> getFilesDiff(Map<String, Object> firstData,
                                                       Map<String, Object> secondData) {
        Set<String> setOfKeys = new TreeSet<>(firstData.keySet());
        setOfKeys.addAll(secondData.keySet());
        TreeMap<String, Object> diff = new TreeMap<>();
        for (var s : setOfKeys) {
            Object oldValue = firstData.get(s);
            Object newValue = secondData.get(s);
            String firstValue = String.valueOf(oldValue);
            String secondValue = String.valueOf(newValue);
            if (firstData.containsKey(s) && secondData.containsKey(s)) {
                if (firstValue.equals(secondValue)) {
                    diff.put(s, new Difference<>("not-changed", oldValue));
                } else {
                    diff.put(s, new Difference<>("updated", oldValue, newValue));
                }
            } else if (firstData.containsKey(s) && !secondData.containsKey(s)) {
                diff.put(s, new Difference<>("removed", oldValue));
            } else if (!firstData.containsKey(s) && secondData.containsKey(s)) {
                diff.put(s, new Difference<>("added", newValue));
            }
        }
        return diff;
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();
        Map<String, Object> firstData = Parser.getObjectMap(path1);
        Map<String, Object> secondData = Parser.getObjectMap(path2);
        var diff = getFilesDiff(firstData, secondData);
        DiffFormat formater = Formatter.getFormatter("stylish");
        return formater.getFormatedString(diff);
    }
}
