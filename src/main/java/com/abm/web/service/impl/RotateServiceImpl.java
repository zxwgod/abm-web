package com.abm.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abm.web.dao.RotateDao;
import com.abm.web.pojo.Rotate;
import com.abm.web.service.RotateService;

@Service
public class RotateServiceImpl implements RotateService{

	@Resource
	private RotateDao rotateDao;

	@Override
	public List<Rotate> getAll() {
		return rotateDao.getAll();
	}
}
