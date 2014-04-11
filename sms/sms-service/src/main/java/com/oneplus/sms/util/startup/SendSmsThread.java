package com.oneplus.sms.util.startup;

import com.oneplus.sms.po.Sms;
import com.oneplus.sms.service.SmsService;

public class SendSmsThread implements Runnable{
	private SmsService smsService;
	
	private Sms sms;
	@Override
	public void run() {
		smsService.realSend(sms);
	}
	
	public SendSmsThread(SmsService smsService,Sms sms){
		this.smsService = smsService;
		this.sms  = sms;		
	}
	
	public SmsService getSmsService() {
		return smsService;
	}
	public void setSmsService(SmsService smsService) {
		this.smsService = smsService;
	}

	public Sms getSms() {
		return sms;
	}

	public void setSms(Sms sms) {
		this.sms = sms;
	}
}
