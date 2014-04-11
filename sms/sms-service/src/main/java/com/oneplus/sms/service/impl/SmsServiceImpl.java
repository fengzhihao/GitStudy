package com.oneplus.sms.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.oneplus.mail.facade.MailFacade;
import com.oneplus.mail.facade.dto.MailSendHtmlDTO;
import com.oneplus.sms.common.util.DateUtil;
import com.oneplus.sms.dao.ReceiveSmsDao;
import com.oneplus.sms.dao.SmsDao;
import com.oneplus.sms.facade.util.CommonConstants;
import com.oneplus.sms.po.ReceiveSms;
import com.oneplus.sms.po.Sms;
import com.oneplus.sms.po.SmsResult;
import com.oneplus.sms.service.SmsService;
import com.oneplus.sms.util.startup.AddToQueueThread;
import com.oneplus.sms.util.startup.SmsSendStartUp;
import com.oneplus.sms.webservice.ArrayOfString;
import com.oneplus.sms.webservice.Wmgw;
import com.oneplus.sms.webservice.WmgwSoap;

/**
 * 深圳市万普拉斯科技有限公司
 * 
 * SmsServiceImpl.java
 * 
 * @Description
 * 
 * @Auther 冯之浩
 * @date 2014年3月13日
 * @version 1.0
 */
@Component("smsService")
public class SmsServiceImpl implements SmsService {

