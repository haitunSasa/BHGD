package com.Entity;

import javax.persistence.*;

/**
 * Created by liyan on 2017/6/27.
 */
@Entity
@Table(name = "follow", schema = "knowledge_sharing", catalog = "")
public class Follow {
    private int followUserId;
    private Integer toUserId;
    private Integer fromUserId;
    private Integer type;

    @Id
    @Column(name = "followUserId", nullable = false)
    public int getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(int followUserId) {
        this.followUserId = followUserId;
    }

    @Basic
    @Column(name = "to_user_id", nullable = true)
    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    @Basic
    @Column(name = "from_user_id", nullable = true)
    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Follow follow = (Follow) o;

        if (followUserId != follow.followUserId) return false;
        if (toUserId != null ? !toUserId.equals(follow.toUserId) : follow.toUserId != null) return false;
        if (fromUserId != null ? !fromUserId.equals(follow.fromUserId) : follow.fromUserId != null) return false;
        if (type != null ? !type.equals(follow.type) : follow.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = followUserId;
        result = 31 * result + (toUserId != null ? toUserId.hashCode() : 0);
        result = 31 * result + (fromUserId != null ? fromUserId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
