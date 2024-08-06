package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        }

        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();
        if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }

        ObjectMapper objectMapper1 = new ObjectMapper();
        ObjectMapper objectMapper2 = new ObjectMapper();
        Map<String, Object> map1 = objectMapper1.readValue(
                path1.toFile(),
                new TypeReference<Map<String, Object>>() { });

        Map<String, Object> map2 = objectMapper2.readValue(
                path2.toFile(),
                new TypeReference<Map<String, Object>>() { });
        return "Нихрена непонятно, но очень интересно\n" + map1 + "\n" + map2;
    }
}
