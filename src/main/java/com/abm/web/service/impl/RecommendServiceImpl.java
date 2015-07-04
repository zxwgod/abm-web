package com.abm.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abm.web.dao.FavoriteDao;
import com.abm.web.dao.GuideDao;
import com.abm.web.dao.ProductDao;
import com.abm.web.dao.RecommendDao;
import com.abm.web.dao.UserDao;
import com.abm.web.dao.global.ThreadContent;
import com.abm.web.enums.FavorType;
import com.abm.web.enums.RecommendType;
import com.abm.web.pojo.Favorite;
import com.abm.web.pojo.Guide;
import com.abm.web.pojo.Recommend;
import com.abm.web.pojo.User;
import com.abm.web.service.RecommendService;
@Service
public class RecommendServiceImpl implements RecommendService{

	@Resource
	private RecommendDao recommendDao;
	@Resource
	private UserDao userDao;
	@Resource
	private ProductDao productDao;
	@Resource
	private GuideDao guideDao;
	@Resource
	private FavoriteDao favoriteDao;
	
	@Override
	public List<Recommend> getList(int start, int count) {
		List<Recommend> recommendList = recommendDao.getList(start, count);
		User currentUser = ThreadContent.getCurrentUser();
		
		for(Recommend recommend : recommendList){
			User user = userDao.getByFid(recommend.getUserFid());
			if(user != null){
				recommend.setUserName(user.getName());
				recommend.setUserHead(user.getHeadPic());
			}
			
			if(RecommendType.GUIDE.getCode() == recommend.getRecommendType()){
				Guide guide = guideDao.getByFid(recommend.getRecommendFid());
				recommend.setPraise(guide.getPraise());
			}
			
			if(currentUser != null){
				Favorite favorite = favoriteDao.getFavorite(currentUser.getFid(), recommend.getFid(), FavorType.RECOMMEND.getCode());
				if(favorite != null){
					recommend.setUserPraise(true);
				}
			}
		}
		
		return recommendList;
	}

	@Override
	public int getCount() {
		return recommendDao.getCount();
	}

	@Override
	public Recommend getByFid(String fid) {
		return recommendDao.getByFid(fid);
	}

}
