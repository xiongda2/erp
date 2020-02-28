package com.bdqn.erp.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bdqn.erp.sys.dao.UserMapper;
import com.bdqn.erp.sys.entity.User;
import com.bdqn.erp.sys.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-21
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByName(String userName) throws Exception {
        //创建条件构造器对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        //指定查询条件  key为数据库表中列名
        queryWrapper.eq("loginname", userName);
        return userMapper.selectOne(queryWrapper);
    }
}
