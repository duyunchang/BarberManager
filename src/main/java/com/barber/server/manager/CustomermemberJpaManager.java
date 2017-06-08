package com.barber.server.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber.server.domain.entity.customermember;


public interface CustomermemberJpaManager extends JpaRepository<customermember, Long> {

}
