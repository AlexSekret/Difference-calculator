package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish implements DiffFormat {
    @Override
    public final String getFormatedString(List<Map<String, Object>> diff) throws IllegalStateException {
        var result = new StringBuilder("{\n");
        for (var e : diff) {
            var type = e.get("type");
            var key = e.get("key");
            var value = e.get("value");
            var value1 = e.get("value1");
            var value2 = e.get("value2");
            switch (type.toString()) {
                case "updated" -> {
                    result.append(String.format("  - %1$s: %2$s%n  + %1$s: %3$s%n", key, value1, value2));
                }
                case "added" -> result.append(String.format("  + %s: %s%n", key, value));
                case "removed" -> result.append(String.format("  - %s: %s%n", key, value));
                case "not-changed" -> result.append(String.format("    %s: %s%n", key, value));
                default -> throw new IllegalStateException("Unexpected value: " + type);
            }
        }
        result.append("}");
        return result.toString();
    }
}
