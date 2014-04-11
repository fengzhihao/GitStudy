package com.oneplus.sms.po;
import java.util.Date;

public class ReceiveSms {
    private Integer id;

    private Date receiveDate;

    private String mobileNo;

    private String spGate;

    private String subPort;

    private String content;

    private String bizType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getSpGate() {
        return spGate;
    }

    public void setSpGate(String spGate) {
        this.spGate = spGate == null ? null : spGate.trim();
    }

    public String getSubPort() {
        return subPort;
    }

    public void setSubPort(String subPort) {
        this.subPort = subPort == null ? null : subPort.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }
}