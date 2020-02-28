package com.bdqn.erp.sys.service;

import com.bdqn.erp.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-21
 */
public interface UserService extends IService<User> {


    /**
     * 根据用户名查询用户信息的方法
     * @param userName
     * @return
     * @throws Exception
     */
    User findUserByName(String userName) throws Exception;

}
