package com.oneplus.sms.common.util;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.util.JSONPObject;


/**
 * 深圳市万普拉斯科技有限公司
 *
 * JsonUtils.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月12日
 * @version 1.0
 */
public class JsonUtils {

	private static Logger logger = Logger.getLogger(JsonUtils.class);

	private ObjectMapper mapper;

	public JsonUtils() {
		mapper = new ObjectMapper();
		//只输出初始值被改变的属性,其它风格见Inclusion(Inclusion.ALWAYS,Inclusion.NON_NULL)
		mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_DEFAULT);
		mapperInit();
	}

	/**
	 * 自定义风格
	 */
	public JsonUtils(Inclusion inclusion) {
		mapper = new ObjectMapper();
		mapper.getSerializationConfig().setSerializationInclusion(inclusion);
		mapperInit();
	}

	private void mapperInit() {
		//忽略在JSON中存在但Java对象没有的属性
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//禁用int代表Enum的order()來反序列化Enum
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
	}

	/**
	 * Json转对象 (若JSON为Null或"null"字符串, 返回Null;若JSON字符串为"[]", 返回空集合)
	 */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			return mapper.readValue(jsonString, clazz);
		} catch (IOException e) {
			logger.warn("parse json to Object error:" + jsonString, e);
			return null;
		}
	}

	/**
	 * 对象转Json(对象为null, 返回"null".集合为空，返回"[]")
	 */
	public String toJson(Object object) {

		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			logger.warn("pase object to json error:" + object, e);
			return null;
		}
	}

	/**
	 * 输出JSONP格式
	 */
	public String toJsonP(String functionName, Object object) {
		return toJson(new JSONPObject(functionName, object));
	}
	
	/**
	 * 创建输出全部属性到Json字符串的Binder.
	 */
	public static JsonUtils buildNormalBinder() {
		return new JsonUtils(Inclusion.ALWAYS);
	}

	/**
	 * 创建只输出非空属性到Json字符串的Binder.
	 */
	public static JsonUtils buildNonNullBinder() {
		return new JsonUtils(Inclusion.NON_NULL);
	}

	/**
	 * 创建只输出初始值被改变的属性到Json字符串的Binder.
	 */
	public static JsonUtils buildNonDefaultBinder() {
		return new JsonUtils(Inclusion.NON_DEFAULT);
	}
	
}
