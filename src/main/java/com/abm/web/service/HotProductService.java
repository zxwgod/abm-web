package com.abm.web.service;

import java.util.List;

import com.abm.web.pojo.HotProduct;

public interface HotProductService {
	public List<HotProduct> getList(int start, int count);
	
	public int getCount();
}
