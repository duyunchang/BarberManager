package com.barber.server.manager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
/**
 * 使用原生sql语句 用法
 * */
@Service
public class BaseNativeSqlRepository {
	
	@PersistenceUnit(unitName = "default")
	private EntityManagerFactory emf;

	
//	public List<lmtLogMonitorM3u8> getLastSendTaskM3u8(String sql) {
//
//		EntityManager em = emf.createEntityManager();
//		// 定义SQL
//		// String sql="select * from lmt_log_monitor_m3u8 l where "+Othersql+"
//		// order by l.createTime desc";
//		// 创建原生SQL查询QUERY实例
//		Query query = em.createNativeQuery(sql, lmtLogMonitorM3u8.class);
//
//		// 执行查询，返回的是查询属性值数组的集合
//		@SuppressWarnings("unchecked")
//		List<lmtLogMonitorM3u8> objecArraytList = query.getResultList();
//
//		em.close();
//		return objecArraytList;
//	}
//
//	public List<lmtLogMonitorTs> getLastSendTaskTs(String sql) {
//
//		EntityManager em = emf.createEntityManager();
//		// 定义SQL
//		// String sql="select * from lmt_log_monitor_m3u8 l where "+Othersql+"
//		// order by l.createTime desc";
//		// 创建原生SQL查询QUERY实例
//		Query query = em.createNativeQuery(sql, lmtLogMonitorTs.class);
//
//		// 执行查询，返回的是查询属性值数组的集合
//		@SuppressWarnings("unchecked")
//		List<lmtLogMonitorTs> objecArraytList = query.getResultList();
//
//		em.close();
//		return objecArraytList;
//	}

}
