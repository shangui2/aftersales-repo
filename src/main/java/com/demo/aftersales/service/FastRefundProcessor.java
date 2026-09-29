package com.demo.aftersales.service;

import com.demo.aftersales.enums.RefundStatusEnum;
import com.demo.aftersales.enums.RefundTypeEnum;
import java.math.BigDecimal;

public class FastRefundProcessor extends BaseRefundHandler {
    private static final BigDecimal MAX_AUTO_REFUND_AMOUNT = new BigDecimal("500.00");

    public void process(String userId, BigDecimal amount) {
        if (amount.compareTo(MAX_AUTO_REFUND_AMOUNT) < 0) {
            System.out.println("Trigger " + RefundTypeEnum.FAST_REFUND.name());
            updateStatus(RefundStatusEnum.AUTO_REFUND_SUCCESS);
        } else {
            updateStatus(RefundStatusEnum.WAIT_AUDIT);
        }
    }

    private void updateStatus(RefundStatusEnum status) {}
}

class BaseRefundHandler {}
