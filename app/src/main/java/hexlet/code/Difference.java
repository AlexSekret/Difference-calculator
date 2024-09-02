package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Difference {

    public static List<Map<String, Object>> getDiff(Map<String, Object> leftMap,
                                                    Map<String, Object> rightMap) {
        Set<String> setOfKeys = new TreeSet<>(leftMap.keySet());
        setOfKeys.addAll(rightMap.keySet());
        List<Map<String, Object>> diff = new ArrayList<>();
        for (var s : setOfKeys) {
            Object value1 = leftMap.get(s);
            Object value2 = rightMap.get(s);
            Map<String, Object> mapDif = new LinkedHashMap<>();
            mapDif.put("key", s);
            if (leftMap.containsKey(s) && !rightMap.containsKey(s)) {
                mapDif.put("type", "removed");
                mapDif.put("value", value1);
            } else if (!leftMap.containsKey(s) && rightMap.containsKey(s)) {
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
