package com.jiawa.train.member.config;

import com.jiawa.train.common.interceptor.MemberInterceptor;
import jakarta.annotation.Resource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author: 陈桂明
 * Date: 2025/5/22 21:56
 * Description: SpringMvcConfig
 */
public class SpringMvcConfig implements WebMvcConfigurer {

    @Resource
    MemberInterceptor memberInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(memberInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/member/hello",
                        "/member/member/send-code",
                        "/member/member/login"
                );
    }
}
