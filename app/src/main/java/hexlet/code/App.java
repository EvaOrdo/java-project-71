package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, description = "Compares two configuration files and shows a difference.")

public class App implements Callable<String > {

    @Parameters(index = "0", description = "filepath1")
    private String filepath1;

    @Parameters(index = "1", description = "filepath2")
    private String filepath2;

    public String call() {
        return "";
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
