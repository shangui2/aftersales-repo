package com.demo.aftersales.service;
import com.demo.aftersales.enums.RefundStatusEnum;
public abstract class BaseRefundHandler {
    protected void updateStatus(String orderId, RefundStatusEnum status) {}
}
