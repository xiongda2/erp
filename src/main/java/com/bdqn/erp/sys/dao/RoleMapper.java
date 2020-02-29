package com.bdqn.erp.sys.dao;

import com.bdqn.erp.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-29
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据角色id删除sys_role_permission关系表数据
     * @param id    角色id
     */
    @Delete("delete from sys_role_permission where rid=#{id}")
    void deleteRolePermissionByRoleId(Serializable id);

    /**
     * 根据角色id删除sys_role_user关系表数据
     * @param id    角色id
     */
    @Delete("delete from sys_role_user where rid=#{id}")
    void deleteRoleUserByRoleId(Serializable id);


    /**
     * 保存角色和权限的关系
     * @param rid
     * @param pid
     */
    @Insert("insert into sys_role_permission(rid,pid) values(#{rid},#{pid})")
    void insertRolePermission(@Param("rid") int rid, @Param("pid") String pid);

    /**
     * 根据角色ID查询该角色拥有的权限菜单id
     * @param roleId
     * @return
     * @throws Exception
     */
    @Select("select pid from sys_role_permission where rid=#{roleId}")
    Set<Integer> findRolePermissionByRoleId(Integer roleId) throws Exception;

}
