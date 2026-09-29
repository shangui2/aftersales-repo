package com.demo.aftersales.enums;

public enum RefundStatusEnum {
    WAIT_AUDIT("待审核"),
    AUTO_REFUND_SUCCESS("自动退款成功"),
    REFUND_FAILED("退款失败"),
    MANUAL_PROCESSING("人工处理中");

    private final String desc;
    RefundStatusEnum(String desc) { this.desc = desc; }
}
