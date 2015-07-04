package com.abm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abm.web.pojo.HotProduct;

public interface HotProductDao {
	public List<HotProduct> getList(@Param("start")int start, @Param("count")int count);
	public int getCount();
}
