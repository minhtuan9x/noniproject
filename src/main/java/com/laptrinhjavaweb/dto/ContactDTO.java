package com.laptrinhjavaweb.dto;

public class ContactDTO extends AbstractDTO{
    private String name;
    private String phone;
    private String email;
    private String needKey;
    private String needValue;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNeedKey() {
        return needKey;
    }

    public void setNeedKey(String needKey) {
        this.needKey = needKey;
    }

    public String getNeedValue() {
        return needValue;
    }

    public void setNeedValue(String needValue) {
        this.needValue = needValue;
    }
}
