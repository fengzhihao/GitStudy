package com.oneplus.sms.facade.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.oneplus.commons.Result;
import com.oneplus.sms.facade.SmsFacade;
import com.oneplus.sms.facade.dto.SmsDTO;
import com.oneplus.sms.po.Sms;
import com.oneplus.sms.service.SmsService;
import com.oneplus.sms.util.dto.SmsDtoHelper;
import com.oneplus.sms.util.dto.SmsValidate;

/**
 * 深圳市万普拉斯科技有限公司
 *
 * SmsFacadeImpl.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月13日
 * @version 1.0
 */
@Component("smsFacade")
public class SmsFacadeImpl implements SmsFacade {
	
	@Resource(name = "smsService")
	private SmsService smsService;

	@Override
	public Result sendSms(SmsDTO smsDto) {
		SmsValidate.addDTOValidate(smsDto);
		Sms sms = SmsDtoHelper.getModel(smsDto);
		smsService.sendSms(sms);
		Result result = new Result();
		result.setRet(Result.SUCCESS);
		return result;
	}

	@Override
	public Result batchSendSms(List<SmsDTO> smsDtos) {
		SmsValidate.batchaddDTOValidate(smsDtos);
		List<Sms> smses = SmsDtoHelper.getModelList(smsDtos);
		smsService.batchSendSms(smses);
		Result result = new Result();
		result.setRet(Result.SUCCESS);
		return result;
	}
	
}
