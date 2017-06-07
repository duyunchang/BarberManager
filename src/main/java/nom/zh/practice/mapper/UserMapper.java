package nom.zh.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 中心用户 Mapper
 *
 * @author Zhao Hui
 */
@Mapper
public interface UserMapper {
    //分页查询
    List<Map<String,Object>> selectPage(@Param("del") String del, @Param("nm") String nm, @Param("type") String type, @Param("sex") String sex)throws Exception;

    //添加用户
    Integer insertUser(@Param("uid") String uid, @Param("user") String user, @Param("pas") String pas, @Param("nm") String nm, @Param("sex") String sex, @Param("birthday") String birthday, @Param("type") String type, @Param("douid") String douid, @Param("dt") String dt, @Param("ip") String ip, @Param("del") String del)throws Exception;

    //通过UID查询用户的所有信息
    Map<String, Object> queryUserByUid(@Param("uid") String uid);

    //修改用户信息
    Integer updateUser(@Param("uid") String uid, @Param("upUid") String upUid, @Param("upDt") String upDt, @Param("upIp") String upIp, @Param("type") String type, @Param("del") String del);


    //查询当天生日的人
    List<Map<String, Object>> queryBirUser() throws Exception;

    //查询当天生日的总数
    Integer queryBirCount() throws Exception;

    //重置密码
    Integer doRePas(@Param("uid") String uid, @Param("pas") String pas, @Param("upuid") String upuid, @Param("updt") String updt, @Param("upip") String upip) throws Exception;

    //查询登录人的权限
    List<Map<String, Object>> queryPop(@Param("uid") String uid) throws Exception;

    //修改权限
    Integer editPopByUid(@Param("id") String id, @Param("uid") String uid, @Param("pid") String pid)throws Exception;

    //删除权限
    Integer delPopByUid(@Param("uid") String uid)throws Exception;

    //查询是否有此权限
    Integer checkPop(@Param("uid") String uid, @Param("pid") String pid) throws Exception;

    //查看此用户名是否存在
    List<Map<String, Object>> queryUser(@Param("user") String user);
}
