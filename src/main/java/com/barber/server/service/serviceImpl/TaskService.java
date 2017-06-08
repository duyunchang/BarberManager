package com.barber.server.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.barber.server.Constants.Constants;
import com.barber.server.config.redis.RedisClient;
import com.barber.server.domain.vo.input.ComResourcesParamsReq;
import com.barber.server.domain.vo.input.DataLogReq;
import com.barber.server.domain.vo.input.NewCmdContents;
import com.barber.server.domain.vo.input.NewContents;
import com.barber.server.manager.BaseNativeSqlRepository;

import com.barber.server.service.ITaskService;
import com.barber.server.util.JsonHelper;

@Service
public class TaskService implements ITaskService {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private BaseNativeSqlRepository baseNativeSql;

	@Autowired
	private RedisClient redisClient;
	
	
	
	@Override
	@Transactional
	public int UpdateRollNews(ComResourcesParamsReq req) throws Exception {
		return 0;
	}

	@Override
	@Transactional
	public int UpdateLive(ComResourcesParamsReq req) throws Exception {
		
		return 0;
	}
}
