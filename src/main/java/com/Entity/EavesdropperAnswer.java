package com.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liyan on 2017/4/16.
 */
@Entity
@Table(name = "eavesdropper_answer", schema = "knowledge_sharing", catalog = "")
public class EavesdropperAnswer {
    private int eavesdropperAnswerId;
    private Integer answerId;
    private Integer userId;
    private Timestamp eavesdroppingTime;
    private Short isPaid;

    @Id
    @Column(name = "eavesdropperAnswerId")
    public int getEavesdropperAnswerId() {
        return eavesdropperAnswerId;
    }

    public void setEavesdropperAnswerId(int eavesdropperAnswerId) {
        this.eavesdropperAnswerId = eavesdropperAnswerId;
    }

    @Basic
    @Column(name = "answerId")
    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
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
    @Column(name = "eavesdroppingTime")
    public Timestamp getEavesdroppingTime() {
        return eavesdroppingTime;
    }

    public void setEavesdroppingTime(Timestamp eavesdroppingTime) {
        this.eavesdroppingTime = eavesdroppingTime;
    }

    @Basic
    @Column(name = "isPaid")
    public Short getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Short isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EavesdropperAnswer that = (EavesdropperAnswer) o;

        if (eavesdropperAnswerId != that.eavesdropperAnswerId) return false;
        if (answerId != null ? !answerId.equals(that.answerId) : that.answerId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (eavesdroppingTime != null ? !eavesdroppingTime.equals(that.eavesdroppingTime) : that.eavesdroppingTime != null)
            return false;
        if (isPaid != null ? !isPaid.equals(that.isPaid) : that.isPaid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eavesdropperAnswerId;
        result = 31 * result + (answerId != null ? answerId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (eavesdroppingTime != null ? eavesdroppingTime.hashCode() : 0);
        result = 31 * result + (isPaid != null ? isPaid.hashCode() : 0);
        return result;
    }
}
