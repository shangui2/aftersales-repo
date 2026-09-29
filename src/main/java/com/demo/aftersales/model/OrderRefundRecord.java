package com.demo.aftersales.model;

import com.demo.aftersales.enums.RefundStatusEnum;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderRefundRecord {
    private Long id;
    private String orderId;
    private String userId;
    private BigDecimal refundAmount;
    private Integer isFastRefund;
    private RefundStatusEnum status;
    private LocalDateTime createTime;

    /**
     * @deprecated 早期渠道标识，V2.1重构后已不再使用，但未清理数据库字段
     */
    @Deprecated
    private String legacyChannelCode; 
}
