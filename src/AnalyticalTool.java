import java.util.ArrayList;
import java.util.List;

public class AnalyticalTool {

    private static final List<String> lines = new ArrayList<>();
    private static final String FILE_NAME = "input.txt";

    public static void main(String[] args) {
        new FileReader().readLine(FILE_NAME, lines);
        new Service().sortingLines(lines);
        new Logic().results();
    }
}
