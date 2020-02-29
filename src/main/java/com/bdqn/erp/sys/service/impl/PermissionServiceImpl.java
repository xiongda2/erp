package com.bdqn.erp.sys.service.impl;

import com.bdqn.erp.sys.entity.Permission;
import com.bdqn.erp.sys.dao.PermissionMapper;
import com.bdqn.erp.sys.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-25
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {


    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public boolean removeById(Serializable id) {
        //根据菜单id或权限id删除sys_role_permission权限菜单关系表数据
        permissionMapper.deleteRolePermissionByPid(id);
        return super.removeById(id);
    }

    @Override
    public List<Integer> findRolePermissionByRoleId(int roleId) throws Exception {
        return permissionMapper.findRolePermissionByRoleId(roleId);
    }
}
