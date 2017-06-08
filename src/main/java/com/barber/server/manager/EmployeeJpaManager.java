package com.barber.server.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber.server.domain.entity.employee;



public interface EmployeeJpaManager extends JpaRepository<employee, Long> {

}
