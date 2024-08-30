package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public interface DiffFormat {
    String getFormatedString(List<Map<String, Object>> diff);
}
