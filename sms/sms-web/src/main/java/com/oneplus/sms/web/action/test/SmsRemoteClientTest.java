package com.oneplus.sms.web.action.test;

import java.util.ArrayList;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.oneplus.commons.Result;
import com.oneplus.sms.common.util.JsonUtils;
import com.oneplus.sms.facade.SmsFacade;
import com.oneplus.sms.facade.dto.SmsDTO;

public class SmsRemoteClientTest {

	private SmsFacade smsFacade;

	private static final String COMMON_FACADE = "http://sms.api.oneplus.cn:10098/sms-web/remote/smsFacade";
	private JsonUtils jsonUtils = new JsonUtils();

	//@Before
	public void getFacade() {
		try {
			HessianProxyFactory factory = new HessianProxyFactory();
			smsFacade = (SmsFacade) factory.create(SmsFacade.class,
					COMMON_FACADE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void testSendOne() {
		SmsDTO s = new SmsDTO();
		s.setBizType("1");
		s.setContent("您好，注册成功");
		s.setMobileNo("13510184738,xxxxxxxxxxx");
		Result r = smsFacade.sendSms(s);
	}

	//@Test
	public void testSendMore() {
		try {
			SmsDTO s1 = new SmsDTO();
			s1.setBizType("112");
			s1.setContent("您好，注册成功");
			s1.setMobileNo("13510184738");
			SmsDTO s2 = new SmsDTO();
			s2.setBizType("113");
			s2.setContent("您好，注册失败");
			s2.setMobileNo("xxxxxxxxxxx");
			SmsDTO s3 = new SmsDTO();
			s3.setBizType("113");
			s3.setContent("您好，注册被催");
			s3.setMobileNo("xxxxxxxxxxx");
			SmsDTO s4 = new SmsDTO();
			s4.setBizType("113");
			s4.setContent("您好，注册二号");
			s4.setMobileNo("xxxxxxxxxxx");
			List<SmsDTO> ls = new ArrayList<SmsDTO>();
			ls.add(s1);
			ls.add(s2);
			ls.add(s3);
			ls.add(s4);
			Result r = smsFacade.batchSendSms(ls);
			System.out.println("batchSendSms() Result:" + jsonUtils.toJson(r));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
