package com.abm.web.service;

import com.abm.web.exception.ParamNullException;
import com.abm.web.pojo.User;

public interface UserService {

	public User getByFid(String fid) throws ParamNullException;
}
