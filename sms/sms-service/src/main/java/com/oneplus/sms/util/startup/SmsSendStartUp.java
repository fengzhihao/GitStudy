package com.oneplus.sms.util.startup;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.oneplus.sms.po.Sms;
import com.oneplus.sms.service.SmsService;

public class SmsSendStartUp implements Runnable{
	
	private SmsService smsService;
	//线程池
	public static ExecutorService executor;
	//阻塞队列
	public static BlockingQueue<Sms> queue;
	
	static{
		//队列初始化
		queue = new ArrayBlockingQueue<Sms>(100);
		executor = Executors.newFixedThreadPool(10);
	}

	@Override
	public void run() {
		Sms sms = null;
		try {
			while(true){
				sms = queue.poll(1,TimeUnit.SECONDS);
				if(sms!=null){
					executor.execute(new SendSmsThread(smsService,sms));
				}
			}
		} catch (Exception e) {
			destory();
		}
		
	}
	
	public SmsSendStartUp(SmsService service){
		this.smsService = service;
	}
	
	public void destory(){
		executor.shutdown();
	}
}
