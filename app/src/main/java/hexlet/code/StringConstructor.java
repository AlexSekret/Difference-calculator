package hexlet.code;

import hexlet.code.formatters.DiffFormat;
import hexlet.code.formatters.RawString;
import hexlet.code.formatters.Stylish;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

//перенести в Differ и реализовать использование класса Formatter
public class StringConstructor {
    public static String getStringDiff(String filepath1, String filepath2, String format) throws Exception {
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();
        Map<String, Object> firstData = Parser.getObjectMap(path1);
        Map<String, Object> secondData = Parser.getObjectMap(path2);
        var diff = Differ.getFilesDiff(firstData, secondData);
        DiffFormat formater = getFormatFactory(format);
        return formater.getFormatedString(diff); //переписать
    }
    //перенести в Formatter
    private static DiffFormat getFormatFactory(String format) {
        return switch (format) {
            case "plain" -> new Stylish();
            case "json" -> new Stylish();
            case "string" -> new RawString();
            default -> new Stylish();
        };
    }
}
