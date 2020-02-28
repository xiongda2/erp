package com.bdqn.erp.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bdqn.erp.sys.entity.Notice;
import com.bdqn.erp.sys.entity.User;
import com.bdqn.erp.sys.service.NoticeService;
import com.bdqn.erp.sys.utils.DataGridViewResult;
import com.bdqn.erp.sys.utils.JSONResult;
import com.bdqn.erp.sys.utils.SystemConstant;
import com.bdqn.erp.sys.vo.NoticeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author meizijiu
 * @since 2020-02-26
 */
@RestController
@RequestMapping("/sys/notice")
public class NoticeController {
    @Resource
    private NoticeService noticeService;


    @ResponseBody
    @RequestMapping("/noticeList")
    public DataGridViewResult findNoticeList(NoticeVo noticeVo){
        //创建分页对象
        IPage<Notice> page = new Page<Notice>(noticeVo.getPage(),noticeVo.getLimit());
        //创建条件构造器
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<Notice>();
        //标题查询
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getTitle()),"title",noticeVo.getTitle());
        //发布人
        queryWrapper.like(StringUtils.isNotBlank(noticeVo.getOpername()),"opername",noticeVo.getOpername());
        //开始时间
        queryWrapper.ge(noticeVo.getStartTime()!=null,"createtime",noticeVo.getStartTime());
        //结束时间
        queryWrapper.le(noticeVo.getEndTime()!=null,"createtime",noticeVo.getEndTime());
        //排序
        queryWrapper.orderByDesc("createtime");
        //分页查询
        noticeService.page(page,queryWrapper);
        //返回数据
        return new DataGridViewResult(page.getTotal(),page.getRecords());
    }


    /**
     * 发布公告
     * @param notice
     * @param request
     * @return
     */
    @RequestMapping("/addNotice")
    public JSONResult addNotice(Notice notice, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(SystemConstant.LOGINUSER);
        notice.setOpername(user.getName());
        notice.setCreatetime(new Date());
        //保存公告
        if(noticeService.save(notice)){
            return SystemConstant.ADD_SUCCESS;
        }
        return SystemConstant.ADD_ERROR;
    }

    /**
     * 修改公告
     * @param notice
     * @return
     */
    @RequestMapping("/updateNotice")
    public JSONResult updateNotice(Notice notice){

        notice.setModifytime(new Date());
        //保存公告
        if(noticeService.updateById(notice)){
            return SystemConstant.UPDATE_SUCCESS;
        }
        return SystemConstant.UPDATE_ERROR;
    }


    /**
     * 删除公告
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public JSONResult deleteById(int id){
        if(noticeService.removeById(id)){
            return SystemConstant.DELETE_SUCCESS;
        }
        return SystemConstant.DELETE_ERROR;
    }


    /**
     * 批量删除公告
     * @param ids
     * @return
     */
    @RequestMapping("/batchDelete")
    public JSONResult batchDelete(String ids){
        try {
            String [] idsStr = ids.split(",");
            //删除
            if(noticeService.removeByIds(Arrays.asList(idsStr))){
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

