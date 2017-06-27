package com.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by liyan on 2017/6/27.
 */
@Entity
@Table(name = "pearson_similar", schema = "knowledge_sharing", catalog = "")
public class PearsonSimilar {
    private int pearsonId;
    private Integer userUId;
    private Integer userVId;
    private Timestamp time;
    private Double pearsonWeight;

    @Id
    @Column(name = "pearsonId")
    public int getPearsonId() {
        return pearsonId;
    }

    public void setPearsonId(int pearsonId) {
        this.pearsonId = pearsonId;
    }

    @Basic
    @Column(name = "userUId")
    public Integer getUserUId() {
        return userUId;
    }

    public void setUserUId(Integer userUId) {
        this.userUId = userUId;
    }

    @Basic
    @Column(name = "userVId")
    public Integer getUserVId() {
        return userVId;
    }

    public void setUserVId(Integer userVId) {
        this.userVId = userVId;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "pearsonWeight")
    public Double getPearsonWeight() {
        return pearsonWeight;
    }

    public void setPearsonWeight(Double pearsonWeight) {
        this.pearsonWeight = pearsonWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PearsonSimilar that = (PearsonSimilar) o;

        if (pearsonId != that.pearsonId) return false;
        if (userUId != null ? !userUId.equals(that.userUId) : that.userUId != null) return false;
        if (userVId != null ? !userVId.equals(that.userVId) : that.userVId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (pearsonWeight != null ? !pearsonWeight.equals(that.pearsonWeight) : that.pearsonWeight != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pearsonId;
        result = 31 * result + (userUId != null ? userUId.hashCode() : 0);
        result = 31 * result + (userVId != null ? userVId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (pearsonWeight != null ? pearsonWeight.hashCode() : 0);
        return result;
    }
}
