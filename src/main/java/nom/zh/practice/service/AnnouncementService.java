package nom.zh.practice.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AnnouncementService {
	/**
	  * 公告列表分页查询
	  * 创建人：赵辉
	  * 创建时间：2017-01-04
	  * @param request
	  * @param _page
	  * @param _pageSize
	  * @return
	  * @throws Exception
	  */
	Map<String,Object> queryGongGaoPage(HttpServletRequest request, String _page, String _pageSize, String bt, String cnm, String vdt)  throws Exception ;


	/**
	 * 根据NID进行删除
	 * 创建人：赵辉
	 * 创建时间：2017-01-06
	 * @param request
	 * @param nid
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> delByNid(HttpServletRequest request, String nid) throws Exception;



	/**
	 * 根据NID进行查询
	 * 创建人：赵辉
	 * 创建时间：2017-01-04
	 * @param nid 公告ID
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> doReadGongGaoByNid(String nid, String uid) ;

	/**
	 * 发公告
	 * @param request
	 * @param bt
	 * @param nr
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> doSendGongGao(HttpServletRequest request, String bt, String nr);

	/**
	 * 发公告
	 * 创建人：赵辉
	 * 创建时间：2017-02-18
	 * @param request
	 * @return
	 */
    Map<String,Object> queryButton(HttpServletRequest request);
}
