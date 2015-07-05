package com.abm.web.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abm.web.pojo.HotProduct;
import com.abm.web.request.BaseListReq;
import com.abm.web.response.BaseListData;
import com.abm.web.response.BaseResp;
import com.abm.web.response.RespInfo;
import com.abm.web.service.HotProductService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "api/hotProduct")
public class HotProductController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(HotProductController.class);
	
	@Resource
	private HotProductService hotProductService;

	@RequestMapping(value = "list")
    @ResponseBody
	public Object list(String params){
		logger.info("list receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		BaseListReq baseListReq = JSON.parseObject(params, BaseListReq.class);
		
		List<HotProduct> hotProductList = hotProductService.getList(baseListReq.getStart(), baseListReq.getLength());
		int count = hotProductService.getCount();
		
		logger.info("list get host product list {}", hotProductList);
		
		BaseListData<HotProduct> data = new BaseListData<HotProduct>(count, baseListReq.getStart(), hotProductList);
		
		result.setData(data);
		return result;
	}
	
}
