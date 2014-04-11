package com.oneplus.sms.util.startup;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oneplus.sms.common.enums.ExceptionEnum;
import com.oneplus.sms.common.exception.BusinessException;
import com.oneplus.sms.po.Sms;
import com.oneplus.sms.util.job.ReceiveJob;

public class AddToQueueThread implements Runnable {

	private static Logger log = LoggerFactory.getLogger(ReceiveJob.class);

	private List<Sms> smses;

	@Override
	public void run() {

		for (Sms sms : smses) {
			try {
				SmsSendStartUp.queue.put(sms);
			} catch (InterruptedException e) {
				log.error("无法插入短信发送队列" + sms.toString() + "，错误信息："
						+ e.getMessage());
				throw new BusinessException(
						ExceptionEnum.BusExcep.CanntAddToQueue.getValue());
			}
		}

	}

	public AddToQueueThread(List<Sms> smses) {
		this.smses = smses;
	}

	public List<Sms> getSmses() {
		return smses;
	}

	public void setSmses(List<Sms> smses) {
		this.smses = smses;
	}

}
