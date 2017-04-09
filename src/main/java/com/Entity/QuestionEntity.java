package com.Entity;

import java.sql.Timestamp;

/**
 * Created by liyan on 2017/3/30.
 */
public class QuestionEntity {
    private int questionId;
    private String questionTitle;
    private String questionContent;
    private Integer questionTypeId;
    private Integer questionReward;
    private Integer questionIsAnswer;
    private Timestamp questionTime;
    private Integer userId;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public Integer getQuestionReward() {
        return questionReward;
    }

    public void setQuestionReward(Integer questionReward) {
        this.questionReward = questionReward;
    }

    public Integer getQuestionIsAnswer() {
        return questionIsAnswer;
    }

    public void setQuestionIsAnswer(Integer questionIsAnswer) {
        this.questionIsAnswer = questionIsAnswer;
    }

    public Timestamp getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Timestamp questionTime) {
        this.questionTime = questionTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        if (questionId != that.questionId) return false;
        if (questionTitle != null ? !questionTitle.equals(that.questionTitle) : that.questionTitle != null)
            return false;
        if (questionContent != null ? !questionContent.equals(that.questionContent) : that.questionContent != null)
            return false;
        if (questionTypeId != null ? !questionTypeId.equals(that.questionTypeId) : that.questionTypeId != null)
            return false;
        if (questionReward != null ? !questionReward.equals(that.questionReward) : that.questionReward != null)
            return false;
        if (questionIsAnswer != null ? !questionIsAnswer.equals(that.questionIsAnswer) : that.questionIsAnswer != null)
            return false;
        if (questionTime != null ? !questionTime.equals(that.questionTime) : that.questionTime != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId;
        result = 31 * result + (questionTitle != null ? questionTitle.hashCode() : 0);
        result = 31 * result + (questionContent != null ? questionContent.hashCode() : 0);
        result = 31 * result + (questionTypeId != null ? questionTypeId.hashCode() : 0);
        result = 31 * result + (questionReward != null ? questionReward.hashCode() : 0);
        result = 31 * result + (questionIsAnswer != null ? questionIsAnswer.hashCode() : 0);
        result = 31 * result + (questionTime != null ? questionTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
