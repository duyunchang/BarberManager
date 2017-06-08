/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.barber.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.barber.server.domain.entity.customer;
import com.barber.server.service.serviceImpl.CustomerService;



/**
 * 返回字符串
 * */


@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public List<customer> getStus(){
		System.out.println("测试不可跨域....");
	    return new ArrayList<customer>();
	}
    
}
