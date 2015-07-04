package com.abm.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abm.web.dao.FavoriteDao;
import com.abm.web.enums.FavorType;
import com.abm.web.pojo.Favorite;
import com.abm.web.service.FavoriteService;
import com.abm.web.utils.DateUtil;
@Service
public class FavoriteServiceImpl implements FavoriteService{

	@Resource
	private FavoriteDao favoriteDao;
	
	@Override
	public void addFavorite(Favorite favorite) {
		String now = DateUtil.getNowday();
		favorite.setCreatedTs(now);
		favorite.setUpdatedTs(now);
		favoriteDao.addFavorite(favorite);
	}

	@Override
	public Favorite getFavorite(String userFid, String favorFid, FavorType favorType) {
		return favoriteDao.getFavorite(userFid, favorFid, favorType.getCode());
	}

	@Override
	public void delFavorite(Integer id) {
		favoriteDao.delFavorite(id);
	}

	@Override
	public List<Favorite> getUserFavorList(String userFid, FavorType favorType) {
		return favoriteDao.getUserFavorList(userFid, favorType.getCode());
	}

}
