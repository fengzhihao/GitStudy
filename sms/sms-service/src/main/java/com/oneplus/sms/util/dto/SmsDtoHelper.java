package com.oneplus.sms.util.dto;

import java.util.ArrayList;
import java.util.List;

import com.oneplus.sms.common.util.StringUtils;
import com.oneplus.sms.facade.dto.SmsDTO;
import com.oneplus.sms.po.Sms;

/**
 * 深圳市万普拉斯科技有限公司
 *
 * SmsDtoHelper.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月12日
 * @version 1.0
 */
public class SmsDtoHelper {

	public static SmsDTO getDto(Sms model) {
		if (model == null) {
			return null;
		}
		SmsDTO dto = new SmsDTO();
		if (!StringUtils.isNullObject(model.getBizType())) {
			dto.setBizType(model.getBizType());
		}
		if (!StringUtils.isNullObject(model.getMobileNo())) {
			dto.setMobileNo(model.getMobileNo());
		}
		if (!StringUtils.isNullObject(model.getContent())) {
			dto.setContent(model.getContent());
		}

		return dto;
	}

	public static Sms getModel(SmsDTO bdto) {
		if (bdto == null) {
			return null;
		}
		Sms po = new Sms();
		if (!StringUtils.isNullObject(bdto.getBizType())) {
			po.setBizType(bdto.getBizType());
		}
		if (!StringUtils.isNullObject(bdto.getMobileNo())) {
			po.setMobileNo(bdto.getMobileNo());
		}
		if (!StringUtils.isNullObject(bdto.getContent())) {
			po.setContent(bdto.getContent());
		}
		return po;
	}
	
	/**
	 * 将DTO列表转为PO列表
	 * @author 冯之浩
	 * @param dtoList
	 * @return List<BasePO>
	 */
	public static List<Sms> getModelList(List<SmsDTO> dtoList) {
		if (dtoList == null || dtoList.size() == 0) {
			return null;
		}
		Sms temp = null;
		List<Sms> listPo = new ArrayList<Sms>();
		for (SmsDTO dto : dtoList) {
			temp =  getModel(dto);
			if (temp != null) {
				listPo.add(temp);
				temp = null;
			}
		}
		return listPo;
	}
	
	/**
	 * 将PO列表转为DTO列表
	 * @author 冯之浩
	 * @param dtoList
	 * @return
	 * List<BaseDTO>
	 */
	public static  List<SmsDTO>  getDTOList(List<Sms> poList) {
		if (poList == null || poList.size() == 0) {
			return null;
		}
		SmsDTO temp = null;
		List<SmsDTO> listDto = new ArrayList<SmsDTO>();
		for (Sms po : poList) {
			temp =getDto(po);
			if (temp != null) {
				listDto.add(temp);
				temp = null;
			}
		}
		return listDto;
	}
	

}
