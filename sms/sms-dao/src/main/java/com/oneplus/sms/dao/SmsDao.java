package com.oneplus.sms.dao;

import java.util.List;

import com.oneplus.sms.po.Sms;

/**
 * 深圳市万普拉斯科技有限公司
 *
 * SmsDao.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月13日
 * @version 1.0
 */
public interface SmsDao {
    /**
     * 删除短信记录
     * @author 冯之浩
     * @param record
     * @return
     * int
     */
    void deleteSms(Sms record);

    /**
     * 添加一条短信记录
     * @author 冯之浩
     * @param record
     * void
     */
    void insertSms(Sms record);
    
    /**
     * 批量添加短信记录
     * @author 冯之浩
     * @param smses
     * void
     */
    void batchInsert(List<Sms> smses);

    /**
     * 短信记录搜索
     * @author 冯之浩
     * @param record
     * @return
     * List<Sms>
     */
    List<Sms> search(Sms record);
    
    /**
     * 更新短信记录
     * @author 冯之浩
     * @param record
     * @return
     */
    void updateSms(Sms record);
    
    /**
     * 批量更新
     * @author 冯之浩
     * @param smses
     * void
     */
    void batchUpdate(List<Sms> smses);
    
    Sms getSmsByEmpCode(String code);
}	
