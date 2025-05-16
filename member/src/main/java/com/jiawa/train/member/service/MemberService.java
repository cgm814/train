package com.jiawa.train.member.service;

import com.jiawa.train.member.mapper.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
        return memberMapper.count();
    }

}
