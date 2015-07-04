package com.abm.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abm.web.pojo.Product;

public interface ProductDao {

	public Product getByFid(String fid);
	
	public void praiseProduct(String fid, int praise);
	
	public List<Product> searchByCategory(@Param("cate1Fid")String cate1Fid
			, @Param("cate2Fid")String cate2Fid, @Param("start")int start, @Param("count")int count);

	public int searchByCategoryCount(@Param("cate1Fid")String cate1Fid, @Param("cate2Fid")String cate2Fid);
	
	public List<Product> searchByCategory9(@Param("cate9Fid")String cate9Fid
			, @Param("start")int start, @Param("count")int count);

	public int searchByCategory9Count(String cate9Fid);
}
