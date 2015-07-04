package com.abm.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abm.web.dao.HotProductDao;
import com.abm.web.dao.ProductDao;
import com.abm.web.pojo.HotProduct;
import com.abm.web.pojo.Product;
import com.abm.web.service.HotProductService;

@Service
public class HotProductServiceImpl implements HotProductService{

	@Resource
	private HotProductDao hotProductDao;
	@Resource
	private ProductDao productDao;
	
	@Override
	public List<HotProduct> getList(int start, int count) {
		List<HotProduct> hotProductList = hotProductDao.getList(start, count);
		for(HotProduct hotProduct : hotProductList){
			
			Product product = productDao.getByFid(hotProduct.getProductId());
			if(product != null){
				hotProduct.setPraise(product.getPraise());
				hotProduct.setPrice(product.getPrice());
			}
		}
		return hotProductList;
	}
	@Override
	public int getCount() {
		return hotProductDao.getCount();
	}

}
