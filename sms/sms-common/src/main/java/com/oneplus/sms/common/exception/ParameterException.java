package com.oneplus.sms.common.exception;

/**
 * 深圳市万普拉斯科技有限公司
 *
 * ParameterException.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月12日
 * @version 1.0
 */
public class ParameterException extends RuntimeException{

    public ParameterException(String msg){
        super(msg);
    }

    public ParameterException(String msg, Throwable t){
        super(msg, t);
        setStackTrace(t.getStackTrace());
    }

    private static final long serialVersionUID = 1L;
}