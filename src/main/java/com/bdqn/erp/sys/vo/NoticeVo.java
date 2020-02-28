package com.bdqn.erp.sys.vo;

import com.bdqn.erp.sys.entity.Notice;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 公告扩展类
 * @author admin
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NoticeVo extends Notice {

    /**
     * 当前页码
     */
    private Integer page;
    /**
     * 每页显示数量
     */
    private Integer limit;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
