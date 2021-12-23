import java.util.ArrayList;
import java.util.List;

public class Logic {
    private final List<Query> queryList = new Service().getQueries();
    private final List<Waiting> waitingList = new Service().getWaitings();

    private boolean compareByService(Query query, Waiting waiting) {
        if (query.getServiceId().equals(waiting.getServiceId()) &&
                query.getVariationId() == null) return true;
        else if (query.getServiceId().equals(waiting.getServiceId()) &&
                query.getVariationId().equals(waiting.getVariationId())) return true;
        else if (query.getServiceId().equals(waiting.getServiceId()) &&
                query.getVariationId().equals("*")) return true;
        else return query.getServiceId().equals("*");
    }

    private boolean compareByQuestion(Query query, Waiting waiting){
        if (query.getQuestionTypeId().equals("*")) return true;
        else if (query.getQuestionTypeId().equals(waiting.getQuestionTypeId()) &&
                query.getCategoryId() == null) return true;
        else if (query.getQuestionTypeId().equals(waiting.getQuestionTypeId()) &&
                query.getCategoryId().equals(waiting.getCategoryId()) &&
                query.getSubCategoryId() == null) return true;
        else if (query.getQuestionTypeId().equals(waiting.getQuestionTypeId()) &&
                query.getCategoryId().equals("*")) return true;
        else if (query.getQuestionTypeId().equals(waiting.getQuestionTypeId()) &&
                query.getCategoryId().equals(waiting.getCategoryId()) &&
                query.getSubCategoryId().equals("*")) return true;
        else return query.getQuestionTypeId().equals(waiting.getQuestionTypeId()) &&
                    query.getCategoryId().equals(waiting.getCategoryId()) &&
                    query.getSubCategoryId().equals(waiting.getSubCategoryId());
    }

    private boolean compareByType(Query query, Waiting waiting){
        return query.getResponseType().equals(waiting.getResponseType());
    }

    private boolean compareByDate(Query query, Waiting waiting){
        if (waiting.getDate().isAfter(query.getDateFrom()) &&
                waiting.getDate().isBefore(query.getDateTo())) return true;
        else return waiting.getDate().equals(query.getDateFrom());
    }

    private boolean compareById(Query query, Waiting waiting){
        return query.getId() > waiting.getId();
    }

    private boolean compareByAllField(Query query, Waiting waiting){
        return compareByService(query, waiting) &&
                compareByQuestion(query, waiting) &&
                compareByType(query, waiting) &&
                compareByDate(query, waiting) &&
                compareById(query, waiting);
    }

    private String getResult(List<Waiting> list){
        int sum = 0;
        for (Waiting waiting : list) {
            sum += waiting.getTime();
        }
        return String.valueOf(sum / list.size());
    }

    public void results(){
        List<String> results = new ArrayList<>();
        for (Query query : queryList) {
            List<Waiting> waitingsTrue = new ArrayList<>();
            for (Waiting waiting : waitingList) {
                if (compareByAllField(query, waiting)) {
                    waitingsTrue.add(waiting);
                    System.out.println(waiting);
                }
            }
            if (!waitingsTrue.isEmpty()) {
                results.add(getResult(waitingsTrue));
            } else results.add("-");
            System.out.println("-------------------");
        }
        System.out.println(results);
    }
}