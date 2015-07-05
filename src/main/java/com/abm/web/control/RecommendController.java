package com.abm.web.control;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abm.web.enums.FavorType;
import com.abm.web.enums.PraiseType;
import com.abm.web.enums.RecommendType;
import com.abm.web.exception.ObjectNotFoundException;
import com.abm.web.exception.ParamNullException;
import com.abm.web.pojo.Favorite;
import com.abm.web.pojo.Guide;
import com.abm.web.pojo.Recommend;
import com.abm.web.pojo.User;
import com.abm.web.request.BaseListReq;
import com.abm.web.request.PraiseRecommendReq;
import com.abm.web.request.RecommendDetailReq;
import com.abm.web.response.BaseListData;
import com.abm.web.response.BaseResp;
import com.abm.web.response.RespInfo;
import com.abm.web.service.FavoriteService;
import com.abm.web.service.GuideService;
import com.abm.web.service.ProductService;
import com.abm.web.service.RecommendService;
import com.abm.web.service.UserService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "abm/recommend")
public class RecommendController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(RecommendController.class);
	
	@Resource
	private RecommendService recommendService;
	@Resource
	private ProductService productService;
	@Resource 
	private FavoriteService favoriteService;
	@Resource
	private GuideService guideService;
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
		
		BaseListReq baseListReq = JSON.parseObject(params, BaseListReq.class);
		
		setCurrentUser(baseListReq.getUserId());
		
		List<Recommend> recommendList = recommendService.getList(baseListReq.getStart(), baseListReq.getLength());
		int count = recommendService.getCount();

		logger.info("list get recommend list {}", recommendList);
		
		BaseListData<Recommend> data = new BaseListData<Recommend>(count, baseListReq.getStart(), recommendList);
		
		result.setData(data);
		return result;
	}
	
	@RequestMapping(value = "praise")
    @ResponseBody
	public Object praise(String params){
		logger.info("praise receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		PraiseRecommendReq praiseRecommendReq = JSON.parseObject(params, PraiseRecommendReq.class);
		String userFid = praiseRecommendReq.getUserId();
		User user;
		try {
			user = userService.getByFid(userFid);
		} catch (ParamNullException e) {
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		if(user == null){
			return new BaseResp(RespInfo.USER_NOT_EXISTS_ERROR);
		}

		try {
			Recommend recommend = recommendService.getByFid(praiseRecommendReq.getRecommendId());
			if(recommend == null) throw new ObjectNotFoundException();
			
			if(praiseRecommendReq.getOperate() == PraiseType.PRAISE.getCode()){//收藏
				Favorite favorite = favoriteService.getFavorite(userFid, recommend.getFid(), FavorType.RECOMMEND);
				if(favorite != null){
					logger.info("favorite is already exists, favorite {}", favorite);
					return new BaseResp(RespInfo.FAVORITE_EXISTS_ERROR);
				}
				
				guideService.praiseGuide(recommend.getRecommendFid());
				
				favorite = new Favorite();
				favorite.setFavorFid(recommend.getFid());
				favorite.setDesc(recommend.getDesc());
				favorite.setFavorUrl(recommend.getUrl());
				favorite.setFavorPic(recommend.getPic());
				favorite.setUserFid(praiseRecommendReq.getUserId());
				favorite.setType(FavorType.RECOMMEND.getCode());
				favorite.setTitle(recommend.getTitle());
				favoriteService.addFavorite(favorite);
			} else if(praiseRecommendReq.getOperate() == PraiseType.UN_PRAISE.getCode()){//取消收藏
				Favorite favorite = favoriteService.getFavorite(praiseRecommendReq.getUserId(), praiseRecommendReq.getRecommendId(), FavorType.RECOMMEND);
				if(favorite == null) throw new ObjectNotFoundException();
				
				favoriteService.delFavorite(favorite.getId());
				if(recommend.getRecommendType() == RecommendType.GUIDE.getCode()){
					guideService.unPraiseGuide(recommend.getRecommendFid());
				}
			}
		} catch (ObjectNotFoundException e) {
			logger.error("data is not found. exception ", e);
			return new BaseResp(RespInfo.OBJECT_NOT_EXISTS_ERROR);
		}
		
		return result;
	}
	
	@RequestMapping(value = "detail")
    @ResponseBody
	public Object detail(String params){
		logger.info("detail receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		RecommendDetailReq recommendDetailReq = JSON.parseObject(params, RecommendDetailReq.class);
		
		Recommend recommend = recommendService.getByFid(recommendDetailReq.getRecommendId());
		
		if(recommend == null){
			return new BaseResp(RespInfo.RECOMMEND_NOT_EXISTS_ERROR);
		}
		
		if(recommend.getRecommendType() == RecommendType.GUIDE.getCode()){
			Guide guide = guideService.getByFid(recommend.getRecommendFid());
			
			if(guide != null && StringUtils.isNotBlank(recommendDetailReq.getUserId())){
				Favorite favorite = favoriteService.getFavorite(recommendDetailReq.getUserId(), recommendDetailReq.getRecommendId(), FavorType.RECOMMEND);
				if(favorite != null){
					guide.setUserPraise(true);
				}
			}
			result.setData(guide);
		}
		
		return result;
	}
	
}
