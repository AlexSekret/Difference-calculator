package hexlet.code.formatters;

import java.util.Map;

public interface DiffFormat {
    String getFormatedString(Map<String, Object> diff);
}
