package com.abm.web.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abm.web.pojo.Rotate;
import com.abm.web.request.RotateListReq;
import com.abm.web.response.BaseResp;
import com.abm.web.response.RespInfo;
import com.abm.web.response.RotateListData;
import com.abm.web.service.RotateService;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "abm/rotate")
public class RotateController extends BaseController{

	private static Logger logger = LoggerFactory.getLogger(RotateController.class);
	
	@Resource
	private RotateService rotateService;

	@RequestMapping(value = "list")
    @ResponseBody
	public Object list(String params){
		logger.info("list receive params {}", params);
		BaseResp result = new BaseResp();
		
		if(params == null){
			return new BaseResp(RespInfo.REQ_PARAM_ERROR);
		}
		
		//not used now
		RotateListReq rotateListReq = JSON.parseObject(params, RotateListReq.class);
		
		List<Rotate> rotateList = rotateService.getAll();
		
		logger.info("list get rotate list {}", rotateList);
		
		RotateListData rotateListData = new RotateListData(rotateList);
		
		result.setData(rotateListData);
		return result;
	}
	
}
