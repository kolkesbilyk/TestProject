import enums.ResponseType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private static final List<Waiting> waitings = new ArrayList<>();
    private static final List<Query> queries = new ArrayList<>();

    public void sortingLines(List<String> list){
        for (String s: list) {
            String[] array = s.split(" ");
            if (array[0].equals("C")) {
                String[] serviceArray = getArray(array[1], "\\.");
                String[] questionArray = getArray(array[2], "\\.");
                Waiting waiting = new Waiting(serviceArray[0],
                        serviceArray[1],
                        questionArray[0],
                        questionArray[1],
                        questionArray[2],
                        responseType(array[3]),
                        parserDate(array[4]),
                        Integer.parseInt(array[5]));
                waitings.add(waiting);
            } else if (array[0].equals("D")) {
                String[] serviceArray = getArray(array[1], "\\.");
                String[] questionArray = getArray(array[2], "\\.");
                String[] dateArray = getArray(array[4], "-");
                Query query = new Query(serviceArray[0],
                        serviceArray[1],
                        questionArray[0],
                        questionArray[1],
                        questionArray[2],
                        responseType(array[3]),
                        parserDate(dateArray[0]),
                        parserDate(dateArray[1]));
                queries.add(query);
            }
        }
    }

    private LocalDate parserDate(String date){
        if (date == null){
            return null;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, dtf);
    }

    private ResponseType responseType(String s){
        if (s.equals("N")) {
            return ResponseType.N;
        } else if (s.equals("P"))
            return ResponseType.P;
        else return null;
    }

    private String[] getArray(String strings, String regex){
        String[] output = new String[3];
        String[] input = strings.split(regex);
        if (input.length == 3) {
            output[0] = input[0];
            output[1] = input[1];
            output[2] = input[2];
            return output;
        } else if (input.length == 2){
            output[0] = input[0];
            output[1] = input[1];
            return output;
        }else {
            output[0] = input[0];
            return output;
        }
    }

    public List<Waiting> getWaitings() {
        return waitings;
    }

    public List<Query> getQueries() {
        return queries;
    }
}
