package nom.zh.practice.service;

import java.util.List;
import java.util.Map;

public interface LogService {
	 /**
     * 功能:插入日志
      * 创建人：赵辉
      * 创建时间：2017-02-18
     * @param lx 操作类型
     * @param nr 操作内容
     * @return true false
     */
    Boolean addLog(String lx, String nr);

    /**
     * 查看日志
     * 创建人：赵辉
     * 创建时间：2017-02-18
     * @param type 类型
     * @param nm 姓名
     * @param dt 时间
     * @param page 页数
     * @param pageSize 每页的大小
     * @return 当前页数据
     */
    Map<String,Object> queryLogPage(String type, String nm, String dt, String page, String pageSize, String uid, String userLx) throws Exception;

    /**
     * 通过日志id 查看一条日志
     * 创建人：赵辉
     * 创建时间：2017-02-18
     * @param id 日志id
     * @return 此id对应的数据
     */
    List<Map<String,Object>> queryLogById(String id);

    /**
     * 所有日志操作类型的回显
     * 创建人：赵辉
     * 创建时间：2017-02-18
     * @param uid
     * @param userLx
     * @return
     */
    List<Map<String,Object>> queryLx(String uid, String userLx);

    /**
     * 个人日志操作类型的回显
     * 创建人：赵辉
     * 创建时间：2017-02-18
     * @param uid
     * @return
     */
    List<Map<String,Object>> queryMyLx(String uid);


}
