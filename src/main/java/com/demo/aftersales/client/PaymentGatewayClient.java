package com.demo.aftersales.client;

import com.demo.aftersales.exception.PaymentTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Slf4j
@Component
public class PaymentGatewayClient {

    public boolean executeRefund(String transactionId, BigDecimal amount) {
        log.info("Calling Payment Gateway for txId: {}, amount: {}", transactionId, amount);
        if ("TIMEOUT_TEST_TX".equals(transactionId)) {
            throw new PaymentTimeoutException("Payment Gateway Timeout > 3000ms");
        }
        log.info("Payment Gateway refund success.");
        return true;
    }
}
