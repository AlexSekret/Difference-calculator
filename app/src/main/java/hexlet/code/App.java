package hexlet.code;
import hexlet.code.Differ;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import static hexlet.code.Differ.*;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filepath1 = "";

    @Parameters(paramLabel = "filepath1", description = "path to second file")
    private String filepath2 = "";

    @Override
    public void run() {
        System.out.println(generate());
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

