package com.jiawa.train.member.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.jiawa.train.common.exception.BusinessException;
import com.jiawa.train.common.exception.BusinessExceptionEnum;
import com.jiawa.train.common.util.SnowUtil;
import com.jiawa.train.member.domain.Member;
import com.jiawa.train.member.domain.MemberExample;
import com.jiawa.train.member.mapper.MemberMapper;
import com.jiawa.train.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: 陈桂明
 * Date: 2025/5/16 14:53
 * Description: MemberService
 */
@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public Integer count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);

        if (CollUtil.isNotEmpty(list)) {
            // return list.get(0).getId();
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());  // 雪花算法
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }

}
