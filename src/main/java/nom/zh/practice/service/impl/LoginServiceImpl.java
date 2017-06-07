package nom.zh.practice.service.impl;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import nom.zh.practice.exception.UserLoginFailedException;
import nom.zh.practice.mapper.LoginMapper;
import nom.zh.practice.service.LogService;
import nom.zh.practice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private LogService logService;

    @Override
    @Transactional
    public Boolean login(String user, String pas, HttpServletRequest request) {
        List<Map<String, Object>> list = new ArrayList<>();
        try{
            list = loginMapper.queryUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (list.isEmpty()) {
            throw new UserLoginFailedException("用户不存在");
        }

        String relPas =  list.get(0).get("PAS").toString();
        String uid = list.get(0).get("UID").toString();
        int del = Integer.parseInt(list.get(0).get("DEL").toString());
        int type = Integer.parseInt(list.get(0).get("TYPE").toString());

        if (!relPas.equals(Hashing.md5().hashString(pas, Charsets.UTF_8).toString())) {
            throw new UserLoginFailedException("密码错误");
        }
        if (del != 1) {
            throw new UserLoginFailedException("账号已停用");
        }
        HttpSession session = request.getSession();
        session.setAttribute("uid", uid);
        session.setAttribute("type", type);

        logService.addLog("登录",uid+"进行了登陆");

        return true;
    }

}
