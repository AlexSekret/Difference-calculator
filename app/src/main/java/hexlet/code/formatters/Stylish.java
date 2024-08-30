package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish implements DiffFormat {
    @Override
    public final String getFormatedString(List<Map<String, Object>> diff) {
        var result = new StringBuilder("{\n");
        for (var e : diff) {
            var key = e.get("key");
            var type = e.get("type");
            var value = e.get("value");
            var value1 = e.get("value1");
            var value2 = e.get("value2");
            if (type.equals("updated")) {
                result.append(String.format("  - %s: %s%n", key, value1));
                result.append(String.format("  + %s: %s%n", key, value2));
            } else if (type.equals("added")) {
                result.append(String.format("  + %s: %s%n", key, value));
            } else if (type.equals("removed")) {
                result.append(String.format("  - %s: %s%n", key, value));
            } else if (type.equals("not-changed")) {
                result.append(String.format("    %s: %s%n", key, value));
            }
        }
        result.append("}");
        return result.toString();
    }
}
