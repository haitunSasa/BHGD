package com.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liyan on 2017/6/27.
 */
@Entity
@Table(name = "interest", schema = "knowledge_sharing", catalog = "")
public class Interest {
    private int interestId;
    private Double interestWeight;
    private Timestamp interestTime;
    private Integer userId;
    private Integer questionId;
    private Timestamp interestUpdateTime;

    @Id
    @Column(name = "interestId")
    public int getInterestId() {
        return interestId;
    }

    public void setInterestId(int interestId) {
        this.interestId = interestId;
    }

    @Basic
    @Column(name = "interestWeight")
    public Double getInterestWeight() {
        return interestWeight;
    }

    public void setInterestWeight(Double interestWeight) {
        this.interestWeight = interestWeight;
    }

    @Basic
    @Column(name = "interestTime")
    public Timestamp getInterestTime() {
        return interestTime;
    }

    public void setInterestTime(Timestamp interestTime) {
        this.interestTime = interestTime;
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
    @Column(name = "questionId")
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "interestUpdateTime")
    public Timestamp getInterestUpdateTime() {
        return interestUpdateTime;
    }

    public void setInterestUpdateTime(Timestamp interestUpdateTime) {
        this.interestUpdateTime = interestUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interest interest = (Interest) o;

        if (interestId != interest.interestId) return false;
        if (interestWeight != null ? !interestWeight.equals(interest.interestWeight) : interest.interestWeight != null)
            return false;
        if (interestTime != null ? !interestTime.equals(interest.interestTime) : interest.interestTime != null)
            return false;
        if (userId != null ? !userId.equals(interest.userId) : interest.userId != null) return false;
        if (questionId != null ? !questionId.equals(interest.questionId) : interest.questionId != null) return false;
        if (interestUpdateTime != null ? !interestUpdateTime.equals(interest.interestUpdateTime) : interest.interestUpdateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = interestId;
        result = 31 * result + (interestWeight != null ? interestWeight.hashCode() : 0);
        result = 31 * result + (interestTime != null ? interestTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (interestUpdateTime != null ? interestUpdateTime.hashCode() : 0);
        return result;
    }
}
