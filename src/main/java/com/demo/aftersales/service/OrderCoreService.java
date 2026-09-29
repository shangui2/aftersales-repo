package com.demo.aftersales.service;

import com.demo.aftersales.client.RiskControlEngine;
import com.demo.aftersales.dto.RefundRequestDTO;
import com.demo.aftersales.enums.RefundStatusEnum;
import com.demo.aftersales.enums.UserLevelEnum;
import com.demo.aftersales.model.OrderRefundRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderCoreService {

    private final FastRefundProcessor fastRefundProcessor;
    private final NormalRefundProcessor normalRefundProcessor;
    private final RiskControlEngine riskControlEngine;

    public String applyRefund(RefundRequestDTO requestDTO) {
        log.info("Receive refund request for order: {}", requestDTO.getOrderId());
        
        OrderRefundRecord record = new OrderRefundRecord();
        record.setOrderId(requestDTO.getOrderId());
        record.setUserId(requestDTO.getUserId());
        record.setRefundAmount(requestDTO.getApplyAmount());
        record.setStatus(RefundStatusEnum.WAIT_AUDIT);
        record.setCreateTime(LocalDateTime.now());

        boolean riskPass = riskControlEngine.checkRisk(requestDTO.getUserId());
        UserLevelEnum mockUserLevel = UserLevelEnum.VIP; 
        
        if (riskPass && mockUserLevel == UserLevelEnum.VIP) {
            fastRefundProcessor.process(record, mockUserLevel);
        } else {
            normalRefundProcessor.process(record);
        }

        return "Refund process initiated. Current Status: " + record.getStatus().getDesc();
    }
}
