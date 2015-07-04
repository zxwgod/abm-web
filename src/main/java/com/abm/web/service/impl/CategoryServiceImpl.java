package com.abm.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abm.web.dao.CategoryDao;
import com.abm.web.pojo.Category;
import com.abm.web.service.CategoryService;
import com.google.common.collect.Lists;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Resource
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getCate9List() {
		return categoryDao.getCate9List();
	}

	@Override
	public List<Category> getCateTreeList() {
		List<Category> categoryTree = Lists.newArrayList();
		
		List<Category> categoryList = categoryDao.getCateTreeList();
		for(Category category : categoryList){
			if(category.getType() == Category.CATE_FIRST){
				categoryTree.add(category);
			}
		}
		
		for(Category child : categoryList){
			if(child.getType() == Category.CATE_SECOND){
				for(Category father : categoryTree){
					if(father.getFid().equals(child.getParentFid())){
						father.getChildren().add(child);
					}
				}
			}
		}
		
		return categoryTree;
	}
	
}
