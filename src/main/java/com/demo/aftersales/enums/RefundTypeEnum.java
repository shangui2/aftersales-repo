package com.demo.aftersales.enums;

public enum RefundTypeEnum {
    NORMAL("普通退款"),
    FAST_REFUND("快速退款");

    private final String desc;
    RefundTypeEnum(String desc) { this.desc = desc; }
}