	private static Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);

	private ExecutorService executor;
	/**
	 * WSDL地址
	 */
	@Value("#{'${web.service.wsdl}'}")
	private String webServiceWsdl;

	/**
	 * 默认短信账户名
	 */
	@Value("#{'${sms.userId}'}")
	private String smsUserId;

	/**
	 * 默认短信账户密码
	 */
	@Value("#{'${sms.password}'}")
	private String smsPassword;
	
	/**
	 * 默认短信账户名
	 */
	@Value("#{'${sms.checkId}'}")
	private String smsCheckId;

	/**
	 * 默认短信账户密码
	 */
	@Value("#{'${sms.checkPassword}'}")
	private String smsCheckPassword;
	
	/**
	 * 开发人员邮箱
	 */
	@Value("#{'${mail.sendToDev}'}")
	private String sendToDev;
	
	/**
	 * 开发人员手机
	 */
	@Value("#{'${sms.sendToDev}'}")
	private String smsToDev;
	
	/**
	 * 短信相关责任人邮箱
	 */
	@Value("#{'${mail.sendToProd}'}")
	private String sendToProd;
	
	/**
	 * 短信相关责任人邮箱
	 */
	@Value("#{'${sms.sendToProd}'}")
	private String smsToProd;

	/**
	 * 默认发送短信数目
	 */
	@Deprecated
	private int defaultSmsCount;

	/**
	 * 默认端口数目
	 */
	private String defaultSubPort;
	
	/**
	 * web-service接口
	 */
	private WmgwSoap sendService;

	@Resource(name = "smsDao")
	private SmsDao smsDao;

	@Resource(name = "receiveSmsDao")
	private ReceiveSmsDao receiveSmsDao;
	
	@Resource(name = "mailService")
	private MailFacade mailService;

	@Override
	public void deleteSms(Sms sms) {
		smsDao.deleteSms(sms);
	}

	@Override
	public void insertSms(Sms sms) {
		smsDao.insertSms(sms);
	}

	@Override
	public void batchInsert(List<Sms> smses) {
		smsDao.batchInsert(smses);
	}

	@Override
	public List<Sms> search(Sms sms) {
		return smsDao.search(sms);
	}

	@Override
	public List<ReceiveSms> searchReceive(ReceiveSms sms) {
		return receiveSmsDao.search(sms);
	}

	@Override
	public void updateSms(Sms sms) {
		smsDao.updateSms(sms);
	}

	@Override
	public void batchUpdate(List<Sms> smses) {
		smsDao.batchUpdate(smses);
	}

	public void realSend(Sms sms) {
		// 提交发送
		log.info("开始提交短信至EMP@" + new Date() + ":" + sms.toString());
		String no = sms.getMobileNo();
		String[] nos = no.split(",");
		String subPort = defaultSubPort;
		subPort = getSubPort(sms.getBizType());
		String result = sendService
				.mongateCsSpSendSmsNew(smsUserId, smsPassword,
						sms.getMobileNo(), sms.getContent(), nos.length,
						subPort);

		Sms temp;
		List<Sms> ls = new ArrayList<Sms>();
		for (int i = 0; i < nos.length; i++) {
			temp = new Sms();
			temp.setBizType(sms.getBizType());
			temp.setContent(sms.getContent());
			temp.setMobileNo(nos[i]);
			temp.setSendDate(new Date());
			ls.add(temp);
		}
		// 解析提交结果
		parseEmpCode(result, ls);
		// 存入数据库
		batchInsert(ls);
		log.info("结束提交短信至EMP");
	}

	@Override
	public void sendSms(Sms sms) {
		log.info("单条提交短信队列：" + sms);
		boolean ifContentOver = sms.getContent().length() > 350;
		boolean ifMobileOver = sms.getMobileNo().split(",").length > 100;
		List<Sms> ls = new ArrayList<Sms>();
		if (ifContentOver) {
			if (ifMobileOver) { // 短信内容和长度都超
				Sms temp;
				String[] contents = splitStringByLength(sms.getContent(),
						CommonConstants.MAX_CONTENT_LENGTH);
				String[] mobiles = splitMobileNo(sms.getMobileNo(),
						CommonConstants.MAX_MOBILE_LENGTH);
				for (String mobile : mobiles) {
					for (String content : contents) {
						temp = new Sms();
						BeanUtils.copyProperties(sms, temp);
						temp.setContent(content);
						temp.setMobileNo(mobile);
						ls.add(temp);
					}
				}
			} else { // 短信内容超出
				String[] contents = splitStringByLength(sms.getContent(),
						CommonConstants.MAX_CONTENT_LENGTH);
				Sms temp;
				for (String string : contents) {
					temp = new Sms();
					BeanUtils.copyProperties(sms, temp);
					temp.setContent(string);
					ls.add(temp);
				}
			}
		} else {
			if (ifMobileOver) { // 号码长度超
				String[] mobiles = splitMobileNo(sms.getMobileNo(),
						CommonConstants.MAX_MOBILE_LENGTH);
				Sms temp;
				for (String string : mobiles) {
					temp = new Sms();
					BeanUtils.copyProperties(sms, temp);
					temp.setMobileNo(string);
					ls.add(temp);
				}
			} else { // 正常
				ls.add(sms);
			}
		}

		SmsSendStartUp.executor.execute(new AddToQueueThread(ls));

	}

	@Override
	public void batchSendSms(List<Sms> smses) {
		log.info("批量提交短信队列：" + smses);
		for (Sms sms : smses) {
			sendSms(sms);
		}
	}

	@Override
	public void findAndDealReports() {
		ArrayOfString re = sendService.mongateCsGetStatusReportExEx(smsUserId,
				smsPassword);
		if (re != null && re.getString().size() > 0) {
			SmsResult sms = null;
			String[] results = null;
			for (String r : re.getString()) {
				results = r.split(",");
				sms = new SmsResult();
				sms.setResultDate(results[0]); // 日期
				sms.setReslutTime(results[1]); // 时间
				sms.setResultMessageid(results[2]); // 信息编号
				sms.setResultState(results[4]); // 状态值
				sms.setResultMessageError(results[5]); // 详细错误原因
				updateState(sms);
			}
		}
	}

	@Override
	public void receiveAndDeal() {
		ArrayOfString re = sendService.mongateCsGetSmsExEx(smsUserId,
				smsPassword);
		if (re != null && re.getString().size() > 0) {
			SmsResult sms = null;
			String[] results = null;
			for (String r : re.getString()) {
				results = r.split(",");
				sms = new SmsResult();
				sms.setResultDate(results[0]); // 日期
				sms.setReslutTime(results[1]); // 时间
				sms.setResultPhone(results[2]); // 上行源手机号码
				sms.setResultSpgate(results[3]); // 上行目标通道号
				sms.setResultSubPort(results[4]);// 子通道号
				sms.setResultMessage(results[5]); // 信息内容
				// 存储上行短信
				insertReceiveSms(sms);
				// 通知相关业务
				notify(sms);
			}
		}
	}

	/**
	 * 保存上行短信
	 * 
	 * @author 冯之浩
	 * @param sms
	 *            void
	 */
	private void insertReceiveSms(SmsResult sms) {
		ReceiveSms s = getFromSmsResult(sms);
		receiveSmsDao.insertReceiveSms(s);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.oneplus.sms.service.SmsService#getSmsByEmpCode(java.lang.String)
	 */
	public Sms getSmsByEmpCode(String code) {
		return smsDao.getSmsByEmpCode(code);
	}

	/**
	 * 接收到上行短信后通知相关业务
	 * 
	 * @author 冯之浩
	 * @param sms
	 *            void
	 */
	private void notify(SmsResult sms) {
		String bizType = CommonConstants.SP_BIZ_CODE.getCodeBizMap().get(
				sms.getResultSubPort());
		// FIXME 通知相关业务
	}

	/**
	 * 更新短信发送状态
	 * 
	 * @author 冯之浩 void
	 */
	private void updateState(SmsResult r) {
		Sms s = smsDao.getSmsByEmpCode(r.getResultMessageid());
		if (s != null) {
			s.setState(r.getResultState());
			s.setSendDetail(r.getResultMessageError());
			smsDao.updateSms(s);
		}
	}

	/**
	 * bean初始化调用 初始化WSDL 初始化短信调动主线程
	 * 
	 * @author 冯之浩 void
	 * @throws Exception 
	 */
	public void init() throws Exception {
		defaultSubPort = "*";
		executor = Executors.newCachedThreadPool();
		try {
			URL url = new URL(webServiceWsdl);
			sendService = new Wmgw(url).getWmgwSoap();
		} catch (MalformedURLException e) {
			System.out.println("load wsdl-url(" + webServiceWsdl + ")error:"
					+ e.getMessage());
			System.out.println("use default wsdl-url!");
			sendService = new Wmgw().getWmgwSoap();
		}
		
		Thread thread = new Thread(new SmsSendStartUp(this));
		thread.setName("SMS-Send-Thread");
		thread.start();
	}

	/**
	 * 解析异常代码，并存入po
	 * 
	 * @author 冯之浩
	 * @param code
	 * @param sms
	 *            void
	 */
	private void parseEmpCode(String code, List<Sms> smses) {
		if (CommonConstants.SEND_ERROR_CODE.getMap().get(code) != null) {
			for (Sms sms : smses) {
				sms.setEmpCode(code);
				sms.setErrorCode(code);
				sms.setState(CommonConstants.SEND_FAIL);
			}
		} else {
			Long longR = Long.parseLong(code);
			for (int i = 0; i < smses.size(); i++) {
				smses.get(i).setEmpCode((longR + i) + "");
			}
		}
	}

	private String getSubPort(String bizType) {
		if (org.apache.commons.lang.StringUtils.isBlank(bizType)) {
			return defaultSubPort;
		} else {
			String profix = bizType.substring(0, 1);
			String result = CommonConstants.SP_BIZ_CODE.getBizCodeMap().get(
					profix);
			if (result == null) {
				return defaultSubPort;
			} else {
				return result;
			}
		}
	}

	private ReceiveSms getFromSmsResult(SmsResult sms) {
		ReceiveSms s = new ReceiveSms();
		s.setContent(sms.getResultMessage());
		s.setMobileNo(sms.getResultPhone());
		s.setSpGate(sms.getResultSpgate());
		s.setSubPort(sms.getResultSubPort());
		String bizType = CommonConstants.SP_BIZ_CODE.getCodeBizMap().get(
				sms.getResultSubPort());
		bizType = (bizType == null ? defaultSubPort : bizType);
		s.setBizType(bizType);
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(sms.getResultDate()).append(" ")
					.append(sms.getResultTime());
			Date d = DateUtil.getDateByFormatStr(sb.toString(),
					DateUtil.TIMEF_FORMAT);
			s.setReceiveDate(d==null?(new Date()):d);
		} catch (Exception e) {
			s.setReceiveDate(new Date());
		}

		return s;
	}

	/**
	 * 分割短信文本
	 * @author 冯之浩
	 * @param msg
	 * @param num
	 * @return
	 * String[]
	 */
	private String[] splitStringByLength(String msg, int num) {
		int len = msg.length();
		if (len <= num)
			return new String[] { msg };

		int count = len / (num - 1);
		count += len > (num - 1) * count ? 1 : 0;

		String[] result = new String[count];

		int pos = 0;
		int splitLen = num - 1;
		for (int i = 0; i < count; i++) {
			if (i == count - 1)
				splitLen = len - pos;

			result[i] = msg.substring(pos, pos + splitLen);
			pos += splitLen;

		}
		return result;
	}

	/**
	 * 分割手机号码段
	 * @author 冯之浩
	 * @param mobileNos
	 * @param num
	 * @return
	 * String[]
	 */
	public static String[] splitMobileNo(String mobileNos, int num) {
		String[] mobiles = mobileNos.split(",");
		List<String> ls = Arrays.asList(mobiles);
		int l = mobiles.length;
		int split = l % num == 0 ? (l / num) : (l / num + 1);
		String[] result = new String[split];
		String temp;
		for (int i = 0; i < split - 1; i++) {
			temp = ls.subList(i * num, (i + 1) * num).toString();
			result[i] = temp.substring(1, temp.length() - 1);
		}
		result[split - 1] = ls.subList((split - 1) * num, ls.size()).toString();
		return result;
	}

	@Override
	public void checkFee() throws Exception {
		Integer num = sendService.mongateQueryBalance(smsCheckId, smsCheckPassword);
		System.out.println("================"+num+smsToProd+"===================");
		if(num!=null&&num.intValue()<= CommonConstants.maxCanSend){
		// 发送邮件	
			MailSendHtmlDTO mail = new MailSendHtmlDTO();
			mail.setToEmail(sendToProd);
			mail.setMailTitle("短信账号充值提醒");
			mail.setHtmlString("短信账号剩余"+num+"条，请及时充值");
			sendMail(mail);
		// 发送短信	
			Sms sms = new Sms();
			sms.setMobileNo(smsToProd);
			sms.setContent("短信账号剩余"+num+"条，请及时充值");
			sms.setBizType(CommonConstants.BIZ_TYPE_ERROR);
			sendSms(sms);
		}
	}

	/**
	 * 发送异常邮件
	 * @author 冯之浩
	 * @param mail
	 * void
	 */
	private void sendMail(final MailSendHtmlDTO mail){
		executor.execute(new Runnable(){
            public void run() {
            	try {
					mailService.sendHtml(mail);
				} catch (Exception e) {
					log.info("发送邮件失败："+e.getMessage());
				}
            }
		});
	}
}
