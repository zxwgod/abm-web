package com.abm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abm.web.pojo.Favorite;

public interface FavoriteDao {

	 public void addFavorite(Favorite favorite);
	 
	 public Favorite getFavorite(@Param("userFid")String userFid
			 , @Param("favorFid")String favorFid, @Param("favorType")int favorType);
	 
	 public void delFavorite(Integer id);
	 
	 public List<Favorite> getUserFavorList(@Param("userFid")String userFid
			 , @Param("favorType")int favorType);
}
