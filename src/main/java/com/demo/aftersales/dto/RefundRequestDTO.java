package com.demo.aftersales.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class RefundRequestDTO {
    private String orderId;
    private String userId;
    private BigDecimal applyAmount;
}
