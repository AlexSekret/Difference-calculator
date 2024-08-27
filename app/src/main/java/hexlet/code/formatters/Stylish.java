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
            var oldValue = e.get("value1");
            var newValue = e.get("value2");
            if (type.equals("updated")) {
                result.append("  - ");
                result.append(key).append(": ");
                result.append(oldValue).append("\n");
                result.append("  + ");
                result.append(key).append(": ");
                result.append(newValue).append("\n");
            } else if (type.equals("added")) {
                result.append("  + ");
                result.append(key).append(": ");
                result.append(value).append("\n");
            } else if (type.equals("removed")) {
                result.append("  - ");
                result.append(key).append(": ");
                result.append(value).append("\n");
            } else if (type.equals("not-changed")) {
                result.append("    ");
                result.append(key).append(": ");
                result.append(value).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
