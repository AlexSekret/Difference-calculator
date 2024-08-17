package hexlet.code.formatters;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Json implements DiffFormat {
    @Override
    public String getFormatedString(Map<String, Object> diff) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(diff);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
