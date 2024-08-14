package hexlet.code;

import java.util.Map;

public class RawStringFormatter implements DiffFormat {

    @Override
    public String getFormatedString(Map<String, Object> diff) {
        return String.valueOf(diff);
    }
}
