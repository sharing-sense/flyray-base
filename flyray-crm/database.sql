CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `chinesename` varchar(10) NOT NULL COMMENT '中文名',
  `dept` tinyint(4) NOT NULL COMMENT '部门',
  `email` varchar(30) NOT NULL COMMENT '邮箱',
  `tel` varchar(4) NOT NULL COMMENT '电话号码',
  `sys_role` tinyint(4) NOT NULL DEFAULT '2' COMMENT '用户组',
  `state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态： 0-离职  1-在职',
  `register_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `update_date` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `dimission_date` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '离职时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `chinesename` (`chinesename`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;


/*Table structure for table `crm_customer_auth` */

DROP TABLE IF EXISTS `crm_customer_auth`;

CREATE TABLE `crm_customer_auth` (
  `id` bigint(20) NOT NULL COMMENT '客户（会员）Id\n            ',
  `identity_type` varchar(20) DEFAULT NULL COMMENT '登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）',
  `identifier` varchar(20) DEFAULT NULL COMMENT '标识（手机号 邮箱 用户名或第三方应用的唯一标识）',
  `credential` varchar(64) DEFAULT NULL COMMENT '密码凭证（站内的保存密码，站外的不保存或保存token）',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_auth` */

/*Table structure for table `crm_customer_base` */

DROP TABLE IF EXISTS `crm_customer_base`;

CREATE TABLE `crm_customer_base` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_no` varchar(60) NOT NULL COMMENT '客户号',
  `cust_name` varchar(30) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `sex` varbinary(2) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `merchant_no` bigint(20) DEFAULT NULL COMMENT '商户号',
  `org_no` char(10) DEFAULT NULL COMMENT '所属机构',
  PRIMARY KEY (`customer_id`,`customer_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_customer_base` */

/*Table structure for table `crm_merchant_base` */

DROP TABLE IF EXISTS `crm_merchant_base`;

CREATE TABLE `crm_merchant_base` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_no` varchar(60) NOT NULL,
  `org_no` bigint(20) DEFAULT NULL COMMENT '所属机构',
  `merchant_name` varbinary(60) DEFAULT NULL COMMENT '商户名称',
  `brief_intro` varbinary(255) DEFAULT NULL COMMENT '商户简介',
  `merchant_address` varchar(255) DEFAULT NULL COMMENT '商户位置',
  `merchant_phone` int(11) DEFAULT NULL,
  `merchant_logo` char(10) DEFAULT NULL COMMENT '商户logo',
  PRIMARY KEY (`merchant_id`,`merchant_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_merchant_base` */