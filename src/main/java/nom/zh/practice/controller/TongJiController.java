package nom.zh.practice.controller;

import nom.zh.practice.service.TongJiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/tongJi")
public class TongJiController {
	 @Autowired
	 @Qualifier("tongJiService")
	 private TongJiService tongJiService;

	/**
	 * 生日统计
	 * 创建人：赵辉
	 * 创建时间：2017-2-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryBir.do")
	@ResponseBody
	public Map<String,Object> queryZgByYear(HttpServletRequest request, String year) throws Exception{
		return tongJiService.queryBir(request);
	}


	/**
	 * 性别统计
	 * 创建人：赵辉
	 * 创建时间：2017-2-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querySex.do")
	@ResponseBody
	public Map<String,Object> querySex(HttpServletRequest request) throws Exception{
		return tongJiService.querySex(request);
	}

}
