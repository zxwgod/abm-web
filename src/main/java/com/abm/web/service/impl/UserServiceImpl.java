package com.abm.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abm.web.dao.UserDao;
import com.abm.web.exception.ParamNullException;
import com.abm.web.pojo.User;
import com.abm.web.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	@Override
	public User getByFid(String fid) throws ParamNullException {
		if(fid == null){
			throw new ParamNullException();
		}
		
		return userDao.getByFid(fid);
	}

}
