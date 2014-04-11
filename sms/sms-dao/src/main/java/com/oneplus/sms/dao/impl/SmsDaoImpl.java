package com.oneplus.sms.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.oneplus.sms.dao.SmsDao;
import com.oneplus.sms.po.Sms;

/**
 * 深圳市万普拉斯科技有限公司
 *
 * SmsDaoImpl.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月13日
 * @version 1.0
 */
@Component("smsDao")
public class SmsDaoImpl extends SqlSessionDaoSupport implements SmsDao{

	@Override
	public void deleteSms(Sms record) {
		getSqlSession().delete("sms.delete", record);
	}

	@Override
	public void insertSms(Sms record) {
		getSqlSession().insert("sms.insert", record);
	}

	@Override
	public void batchInsert(List<Sms> smses) {
		getSqlSession().insert("sms.batch_insert", smses);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sms> search(Sms record) {
		return getSqlSession().selectList("sms.search", record);
	}

	@Override
	public void updateSms(Sms record) {
		getSqlSession().update("sms.update", record);
	}

	@Override
	public void batchUpdate(List<Sms> smses) {
		getSqlSession().update("sms.batch_update", smses);
	}

	@Override
	public Sms getSmsByEmpCode(String code) {
		return (Sms) getSqlSession().selectOne("sms.get_by_emp_code", code);
	}

}
