package com.demo.aftersales.model;
import java.math.BigDecimal;
public class OrderRefundRecord {
    private Long id;
    private String orderId;
    private BigDecimal refundAmount;
    private Integer isFastRefund;
    // 故意不写 legacy_channel_code 字段
}
