package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;

public class Parser {


    public static Map<String, Object> getObjectMap(Path pathFile) throws Exception {
        ObjectMapper dataFile = parserFabric(pathFile);
        return dataFile.readValue(
                pathFile.toFile(),
                new TypeReference<Map<String, Object>>() {
                });
    }

    private static ObjectMapper parserFabric(Path filePath) throws Exception {
        var extension = getFileExtension(filePath);
        ObjectMapper parser = switch (extension) {
            case "yml" -> new YAMLMapper();
            case "json" -> new ObjectMapper();
            default -> throw new IllegalStateException("Invalid file extension: <" + extension + ">");
        };
        return parser;
    }

    private static String getFileExtension(Path filePath) throws Exception {
        if (!Files.exists(filePath)) {
            throw new Exception("File '" + filePath + "' does not exist");
        }
        String[] fileInfo = filePath.getFileName().toString().split("\\.");
        String fileExtension = Arrays.stream(fileInfo).toList().getLast();
        return fileExtension;
    }
}
