package com.oneplus.sms.po;

/**
 * 深圳市万普拉斯科技有限公司
 * 
 * SmsResult.java
 * 
 * @Description 处理上行与状态报告返回结果的实体类
 * @auther 冯之浩
 * @date 2014年3月13日
 * @version 1.0
 */
public class SmsResult {
	private String resultDate; // 日期
	private String resultTime; // 时间
	private String resultPhone; // 上行源号码
	private String resultSpgate; // 上行目标通道号
	private String resultMessage; // 信息内容
	private String resultMessageid; // 信息编号
	private String resultState; // 状态值
	private String resultMessageError; // 详细错误原因
	private String resultIReqType; // 信息类型(0表示上行和状态报告，1表示上行，2表示状态报告 )
	private String resultMongateSendSubmitMsgid; // MongateSendSubmit时填写的MsgId

	private String resultSubPort;// 扩展/子端口号

	public String getResultIReqType() {
		return this.resultIReqType;
	}

	public void setResultIReqType(String returnireqtype) {
		this.resultIReqType = returnireqtype;
	}

	public String getResultMongateSendSubmitMsgid() {
		return this.resultMongateSendSubmitMsgid;
	}

	public void setResultMongateSendSubmitMsgid(String mesgid) {
		this.resultMongateSendSubmitMsgid = mesgid;
	}

	public String getResultDate() {
		return this.resultDate;
	}

	public void setResultDate(String date) {
		this.resultDate = date;
	}

	public String getResultTime() {
		return this.resultTime;
	}

	public void setReslutTime(String time) {
		this.resultTime = time;
	}

	public String getResultPhone() {
		return this.resultPhone;
	}

	public void setResultPhone(String phone) {
		this.resultPhone = phone;
	}

	public String getResultSpgate() {
		return this.resultSpgate;
	}

	public void setResultSpgate(String spgate) {
		this.resultSpgate = spgate;
	}

	public String getResultMessage() {
		return this.resultMessage;
	}

	public void setResultMessage(String message) {
		this.resultMessage = message;
	}

	public String getResultMessageid() {
		return this.resultMessageid;
	}

	public void setResultMessageid(String messageid) {
		this.resultMessageid = messageid;
	}

	public String getResultState() {
		return this.resultState;
	}

	public void setResultState(String state) {
		this.resultState = state;
	}

	public String getResultMessageError() {
		return this.resultMessageError;
	}

	public void setResultMessageError(String messageerror) {
		this.resultMessageError = messageerror;
	}

	public String getResultSubPort() {
		return resultSubPort;
	}

	public void setResultSubPort(String resultSubPort) {
		this.resultSubPort = resultSubPort;
	}
}
