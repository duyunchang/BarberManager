package nom.zh.practice.mapper;

import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface AnnouncementMapper {

	/**
	 * 公告列表分页查询
	 * 创建人：赵辉
	 * 创建时间：2017-01-04
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	List<Map<String,Object>> queryGongGaoPage(@Param("uid") String uid, @Param("cnm") String cnm, @Param("bt") String bt, @Param("vdt") String vdt) throws SQLException;
    

	/**
	 * 通过Nid进行查询
	 * 创建人：赵辉
	 * 创建时间：20167-01-06
	 * @param nid
	 * @return
	 * @throws SQLException
	 */
	Map<String,Object> queryGongGaoByNid(@Param("nid") String nid)throws SQLException;

	/**
	 * 标记为已读
	 * 创建人：赵辉
	 * 创建时间：2017-01-06
	 * @param nid
	 * @param uid
	 * @param rid
	 * @param rip
	 * @param rdt
	 * @return
	 * @throws SQLException
	 */
	Integer updateRead(@Param("rid") String rid, @Param("nid") String nid, @Param("uid") String uid, @Param("rdt") String rdt, @Param("rip") String rip)throws SQLException;


	/**
	 * 查看是否已读公告
	 * 创建人：赵辉
	 * 创建时间：2017-01-06
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	Integer queryIfRead(@Param("uid") String uid, @Param("nid") String nid)throws SQLException;


	/**
	 * 删除公告
	 * 创建人：赵辉
	 * 创建时间：2017-01-06
	 * @param nid
	 * @return
	 * @throws SQLException
	 */
	Integer updateDel(@Param("nid") String nid, @Param("deluid") String deluid, @Param("deldt") String deldt, @Param("delip") String delip)throws SQLException;

	/**
	 * 发送公告
	 * 创建人：赵辉
	 * 创建时间：2017-02-17
	 * @param inId
	 * @return
	 * @throws SQLException
	 */
	Integer doSendMes(@Param("nid") String nid, @Param("bt") String bt, @Param("nr") String nr, @Param("inId") String inId, @Param("inDt") String inDt, @Param("inIp") String inIp, @Param("del") String del) throws SQLException;
}
