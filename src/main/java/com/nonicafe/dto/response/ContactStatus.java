package com.nonicafe.dto.response;

public class ContactStatus {
    private Integer contactProcess;
    private Integer contactNew;
    private Integer contactProcessed;
    private Integer totalProcess;

    public Integer getTotalProcess() {
        return totalProcess;
    }

    public void setTotalProcess(Integer totalProcess) {
        this.totalProcess = totalProcess;
    }

    public Integer getContactProcessed() {
        return contactProcessed;
    }

    public void setContactProcessed(Integer contactProcessed) {
        this.contactProcessed = contactProcessed;
    }

    public Integer getContactProcess() {
        return contactProcess;
    }

    public void setContactProcess(Integer contactProcess) {
        this.contactProcess = contactProcess;
    }

    public Integer getContactNew() {
        return contactNew;
    }

    public void setContactNew(Integer contactNew) {
        this.contactNew = contactNew;
    }
}
