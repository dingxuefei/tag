/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.24 : Database - tag
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tag` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tag`;

/*Table structure for table `t_tag` */

DROP TABLE IF EXISTS `t_tag`;

CREATE TABLE `t_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签主键',
  `tag_group_id` int(11) NOT NULL COMMENT '标签组主键',
  `tag_name` varchar(20) NOT NULL COMMENT '标签名称',
  `tab_use_num` int(11) NOT NULL COMMENT '该标签使用次数统计',
  `tag_create_time` datetime NOT NULL COMMENT '标签创建时间',
  `tag_status` int(11) NOT NULL COMMENT '标签类型0-系统标签 1-自定义标签 2-删除标签',
  `tag_create_object` varchar(20) NOT NULL COMMENT '标签由谁创建（如果是系统默认，则值默认为0）',
  `tag_update_time` datetime DEFAULT NULL COMMENT '标签更新时间',
  `tag_update_remark` text COMMENT '标签更新备注',
  PRIMARY KEY (`tag_id`),
  KEY `tag_group_id` (`tag_group_id`),
  KEY `tag_name` (`tag_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_tag` */

/*Table structure for table `t_tag_group` */

DROP TABLE IF EXISTS `t_tag_group`;

CREATE TABLE `t_tag_group` (
  `tag_group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签组主键',
  `tag_group_name` varchar(20) NOT NULL COMMENT '组名称',
  `tag_group_create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `tag_group_remark` text COMMENT '备注',
  PRIMARY KEY (`tag_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_tag_group` */

insert  into `t_tag_group`(`tag_group_id`,`tag_group_name`,`tag_group_create_time`,`tag_group_remark`) values (1,'user_manage','2015-11-19 17:15:00','用户管理分组');

/*Table structure for table `t_tag_object` */

DROP TABLE IF EXISTS `t_tag_object`;

CREATE TABLE `t_tag_object` (
  `tag_object_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID主键',
  `tag_object_code` varchar(20) NOT NULL COMMENT '操作对象的编码可以是某个业务的表明',
  `tag_object_remark` text COMMENT '描述',
  PRIMARY KEY (`tag_object_id`),
  KEY `tag_object_code` (`tag_object_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_tag_object` */

insert  into `t_tag_object`(`tag_object_id`,`tag_object_code`,`tag_object_remark`) values (1,'t_khkf_candidate','用户表');

/*Table structure for table `t_tagmap` */

DROP TABLE IF EXISTS `t_tagmap`;

CREATE TABLE `t_tagmap` (
  `tagmap_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系表主键',
  `tag_id` int(11) NOT NULL COMMENT '标签主键',
  `tag_group_id` int(11) NOT NULL COMMENT '标签组主键',
  `tag_object_id` int(11) NOT NULL COMMENT 'ID主键',
  `tagmap_create_time` datetime NOT NULL COMMENT '创建时间',
  `tagmap_update_time` datetime NOT NULL COMMENT '修改时间',
  `business_id` int(11) NOT NULL COMMENT '具体业务的ID',
  PRIMARY KEY (`tagmap_id`),
  KEY `tag_id` (`tag_id`),
  KEY `tag_group_id` (`tag_group_id`),
  KEY `tag_object_id` (`tag_object_id`),
  KEY `business_id` (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_tagmap` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
