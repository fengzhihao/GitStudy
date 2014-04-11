package com.oneplus.sms.webservice;

import org.junit.Before;
import org.junit.Test;

import com.oneplus.sms.po.SmsResult;

public class MongateTest {
	private WmgwSoap wmgw;

	@Before
	public void setUp() throws Exception {
		wmgw = new Wmgw().getWmgwSoap();
	}
	
	@Test
	public void sendOneSms(){
		String result=wmgw.mongateCsSpSendSmsNew("J01217",
				"792101", "13510184738", "testfewdf24",
				1, "81");
		System.out.println(result);
	}
	
	@Test
	public void getReport(){
		ArrayOfString re=wmgw.mongateCsGetStatusReportExEx("send01", "123456");
		System.out.println(re==null);
		if(re.getString().size()>0){
			for (String r : re.getString()) {
				System.out.println(r);
			}
		}
	}
	
	@Test
	public void getReceive(){
		ArrayOfString re=wmgw.mongateCsGetSmsExEx("send01", "123456");
		System.out.println(re==null);
		if(re.getString().size()>0){
			for (String r : re.getString()) {
				System.out.println(r);
			}
		}
	}
	
	@Test
	public void checkFee(){
		int re=wmgw.mongateQueryBalance("J01217", "792101");
		System.out.println(re);
	}
}
