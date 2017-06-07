package nom.zh.practice.mapper;

import java.util.List;
import java.util.Map;

public interface TongJiMapper {

	/**
	 * 生日统计
	 * 创建人：赵辉
	 * 创建时间：2017-02-17
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> queryBir()throws Exception;

	/**
	 * 性别统计
	 * 创建人：赵辉
	 * 创建时间：2017-02-17
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> querySex()throws Exception;
}
