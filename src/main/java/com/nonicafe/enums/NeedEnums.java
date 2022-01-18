package com.nonicafe.enums;

public enum NeedEnums {
    MUA("Cần Mua"),
    TU_VAN("Cần Tư Vấn Về Sản Phẩm");

    private final String valueNeed;

    public String getValueNeed() {
        return valueNeed;
    }

    NeedEnums(String valueNeed) {
        this.valueNeed = valueNeed;
    }
}
