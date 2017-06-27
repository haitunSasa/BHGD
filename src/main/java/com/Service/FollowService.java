package com.Service;

import com.Entity.Follow;

import java.util.List;

/**
 * Created by liyan on 2017/4/16.
 */
public interface FollowService extends BaseServiceI<Follow> {
    List<Follow> findByUIdAndFId (int userId,int followId);
}
