package hexlet.code;

import hexlet.code.formatters.DiffFormat;

import java.util.*;

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
        return generate(filePath1, filePath2, "stylish");
    }

    private static TreeMap<String, Object> getFilesDiff2(Map<String, Object> firstData,
                                                        Map<String, Object> secondData) {
        Set<String> setOfKeys = new TreeSet<>(firstData.keySet());
        setOfKeys.addAll(secondData.keySet());
        List<Map<String, Object>> diff = new ArrayList<>();
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
}
