package com.bdqn.erp.sys.vo;

import com.bdqn.erp.sys.entity.Role;
import lombok.Getter;
import lombok.Setter;

/**
 * 角色扩展类
 * @author admin
 */
@Getter
@Setter
public class RoleVo extends Role {
    /**
     * 当前页码
     */
    private Integer page;
    /**
     * 每页显示数量
     */
    private Integer limit;

}
