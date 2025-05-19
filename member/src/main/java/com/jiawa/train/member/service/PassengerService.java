package com.jiawa.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import com.jiawa.train.common.util.SnowUtil;
import com.jiawa.train.member.domain.Passenger;
import com.jiawa.train.member.mapper.PassengerMapper;
import com.jiawa.train.member.req.PassengerSaveReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Author: 陈桂明
 * Date: 2025/5/19 21:35
 * Description: PassengerService
 */
@Service
public class PassengerService {

    @Resource
    private PassengerMapper passengerMapper;

    public void save(PassengerSaveReq req) {
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);

        passengerMapper.insert(passenger);
    }
}
