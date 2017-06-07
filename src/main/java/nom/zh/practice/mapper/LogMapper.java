package nom.zh.practice.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LogMapper {
	/**
	 * 插入日志
	 * 创建人：赵辉
	 * 创建时间：2017-02-18
	 * @param uid
	 * @return
	 */
	Integer addLog(@Param("id") String id, @Param("type") String type, @Param("nr") String nr, @Param("uid") String uid, @Param("dt") String dt, @Param("ip") String ip) throws Exception;


	/**
	 * 日志分页查询
	 * 创建人：赵辉
	 * 创建时间：2017-02-18
	 * @param type
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> selectPage(@Param("type") String type, @Param("nm") String nm, @Param("dt") String dt, @Param("uid") String uid)throws Exception;

	/**
	 * 通过id查询单个日志
	 * 创建人：赵辉
	 * 创建时间：2017-02-18
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selectLogById(@Param("id") String id) throws Exception;

	/**
	 * 回显操作类型
	 * 创建人：赵辉
	 * 创建时间：2017-02-18
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selectLx(@Param("uid") String uid) throws Exception;

}
