package com.jiawa.train.business.mapper.cust;

import java.util.Date;

/**
 * Author: 陈桂明
 * Date: 2025/7/12 15:09
 * Description: DailyTrainTicketMapperCust
 */
public interface DailyTrainTicketMapperCust {

    void updateCountBySell(Date date
            , String trainCode
            , String seatTypeCode
            , Integer minStartIndex
            , Integer maxStartIndex
            , Integer minEndIndex
            , Integer maxEndIndex);
}

