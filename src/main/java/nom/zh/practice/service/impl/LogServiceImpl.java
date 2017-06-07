package nom.zh.practice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nom.zh.practice.exception.LogException;
import nom.zh.practice.exception.SqlException;
import nom.zh.practice.mapper.LogMapper;
import nom.zh.practice.service.LogService;
import nom.zh.practice.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Resource
    private HttpServletRequest request;

    /*
     * 添加日志
	 * 创建人：赵辉
	 * 创建时间：2017-02-18
     * @param type
     * @param nr
     */
    @Override
    @Transactional
    public Boolean addLog(String type, String nr)  {
        String uid = request.getSession().getAttribute("uid").toString();
        String ip = MyUtil.getIpAddr();
        String id = MyUtil.newGuid();
        String dt = MyUtil.getDatetime();

        try {
            return logMapper.addLog(id,type,nr,uid,dt,ip) > 0;
        } catch (Exception e) {
            throw new SqlException("添加日志失败");
        }
    }

    /**
     * 查看日志
     * 创建人：赵辉
     * 创建时间：2017-02-18
     * @param type 类型
     * @param nm 姓名
     * @param dt 时间
     * @param _page 页数
     * @param _pageSize 每页的大小
     * @return 当前页数据
     */
    @Override
    public Map<String, Object> queryLogPage(String type, String nm, String dt, String _page, String _pageSize, String uid, String userLx) throws Exception{

        // 定义返回值
        Map<String, Object> result = new HashMap<>();

        //如果类型为1管理员，则不传uid
        if(userLx.equals("1")){
            uid = "";
        }

        //分页
        PageHelper.startPage(Integer.valueOf(_page),Integer.valueOf(_pageSize));
        List<Map<String, Object>> mapList = logMapper.selectPage(type,nm,dt,uid);
        result.put("data", mapList);
        //总数
        PageInfo<Map<String, Object>> page = new PageInfo<>(mapList);
        result.put("count", page.getTotal());

        return result;
    }

    /**
     * 通过日志id 查看一条日志
     * 创建人：赵辉
     * 创建时间：2017-02-18
     * @param id 日志id
     * @return 此id对应的数据
     */
    @Override
    public List<Map<String, Object>> queryLogById(String id) {
        try {
            return logMapper.selectLogById(id);
        } catch (Exception e) {
            throw new LogException("读取失败");
        }
    }


    /**
     * 个人日志操作类型的回显
     * 创建人：赵辉
     * 创建时间：2017-02-18
     * @param uid
     * @return
     */
    @Override
    public List<Map<String, Object>> queryMyLx(String uid) {
        try {
            return logMapper.selectLx(uid);
        } catch (Exception e) {
            throw new LogException("读取失败");
        }
    }

    /**
     * 所有日志操作类型的回显
     * 创建人：赵辉
     * 创建时间：2017-02-18
     * @param userId
     * @param userLx
     * @return
     */
    @Override
    public List<Map<String, Object>> queryLx(String userId,String userLx) {
        String uid = "";
        //如果类型为3管理员，则不传UID
        if(!"3".equals(userLx)){
            uid = userId;
        }
        try {
            return logMapper.selectLx(uid);
        } catch (Exception e) {
            throw new LogException("读取失败");
        }
    }
}
