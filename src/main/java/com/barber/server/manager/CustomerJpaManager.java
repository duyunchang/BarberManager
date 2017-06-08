package com.barber.server.manager;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barber.server.domain.entity.customer;


public interface CustomerJpaManager extends JpaRepository<customer, Long> {

	
	List<customer> findByNameIn(String[]   name,Pageable pageable);
	
	
	@Query("FROM customer l where l.isDelete!=1  ORDER BY l.updateTime ASC")
	List<customer> findAll1();

	//实现分页功能  
	Page<customer> findByIsDeleteNotAndNameLike(Integer isDelete,String name,Pageable pageable);  
	
	//实现分页功能  
//	@Query("FROM customer l where l.isDelete!=?1 and (name like %?2% or c_desc like %?3%)")
//	Page<customer> findByIsDeleteNotAndNameOrC_descLike(Integer isDelete,String name,String c_desc,Pageable pageable); 
	
	//实现分页功能  
	//@Query("FROM customer l where l.isDelete!=?1 and (name like %?2% or c_desc like %?3%)")
	//Page<customer> findByIsDeleteNotAndAgeLike(Integer isDelete,Integer age,Pageable pageable); 
	
	//Page<customer> findByIsDeleteNotAndCDescLike(Integer isDelete,String  c_desc,Pageable pageable); 
		
}
