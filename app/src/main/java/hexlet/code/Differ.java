package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();
        Map<String, Object> firstData = Parser.getObjectMap(path1);
        Map<String, Object> secondData = Parser.getObjectMap(path2);
        var diff = processDifference(firstData, secondData);
        return constructStringRepresentation(diff);
    }

    private static String constructStringRepresentation(TreeMap<String, Object> diff) {
        var result = new StringBuilder("{\n");
        for (var e : diff.entrySet()) {
            var object = (Difference) e.getValue();
            var type = object.getTypeDiff();
            if (type.equals("changed")) {
                result.append("  - ");
                result.append(e.getKey()).append(": ");
                result.append(object.getValues().getFirst()).append("\n");
                result.append("  + ");
                result.append(e.getKey()).append(": ");
                result.append(object.getValues().getLast()).append("\n");
            } else if (type.equals("added")) {
                result.append("  + ");
                result.append(e.getKey()).append(": ");
                result.append(object.getValues().getFirst()).append("\n");
            } else if (type.equals("removed")) {
                result.append("  - ");
                result.append(e.getKey()).append(": ");
                result.append(object.getValues().getFirst()).append("\n");
            } else if (type.equals("not-changed")) {
                result.append("    ");
                result.append(e.getKey()).append(": ");
                result.append(object.getValues().getFirst()).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }

    private static TreeMap<String, Object> processDifference(Map<String, Object> firstData,
                                                             Map<String, Object> secondData) {
        Set<String> setOfKeys = new TreeSet<>(firstData.keySet());
        setOfKeys.addAll(secondData.keySet());
        TreeMap<String, Object> diff = new TreeMap<>();
        for (var s : setOfKeys) {
            var oldValue = firstData.get(s);
            var newValue = secondData.get(s);
            if (firstData.containsKey(s) && secondData.containsKey(s)) {
                if (oldValue.equals(newValue)) {
                    diff.put(s, new Difference<>("not-changed", oldValue));
                } else {
                    diff.put(s, new Difference<>("changed", oldValue, newValue));
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
