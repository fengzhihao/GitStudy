package com.oneplus.sms.common.exception;


/**
 * 深圳市万普拉斯科技有限公司
 *
 * BusinessException.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月12日
 * @version 1.0
 */
public class BusinessException extends RuntimeException{

	private String code;
	
    public BusinessException(String msg){
        super(msg);
    }
    
    public BusinessException(String code, String msg){
        super(msg);
        this.code = code;
    }
    
    public BusinessException(String msg, Throwable t){
        super(msg, t);
        setStackTrace(t.getStackTrace());
    }

    private static final long serialVersionUID = 1L;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	} 
}