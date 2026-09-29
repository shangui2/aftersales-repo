package com.demo.aftersales.service;
public class OrderCoreService {
    public void applyRefund(String orderId) {
        new FastRefundProcessor().process("U1", new java.math.BigDecimal("200"), true);
    }
}
