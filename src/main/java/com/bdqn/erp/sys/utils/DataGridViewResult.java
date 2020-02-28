package com.bdqn.erp.sys.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * layui 数据表格类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridViewResult {
    private Integer code=0;//执行状态码
    private String msg="";//提示信息
    private Long count=0L;//数量
    private Object data;//数据


    public DataGridViewResult(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }
    public DataGridViewResult(Object data) {
        super();
        this.data = data;
    }
}