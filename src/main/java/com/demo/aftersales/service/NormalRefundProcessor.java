package com.demo.aftersales.service;

import com.demo.aftersales.model.OrderRefundRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NormalRefundProcessor extends BaseRefundHandler {
    public void process(OrderRefundRecord record) {
        log.info("Processing normal refund for order: {}", record.getOrderId());
        record.setIsFastRefund(0);
    }
}
