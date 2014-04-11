package com.oneplus.sms.util.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oneplus.sms.service.SmsService;
import com.oneplus.sms.service.impl.SmsServiceImpl;

/**
 * 深圳市万普拉斯科技有限公司
 *
 * GetReportJob.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月13日
 * @version 1.0
 */
public class GetReportJob {
	private static Logger log = LoggerFactory
			.getLogger(GetReportJob.class);
	
	private SmsService smsService;

	public void execute() {
		log.info("======================Get Status Report Start======================");
		smsService.findAndDealReports();
		log.info("======================Get Status Report End========================");
	}

	public SmsService getSmsService() {
		return smsService;
	}

	public void setSmsService(SmsService smsService) {
		this.smsService = smsService;
	}

}
