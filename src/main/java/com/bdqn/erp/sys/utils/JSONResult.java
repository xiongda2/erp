package com.bdqn.erp.sys.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回值JSON结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JSONResult {

    //是否成功
    private Boolean success;
    //提示信息
    private String message;
}