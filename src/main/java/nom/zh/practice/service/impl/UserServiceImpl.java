package nom.zh.practice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import nom.zh.practice.exception.NoPermissioneException;
import nom.zh.practice.exception.SqlException;
import nom.zh.practice.exception.UserException;
import nom.zh.practice.mapper.UserMapper;
import nom.zh.practice.service.LogService;
import nom.zh.practice.service.UserService;
import nom.zh.practice.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户 ServiceImpl
 *
 * @author Zhao Hui
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogService logService;

    private HashFunction md5 = Hashing.md5();

    //分页查询
    @Override
    public Map<String, Object> queryPage(String douid ,String _page, String _pageSize, String sex, String nm, String type, String del)
            throws Exception {

        Map<String, Object> result = new HashMap<>();

        if(!hasPop(douid,"1")) {
            throw new NoPermissioneException("无操作权限");
        }

        //分页
        PageHelper.startPage(Integer.valueOf(_page),Integer.valueOf(_pageSize));
        List<Map<String, Object>> mapList = userMapper.selectPage(del,nm,type,sex);
        result.put("data", mapList);
        //总数
        PageInfo<Map<String, Object>> page = new PageInfo<>(mapList);
        result.put("count", page.getTotal());

        return result;

    }


    /**
     * 管理员添加用户
     */
    @Override
    @Transactional
    public Map<String, Object> addUser(String douid,String user, String pas, String nm, String sex,String birthday,String type,String del) throws Exception {
        //		定义返回值
        Map<String,Object> map = new HashMap<String, Object>();

        String dt = MyUtil.getDatetime();
        String ip = MyUtil.getIpAddr();
        String uid = MyUtil.newGuid();

        if (queryIfHasUser(user)) {
            throw new UserException("用户名重复");
        }

        if(!hasPop(douid,"1")) {
            throw new NoPermissioneException("无操作权限");
        }

//		添加
        if (userMapper.insertUser(uid,user,pas,nm,sex,birthday,type,douid,dt,ip,del) > 0) {
            map.put("result", true);
            map.put("message", "添加成功！");
            logService.addLog("添加", douid + "添加用户：" + uid);
        } else {
            throw new SqlException("数据超时，请刷新后重试！");
        }

        return map;
    }



    /**
     * 修改用户信息
     */
    @Override
    @Transactional
    public Map<String, Object> doEditUserByUid(String douid,String uid, String type, String del) throws Exception {
        //		定义返回值
        Map<String,Object> map = new HashMap<String, Object>();

        String upUid = douid;
        String upDt = MyUtil.getDatetime();
        String upIp = MyUtil.getIpAddr();

        if(!hasPop(douid,"1")) {
            throw new NoPermissioneException("无操作权限");
        }
//		修改
        if (userMapper.updateUser(uid,upUid,upDt,upIp,type,del) > 0) {
            map.put("result", true);
            map.put("message", "修改成功！");
            logService.addLog("修改", douid + "修改了用户：" + uid + "的信息");

        } else {
            throw new SqlException("数据超时，请刷新后重试！");
        }
        return map;
    }

    /**
     * 根据UID查看用户的所有信息
     *
     * @param uid
     * @return
     */
    @Override
    public Map<String, Object> queryUserByUid(String uid) {
        return userMapper.queryUserByUid(uid);
    }

    /**
     * 查询用户名
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,String> queryName(HttpServletRequest request) throws Exception {
        Map<String,String> map = new HashMap<String,String>();
        String uid = request.getSession().getAttribute("uid").toString();
        Map<String, Object> queryUserByUid = userMapper.queryUserByUid(uid);
        if(queryUserByUid.size()>0){
            map.put("name",queryUserByUid.get("NM").toString());
        }else{
            map.put("name","无");
        }
        return map;

    }


    /**
     * 查询生日信息
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,Object> queryBir() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        int count = userMapper.queryBirCount();
        if(count>0){
            map.put("result",true);
            map.put("data",userMapper.queryBirUser());
            map.put("count",count);
        }else{
            map.put("result",false);
        }
        return map;

    }


    //重置用户密码
    @Override
    @Transactional
    public Map<String, Object> doRePas(HttpServletRequest request, String uid)
            throws Exception {
//		定义返回值
        Map<String,Object> map = new HashMap<String, Object>();
        String pas =  md5.hashString("1", Charsets.UTF_8).toString();
        String upuid = request.getSession().getAttribute("uid").toString();
        String upip = MyUtil.getIpAddr();
        String updt = MyUtil.getDatetime();
//		判断参数和权限
        if(!hasPop(upuid,"1")){
            throw new NoPermissioneException("无操作权限");
        }
//		更新
        if(userMapper.doRePas(uid,pas,upuid,updt,upip)>0){
            map.put("result", true);
            map.put("message", "重置成功！");
            logService.addLog("修改",upuid+"重置用户："+uid+"的密码为："+pas);
        }else{
            throw new SqlException("数据超时，请刷新后重试！");
        }


        return map;
    }


    /**
     * 查询登录人的权限
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,Object> queryPop(HttpServletRequest request) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        String uid = request.getSession().getAttribute("uid").toString();
        map.put("data",userMapper.queryPop(uid));
        return map;

    }

    /**
     * 查询权限ByUid
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,Object> queryPopByUid(String uid) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("data",userMapper.queryPop(uid));
        return map;

    }


    /**
     * 修改权限
     * @param request
     * @param uid
     * @param pops
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public Map<String, Object> editPopByUid(HttpServletRequest request, String uid, String[] pops) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        String douid = request.getSession().getAttribute("uid").toString();
        String id = "";
        try{
            if(!hasPop(douid,"1")){
                throw new NoPermissioneException("无操作权限");
            }

            if(pops.length > 0){
                userMapper.delPopByUid(uid);
                for (String pid: pops
                        ) {
                    id = MyUtil.newGuid();
                    userMapper.editPopByUid(id,uid,pid);
                }
                logService.addLog("修改",douid+"修改了"+ uid +"的权限");
            }else{
                userMapper.delPopByUid(uid);
                logService.addLog("修改",douid+"修改了"+ uid +"的权限");
            }
            map.put("result", true);
            map.put("message","修改成功");

            return map;
        }catch (Exception e){
            //数据库异常时的操作
            throw new SqlException("数据超时，请刷新后重试！");

        }
    }

    //查询是否有此权限
    @Override
    public boolean hasPop(String uid, String pid) throws Exception {
        if(userMapper.checkPop(uid,pid) > 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 查询用户名是否存在
     *
     * @param user
     * @return
     */
    private boolean queryIfHasUser(String user) {
        return userMapper.queryUser(user).size() > 0;
    }
}
