package nom.zh.practice.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 中心用户 Service
 *
 * @author Zhao Hui
 */
public interface UserService {
    //分页查询
    Map<String, Object> queryPage(String douid, String _page, String _pageSize, String sex, String nm, String type, String del) throws Exception;

    //添加用户
    Map<String, Object> addUser(String douid, String user, String pas, String nm, String sex, String birthday, String type, String del) throws Exception;

    //通过UID查看用户的所有信息
    Map<String, Object> queryUserByUid(String uid);

    //修改用户信息
    Map<String,Object> doEditUserByUid(String douid, String uid, String type, String del) throws Exception;

    //查看用户名
    Map<String,String> queryName(HttpServletRequest request)throws Exception;

    //查询生日信息
    Map<String, Object> queryBir()throws Exception;


    /**
     * 重置用户密码
     * 创建人：赵辉
     * 创建时间：2017-02-17
     * @param request
     * @param uid
     * @return
     * @throws Exception
     */
    Map<String,Object> doRePas(HttpServletRequest request, String uid) throws Exception;

    /**
     * 查询登录人的权限
     * 创建人：赵辉
     * 创建时间：2017-02-18
     * @return
     * @throws Exception
     */
    Map<String,Object> queryPop(HttpServletRequest request)throws Exception;

    /**
     * 查询权限ByUid
     * 创建人：赵辉
     * 创建时间：2017-02-18
     * @return
     * @throws Exception
     */
    Map<String,Object> queryPopByUid(String uid)throws Exception;


    //修改权限
    Map<String,Object> editPopByUid(HttpServletRequest request, String uid, String[] pops) throws Exception;

    //查询是否有此权限
    boolean hasPop(String uid, String pid) throws Exception;
}
