package hexlet.code.formatters;

import hexlet.code.Difference;

import java.util.Map;

public class Stylish implements DiffFormat {

    @Override
    public String getFormatedString(Map<String, Object> diff) {
        var result = new StringBuilder("{\n");
        for (var e : diff.entrySet()) {
            var object = (Difference) e.getValue();
            var type = object.getTypeDiff();
            if (type.equals("updated")) {
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
}
