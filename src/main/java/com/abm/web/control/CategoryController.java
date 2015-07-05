package com.abm.web.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abm.web.json.Cate9Item;
import com.abm.web.json.CateTreeItem;
import com.abm.web.json.SearchCateProduct;
import com.abm.web.pojo.Category;
import com.abm.web.pojo.Product;
import com.abm.web.request.Cate9ListReq;
import com.abm.web.request.CateTreeReq;
import com.abm.web.request.SearchCate9Req;
import com.abm.web.request.SearchCateTreeReq;
import com.abm.web.response.BaseListData;
import com.abm.web.response.BaseResp;
import com.abm.web.response.Cate9ListData;
import com.abm.web.response.CateTreeData;
import com.abm.web.response.RespInfo;
import com.abm.web.service.CategoryService;
import com.abm.web.service.ProductService;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "api/category")
public class CategoryController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private ProductService productService;

	@RequestMapping(value = "cate9")
    @ResponseBody
	public Object cate9(String params){
		logger.info("cate9 receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		//not used now
		Cate9ListReq cate9ListReq = JSON.parseObject(params, Cate9ListReq.class);
		
		List<Category> cate9List = categoryService.getCate9List();
		logger.info("cate9 get cate9List {}", cate9List);
		
		List<Cate9Item> cate9JsonList = Lists.newArrayList();
		for(Category category : cate9List){
			cate9JsonList.add(new Cate9Item(category));
		}
		
		Cate9ListData cate9ListData = new Cate9ListData(cate9JsonList);
		
		result.setData(cate9ListData);
		return result;
	}
	
	@RequestMapping(value = "cateTree")
    @ResponseBody
	public Object cateTree(String params){
		logger.info("cateTree receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		//not used now
		CateTreeReq cateTreeReq = JSON.parseObject(params, CateTreeReq.class);
		
		List<Category> cateTree = categoryService.getCateTreeList();
		logger.info("cateTree get list {}", cateTree);
		
		List<CateTreeItem> cateTreeJsonList = Lists.newArrayList();
		for(Category category : cateTree){
			cateTreeJsonList.add(new CateTreeItem(category));
		}
		
		CateTreeData cateTreeData = new CateTreeData(cateTreeJsonList);
		
		result.setData(cateTreeData);
		return result;
	}
	
	@RequestMapping(value = "searchCateTree")
    @ResponseBody
	public Object searchCateTree(String params){
		logger.info("searchCateTree receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		SearchCateTreeReq searchCateReq = JSON.parseObject(params, SearchCateTreeReq.class);
		
		List<Product> productList = productService.searchByCategory(searchCateReq.getBigCate()
				, searchCateReq.getSmallCate(), searchCateReq.getStart(), searchCateReq.getLength());
		int count = productService.searchByCategoryCount(searchCateReq.getBigCate(), searchCateReq.getSmallCate());
		logger.info("searchCateTree get list count{}, data {}", count, productList);
		
		List<SearchCateProduct> searchCateProductList = Lists.newArrayList();
		for(Product product : productList){
			searchCateProductList.add(new SearchCateProduct(product));
		}

		BaseListData<SearchCateProduct> data = new BaseListData<SearchCateProduct>(count, searchCateReq.getStart(), searchCateProductList);
		
		result.setData(data);
		return result;
	}
	
	@RequestMapping(value = "searchCate9")
    @ResponseBody
	public Object searchCate9(String params){
		logger.info("searchCate9 receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		SearchCate9Req searchCate9Req = JSON.parseObject(params, SearchCate9Req.class);
		
		if(searchCate9Req.getCateId() == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		List<Product> productList = productService.searchByCategory9(
				searchCate9Req.getCateId(), searchCate9Req.getStart(), searchCate9Req.getLength());
		int count = productService.searchByCategory9Count(searchCate9Req.getCateId());
		logger.info("searchCate9 get list count{}, data {}", count, productList);
		
		List<SearchCateProduct> searchCateProductList = Lists.newArrayList();
		for(Product product : productList){
			searchCateProductList.add(new SearchCateProduct(product));
		}

		BaseListData<SearchCateProduct> data = new BaseListData<SearchCateProduct>(count, searchCate9Req.getStart(), searchCateProductList);
		
		result.setData(data);
		return result;
	}
}
