package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {


    public static Map<String, Object> getObjectMap(String fileContent, String extension) throws Exception {
        ObjectMapper dataFile = parserFactory(extension);
        return dataFile.readValue(fileContent, new TypeReference<Map<String, Object>>() {
        });
    }

    private static ObjectMapper parserFactory(String extension) throws IllegalStateException {
        return switch (extension) {
            case "yml" -> new YAMLMapper();
            case "json" -> new ObjectMapper();
            default -> throw new IllegalStateException("Invalid file extension: <" + extension + ">");
        };
    }

}
