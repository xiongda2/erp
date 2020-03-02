package com.bdqn.erp.sys.controller;

import com.bdqn.erp.sys.utils.SystemConstant;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 */
@ControllerAdvice
public class BaseController {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception ex) {
        ex.printStackTrace();
        if (isAjax(request)) {
            int o = 0;
            if (ex instanceof UnauthenticatedException) {
                o = 1;
            }
            if (o == 1) {
                return SystemConstant.AUTHORITY_ERROR;
            }
            return null;
        } else {
            //不是异步请求

            return null;
        }


    }

    public boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null &&
                "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }


}




