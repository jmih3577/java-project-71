package hexlet.code;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @Parameters(index = "0", description = "path to first file")
    private String filePath1;
    @Parameters(index = "1", description = "path to second file")
    private String filePath2;
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";
    @Override
    public final Integer call() throws Exception {
        //System.out.println(format);
        var result = Differ.generate(filePath1, filePath2, format);
        System.out.println(result);
        return 0;
    }
    public static void main(String[] args) {
        System.exit(new CommandLine(new App()).execute(args));
    }

}
