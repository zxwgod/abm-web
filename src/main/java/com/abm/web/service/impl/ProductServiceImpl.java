package com.abm.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abm.web.dao.FavoriteDao;
import com.abm.web.dao.ProductDao;
import com.abm.web.dao.global.ThreadContent;
import com.abm.web.enums.FavorType;
import com.abm.web.exception.ObjectNotFoundException;
import com.abm.web.pojo.Favorite;
import com.abm.web.pojo.Product;
import com.abm.web.pojo.User;
import com.abm.web.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{

	@Resource
	private ProductDao productDao;
	@Resource
	private FavoriteDao favoriteDao;
	
	@Override
	public void praiseProduct(String fid) throws ObjectNotFoundException {
		Product product = productDao.getByFid(fid);
		if(product == null){
			throw new ObjectNotFoundException();
		}
		productDao.praiseProduct(fid, product.getPraise() + 1);
	}
	
	@Override
	public void unPraiseProduct(String fid) throws ObjectNotFoundException {
		Product product = productDao.getByFid(fid);
		if(product == null){
			throw new ObjectNotFoundException();
		}
		productDao.praiseProduct(fid, product.getPraise() - 1);
	}

	@Override
	public Product getByFid(String fid) {
		Product product = productDao.getByFid(fid);

		User currentUser = ThreadContent.getCurrentUser();
		if(currentUser != null){
			Favorite favorite = favoriteDao.getFavorite(currentUser.getFid(), fid, FavorType.PRODUCT.getCode());
			if(favorite != null){
				product.setUserPraise(true);
			}
		}
		
		return product;
	}

	@Override
	public List<Product> searchByCategory(String cate1Fid, String cate2Fid, int start, int length) {
		return productDao.searchByCategory(cate1Fid, cate2Fid, start, length);
	}

	@Override
	public int searchByCategoryCount(String cate1Fid, String cate2Fid) {
		return productDao.searchByCategoryCount(cate1Fid, cate2Fid);
	}

	@Override
	public List<Product> searchByCategory9(String cate9Fid, int start,
			int length) {
		return productDao.searchByCategory9(cate9Fid, start, length);
	}

	@Override
	public int searchByCategory9Count(String cate9Fid) {
		return productDao.searchByCategory9Count(cate9Fid);
	}

}
