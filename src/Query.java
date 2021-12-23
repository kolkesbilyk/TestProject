import enums.*;

import java.time.LocalDate;

public class Query {
    private final Type type = Type.D;
    private final String serviceId;
    private final String variationId;
    private final String questionTypeId;
    private final String categoryId;
    private final String subCategoryId;
    private final ResponseType responseType;
    private final LocalDate dateFrom;
    private final LocalDate dateTo;

    public Query(String serviceId,
                 String variationId,
                 String questionTypeId,
                 String categoryId,
                 String subCategoryId,
                 ResponseType responseType,
                 LocalDate dateFrom,
                 LocalDate dateTo) {
        this.serviceId = serviceId;
        this.variationId = variationId;
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.responseType = responseType;
        this.dateFrom = dateFrom;
        if(dateTo == null){
            this.dateTo = dateFrom;
        }else this.dateTo = dateTo;
    }

    public Type getType() {
        return type;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getVariationId() {
        return variationId;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    @Override
    public String toString() {
        return "Query{" +
                "type=" + type +
                ", serviceId='" + serviceId + '\'' +
                ", variationId='" + variationId + '\'' +
                ", questionTypeId='" + questionTypeId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", subCategoryId='" + subCategoryId + '\'' +
                ", responseType=" + responseType +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
