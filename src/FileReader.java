import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FileReader {
    public void readLine(String filename, List<String> list){
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(filename))) {
            while (reader.ready()) {
                String line = reader.readLine();
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something wrong!!!");
        }
    }
}
