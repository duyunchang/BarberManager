package com.barber.server.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barber.server.domain.entity.memberinfo;


public interface MemberInfoJpaManager extends JpaRepository<memberinfo, Long> {

}
