package com.oneplus.sms.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OperateConfig {
	
	private static final OperateConfig operateConfig = new OperateConfig();
	
	private static Properties props=null;
	
	public static OperateConfig getInstance() {
		return operateConfig;
	}
	
	public String getString(String key) {
		return props.getProperty(key);
	}

	private OperateConfig() {
		init();
	}
	
	private void init() {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("dbconfig.properties");
	    props = new Properties();
		try {
			props.load(is);
		} catch (Exception e) {
			System.err.println("Can not read the properties file; "+ "make sure config.properties is in the Classpath");
			return;
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		String ss = OperateConfig.getInstance().getString("order.db.driverClass");
		System.out.println(ss);
	}
}
