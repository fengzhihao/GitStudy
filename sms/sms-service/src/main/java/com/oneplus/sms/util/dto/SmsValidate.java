package com.oneplus.sms.util.dto;

import java.util.List;

import com.oneplus.sms.common.enums.ExceptionEnum;
import com.oneplus.sms.common.exception.ParameterException;
import com.oneplus.sms.common.util.StringUtils;
import com.oneplus.sms.facade.dto.SmsDTO;

/**
 * 深圳市万普拉斯科技有限公司
 *
 * SmsValidate.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月13日
 * @version 1.0
 */
public class SmsValidate {
	/**
	 * 新增短信验证
	 * @author 冯之浩
	 * @param dto
	 * void
	 */
	public static void addDTOValidate(SmsDTO dto) {
		if(dto==null){
			throw new ParameterException(ExceptionEnum.BusExcep.NoSmsInfo.getValue());
		}
		if(StringUtils.isNullString(dto.getBizType())){
			throw new ParameterException(ExceptionEnum.BusExcep.NoBizType.getValue());
		}
		if(StringUtils.isNullString(dto.getContent())){
			throw new ParameterException(ExceptionEnum.BusExcep.NoContent.getValue());
		}
		//if(dto.getContent().length()>350){
		//	throw new ParameterException("短信内容超过350个字符");
		//}
		if(StringUtils.isNullString(dto.getMobileNo())){
			throw new ParameterException(ExceptionEnum.BusExcep.NoMobileNo.getValue());
		}
		/*if(dto.getMobileNo().length()!=11){
			throw new ParameterException("手机号码"+dto.getMobileNo()+"格式错误");
		}*/
	}

	/**
	 * 更新短信验证
	 * @author 冯之浩
	 * @param dto
	 * void
	 */
	public static void updateDTOValidate(SmsDTO dto) {
		addDTOValidate(dto);
	}

	/**
	 * 批量验证
	 * @author 冯之浩
	 * @param smsDtos
	 * void
	 */
	public static void batchaddDTOValidate(List<SmsDTO> smsDtos){
		if(smsDtos==null||smsDtos.size()==0){
			throw new ParameterException(ExceptionEnum.BusExcep.NoSmsList.getValue());
		}
		for (SmsDTO smsDTO : smsDtos) {
			addDTOValidate(smsDTO);
		}
	}
}
