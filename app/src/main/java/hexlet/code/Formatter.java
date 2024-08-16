package hexlet.code;


import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.RawString;
import hexlet.code.formatters.Stylish;

public class Formatter {

    static hexlet.code.formatters.DiffFormat getFormatter(String format) {
        return switch (format) {
            case "plain" -> new Plain();
            case "json" -> new Json();
            case "string" -> new RawString();
            default -> new Stylish();
        };
    }
}
