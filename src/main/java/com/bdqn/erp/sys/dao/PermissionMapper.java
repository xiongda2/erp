package com.bdqn.erp.sys.dao;

import com.bdqn.erp.sys.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;

import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-25
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据菜单id或权限id删除sys_role_permission权限菜单关系表数据
     * @param id
     */
    @Delete("delete from sys_role_permission where pid =#{id}")
    void deleteRolePermissionByPid(Serializable id);

}
