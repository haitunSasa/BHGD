package com.Entity;

import javax.persistence.*;

/**
 * Created by liyan on 2017/6/7.
 */
@Entity
@Table(name = "search_record", schema = "knowledge_sharing", catalog = "")
public class SearchRecord {
    private int recordId;
    private Integer userId;
    private String key;
    private Integer questionId;

    @Id
    @Column(name = "recordId")
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
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
    @Column(name = "key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Basic
    @Column(name = "questionId")
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchRecord that = (SearchRecord) o;

        if (recordId != that.recordId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recordId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        return result;
    }
}
