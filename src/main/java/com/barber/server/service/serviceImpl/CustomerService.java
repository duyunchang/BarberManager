package com.barber.server.service.serviceImpl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barber.server.domain.entity.customer;
import com.barber.server.manager.CustomerJpaManager;



@Service
public class CustomerService  {

	@Autowired
	private CustomerJpaManager customerJpaManager;
	
	@Transactional
	public  Page<customer> getList(String name,Pageable pageable){
		
		 Page<customer> pages=customerJpaManager.findByIsDeleteNotAndNameLike(1,name,pageable);  
//	     Iterator<customer> it=pages.iterator();  
//	     while(it.hasNext()){  
//	         System.out.println("value:"+((customer)it.next()).getId());  
//	     }  
		 String c_desc="dyc";
		 //pages=customerJpaManager.findByIsDeleteNotAndNameOrC_descLike(1,name,c_desc,pageable);  
		return  pages;
	}
	@Transactional
	public   List<customer> getListNames(String name,Pageable pageable){
		name="xx1,xx2,xx3";
		name="xx1";
		String[] split = name.split(",");
		
		 List<customer> findByNameIn = customerJpaManager.findByNameIn(split,pageable);
		return  findByNameIn;
	}
	
	
}
