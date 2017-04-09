package com.Entity;

/**
 * Created by liyan on 2017/3/30.
 */
public class FollowEntity {
    private int followId;
    private Integer userId;
    private Integer followUserId;

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Integer followUserId) {
        this.followUserId = followUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FollowEntity that = (FollowEntity) o;

        if (followId != that.followId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (followUserId != null ? !followUserId.equals(that.followUserId) : that.followUserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = followId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (followUserId != null ? followUserId.hashCode() : 0);
        return result;
    }
}
