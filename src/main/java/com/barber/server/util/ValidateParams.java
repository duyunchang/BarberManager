package com.barber.server.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.barber.server.Constants.Constants;
import com.barber.server.config.MyConfig;
import com.barber.server.domain.vo.input.ComResourcesParamsReq;
import com.barber.server.domain.vo.input.DataLogReq;
import com.barber.server.domain.vo.input.ResourceInfoReq;

@Component
public class ValidateParams {
	
	@Autowired
	private MyConfig config;
	
	
	public  String validateGet(DataLogReq req){
		//校验
		StringBuffer sb = new StringBuffer();
		sb.append("参数为空");
		if(StringUtils.isEmpty(req.getSource_type())){
			sb.append(",source_type="+req.getSource_type());
		}
		if(StringUtils.isEmpty(req.getFileType())){
			sb.append(",fileType="+req.getFileType());
		}

		
		if(StringUtils.isEmpty(req.getStatus())){
			sb.append(",status="+req.getStatus());
		}
		if(StringUtils.isEmpty(req.getPage())){
			sb.append(",page="+req.getPage());
		}
		if(StringUtils.isEmpty(req.getSize())){
			sb.append(",size="+req.getSize());
		}
		
		if(sb.toString().length() > 4){
			return sb.toString();
		}
		return null;
	}
	
	public  String validateRollNews(ComResourcesParamsReq req){
		//校验
		StringBuffer sb = new StringBuffer();
		sb.append("参数为空");
		if(StringUtils.isEmpty(req.getResourcesGroupCode())){
			sb.append(",resourcesGroupCode="+req.getResourcesGroupCode());
		}
		
		
		if(sb.toString().length() > 4){
			return sb.toString();
		}
		return null;
	}
	
	public  String validateMonitorPeriod(DataLogReq req){
		//校验
		StringBuffer sb = new StringBuffer();
		sb.append("参数为空");
		if(StringUtils.isEmpty(req.getMonitorPeriod())){
			sb.append(",monitorPeriod="+req.getMonitorPeriod());
		}
		
		
		if(sb.toString().length() > 4){
			return sb.toString();
		}
		return null;
	}
	
	
	public String validateResourceInfoReq(String data) {
		StringBuffer sb = new StringBuffer();
		sb.append("参数为空");
		if (StringUtils.isEmpty(data)) {
			return sb.toString();
		}
		ResourceInfoReq rir = JsonHelper.toJSONObject(data,
				ResourceInfoReq.class);

		Integer activityResources = rir.getActivityResources();
		if (activityResources == null
				|| (activityResources != 1 && activityResources != 2)) {
			sb.append(",activityResources=" + activityResources);
			return sb.toString();
		}

		if (StringUtils.isEmpty(rir.getBgPicUp())) {
			sb.append(",bgPicUp=" + rir.getBgPicUp());
		}
		if (StringUtils.isEmpty(rir.getBgPicDown())) {
			sb.append(",bgPicDown=" + rir.getBgPicDown());
		}
		if (StringUtils.isEmpty(rir.getInfoUp())) {
			sb.append(",infoUp=" + rir.getInfoUp());
		}
		if (StringUtils.isEmpty(rir.getInfDown())) {
			sb.append(",infoDown=" + rir.getInfDown());
		}

		if (sb.toString().length() > 4) {
			return sb.toString();
		}
		return null;
	}

}
