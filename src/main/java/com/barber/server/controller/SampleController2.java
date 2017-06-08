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
/**
 * 返回的类可以变成字符串
 * */
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.data.domain.*;



@RestController
@EnableAutoConfiguration
@RequestMapping("/stu")
public class SampleController2 {
//	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
//	
//	@Autowired
//	private CustomerService customerService;
//	
//	@Value("${sample.data.jpa.controller.ll}")
//	private String ll;
//
//	@RequestMapping(value ="/list")//,produces = MediaType.APPLICATION_JSON_VALUE
//	public List<customer> getStus(){
//		 //logger.info("第二个驱动...");
//		 //System.out.println( ~2020);
//		 //System.out.println( Math.abs(~2020));
//	     //System.out.println(JsonHelper.toJsonStr(customerService.getList()));
//	    return customerService.getList();
//	}
//	@RequestMapping("/ll")
//	public String getLl(){
//	    return ll;
//	}
//	@RequestMapping("/liststr")
//	public String getStuss(){
//	    return JsonHelper.toJsonStr(customerService.getList());
//	}
//	
//	@RequestMapping("/liststrem")
//	public String getStussem(){
//	    return JsonHelper.toJsonStr(customerService.getListem());
//	}
//	
//	/**
//    *
//    * @param page
//    * @param pageSize
//    * @return
//    */
//	
////	 @ResponseBody  
////	   public String Page(@RequestParam(value = "name", defaultValue = "") String name, @RequestParam(value = "page", defaultValue = "0") Integer page,
////			   @RequestParam(value = "size", defaultValue = "15") Integer size) {  
////	       Sort sort = new Sort(Sort.Direction.DESC, "id");  
////	       Pageable pageable = new PageRequest(page, size, sort);  
////	       Page<customer> pages=userDao.findByNameNot(name,pageable);  
////	       Iterator<customer> it=pages.iterator();  
////	       while(it.hasNext()){  
////	           System.out.println("value:"+((customer)it.next()).getId());  
////	       }  
////	       return "success...login....";  
////	   }
//	 
//   @RequestMapping(value = "/page", method = RequestMethod.GET)
//   public  List<customer> Page(
//           @RequestParam(value = "page", defaultValue = "0") Integer page,
//           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,HttpServletRequest request) {
//	   logger.info("分页请求....");
//	   //Response.AddHeader("Access-Control-Allow-Origin", "*");
//	   List<customer> pageList = customerService.pageList(page, pageSize);
//       return pageList;
//   }
   
}
