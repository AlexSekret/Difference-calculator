package hexlet.code;


import hexlet.code.formatters.DiffFormat;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

public class Formatter {

    public static DiffFormat getFormatter(String format) {
        return switch (format) {
            case "plain" -> new Plain();
            case "json" -> new Json();
            default -> new Stylish();
        };
    }
}
