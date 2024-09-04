package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface DiffFormat {
    String getFormatedString(List<Map<String, Object>> diff) throws JsonProcessingException;
}
