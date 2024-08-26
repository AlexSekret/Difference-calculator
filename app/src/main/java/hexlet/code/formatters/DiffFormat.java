package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public interface DiffFormat {
    //    String getFormatedString(Map<String, Object> diff);
    String getFormatedString(List<Map<String, Object>> diff);
}
