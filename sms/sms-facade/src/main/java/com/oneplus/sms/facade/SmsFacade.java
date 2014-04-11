package com.oneplus.sms.facade;

import java.util.List;

import com.oneplus.commons.Result;
import com.oneplus.sms.facade.dto.SmsDTO;

/**
 * @ClassName: CssCommonFacade
 * @Description: 售后系统（退货）相关的公用facade接口 供第三方系统统一调用
 * @author 冯之浩
 * @date 2014-02-21
 */
public interface SmsFacade {

	/**
	 * 发送一条短信
	 * 
	 * @author 冯之浩
	 * @param smsDto
	 * @return Result
	 */
	Result sendSms(SmsDTO smsDto);

	/**
	 * 发送多条短信
	 * 
	 * @author 冯之浩
	 * @param smsDto
	 * @return Result
	 */
	Result batchSendSms(List<SmsDTO> smsDto);

}
