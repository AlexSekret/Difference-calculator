package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {

    public static TreeMap<String, Object> getFilesDiff(Map<String, Object> firstData,
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
