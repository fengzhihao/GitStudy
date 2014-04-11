package com.oneplus.sms.web.aspect;

import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oneplus.commons.Result;
import com.oneplus.commons.util.JsonUtils;
import com.oneplus.sms.common.exception.BusinessException;
import com.oneplus.sms.common.exception.ParameterException;
import com.oneplus.sms.web.util.ExceptionProcessor;

public class FacadeAspect {
	
	private static final JsonUtils jsonUtils = JsonUtils.buildNonNullBinder();
	private Logger logger;
    
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
    	
    	    Result result = null;
    	    StringBuilder classInfo = null;
    	    StringBuilder argStr = null;
    	    StringBuilder outStr = null;
    	    StringBuilder inStr = null;
    	    String logId = null;
    	    logger = LoggerFactory.getLogger(pjp.getTarget().getClass());
    	    try {
    	      long stime = System.currentTimeMillis();

    	      classInfo = new StringBuilder();

    	      classInfo.append("[className=").append(pjp.getTarget().getClass().getName());
    	      classInfo.append(",methodName=").append(pjp.getSignature().getName()).append("]");

    	      argStr = new StringBuilder();
    	      inStr = new StringBuilder();
    	      outStr = new StringBuilder();

    	      for (Object arg : pjp.getArgs()) {
    	        if (arg == null) continue;
    	        try {
    	          logId = BeanUtils.getProperty(arg, "logId");
    	        } catch (Exception e) {
    	        }
    	        argStr.append(jsonUtils.toJson(arg)).append("(").append(arg.getClass().getSimpleName()).append(")");
    	      }

    	      inStr.append("++++ LogId=").append(logId);
    	      inStr.append(" , Enter info ").append(classInfo);
    	      inStr.append(" , InArgs=").append(argStr);
    	      logger.info(inStr.toString());

    	      result = (Result)pjp.proceed();

    	      outStr.append("++++ LogId=").append(logId);
    	      outStr.append(" , Exit[").append(classInfo);
    	      outStr.append(" , OutArgs=");

    	      if (null != result) {
    	        outStr.append(jsonUtils.toJson(result));
    	      }
    	      outStr.append(" , cost ").append(System.currentTimeMillis() - stime).append(" ms]");

    	      logger.info(outStr.toString());

		} catch (ParameterException e) {
			result = ExceptionProcessor.getParameterExceptionResult(e);
			logger.error("ParameterException: errCode={}, errMsg={}", new Object[] { result.getErrCode(), result.getErrMsg() });
		} catch (BusinessException e) {
			result = ExceptionProcessor.getBusinessExceptionResult(e);
			logger.error("BusinessException: errCode={}, errMsg={}",new Object[] { result.getErrCode(), result.getErrMsg() });
		}  catch (Exception e) {
			result = ExceptionProcessor.getExceptionResult(e);
			logger.error("Exception: errCode={}, errMsg={}",new Object[] { result.getErrCode(), e.getMessage() });
		}
        return result;
    }     
    
    public void doThrowing(JoinPoint jp, Throwable ex){
        sendEx(ex.getMessage());
    }
    
    private void sendEx(String ex) {     
        //这里可以发送邮件或者短信通知错误
    	System.err.println(ex);
    }     
}