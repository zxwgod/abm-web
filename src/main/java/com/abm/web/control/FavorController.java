package com.abm.web.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abm.web.enums.FavorType;
import com.abm.web.enums.FavorTypeReq;
import com.abm.web.exception.ParamNullException;
import com.abm.web.pojo.Favorite;
import com.abm.web.pojo.User;
import com.abm.web.request.FavorListReq;
import com.abm.web.response.BaseListData;
import com.abm.web.response.BaseResp;
import com.abm.web.response.RespInfo;
import com.abm.web.service.FavoriteService;
import com.abm.web.service.UserService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "abm/favor")
public class FavorController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(FavorController.class);
	
	@Resource
	private FavoriteService favoriteService;
	
	@Resource
	private UserService userService;

	@RequestMapping(value = "list")
    @ResponseBody
	public Object list(String params){
		logger.info("list receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		FavorListReq favorListReq = JSON.parseObject(params, FavorListReq.class);
		
		FavorTypeReq type = FavorTypeReq.codeOf(favorListReq.getType());
		if(type == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		FavorType favorType = null;
		if(type == FavorTypeReq.GUIDE){
			favorType = FavorType.RECOMMEND;
		} else if(type == FavorTypeReq.PRODUCT){
			favorType = FavorType.PRODUCT;
		} else {
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		try {
			User user = userService.getByFid(favorListReq.getUserId());
			if(user == null){
				return new BaseResp(RespInfo.USER_NOT_EXISTS_ERROR);
			}
		} catch (ParamNullException e) {
			logger.error("user id is null. exception ", e);
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		List<Favorite> userFavorList = favoriteService.getUserFavorList(favorListReq.getUserId(), favorType);
		
		logger.info("list get list {}", userFavorList);
		
		BaseListData<Favorite> data = new BaseListData<Favorite>(100, 0, userFavorList);
		
		
		result.setData(data);
		return result;
	}
	
}
