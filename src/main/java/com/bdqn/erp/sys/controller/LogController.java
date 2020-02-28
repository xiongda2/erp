package com.bdqn.erp.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.erp.sys.entity.Log;
import com.bdqn.erp.sys.service.LogService;
import com.bdqn.erp.sys.utils.DataGridViewResult;
import com.bdqn.erp.sys.utils.JSONResult;
import com.bdqn.erp.sys.utils.SystemConstant;
import com.bdqn.erp.sys.vo.LogVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-25
 */
@RestController
@RequestMapping("/sys/log")
public class LogController {

    @Resource
    private LogService logService;

    @RequestMapping("/loglist")
    public DataGridViewResult findLogList(LogVo logVo) {
        //创建分页对象，并指定当前页码及每页显示数量
        IPage<Log> page = new Page<Log>(logVo.getPage(), logVo.getLimit());
        //设置查询条件
        QueryWrapper<Log> queryWrapper = new QueryWrapper<Log>();
        //登录名模糊查询
        queryWrapper.like(StringUtils.isNotBlank(logVo.getLoginname()), "loginname", logVo.getLoginname());
        //操作类型
        queryWrapper.eq(StringUtils.isNotBlank(logVo.getType()), "type", logVo.getType());
        //开始时间
        queryWrapper.ge(logVo.getStartTime() != null, "createtime", logVo.getStartTime());
        //结束时间
        queryWrapper.le(logVo.getEndTime() != null, "createtime", logVo.getEndTime());
        //设置排序
        //登录时间降序
        queryWrapper.orderByDesc("createtime");
        //调用分页查询方法
        logService.page(page, queryWrapper);
        //返回数据
        return new DataGridViewResult(page.getTotal(), page.getRecords());
    }


    @RequestMapping("/batchDelete")
    public JSONResult batchDelete(String ids){
        try {
            String [] idsStr = ids.split(",");
            //删除
            if(logService.removeByIds(Arrays.asList(idsStr))){
                //删除成功
                return SystemConstant.DELETE_SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //删除失败
        return SystemConstant.DELETE_ERROR;
    }

}

