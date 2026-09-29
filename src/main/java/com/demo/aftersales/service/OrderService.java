package com.demo.aftersales.service;

import java.math.BigDecimal;

public class OrderService {
    public void applyRefund(String orderId) {
        FastRefundProcessor processor = new FastRefundProcessor();
        processor.process("USER_001", new BigDecimal("200"));
    }
}
