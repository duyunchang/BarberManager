package nom.zh.practice.controller;

import nom.zh.practice.exception.UserLoginFailedException;
import nom.zh.practice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆 Controller
 *
 * @author Zhao Hui
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 登陆Controller
     * @param user 登录名
     * @param pas  密码
     */
    @PostMapping("/login.index")
    public boolean login(String user, String pas, HttpServletRequest request) {
        Assert.isTrue(!StringUtils.isEmpty(user), "用户名为空");
        Assert.isTrue(!StringUtils.isEmpty(pas), "密码为空");

        return loginService.login(user, pas, request);
    }

    @ExceptionHandler(UserLoginFailedException.class)
    public ResponseEntity loginFailedHandle(UserLoginFailedException ex) {
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }


    //登出
    @PostMapping("/logout.index")
    public boolean logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return true;
    }
}
