package com.demo.aftersales.service;

import com.demo.aftersales.client.PaymentGatewayClient;
import com.demo.aftersales.enums.RefundStatusEnum;
import com.demo.aftersales.enums.UserLevelEnum;
import com.demo.aftersales.exception.PaymentTimeoutException;
import com.demo.aftersales.model.OrderRefundRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class FastRefundProcessor extends BaseRefundHandler {

    private final PaymentGatewayClient paymentGatewayClient;
    private static final BigDecimal MAX_AUTO_REFUND_AMOUNT = new BigDecimal("500.00");

    public void process(OrderRefundRecord record, UserLevelEnum userLevel) {
        log.info("Start processing FastRefund for order: {}", record.getOrderId());
        record.setIsFastRefund(1);

        if (userLevel != UserLevelEnum.VIP && userLevel != UserLevelEnum.SVIP) {
            log.warn("User level {} not match VIP/SVIP, fallback to manual.", userLevel);
            updateStatus(record, RefundStatusEnum.WAIT_AUDIT);
            return;
        }

        if (record.getRefundAmount().compareTo(MAX_AUTO_REFUND_AMOUNT) >= 0) {
            log.warn("Amount {} exceeds limit 500, fallback to manual.", record.getRefundAmount());
            updateStatus(record, RefundStatusEnum.WAIT_AUDIT);
            return;
        }

        updateStatus(record, RefundStatusEnum.RISK_PASS);

        try {
            boolean success = paymentGatewayClient.executeRefund(record.getOrderId(), record.getRefundAmount());
            if (success) {
                updateStatus(record, RefundStatusEnum.AUTO_REFUND_SUCCESS);
            }
        } catch (PaymentTimeoutException e) {
            log.error("Payment timeout, rollback status. Error: {}", e.getMessage());
            updateStatus(record, RefundStatusEnum.WAIT_AUDIT);
        }
    }
}
