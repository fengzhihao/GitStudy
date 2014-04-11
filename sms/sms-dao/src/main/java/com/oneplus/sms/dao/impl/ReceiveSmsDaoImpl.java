package com.oneplus.sms.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.oneplus.sms.dao.ReceiveSmsDao;
import com.oneplus.sms.po.ReceiveSms;

/**
 * 深圳市万普拉斯科技有限公司
 *
 * ReceiveSmsDaoImpl.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月13日
 * @version 1.0
 */
@Component("receiveSmsDao")
public class ReceiveSmsDaoImpl extends SqlSessionDaoSupport implements ReceiveSmsDao{

	@Override
	public void deleteReceiveSms(ReceiveSms record) {
		getSqlSession().delete("receiveSms.delete", record);
	}

	@Override
	public void insertReceiveSms(ReceiveSms record) {
		getSqlSession().insert("receiveSms.insert", record);
	}

	@Override
	public void batchInsert(List<ReceiveSms> smses) {
		getSqlSession().insert("receiveSms.batch_insert", smses);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReceiveSms> search(ReceiveSms record) {
		return getSqlSession().selectList("receiveSms.search", record);
	}

}
