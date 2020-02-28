package com.bdqn.erp.sys.vo;

import com.bdqn.erp.sys.entity.Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 日志扩展类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogVo extends Log {
    private Integer page;//当前页码
    private Integer limit;//每页显示数量
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;//结束时间
}
