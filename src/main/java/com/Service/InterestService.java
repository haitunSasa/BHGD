package com.Service;

import com.Entity.Interest;

import java.util.List;

/**
 * Created by liyan on 2017/6/27.
 */
public interface InterestService extends BaseServiceI<Interest> {
    List<Interest> getByUIAndQI(int userId,int question);
    List<Interest> getByNU(int userId);

}
