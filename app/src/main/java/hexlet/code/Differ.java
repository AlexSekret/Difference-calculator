package hexlet.code;

import hexlet.code.formatters.DiffFormat;

import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = Utils.getFileContent(filepath1);
        String content2 = Utils.getFileContent(filepath2);

        var extension1 = Utils.getFileExtension(filepath1);
        var extension2 = Utils.getFileExtension(filepath2);

        Map<String, Object> firstData = Parser.getObjectMap(content1, extension1);
        Map<String, Object> secondData = Parser.getObjectMap(content2, extension2);
        var diff = Difference.getDiff(firstData, secondData);
        DiffFormat formater = Formatter.getFormatter(format);
        return formater.getFormatedString(diff);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

}
