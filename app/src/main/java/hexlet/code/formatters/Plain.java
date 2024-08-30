package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain implements DiffFormat {
    @Override
    public final String getFormatedString(List<Map<String, Object>> diff) {
        StringBuilder result = new StringBuilder();
        for (var e : diff) {
            var key = e.get("key");
            var type = e.get("type");
            if (type.equals("updated")) {
                var value1 = e.get("value1");
                var value2 = e.get("value2");
                result.append(String.format("Property '%s' was updated. From %s to %s%n",
                        key, changeOutput(value1), changeOutput(value2)));
            } else if (type.equals("added")) {
                var value = e.get("value");
                result.append(String.format("Property '%s' was added with value: %s%n", key, changeOutput(value)));
            } else if (type.equals("removed")) {
                result.append(String.format("Property '%s' was removed%n", key));
            }
        }
        return result.toString().trim();
    }

    private String changeOutput(Object value) {
        if (isComplexValue(value)) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return String.valueOf(value);
    }

    private boolean isComplexValue(Object value) {
        return (value instanceof List<?>) || (value instanceof Map<?, ?>);
    }

}
