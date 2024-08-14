package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class StringConstructor {
    public static String getStringDiff(String filepath1, String filepath2, String format) throws Exception {
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();
        Map<String, Object> firstData = Parser.getObjectMap(path1);
        Map<String, Object> secondData = Parser.getObjectMap(path2);
        var diff = Differ.getFilesDiff(firstData, secondData);
        DiffFormat formater = formatFactory(format);
        return formater.getFormatedString(diff); //переписать
    }
    private static DiffFormat formatFactory(String format) {
        return switch (format) {
            case "plain" -> new StylishFormatter();
            case "json" -> new StylishFormatter();
            case "string" -> new RawStringFormatter();
            default -> new StylishFormatter();
        };
    }
}
