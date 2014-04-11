package com.oneplus.sms.po;

import java.util.Date;

/**
 * 深圳市万普拉斯科技有限公司
 *
 * Sms.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月12日
 * @version 1.0
 */
public class Sms {
    private Integer id;

    private String mobileNo;

    private String content;

    private String bizType;

    private String state;

    private Date sendDate;

    private String empCode;

    private String errorCode;
    
    private String sendDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
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
        this.bizType = bizType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode == null ? null : empCode.trim();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

	public String getSendDetail() {
		return sendDetail;
	}

	public void setSendDetail(String sendDetail) {
		this.sendDetail = sendDetail;
	}

	@Override
	public String toString() {
		return "Sms [mobileNo=" + mobileNo + ", content=" + content
				+ ", bizType=" + bizType + "]";
	}
}