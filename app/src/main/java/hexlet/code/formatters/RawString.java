package hexlet.code.formatters;

import java.util.Map;

public class RawString implements DiffFormat {

    @Override
    public String getFormatedString(Map<String, Object> diff) {
        return String.valueOf(diff);
    }
}
