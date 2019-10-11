package com.kevin.controller;

import com.kevin.commons.JWTUsers;
import com.kevin.utils.JWTUtils;
import com.kevin.utils.ResponseCodeEnum;
import com.kevin.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author caonanqing
 * @version 1.0
 * @description     jwt控制器
 * @createDate 2019/8/19
 */
@Controller
@RequestMapping("/user")
public class JWTController {

    @Autowired
    JWTUtils jwtUtils;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     *  如果已经登录，则可以重新刷新过期时间，如果没登录则无法访问
     * @param request
     * @return
     */
    @RequestMapping("/testAll")
    @ResponseBody
    public Result testAll(HttpServletRequest request){
        Result result;
        // 获取客户端发送过来的Token
        String token = request.getHeader("token");
        String subject = jwtUtils.getClaimsToken(token).getSubject();
        // 重新生成token，就是为了重置token的有效期
        String newToken = jwtUtils.createJWT(subject);
        result = Result.ok("user",subject);
        result.setToken(newToken);
        System.out.println(new Date()+result.toString());
        return result;
    }

    /**
     * 登录
     * @param username      用户名
     * @param password      密码
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result login(String username, String password) {
        Result result;
        // 验证用户信息
        if(JWTUsers.isLogin(username,password)) {
            // 生成Token
            String token = jwtUtils.createJWT(username);
            result = Result.build(ResponseCodeEnum.OK.getCode(),"登录成功");
            result.setToken(token);
        } else {
            result = Result.build(ResponseCodeEnum.INTERNAL_SERVER_ERROR.getCode(),"登录失败");
        }
        System.out.println(new Date()+result.toString());
        return result;
    }

    /**
     * 注销登录
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Result logout(HttpServletRequest request) {
        Result result = null;
        System.out.println(result.toString());
        return result;
    }

}
