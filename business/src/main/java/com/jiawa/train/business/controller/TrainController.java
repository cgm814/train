package com.jiawa.train.business.controller;

import com.jiawa.train.business.resp.TrainQueryResp;
import com.jiawa.train.business.service.TrainService;
import com.jiawa.train.common.resp.CommonResp;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/train")
public class TrainController {

    @Resource
    private TrainService trainService;


    /**
     * 查询车次
     *
     * @return
     */
    @GetMapping("/query-all")
    public CommonResp<List<TrainQueryResp>> queryAll() {
        List<TrainQueryResp> list = trainService.queryAll();
        return new CommonResp<>(list);
    }
}
