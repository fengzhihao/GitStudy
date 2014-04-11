package com.oneplus.sms.facade.dto;

import java.io.Serializable;

import com.oneplus.commons.dto.CommonDTO;

/**
 * 深圳市万普拉斯科技有限公司
 * 
 * SmsDTO.java
 * 
 * @Description
 * 
 * @auther 冯之浩
 * @date 2014年3月12日
 * @version 1.0
 */
public class SmsDTO extends CommonDTO {

	private String mobileNo;

	private String content;

	private String bizType;

	public SmsDTO() {

	}

	public SmsDTO(String mobileNo, String content, String bizType) {
		super();
		this.mobileNo = mobileNo;
		this.content = content;
		this.bizType = bizType;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

}