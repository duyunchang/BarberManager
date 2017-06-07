package nom.zh.practice.controller;


import nom.zh.practice.exception.UserException;
import nom.zh.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 中心用户 Controller
 *
 * @author Zhao Hui
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //分页查询，所有用户信息
    @PostMapping("/queryPage.do")
    @ResponseBody
    public Map<String, Object> queryPage(HttpServletRequest request, String _page, String _pageSize, String sex, String nm, String type, String del) throws Exception {
        Assert.isTrue(!StringUtils.isEmpty(_page),"page参数错误");
        Assert.isTrue(!StringUtils.isEmpty(_pageSize),"pageSize参数错误");
        String douid = request.getSession().getAttribute("uid").toString();

        return userService.queryPage(douid,_page, _pageSize, sex, nm, type, del);
    }



    //添加中心用户

    /**
     * @param user
     * @param pas
     * @param nm
     */
    @PostMapping("/addUser.do")
    @ResponseBody
    public Map<String, Object> addUser(HttpServletRequest request, String user, String pas, String nm, String sex, String birthday, String type, String del) throws Exception {
        Assert.isTrue(!StringUtils.isEmpty(user), "用户名不能为空");
        Assert.isTrue(!StringUtils.isEmpty(pas), "密码不能为空");
        Assert.isTrue(!StringUtils.isEmpty(nm), "姓名不能为空");
        Assert.isTrue(!StringUtils.isEmpty(type), "类型不能为空");
        Assert.isTrue(!StringUtils.isEmpty(sex), "性别不能为空");
        Assert.isTrue(!StringUtils.isEmpty(birthday), "生日不能为空");
        Assert.isTrue(!StringUtils.isEmpty(del), "有效性不能为空");

        String douid = request.getSession().getAttribute("uid").toString();

        return userService.addUser(douid,user,pas,nm,sex,birthday,type,del);

    }


    /**
     * 根据UID查看用户的信息
     *
     * @param uid
     * @return
     */
    @PostMapping("/queryUserByUid.do")
    @ResponseBody
    public Map<String, Object> queryUser(String uid) {

        Assert.isTrue(!StringUtils.isEmpty(uid), "uid不能为空");

        return userService.queryUserByUid(uid);
    }

    @PostMapping("/editUserByUid.do")
    @ResponseBody
    public Map<String, Object> editUserByUid(HttpServletRequest request, String uid, String type, String del) throws Exception {

        Assert.isTrue(!StringUtils.isEmpty(uid), "uid不能为空");
        Assert.isTrue(!StringUtils.isEmpty(type), "type不能为空");
        Assert.isTrue(!StringUtils.isEmpty(del), "del不能为空");

        String douid = request.getSession().getAttribute("uid").toString();

        return userService.doEditUserByUid(douid,uid,type,del);
    }

    /**
     * 重置用户密码
     * 创建人：赵辉
     * 创建时间：2017-02-17
     * @param request
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping("/doRePas.do")
    @ResponseBody
    public Map<String,Object> doRePas(HttpServletRequest request,
                                       String uid) throws Exception {
        return userService.doRePas(request, uid);
    }


    /**
     * 获取服务器时间
     * @return time
     */
    @PostMapping("/serviceTime.do")
    public long serviceTime(){
        return System.currentTimeMillis();
    }

    /**
     * 获取用户名
     * @return queryName
     */
    @PostMapping("/queryName.do")
    public Map<String,String> queryName(HttpServletRequest request) throws Exception {
        return userService.queryName(request);
    }

    /**
     * 获取生日信息
     * @return queryBir
     */
    @PostMapping("/queryBir.do")
    public Map<String,Object> queryBir() throws Exception {
        return userService.queryBir();
    }

    /**
     * 查询登录人的权限
     * @return queryPop
     */
    @PostMapping("/queryPop.do")
    public Map<String,Object> queryPop(HttpServletRequest request) throws Exception {
        return userService.queryPop(request);
    }

    /**
     * 查询权限ByUid
     * @return queryPop
     */
    @PostMapping("/queryPopByUid.do")
    public Map<String,Object> queryPopByUid(String uid) throws Exception {
        return userService.queryPopByUid(uid);
    }


    @RequestMapping("/editPopByUid.do")
    @ResponseBody
    public Map<String, Object> editPopByUid(HttpServletRequest request,
                                       String uid, String[] pops) throws Exception {
        Assert.isTrue(!StringUtils.isEmpty(uid), "被修改人不能为空");
        return userService.editPopByUid(request,uid,pops);
    }

    //处理异常
    @ExceptionHandler(UserException.class)
    public ResponseEntity userException(UserException ee) {
        return new ResponseEntity<>(ee, HttpStatus.BAD_REQUEST);
    }

}
