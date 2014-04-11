/*
 * 文件名：CommonConstants.java
 * 版权：Copyright©2014 Shenzhen OnePlus Informtaion Technology Co.,Ltd. All Rights Reserved.
 * 描述：<描述>
 * 创建人：80071746
 * 创建时间：2014年1月20日
 * 备注: 
 */
package com.oneplus.sms.facade.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 深圳市万普拉斯科技有限公司
 * 
 * CommonConstants.java
 * 
 * @Description 定义常量
 * @auther 冯之浩
 * @date 2014年3月13日
 * @version 1.0
 */
public class CommonConstants {
	/**
	 * 远程调用操作成功标识
	 */
	public static final String OPERATE_SUCESS_FLAG = "1";
	public static final String OPERATE_FAIL_FLAG = "0";
	
	public static final int MAX_CONTENT_LENGTH = 340;	
	public static final int MAX_MOBILE_LENGTH = 100;	
	
	/************************* 短信业务类型 ***********************/
	public static final String BIZ_TYPE_ERROR = "0";// 异常提醒
	public static final String BIZ_TYPE_VIP = "1";// 会员
	public static final String BIZ_TYPE_ORDER = "2";// 订单
	public static final String BIZ_TYPE_CRM = "3";// 客服
	public static final String BIZ_TYPE_CSS = "4";// 退换修
	public static final String BIZ_TYPE_SALES = "5";// 促销
	public static final String BIZ_TYPE_ACTIVITY = "6";// 活动
	public static final String BIZ_TYPE_PAY = "7";// 支付
	
	/************************* 系统错误码 ***********************/
	public static final String ERROR_PARAMS = "100";// 参数异常
	public static final String ERROR_BIZ = "200";// 业务异常
	public static final String ERROR_SYS = "300";// 系统异常
	public static final String ERROR_EMP = "310";// EMP异常
	
	/************************* 短信发送结果码 ***********************/
	public static final String SEND_SUCCESS = "0";// 接收成功
	public static final String SEND_FAIL = "2";// 发送异常
	public static final String SEND_CACHE = "1";// 发送被缓存

	/************************ 报告类型 **************************/
	public static final int state=2;//状态
	public static final int context=1;//上行
	public static final int all=0;//二者兼有
	
	/**
	 * 查询是否将要欠费的短信数量阀值
	 */
	public static final int maxCanSend = 10000;
	
	/************************ 异常编码 **************************/
	public enum SEND_ERROR_CODE {

		ParamsNull("-1", "参数为空。信息、电话号码等有空指针，登陆失败"), 
		NumsExceed("-2", "电话号码个数超过100"), 
		CacheApply("-10", "申请缓存空间失败"), 
		NumError("-11", "电话号码中有非数字字符"), 
		NumsInvalid("-12", "有异常电话号码"), 
		NumsNotEqFact("-13", "电话号码个数与实际个数不相等"), 
		FactNumsExceed("-14", "实际号码个数超过100"), 
		SendOverTime("-101", "发送消息等待超时"), 
		SendOrReceive("-102", "发送或接收消息失败"), 
		ReceiveOverTime("-103", "接收消息超时"), 
		Other("-200", "其他错误"), 
		AccountLogin("-10001", "用户登陆不成功"), 
		FormatInvalid("-10002", "提交格式不正确"), 
		NoMoney("-10003", "用户余额不足"), 
		NumError2("-10004", "手机号码不正确"), 
		UserIdInvalid("-10005", "计费用户帐号错误"), 
		PwdInvalid("-10006", "计费用户密码错"), 
		AccountEnded("-10007", "账号已经被停用"), 
		AccountNoSupported("-10008", "账号类型不支持该功能"), 
		Other2("-10009", "其它错误"), 
		CompanyCode("-10010", "企业代码不正确"), 
		ContentExceed("-10011", "信息内容超长"), 
		Unicom("-10012", "不能发送联通号码"), 
		UserRight("-10013", "操作员权限不够"), 
		FeeRateCode("-10014", "费率代码不正确"), 
		BusyServer("-10015", "服务器繁忙"), 
		CompanyRight("-10016", "企业权限不够"), 
		TimeError("-10017", "此时间段不允许发送"), 
		ResellerAccount("-10018", "经销商用户名或密码错"), 
		NumList("-10019", "手机列表或规则错误"), 
		StopAccountRight("-10021", "没有开停户权限"), 
		SwapAccountRight("-10022", "没有转换用户类型的权限"), 
		UpdateAccountRight("-10023", "没有修改用户所属经销商的权限"), 
		ResellerAccount2("-10024", "经销商用户名或密码错"), 
		UserAccount("-10025", "操作员登陆名或密码错误"), 
		UserAccountInvalid("-10026", "操作员所充值的用户不存在"), 
		UserRight2("-10027", "操作员没有充值商务版的权限"), 
		CantAddMoney("-10028", "该用户没有转正不能充值"), 
		CompanyNoRight("-10029", "此用户没有权限从此通道发送信息"), 
		ChinaMobile("-10030", "不能发送移动号码"), 
		NumError3("-10031", "手机号码(段)非法"),
		FeeRateCode2("-10032", "用户使用的费率代码错误"), 
		InvalidWord("-10033", "非法关键词");
		
		private final String key;
		private final String value;

		private SEND_ERROR_CODE(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}

		public static Map<String, String> getMap() {
			Map<String, String> map = new HashMap<String, String>();
			for (SEND_ERROR_CODE e : SEND_ERROR_CODE.values()) {
				map.put(e.getKey(), e.getValue());
			}
			return map;
		}
	}
	
	/**
	 * 深圳市万普拉斯科技有限公司
	 *
	 * CommonConstants.java
	 * @Description
	 * 业务和子端口扩展对应编码
	 * @auther 冯之浩
	 * @date   2014年3月15日
	 * @version 1.0
	 */
	public enum SP_BIZ_CODE {
		
		VIP("1", "01"), 
		ORDER("2", "02"), 
		CRM("3", "03"), 
		CSS("4", "04"), 
		SALES("5", "05"), 
		ACTIVITY("6", "06"), 
		PAY("7", "07");
		
		private final String key;
		private final String value;

		private SP_BIZ_CODE(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}

		public static Map<String, String> getBizCodeMap() {
			Map<String, String> map = new HashMap<String, String>();
			for (SP_BIZ_CODE e : SP_BIZ_CODE.values()) {
				map.put(e.getKey(), e.getValue());
			}
			return map;
		}
		
		public static Map<String, String> getCodeBizMap() {
			Map<String, String> map = new HashMap<String, String>();
			for (SP_BIZ_CODE e : SP_BIZ_CODE.values()) {
				map.put(e.getValue(),e.getKey() );
			}
			return map;
		}
	}

}
