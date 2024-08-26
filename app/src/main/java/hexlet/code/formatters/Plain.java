package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain implements DiffFormat {
//    @Override
//    public final String getFormatedString(Map<String, Object> diff) {
//        var result = new StringBuilder();
//        for (var e : diff.entrySet()) {
//            var property = e.getKey();
//            var object = (Difference) e.getValue();
//            var type = object.getTypeDiff();
//            if (type.equals("updated")) {
//                var oldValue = object.getValues().getFirst();
//                var newValue = object.getValues().getLast();
//                result.append("Property '").append(property).append("' was updated. From ");
//                result.append(changeOutput(oldValue));
//                result.append(" to ").append(changeOutput(newValue)).append("\n");
//            } else if (type.equals("added")) {
//                var value = object.getValues().getFirst();
//                result.append("Property '").append(property).append("' was added with value: ");
//                result.append(changeOutput(value));
//                result.append("\n");
//            } else if (type.equals("removed")) {
//                result.append("Property '").append(property).append("' was removed").append("\n");
//            }
//        }
//        return result.toString().trim();
//    }

    @Override
    public final String getFormatedString(List<Map<String, Object>> diff) {
        var result = new StringBuilder();
        for (var e : diff) {
            var key = e.get("key");
            var type = e.get("type");
            if (type.equals("updated")) {
                var oldValue = e.get("value1");
                var newValue = e.get("value2");
                result.append("Property '").append(key).append("' was updated. From ");
                result.append(changeOutput(oldValue));
                result.append(" to ").append(changeOutput(newValue)).append("\n");
            } else if (type.equals("added")) {
                var value = e.get("value");
                result.append("Property '").append(key).append("' was added with value: ");
                result.append(changeOutput(value));
                result.append("\n");
            } else if (type.equals("removed")) {
                result.append("Property '").append(key).append("' was removed").append("\n");
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
