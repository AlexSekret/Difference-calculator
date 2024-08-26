package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Utils {
    public static String getFileExtension(String filePath) throws Exception {
        Path normilezedPath = getNormalized(filePath);
        String[] fileInfo = normilezedPath.getFileName().toString().split("\\.");
        return Arrays.stream(fileInfo).toList().getLast();
    }

    public static String getFileContent(String filePath) throws Exception {
        var normalisedPath = getNormalized(filePath);
        if (!Files.exists(normalisedPath)) {
            throw new Exception("File '" + normalisedPath + "' does not exist");
        }
        return Files.readString(normalisedPath);
    }

    private static Path getNormalized(String filepath) {
        Path path = Path.of(filepath);
        return path.toAbsolutePath().normalize();
    }
}
