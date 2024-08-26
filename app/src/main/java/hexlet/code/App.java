package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 0.0",
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<Integer> {
    @Option(names = {"-f", "--format"},
            description = """
                    Output format [default: ${DEFAULT-VALUE}].
                    Supported output formats: plain, stylish, json.""",
            defaultValue = "stylish")
    private static String format;
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private static String filepath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private static String filepath2;

    @Override
    public Integer call() {
        try {
            System.out.println(Differ.generate(filepath1, filepath2, format));
        } catch (Exception e) {
            System.out.println("Oops!: " + e.getMessage());
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

