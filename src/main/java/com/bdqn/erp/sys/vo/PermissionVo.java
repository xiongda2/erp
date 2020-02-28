package com.bdqn.erp.sys.vo;

import com.bdqn.erp.sys.entity.Permission;
import lombok.Data;

/**
 * 权限扩展类
 */
@Data
public class PermissionVo extends Permission {
    private Integer page;//当前页码
    private Integer limit;//每页显示数量

}
