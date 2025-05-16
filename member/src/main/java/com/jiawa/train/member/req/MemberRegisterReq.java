package com.jiawa.train.member.req;

/**
 * Author: 陈桂明
 * Date: 2025/5/16 22:50
 * Description: MemberRegisterReq
 */
public class MemberRegisterReq {

    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberRegisterReq{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
