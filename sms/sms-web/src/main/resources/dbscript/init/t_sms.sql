/*
Navicat MySQL Data Transfer

Source Server         : db.devel.oneplus.cn
Source Server Version : 50161
Source Host           : db.devel.oneplus.cn:3306
Source Database       : oneplus_sms

Target Server Type    : MYSQL
Target Server Version : 50161
File Encoding         : 65001

Date: 2014-03-12 10:44:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_sms
-- ----------------------------
DROP TABLE IF EXISTS `t_sms`;
CREATE TABLE `t_sms` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据库id',
  `mobile_no` varchar(15) DEFAULT NULL COMMENT '电话号码',
  `content` varchar(160) DEFAULT NULL COMMENT '短信内容',
  `biz_type` int(3) DEFAULT NULL COMMENT '业务类型',
  `state` varchar(1) DEFAULT NULL COMMENT '发送结果',
  `send_date` datetime DEFAULT NULL COMMENT '发送日期',
  `emp_code` varchar(25) DEFAULT NULL COMMENT 'EMP系统返回的编码',
  `error_code` varchar(10) DEFAULT NULL COMMENT '异常编码',
  `send_detail` varchar(50) DEFAULT NULL COMMENT '异常详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_receive_sms
-- ----------------------------
DROP TABLE IF EXISTS `t_receive_sms`;
CREATE TABLE `t_receive_sms` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据库id',
  `receive_date` datetime DEFAULT NULL  COMMENT '实际接收日期',
  `mobile_no` varchar(30) DEFAULT NULL  COMMENT '电话号码',
  `sp_gate` varchar(20) DEFAULT NULL  COMMENT '通道名称',
  `sub_port` varchar(4) DEFAULT NULL  COMMENT '子端口',
  `content` varchar(100) DEFAULT NULL  COMMENT '短信内容',
  `biz_type` varchar(4) DEFAULT NULL  COMMENT '业务类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

