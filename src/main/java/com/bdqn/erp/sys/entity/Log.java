package com.bdqn.erp.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-25
 */
@Data
@NoArgsConstructor
@TableName("sys_log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 日志内容
     */
    private String content;

    /**
     * 日志操作类型
     */
    private String type;

    /**
     * 执行人
     */
    private String loginname;

    /**
     * 执行人编号
     */
    private Integer userid;

    /**
     * 登录ip
     */
    private String loginip;

    /**
     * 创建时间
     */
    private Date createtime;

    public Log(String content, String type, String loginname, Integer userid, String loginip, Date createtime) {
        this.content = content;
        this.type = type;
        this.loginname = loginname;
        this.userid = userid;
        this.loginip = loginip;
        this.createtime = createtime;
    }


    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", content=" + content +
                ", type=" + type +
                ", loginname=" + loginname +
                ", userid=" + userid +
                ", loginip=" + loginip +
                ", createtime=" + createtime +
                "}";
    }
}
