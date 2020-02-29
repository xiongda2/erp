package com.bdqn.erp.sys.service;

import com.bdqn.erp.sys.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-25
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 根据角色id查询菜单编号
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Integer> findRolePermissionByRoleId(int roleId) throws Exception;


}
