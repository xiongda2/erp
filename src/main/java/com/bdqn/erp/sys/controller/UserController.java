package com.bdqn.erp.sys.controller;


import com.bdqn.erp.sys.entity.Log;
import com.bdqn.erp.sys.service.LogService;
import com.bdqn.erp.sys.utils.JSONResult;
import com.bdqn.erp.sys.utils.SystemConstant;
import com.bdqn.erp.sys.vo.LoginUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-21
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    /**
     * 登录
     *
     * @param loginname     用户名
     * @param pwd           密码
     * @param request
     * @return
     */

    @Resource
    public LogService logService;


    @PostMapping("/login")
    public JSONResult login(String loginname, String pwd, HttpServletRequest request) {
        try {

            //获取当前登录主体对象
            Subject subject = SecurityUtils.getSubject();
            //创建令牌对象
            UsernamePasswordToken token = new UsernamePasswordToken(loginname, pwd);
            //登录
            subject.login(token);
            //获取当前登录对象
            LoginUserVo userVo = (LoginUserVo) subject.getPrincipal();
            //保存session
            request.getSession().setAttribute(SystemConstant.LOGINUSER, userVo.getUser());
            //保存日志
            Log log = new Log("用户登录", SystemConstant.LOGIN_ACTTON,
                    userVo.getUser().getLoginname() + "-" + userVo.getUser().getName(),
                    userVo.getUser().getId(), request.getRemoteAddr(), new Date());
            logService.save(log);
            //登录成功
            return SystemConstant.LOGIN_SUCCESS;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            //登录失败，用户名或密码错误
            return SystemConstant.LOGIN_ERROR_PASS;
        }
    }
}

