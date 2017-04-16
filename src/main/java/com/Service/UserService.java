package com.Service;

import com.Entity.UsersEntity;

import java.util.List;

public interface UserService extends BaseServiceI<UsersEntity> {
	public  List<UsersEntity>  getUserByUserName(String userName);
}
