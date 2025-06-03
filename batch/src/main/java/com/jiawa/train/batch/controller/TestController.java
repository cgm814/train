package com.jiawa.train.batch.controller;

import com.jiawa.train.batch.feign.BusinessFeign;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 陈桂明
 * Date: 2025/5/15 18:58
 * Description: TestController
 */
@RestController
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Resource
    private BusinessFeign businessFeign;

    @GetMapping("/hello")
    public String hello() {
        String hello = businessFeign.hello();
        LOG.info(hello);
        return "hello world  Batch！！！";
    }
}
