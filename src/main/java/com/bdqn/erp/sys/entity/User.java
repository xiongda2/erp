package com.bdqn.erp.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-21
 */
@Data
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录名称
     */
    private String loginname;

    /**
     * 登录密码
     */
    private String loginpwd;

    /**
     * 用户真实姓名
     */
    private String name;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 性别(0男1女)
     */
    private Integer sex;

    /**
     * 所在部门编号
     */
    private Integer deptid;

    /**
     * 入职日期
     */
    private Date hiredate;

    /**
     * 所属领导
     */
    private Integer mgr;

    /**
     * 用户类型[0超级管理员1，管理员，2普通用户]
     */
    private Integer type;

    /**
     * 头像地址
     */
    private String imgpath;

    /**
     * 是否可用(0否1可)
     */
    private Integer available;

    /**
     * 密码加密盐值
     */
    private String salt;

    /**
     * 备注
     */
    private String remark;




    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", loginname=" + loginname +
        ", loginpwd=" + loginpwd +
        ", name=" + name +
        ", address=" + address +
        ", sex=" + sex +
        ", deptid=" + deptid +
        ", hiredate=" + hiredate +
        ", mgr=" + mgr +
        ", type=" + type +
        ", imgpath=" + imgpath +
        ", available=" + available +
        ", salt=" + salt +
        ", remark=" + remark +
        "}";
    }
}
