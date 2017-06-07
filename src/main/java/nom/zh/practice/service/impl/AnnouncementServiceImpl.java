package nom.zh.practice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nom.zh.practice.exception.NoPermissioneException;
import nom.zh.practice.exception.SqlException;
import nom.zh.practice.mapper.AnnouncementMapper;
import nom.zh.practice.mapper.UserMapper;
import nom.zh.practice.service.AnnouncementService;
import nom.zh.practice.service.LogService;
import nom.zh.practice.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {
	
	@Autowired
    private AnnouncementMapper announcementMapper;

    @Autowired
    private UserMapper userMapper;

	@Autowired
	private LogService logService;


	@Override
	public Map<String, Object> queryGongGaoPage(HttpServletRequest request,
												String _page, String _pageSize,String bt,String cnm,String vdt) throws Exception {
		// 定义返回值
		Map<String, Object> result = new HashMap<>();

		String uid = request.getSession().getAttribute("uid").toString();

		//分页
		PageHelper.startPage(Integer.valueOf(_page),Integer.valueOf(_pageSize));
		List<Map<String, Object>> mapList = announcementMapper.queryGongGaoPage(uid, cnm, bt, vdt);
		result.put("data", mapList);
		//总数
		PageInfo<Map<String, Object>> page = new PageInfo<>(mapList);
		result.put("count", page.getTotal());

		return result;
	}



	@Override
    @Transactional
    public Map<String, Object> doSendGongGao(HttpServletRequest request, String bt, String nr) {
		Map<String,Object> map = new HashMap<String,Object>();

		String nid = MyUtil.newGuid();
		String inId = request.getSession().getAttribute("uid").toString();
		String inDt = MyUtil.getDatetime();
		String inIp = MyUtil.getIpAddr();
		String del = "1";

		//权限控制
		if(!"1".equals(userMapper.queryUserByUid(inId).get("TYPE").toString())){
			throw new NoPermissioneException("无操作权限");
		}
		//发公告
		try {
			announcementMapper.doSendMes(nid,bt,nr,inId,inDt,inIp,del);
			map.put("result", true);
			map.put("message","发布成功");
			logService.addLog("发布公告",inId+"发布了公告："+nid);
            return map;
		} catch (SQLException e) {
            throw new SqlException("数据超时，请刷新后重试！");
        }
	}


	//根据NID进行删除
	@Override
    @Transactional
    public Map<String, Object> delByNid(HttpServletRequest request, String nid)
			throws Exception {
//		定义返回值
		Map<String,Object> map = new HashMap<String, Object>();
		String deluid = request.getSession().getAttribute("uid").toString();
		String delip = MyUtil.getIpAddr();
		String deldt = MyUtil.getDatetime();

//		判断参数
		if(!"1".equals(userMapper.queryUserByUid(deluid).get("TYPE").toString())){
			throw new NoPermissioneException("无操作权限");
		}
//		删除操作
		if(announcementMapper.updateDel(nid,deluid,deldt,delip)>0){
			map.put("result", true);
			map.put("message", "删除成功！");
			logService.addLog("删除公告",deluid+"删除了公告："+nid);
            return map;
		}else{
		    throw new SqlException("数据超时，请刷新后重试！");
		}
	}


	/**
	 * 根据NID进行查询
	 * 创建人：赵辉
	 * 创建时间：2017-01-06
	 * @param nid
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Map<String, Object> doReadGongGaoByNid(String nid ,String uid) {
        //如果是收件人进行查看，并处于未读状态 标记为已读
		try {
			if(announcementMapper.queryIfRead(uid,nid) == 0){
                String rid = MyUtil.newGuid();
                String rdt = MyUtil.getDatetime();
                String rip = MyUtil.getIpAddr();
                announcementMapper.updateRead(rid,nid,uid,rdt,rip);
            }
			return announcementMapper.queryGongGaoByNid(nid);
		} catch (SQLException e) {
            throw new SqlException("数据超时，请刷新后重试！");
		}
	}


	//按钮
    @Override
    public Map<String, Object> queryButton(HttpServletRequest request)  {
        Map<String,Object> map = new HashMap<String,Object>();

        String uid = request.getSession().getAttribute("uid").toString();
        try{
            if("1".equals(userMapper.queryUserByUid(uid).get("TYPE").toString())){
                map.put("result", true);
            }else {
                map.put("result", false);
            }
            return map;
        }catch (Exception e){
            throw new SqlException("数据超时，请刷新后重试！");
        }
    }
}
