package com.demo.aftersales.service;

import com.demo.aftersales.enums.RefundStatusEnum;
import com.demo.aftersales.model.OrderRefundRecord;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseRefundHandler {
    protected void updateStatus(OrderRefundRecord record, RefundStatusEnum targetStatus) {
        log.info("Order {} status changing from {} to {}", 
                record.getOrderId(), record.getStatus(), targetStatus);
        record.setStatus(targetStatus);
    }
}
