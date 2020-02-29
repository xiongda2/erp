package com.bdqn.erp.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bdqn.erp.sys.entity.Role;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-29
 */
public interface RoleService extends IService<Role> {

    /**
     * 保存角色和权限的关系
     * @param rid   角色id
     * @param ids   权限列表
     * @return
     * @throws Exception
     */
    boolean saveRolePermission(int rid, String ids) throws Exception;
}
