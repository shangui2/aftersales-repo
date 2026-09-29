package com.demo.aftersales.model;

import java.math.BigDecimal;

public class OrderRefundRecord {
    private Long id;
    private String orderId;
    private BigDecimal refundAmount;
    private Integer isFastRefund; 

    public Integer getIsFastRefund() { return isFastRefund; }
    public void setIsFastRefund(Integer isFastRefund) { this.isFastRefund = isFastRefund; }
}
