package com.oneplus.sms.service;

import java.util.List;

import com.oneplus.sms.po.ReceiveSms;
import com.oneplus.sms.po.Sms;

/**
 * 深圳市万普拉斯科技有限公司
 * 
 * SmsService.java
 * 
 * @Description
 * 
 * @auther 冯之浩
 * @date 2014年3月12日
 * @version 1.0
 */
public interface SmsService {
	/**
	 * 删除短信记录
	 * 
	 * @author 冯之浩
	 * @param record
	 * @return int
	 */
	void deleteSms(Sms sms);

	/**
	 * 添加一条短信记录
	 * 
	 * @author 冯之浩
	 * @param record
	 *            void
	 */
	void insertSms(Sms sms);

	/**
	 * 将短信加入发送队列
	 * 
	 * @author 冯之浩
	 * @param sms
	 * @return String
	 */
	void sendSms(Sms sms);

	/**
	 * 发送多条短信
	 * 
	 * @author 冯之浩
	 * @param sms
	 * @return String
	 */
	void batchSendSms(List<Sms> smses);

	/**
	 * 批量添加短信记录
	 * 
	 * @author 冯之浩
	 * @param smses
	 *            void
	 */
	void batchInsert(List<Sms> smses);

	/**
	 * 短信记录搜索
	 * 
	 * @author 冯之浩
	 * @param record
	 * @return List<Sms>
	 */
	List<Sms> search(Sms sms);
	
	
	/**
	 * 上行短信记录搜索
	 * 
	 * @author 冯之浩
	 * @param record
	 * @return List<Sms>
	 */
	List<ReceiveSms> searchReceive(ReceiveSms sms);

	/**
	 * 更新短信记录
	 * 
	 * @author 冯之浩
	 * @param record
	 * @return
	 */
	void updateSms(Sms sms);

	/**
	 * 批量更新
	 * 
	 * @author 冯之浩
	 * @param smses
	 *            void
	 */
	void batchUpdate(List<Sms> smses);
	
	/**
	 * 获取并处理状态报告
	 * @author 冯之浩
	 * void
	 */
	void findAndDealReports();
	
	/**
	 * 根据emp编号获取短信历史记录
	 * @author 冯之浩
	 * @param code
	 * @return
	 */
	Sms getSmsByEmpCode(String code);
	
	/**
	 * 接收上行短信并处理
	 * @author 冯之浩
	 * void
	 */
	void receiveAndDeal();
	
	/**
	 * 调用web-service发送短信
	 * @author 冯之浩
	 * @param sms
	 * void
	 */
	void realSend(Sms sms);
	
	/**
	 * 检查是否将要欠费
	 * @author 冯之浩
	 * void
	 * @throws Exception 
	 */
	void checkFee() throws Exception;
}
