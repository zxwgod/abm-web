package com.abm.web.control;

import javax.annotation.Resource;

import com.abm.web.dao.global.ThreadContent;
import com.abm.web.exception.ParamNullException;
import com.abm.web.pojo.User;
import com.abm.web.service.UserService;

public class BaseController {

	@Resource
	private UserService userService;
	
	protected void setCurrentUser(String userFid){
		if(userFid != null){
			User user = null;
			try {
				user = userService.getByFid(userFid);
			} catch (ParamNullException e) {
			}
			
			ThreadContent.setCurrentUser(user);
		}
	}
}
