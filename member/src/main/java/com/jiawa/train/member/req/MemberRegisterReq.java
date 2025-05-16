package com.jiawa.train.member.req;

import jakarta.validation.constraints.NotBlank;

/**
 * Author: 陈桂明
 * Date: 2025/5/16 22:50
 * Description: MemberRegisterReq
 */
public class MemberRegisterReq {

    @NotBlank(message = "【手机号不能为空】")
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
