package com.bdqn.erp.sys.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptVo {

    /**
     * 部门编号
     */
    private Integer id;
    /**
     * 当前页码
     */
    private Integer page;
    /**
     * 每页显示数量
     */
    private Integer limit;

    /**
     * 父级部门名称
     */
    private String title;

    /**
     * 部门地址
     */
    private String address;
}
