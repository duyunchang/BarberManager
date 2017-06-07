package nom.zh.practice.service;

import javax.servlet.http.HttpServletRequest;


public interface LoginService {



    //登录
    Boolean login(String user, String pas, HttpServletRequest request);
}
