package com.Entity;

/**
 * Created by liyan on 2017/3/30.
 */
public class QuestionTypeEntity {
    private int questionTypeId;
    private String questionType;

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionTypeEntity that = (QuestionTypeEntity) o;

        if (questionTypeId != that.questionTypeId) return false;
        if (questionType != null ? !questionType.equals(that.questionType) : that.questionType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionTypeId;
        result = 31 * result + (questionType != null ? questionType.hashCode() : 0);
        return result;
    }
}
