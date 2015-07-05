package com.abm.web.control;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abm.web.dao.global.Separator;
import com.abm.web.enums.FavorProductType;
import com.abm.web.enums.FavorType;
import com.abm.web.exception.ObjectNotFoundException;
import com.abm.web.exception.ParamNullException;
import com.abm.web.json.ProductDetail;
import com.abm.web.pojo.Favorite;
import com.abm.web.pojo.Product;
import com.abm.web.pojo.User;
import com.abm.web.request.FavorProductReq;
import com.abm.web.request.ProductDetailReq;
import com.abm.web.response.BaseResp;
import com.abm.web.response.RespInfo;
import com.abm.web.service.FavoriteService;
import com.abm.web.service.ProductService;
import com.abm.web.service.UserService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "api/product")
public class ProductController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Resource
	private ProductService productService;
	@Resource
	private FavoriteService favoriteService;
	@Resource
	private UserService userService;

	@RequestMapping(value = "detail")
    @ResponseBody
	public Object detail(String params){
		logger.info("detail receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		ProductDetailReq productDetailReq = JSON.parseObject(params, ProductDetailReq.class);

		setCurrentUser(productDetailReq.getUserId());
		
		Product product = productService.getByFid(productDetailReq.getGoodsId());
		
		logger.info("detail get product detail {}", product);
		
		if(product == null){
			return new BaseResp(RespInfo.PRODUCT_NOT_EXISTS_ERROR);
		}
		
		ProductDetail productDetail = new ProductDetail(product);
		
		result.setData(productDetail);
		return result;
	}
	
	@RequestMapping(value = "priase")
    @ResponseBody
	public Object favorite(String params){
		logger.info("favorite receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		FavorProductReq favorProductReq = JSON.parseObject(params, FavorProductReq.class);
		
		String userFid = favorProductReq.getUserId();
		User user;
		try {
			user = userService.getByFid(userFid);
		} catch (ParamNullException e) {
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		if(user == null){
			return new BaseResp(RespInfo.USER_NOT_EXISTS_ERROR);
		}
		
		try {
			Product product = productService.getByFid(favorProductReq.getGoodsId());
			if(product == null){
				return new BaseResp(RespInfo.PRODUCT_NOT_EXISTS_ERROR);
			}
			
			if(favorProductReq.getOperate() == FavorProductType.FAVOR.getCode()){//收藏
				Favorite favorite = favoriteService.getFavorite(userFid, product.getFid(), FavorType.PRODUCT);
				if(favorite != null){
					logger.info("favorite is already exists, favorite {}", favorite);
					return new BaseResp(RespInfo.FAVORITE_EXISTS_ERROR);
				}
				
				productService.praiseProduct(product.getFid());
				
				favorite = new Favorite();
				favorite.setFavorFid(product.getFid());
				favorite.setDesc(product.getDesc());
				favorite.setFavorUrl(product.getUrl());
				favorite.setFavorPic(product.getShowPics().split(Separator.COMMON)[0]);
				favorite.setUserFid(favorProductReq.getUserId());
				favorite.setType(FavorType.PRODUCT.getCode());
				favorite.setPrice(product.getPrice());
				favorite.setTitle(product.getTitle());
				favoriteService.addFavorite(favorite);
			} else if(favorProductReq.getOperate() == FavorProductType.UN_FAVOR.getCode()){//取消收藏
				Favorite favorite = favoriteService.getFavorite(favorProductReq.getUserId(), favorProductReq.getGoodsId(), FavorType.PRODUCT);
				if(favorite == null){
					return new BaseResp(RespInfo.FAVORITE_NOT_EXISTS_ERROR);
				}
				
				favoriteService.delFavorite(favorite.getId());
				productService.unPraiseProduct(product.getFid());
			}
		} catch (ObjectNotFoundException e) {
			logger.error("data is not found. exception ", e);
			return new BaseResp(RespInfo.OBJECT_NOT_EXISTS_ERROR);
		}
		
		return result;
	}
	
}
