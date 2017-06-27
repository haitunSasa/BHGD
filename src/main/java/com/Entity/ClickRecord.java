package com.Entity;

import javax.persistence.*;

/**
 * Created by liyan on 2017/6/7.
 */
@Entity
@Table(name = "click_record", schema = "knowledge_sharing", catalog = "")
public class ClickRecord {
    private int clickRecordId;
    private Integer userId;
    private Integer questionId;
    private Integer count;

    @Id
    @Column(name = "clickRecordId")
    public int getClickRecordId() {
        return clickRecordId;
    }

    public void setClickRecordId(int clickRecordId) {
        this.clickRecordId = clickRecordId;
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
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClickRecord that = (ClickRecord) o;

        if (clickRecordId != that.clickRecordId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clickRecordId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }
}
