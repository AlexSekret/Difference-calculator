package hexlet.code.formatters;

import hexlet.code.Difference;

import java.util.List;
import java.util.Map;

public class Plain implements DiffFormat {
    @Override
    public String getFormatedString(Map<String, Object> diff) {
        var result = new StringBuilder();
        for (var e : diff.entrySet()) {
            var property = e.getKey();
            var object = (Difference) e.getValue();
            var type = object.getTypeDiff();
            if (type.equals("updated")) {
                var oldValue = object.getValues().getFirst();
                var newValue = object.getValues().getLast();
                result.append("Property '").append(property).append("' was updated. From ");
                result.append(changeOutput(oldValue));
                result.append(" to ").append(changeOutput(newValue)).append("\n");
            } else if (type.equals("added")) {
                var value = object.getValues().getFirst();
                result.append("Property '").append(property).append("' was added with value: ");
                result.append(changeOutput(value));
                result.append("\n");
            } else if (type.equals("removed")) {
                result.append("Property '").append(property).append("' was removed").append("\n");
            }
        }
        return result.toString().trim();
    }

    private boolean isComplexValue(Object value) {
        return (value instanceof List<?>) || (value instanceof Map<?, ?>);
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

}
