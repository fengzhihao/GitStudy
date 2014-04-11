package com.oneplus.sms.common.util;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;


/**
 * 深圳市万普拉斯科技有限公司
 *
 * CommonUtils.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月12日
 * @version 1.0
 */
public final class CommonUtils {
	
    @SuppressWarnings("rawtypes")
    public static Collection collectByPropertyName(Collection collection, String propertyName) {
        return CollectionUtils.collect(collection, new BeanToPropertyValueTransformer(propertyName));
    }
    
    public static String map2String(Map<String, String> map){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> m : map.entrySet()) {
            sb.append(m.getValue());
        }
        return sb.toString();
    }
    
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
    /**
     * 返回随机数，范围在[start,end]
     * @param int start
     * @param int end
     * @return int 
     */
	public static int getRandom(int start, int end) {
		return (new Random().nextInt(end) + start);
	}
	
	public static void main(String[] args){
		for (int  i = 0; i<100;i++) {
			System.out.println("getRandom(1,2)="+getRandom(1,2));
		}
	}
    
}
