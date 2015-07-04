package com.abm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abm.web.pojo.Recommend;

public interface RecommendDao {

	public List<Recommend> getList(@Param("start")int start, @Param("count")int count);
	
	public int getCount();
	
	public Recommend getByFid(String fid);
}
