package com.oneplus.sms.common.enums;

import java.util.HashMap;
import java.util.Map;

public class ExceptionEnum {
	
	/**
	 * PARAMETER_OBJECT = "入参对象为null"
	 */
	public static final String PARAMETER_OBJECT = "入参对象为null";
	
	/**
	 * PARAMETER_VALUE = "入参对象的属性为null"
	 */
	public static final String PARAMETER_VALUE = "入参对象的属性为null";
	
	/**
	 * PARA_VALUE = "入参不合法"
	 */
	public static final String PARA_VALUE = "入参不合法";
	
	/**
	 * 异常类型:参数异常
	 */
	public static final String ERROE_CODE_PARAMETER = "100";
	
	/**
	 * 异常类型:业务异常
	 */
	public static final String ERROE_CODE_BUSINESS = "200";
	
	/**
	 * 异常类型:系统异常
	 */
	public static final String ERROE_CODE_SYSTEM = "300";
	
	/**
	 * 业务异常 
	 */
    public enum BusExcep {
    	
    	CanntAddToQueue("800","无法插入短信发送队列"),
        NoSmsInfo("801","短信信息不完整"),
        NoBizType("802","未填写业务编号"),
        NoContent("803","未填写短信内容"),
        NoMobileNo("804","未填写手机号码"),
        NoSmsList("805","短信列表为空");
        
        private final String key;
        private final String value;
        
        private BusExcep(String key, String value) {
            this.key = key;
            this.value = value;
        }
        
        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
         
        public static Map<String, String> getList() {
            Map<String, String> map = new HashMap<String, String>();
            for (BusExcep e : BusExcep.values()) {
                map.put(String.valueOf(e.getKey()), e.getValue());
            }
            return map;
        }
    }
	
}
