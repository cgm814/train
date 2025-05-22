package com.jiawa.train.common.resp;

/**
 * Author: 陈桂明
 * Date: 2025/5/18 14:41
 * Description: MemberLoginResp
 */
public class MemberLoginResp {
    private Long id;

    private String mobile;

    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "MemberLoginResp{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
