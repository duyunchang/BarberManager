package nom.zh.practice.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface TongJiService {

	Map<String,Object> queryBir(HttpServletRequest request)throws Exception;


	/**
	 * 性别统计
	 * 创建人：赵辉
	 * 创建时间：2017-02-17
	 * @param request
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> querySex(HttpServletRequest request)throws Exception;
}
