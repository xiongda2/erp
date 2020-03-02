package com.bdqn.erp.sys.vo;

import com.bdqn.erp.sys.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVo {
    /**
     * 用户信息
     */
    private User user;
    /**
     * 角色列表
     */
    private Set<String> roles;
    /**
     * 权限列表
     */
    private Set<String> permissions;


}
