package com.abm.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.abm.web.dao.GuideDao;
import com.abm.web.exception.ObjectNotFoundException;
import com.abm.web.pojo.Guide;
import com.abm.web.service.GuideService;

@Service
public class GuideServiceImpl implements GuideService{

	@Resource
	private GuideDao guideDao;
	
	@Override
	public Guide getByFid(String fid) {
		return guideDao.getByFid(fid);
	}

	@Override
	public void praiseGuide(String fid) throws ObjectNotFoundException {
		Guide guide = guideDao.getByFid(fid);
		if(guide == null){
			throw new ObjectNotFoundException();
		}
		guideDao.praiseGuide(fid, guide.getPraise() + 1);
	}

	@Override
	public void unPraiseGuide(String fid) throws ObjectNotFoundException {
		Guide guide = guideDao.getByFid(fid);
		if(guide == null){
			throw new ObjectNotFoundException();
		}
		guideDao.praiseGuide(fid, guide.getPraise() - 1);
	}

}
