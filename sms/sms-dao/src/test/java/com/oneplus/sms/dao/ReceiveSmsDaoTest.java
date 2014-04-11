package com.oneplus.sms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oneplus.sms.po.ReceiveSms;
import com.oneplus.sms.po.Sms;

public class ReceiveSmsDaoTest {
	private ReceiveSmsDao smsDao;
	/**
     * 设置初始化容器以及测试相关服务bean
     * @throws Exception
     */
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring-sms-jdbc.xml");
		smsDao = (ReceiveSmsDao) ctx.getBean("receiveSmsDao");
	}
	
	@Test
	public void testDeleteSms() {
		ReceiveSms s = new ReceiveSms();
		s.setId(1);
		smsDao.deleteReceiveSms(s);
	}

	@Test
	public void testInsertSms() {
		ReceiveSms s = new ReceiveSms();
		s.setBizType("11");
		s.setContent("您好，再见");
		s.setMobileNo("13510184735");
		smsDao.insertReceiveSms(s);
	}

	@Test
	public void testBatchInsert() {
		ReceiveSms s2 = new ReceiveSms();
		s2.setBizType("11");
		s2.setContent("您好，再见");
		s2.setMobileNo("13510184740");
		ReceiveSms s1 = new ReceiveSms();
		s1.setBizType("12");
		s1.setContent("再见,您好");
		s1.setMobileNo("13510184739");
		List<ReceiveSms> list = new ArrayList<ReceiveSms>();
		list.add(s1);
		list.add(s2);
		smsDao.batchInsert(list);
	}

	@Test
	public void testSearch() {
		ReceiveSms s = new ReceiveSms();
		s.setBizType("11");
		List<ReceiveSms> list =smsDao.search(s);
		for (ReceiveSms sms : list) {
			System.out.println(sms);
		}
	}

}
