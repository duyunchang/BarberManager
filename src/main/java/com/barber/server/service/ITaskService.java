package com.barber.server.service;

import com.barber.server.domain.vo.input.ComResourcesParamsReq;

public interface ITaskService {

	
	int UpdateRollNews(ComResourcesParamsReq req) throws Exception;
	
	int UpdateLive(ComResourcesParamsReq req) throws Exception;
	
}
