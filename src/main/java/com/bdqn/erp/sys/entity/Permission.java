package com.bdqn.erp.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 菜单权限编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属菜单
     */
    private Integer pid;

    /**
     * 权限类型[menu/permission]
     */
    private String type;

    /**
     * 菜单权限名称
     */
    private String title;

    /**
     * 权限编码[只有type= permission才有  user:view]
     */
    private String percode;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单跳转请求路径
     */
    private String href;

    /**
     * 菜单是否展开(0展开，1不展开)
     */
    private Integer open;

    /**
     * 排序码
     */
    private Integer ordernum;

    /**
     * 状态【0不可用1可用】
     */
    private Integer available;




    @Override
    public String toString() {
        return "Permission{" +
        "id=" + id +
        ", pid=" + pid +
        ", type=" + type +
        ", title=" + title +
        ", percode=" + percode +
        ", icon=" + icon +
        ", href=" + href +
        ", open=" + open +
        ", ordernum=" + ordernum +
        ", available=" + available +
        "}";
    }
}
