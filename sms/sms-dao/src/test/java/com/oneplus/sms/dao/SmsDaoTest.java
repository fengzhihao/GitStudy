package com.oneplus.sms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oneplus.sms.po.Sms;

public class SmsDaoTest {
	private SmsDao smsDao;
	/**
     * 设置初始化容器以及测试相关服务bean
     * @throws Exception
     */
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring-sms-jdbc.xml");
		smsDao = (SmsDao) ctx.getBean("smsDao");
	}
	
	@Test
	public void testDeleteSms() {
		Sms s = new Sms();
		s.setId(1);
		smsDao.deleteSms(s);
	}

	@Test
	public void testInsertSms() {
		Sms s = new Sms();
		s.setBizType("11");
		s.setContent("您好，再见");
		s.setMobileNo("13510184735");
		smsDao.insertSms(s);
	}

	@Test
	public void testBatchInsert() {
		Sms s2 = new Sms();
		s2.setBizType("11");
		s2.setContent("您好，再见");
		s2.setMobileNo("13510184740");
		s2.setSendDate(new Date());
		Sms s1 = new Sms();
		s1.setBizType("12");
		s1.setContent("再见,您好");
		s1.setMobileNo("13510184739");
		s1.setSendDate(new Date());
		List<Sms> list = new ArrayList<Sms>();
		list.add(s1);
		list.add(s2);
		smsDao.batchInsert(list);
	}

	@Test
	public void testSearch() {
		Sms s = new Sms();
		s.setBizType("11");
		List<Sms> list =smsDao.search(s);
		for (Sms sms : list) {
			System.out.println(sms);
		}
	}

	@Test
	public void testUpdateSms() {
		Sms s = new Sms();
		s.setId(2);
		s.setContent("垃圾短信 ");
		s.setState("2");
		smsDao.updateSms(s);
	}

	@Test
	public void testBatchUpdate() {
		Sms s2 = new Sms();
		s2.setId(1);
		s2.setBizType("112");
		s2.setContent("您好，再见2");
		s2.setMobileNo("135101847410");
		Sms s1 = new Sms();
		s1.setId(2);
		s1.setBizType("122");
		s1.setContent("再见,您好2");
		s1.setMobileNo("135101847319");
		List<Sms> list = new ArrayList<Sms>();
		list.add(s1);
		list.add(s2);
		smsDao.batchUpdate(list);
	}

}
