package com.abm.web.dao;

import org.apache.ibatis.annotations.Param;

import com.abm.web.pojo.Guide;

public interface GuideDao {

	public Guide getByFid(String fid);
	
	public void praiseGuide(@Param("fid")String fid, @Param("praise")int praise);
	
}
