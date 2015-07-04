package com.abm.web.service;

import com.abm.web.exception.ObjectNotFoundException;
import com.abm.web.pojo.Guide;

public interface GuideService {

	public Guide getByFid(String fid);
	
	public void praiseGuide(String fid) throws ObjectNotFoundException;

	public void unPraiseGuide(String fid) throws ObjectNotFoundException;
}
