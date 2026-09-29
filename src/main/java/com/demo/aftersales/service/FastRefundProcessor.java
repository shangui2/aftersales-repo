package com.demo.aftersales.service;
import com.demo.aftersales.enums.*;
import java.math.BigDecimal;
public class FastRefundProcessor extends BaseRefundHandler {
    private static final BigDecimal MAX_AUTO_REFUND_AMOUNT = new BigDecimal("500.00");
    public void process(String userId, BigDecimal amount, boolean isVip) {
        if (!isVip) return;
        if (amount.compareTo(MAX_AUTO_REFUND_AMOUNT) < 0) {
            updateStatus("ORDER_123", RefundStatusEnum.AUTO_REFUND_SUCCESS);
        }
    }
}
