package com.barber.server.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber.server.domain.entity.employeeserviceproducts;


public interface EmployeeserviceproductsJpaManager extends JpaRepository<employeeserviceproducts, Long> {

}
