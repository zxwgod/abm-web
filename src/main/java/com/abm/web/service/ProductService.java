package com.abm.web.service;

import java.util.List;

import com.abm.web.exception.ObjectNotFoundException;
import com.abm.web.pojo.Product;

public interface ProductService {

	public void praiseProduct(String fid) throws ObjectNotFoundException;

	public void unPraiseProduct(String fid) throws ObjectNotFoundException;
	
	public Product getByFid(String fid);
	
	public List<Product> searchByCategory(String cate1Fid, String cate2Fid, int start, int length);

	public int searchByCategoryCount(String cate1Fid, String cate2Fid);
	
	public List<Product> searchByCategory9(String cate9Fid, int start, int length);

	public int searchByCategory9Count(String cate9Fid);
}
