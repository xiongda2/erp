package com.bdqn.erp.sys.vo;

import com.bdqn.erp.sys.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVo {
    private User user;//用户信息
    private Set<String> roles;//角色列表
    private Set<String> permissions;//权限列表


}
