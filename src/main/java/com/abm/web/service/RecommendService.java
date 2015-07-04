package com.abm.web.service;

import java.util.List;

import com.abm.web.pojo.Recommend;

public interface RecommendService {

	public List<Recommend> getList(int start, int count);
	
	public int getCount();
	
	public Recommend getByFid(String fid);
	
}
