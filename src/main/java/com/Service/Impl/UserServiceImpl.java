package com.Service.Impl;

import com.Dao.BaseDaoI;
import com.Entity.UsersEntity;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UsersEntity> implements UserService {
	@Autowired 
	private BaseDaoI<UsersEntity> dao;
	private List<UsersEntity> list = new ArrayList<UsersEntity>();
	@Override
	public List<UsersEntity> getUserByUserName(String userName) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        
        String hql = "from Users t where userName =:userName";
        list = this.dao.find(hql, params);
		return list;
	}
	

}
