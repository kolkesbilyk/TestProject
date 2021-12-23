import enums.*;

import java.time.LocalDate;

public class Waiting {
    private final Type TYPE = Type.C;
    private final String serviceId;
    private final String variationId;
    private final String questionTypeId;
    private final String categoryId;
    private final String subCategoryId;
    private final ResponseType responseType;
    private final LocalDate date;
    private final int time;
    private final int id;

    public Waiting(String serviceId,
                   String variationId,
                   String questionTypeId,
                   String categoryId,
                   String subCategoryId,
                   ResponseType responseType,
                   LocalDate date,
                   int time,
                   int id) {
        this.serviceId = serviceId;
        this.variationId = variationId;
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.responseType = responseType;
        this.date = date;
        this.time = time;
        this.id = id;
    }

    public Type getTYPE() {
        return TYPE;
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

    public LocalDate getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Waiting{" +
                "TYPE=" + TYPE +
                ", serviceId='" + serviceId + '\'' +
                ", variationId='" + variationId + '\'' +
                ", questionTypeId='" + questionTypeId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", subCategoryId='" + subCategoryId + '\'' +
                ", responseType=" + responseType +
                ", date=" + date +
                ", time=" + time +
                ", id=" + id +
                '}';
    }
}
