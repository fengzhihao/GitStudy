/*
 * 文件名：Util.java
 * 版权：Copyright©2014 Shenzhen OnePlus Informtaion Technology Co.,Ltd. All Rights Reserved.
 * 描述：<描述>
 * 创建人：80071746
 * 创建时间：2014年1月24日
 * 备注: 
 */
package com.oneplus.sms.common.util;

import java.util.List;

public class Utils {
	
	/*******************特殊符号常量***************************/
	public static final String COMMON_SPLIT_CHAR = ",";
	
	/**
	 * 功能描述：判断列表是否为空，如果为空返回true，否则返回false
	 * 
	 * 生成时间：2014年1月24日
	 * 
	 * 修改记录：
	 * 
	 * 作者：hujt
	 * 
	 * @param   list  列表对象
	 * @return
	 */
	public static boolean isEmptyList(List<?> list){
		return list == null || list.size() <= 0;
	}
	
	/**
	 * 功能描述：根据列表元素，拼接字符串，用逗号分割
	 * 
	 * 生成时间：2014年02月11日
	 * 
	 * 修改记录：
	 * 
	 * 作者：menglei
	 * 
	 * @param   list  列表对象
	 * @return
	 */
	public static String buildString(List<?> list, String splitChar) {
		String sbStr = null;
		if (!isEmptyList(list)) {
			StringBuffer sbBuffer = new StringBuffer();
			for (Object itemList : list) {
				sbBuffer.append((String) itemList);
				sbBuffer.append(COMMON_SPLIT_CHAR);
			}
			if (sbBuffer.toString().length() > 0) {
				sbStr = sbBuffer.toString().substring(0,sbBuffer.toString().length() - 1);
			}
		} else {
			sbStr = "";
		}
		return sbStr;
	}
	
}
