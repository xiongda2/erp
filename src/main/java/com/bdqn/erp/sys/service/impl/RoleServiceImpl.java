package com.bdqn.erp.sys.service.impl;

import com.bdqn.erp.sys.entity.Role;
import com.bdqn.erp.sys.dao.RoleMapper;
import com.bdqn.erp.sys.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    @Resource
    private RoleMapper roleMapper;

    @Override
    public boolean removeById(Serializable id) {
        //根据角色id删除sys_role_permission关系表数据
        roleMapper.deleteRolePermissionByRoleId(id);
        //根据角色id删除sys_role_user关系表数据
        roleMapper.deleteRoleUserByRoleId(id);
        return super.removeById(id);
    }

    @Override
    public boolean saveRolePermission(int rid, String ids) throws Exception {
        try {
            //先删除原有的数据
            roleMapper.deleteRolePermissionByRoleId(rid);
            //再保存新的关系数据
            //拆分权限id字符串
            String [] pids = ids.split(",");
            for (int i = 0; i < pids.length; i++) {
                //调用保存角色权限关系的方法
                roleMapper.insertRolePermission(rid,pids[i]);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



}
