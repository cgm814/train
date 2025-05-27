package com.jiawa.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.train.common.context.LoginMemberContext;
import com.jiawa.train.common.resp.PageResp;
import com.jiawa.train.common.util.SnowUtil;
import com.jiawa.train.member.domain.${Domain};
import com.jiawa.train.member.domain.${Domain}Example;
import com.jiawa.train.member.mapper.${Domain}Mapper;
import com.jiawa.train.member.req.${Domain}QueryReq;
import com.jiawa.train.member.req.${Domain}SaveReq;
import com.jiawa.train.member.resp.${Domain}QueryResp;
import com.mysql.cj.util.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: 陈桂明
 * Date: 2025/5/19 21:35
 * Description: ${Domain}Service
 */
@Service
public class ${Domain}Service {

    @Resource
    private ${Domain}Mapper ${domain}Mapper;

    public void save(${Domain}SaveReq req) {
        DateTime now = DateTime.now();
        ${Domain} ${domain} = BeanUtil.copyProperties(req, ${Domain}.class);
        if (ObjectUtil.isNull(${domain}.getId())) {
            // 新增乘车
            ${domain}.setMemberId(LoginMemberContext.getId());
            ${domain}.setId(SnowUtil.getSnowflakeNextId());
            ${domain}.setCreateTime(now);
            ${domain}.setUpdateTime(now);
            ${domain}Mapper.insert(${domain});
        } else {
            // 编辑乘客信息
            ${domain}.setUpdateTime(now);
            ${domain}Mapper.updateByPrimaryKey(${domain});
        }
    }

    public PageResp<${Domain}QueryResp> queryList(${Domain}QueryReq req) {
        ${Domain}Example ${domain}Example = new ${Domain}Example();
        ${domain}Example.setOrderByClause("id desc");
        ${Domain}Example.Criteria criteria = ${domain}Example.createCriteria();

        Long memberId = req.getMemberId();
        if (ObjectUtil.isNotNull(memberId)) {
            criteria.andMemberIdEqualTo(memberId);
        }
        PageHelper.startPage(req.getPage(), req.getSize());
        List<${Domain}> ${domain}List = ${domain}Mapper.selectByExample(${domain}Example);

        PageInfo<${Domain}> pageInfo = new PageInfo<>(${domain}List);

        List<${Domain}QueryResp> list = BeanUtil.copyToList(${domain}List, ${Domain}QueryResp.class);
        PageResp<${Domain}QueryResp> resp = new PageResp<>();
        resp.setTotal(pageInfo.getTotal());
        resp.setList(list);

        return resp;
    }


    public void delete(Long id) {
        ${domain}Mapper.deleteByPrimaryKey(id);
    }
}
