package com.abm.web.control;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abm.web.exception.ParamNullException;
import com.abm.web.pojo.User;
import com.abm.web.request.UserDetailReq;
import com.abm.web.response.BaseResp;
import com.abm.web.response.RespInfo;
import com.abm.web.service.UserService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "api/user")
public class UserController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService userService;

	@RequestMapping(value = "detail")
    @ResponseBody
	public Object detail(String params){
		logger.info("detail receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		UserDetailReq userDetailReq = JSON.parseObject(params, UserDetailReq.class);
		
		User user = null;
		try {
			user = userService.getByFid(userDetailReq.getUserId());
		} catch (ParamNullException e) {
			logger.error("user id is null. exception ", e);
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		logger.info("detail get user {}", user);
		
		if(user == null){
			return new BaseResp(RespInfo.USER_NOT_EXISTS_ERROR);
		}
		result.setData(user);
		return result;
	}
	
}
