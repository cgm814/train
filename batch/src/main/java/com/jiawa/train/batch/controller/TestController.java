package com.jiawa.train.batch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 陈桂明
 * Date: 2025/5/15 18:58
 * Description: TestController
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "hello world  Batch！！！";
    }
}
