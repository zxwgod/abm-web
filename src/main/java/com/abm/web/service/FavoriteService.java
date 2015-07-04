package com.abm.web.service;

import java.util.List;

import com.abm.web.enums.FavorType;
import com.abm.web.pojo.Favorite;

public interface FavoriteService {

	 public void addFavorite(Favorite favorite);
	 
	 public Favorite getFavorite(String userFid, String favorFid, FavorType favorType);
	 
	 public void delFavorite(Integer id);
	 
	 public List<Favorite> getUserFavorList(String userFid, FavorType favorType);
}
