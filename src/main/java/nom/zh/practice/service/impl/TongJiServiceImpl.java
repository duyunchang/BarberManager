package nom.zh.practice.service.impl;

import nom.zh.practice.exception.NoPermissioneException;
import nom.zh.practice.mapper.TongJiMapper;
import nom.zh.practice.service.TongJiService;
import nom.zh.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("tongJiService")
public class TongJiServiceImpl implements TongJiService {
	
	@Autowired
    private TongJiMapper tongJiMapper;

	@Autowired
	private UserService userService;

	//生日统计
	@Override
	public Map<String, Object> queryBir(HttpServletRequest request) throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		List<String> months = new ArrayList<String>();
		List<Integer> sum = new ArrayList<Integer>();
		String uid = request.getSession().getAttribute("uid").toString();
		months.add("1月");
		months.add("2月");
		months.add("3月");
		months.add("4月");
		months.add("5月");
		months.add("6月");
		months.add("7月");
		months.add("8月");
		months.add("9月");
		months.add("10月");
		months.add("11月");
		months.add("12月");

		if(!userService.hasPop(uid,"2")){
			throw new NoPermissioneException("无操作权限");
		}

		List<Map<String, Object>> list = tongJiMapper.queryBir();
		for (int i = 1; i <= 12 ; i ++) {
			for (Map<String, Object> data:list) {
				if(i == Integer.valueOf(data.get("DT").toString())){
					sum.add(Integer.valueOf(data.get("SUM").toString()));
				}
			}
			if(sum.size() < i){
				sum.add(0);
			}
		}

		map.put("months",months);
		map.put("sum",sum);
		return map;
	}


	@Override
	public Map<String, Object> querySex(HttpServletRequest request) throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		List<String> sex = new ArrayList<String>();
		List<Map<String, Object>> querySex = new ArrayList<Map<String, Object>>();

		String uid = request.getSession().getAttribute("uid").toString();
		if(!userService.hasPop(uid,"2")){
			throw new NoPermissioneException("无操作权限");
		}

		querySex = tongJiMapper.querySex();

		for (Map<String, Object> a:querySex
				) {
			sex.add(a.get("name").toString());
		}

		map.put("count",querySex);
		map.put("sex",sex);
		return map;
	}

}
