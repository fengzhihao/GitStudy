package com.oneplus.sms.dao;

import java.util.List;

import com.oneplus.sms.po.ReceiveSms;

/**
 * 深圳市万普拉斯科技有限公司
 *
 * ReceiveSmsDao.java
 * @Description
 *	
 * @auther 冯之浩
 * @date   2014年3月13日
 * @version 1.0
 */
public interface ReceiveSmsDao {
    /**
     * 删除上行短信记录
     * @author 冯之浩
     * @param record
     * @return
     * int
     */
    void deleteReceiveSms(ReceiveSms record);

    /**
     * 添加一条上行短信记录
     * @author 冯之浩
     * @param record
     * void
     */
    void insertReceiveSms(ReceiveSms record);
    
    /**
     * 批量添加上行短信记录
     * @author 冯之浩
     * @param smses
     * void
     */
    void batchInsert(List<ReceiveSms> smses);

    /**
     * 上行短信记录搜索
     * @author 冯之浩
     * @param record
     * @return
     * List<Sms>
     */
    List<ReceiveSms> search(ReceiveSms record);
    
}	
