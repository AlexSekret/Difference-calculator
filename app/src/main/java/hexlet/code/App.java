package hexlet.code;
import hexlet.code.Differ;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import static hexlet.code.Differ.*;
//import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Runnable {
    @Override
    public void run() {
        System.out.println(generate());
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

