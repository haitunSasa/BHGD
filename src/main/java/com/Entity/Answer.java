package com.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liyan on 2017/4/16.
 */
@Entity
@Table(name = "answer", schema = "knowledge_sharing", catalog = "")
public class Answer {
    private int answerId;
    private String answerContent;
    private Integer questionId;
    private Integer userId;
    private Timestamp answerTime;
    private Short isFree;

    @Id
    @Column(name = "answerId")
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Basic
    @Column(name = "answerContent")
    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    @Basic
    @Column(name = "questionId")
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "answerTime")
    public Timestamp getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Timestamp answerTime) {
        this.answerTime = answerTime;
    }

    @Basic
    @Column(name = "isFree")
    public Short getIsFree() {
        return isFree;
    }

    public void setIsFree(Short isFree) {
        this.isFree = isFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer that = (Answer) o;

        if (answerId != that.answerId) return false;
        if (answerContent != null ? !answerContent.equals(that.answerContent) : that.answerContent != null)
            return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (answerTime != null ? !answerTime.equals(that.answerTime) : that.answerTime != null) return false;
        if (isFree != null ? !isFree.equals(that.isFree) : that.isFree != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = answerId;
        result = 31 * result + (answerContent != null ? answerContent.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (answerTime != null ? answerTime.hashCode() : 0);
        result = 31 * result + (isFree != null ? isFree.hashCode() : 0);
        return result;
    }
}
