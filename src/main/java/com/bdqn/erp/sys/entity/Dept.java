package com.bdqn.erp.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-27
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 部门编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父级部门编号
     */
    private Integer pid;

    /**
     * 父级部门名称
     */
    private String title;

    /**
     * 是否展开(0-展开,1-不展开)
     */
    private Integer open;

    /**
     * 部门地址
     */
    private String address;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 备注
     */
    private String remark;


}
