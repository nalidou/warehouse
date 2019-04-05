/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 10.1.35-MariaDB : Database - db_warehouse
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_warehouse` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_warehouse`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`name`,`class`,`school`,`college`) values (1,'张三01','软工','信息','首经贸'),(2,'张三02','软工','信息','首经贸'),(3,'张三03','软工','信息','首经贸'),(4,'张三04','软工','信息','首经贸'),(5,'李四01','管科','信息','首经贸'),(6,'李四02','管科','信息','首经贸'),(7,'王五01','管科','金融','首经贸'),(8,'王五02','管科','金融','首经贸'),(9,'王五01','信息','金融','首经贸');

/*Table structure for table `t_check` */

DROP TABLE IF EXISTS `t_check`;

CREATE TABLE `t_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cd_encode` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `cd_checkman` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `cd_checkdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

/*Data for the table `t_check` */

insert  into `t_check`(`id`,`cd_encode`,`cd_checkman`,`cd_checkdate`) values (32,'2018年第001号','admin','2018-12-20'),(33,'2018年第002号','admin','2018-12-20'),(34,'2018年第003号','吴兆跃','2018-12-20'),(35,'2018年第004号','吴兆跃','2018-12-20'),(36,'2018年第005号','admin','2018-12-27'),(37,'2018年第006号','admin','2018-12-27'),(38,'2018年第007号','admin','2018-12-27'),(39,'2018年第008号','admin','2018-12-27'),(40,'2018年第009号','admin','2018-12-27'),(41,'2018年第010号','admin','2018-12-27'),(42,'2018年第011号','admin','2018-12-27'),(43,'2018年第012号','admin','2018-12-27');

/*Table structure for table `t_checkdetail` */

DROP TABLE IF EXISTS `t_checkdetail`;

CREATE TABLE `t_checkdetail` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_encode` varchar(100) DEFAULT NULL,
  `c_foodid` int(11) DEFAULT NULL,
  `c_entrynum` int(11) DEFAULT NULL,
  `c_outnum` int(11) DEFAULT NULL,
  `c_rem_number` int(11) DEFAULT NULL,
  `c_entrydate` varchar(100) DEFAULT NULL,
  `c_posencode` varchar(100) DEFAULT NULL,
  `c_entryman` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_checkdetail` */

/*Table structure for table `t_checkdetail2` */

DROP TABLE IF EXISTS `t_checkdetail2`;

CREATE TABLE `t_checkdetail2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ck_num` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `standard` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `ennumber` varchar(255) DEFAULT NULL,
  `outnumber` varchar(255) DEFAULT NULL,
  `renumber` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `producedate` varchar(255) DEFAULT NULL,
  `posencode` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `ckman` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

/*Data for the table `t_checkdetail2` */

insert  into `t_checkdetail2`(`id`,`ck_num`,`name`,`standard`,`unit`,`ennumber`,`outnumber`,`renumber`,`price`,`producedate`,`posencode`,`create_time`,`ckman`) values (161,'2018年第001号','法国干红','22/箱','个','20','0','20','32','2018年10月12号','1号库3货架下','2018-12-20 14:18:34','admin'),(162,'2018年第001号','牛栏山','21/箱','个','20','0','20','31','2018年10月11号','1号库2货架中','2018-12-20 14:18:34','admin'),(163,'2018年第001号','青岛啤酒','20/箱','个','20','0','20','30','2018年11月13号','1号库1货架上','2018-12-20 14:18:34','admin'),(164,'2018年第002号','法国干红','22/箱','个','20','0','20','32','2018年10月12号','1号库3货架下','2018-12-20 14:19:19','admin'),(165,'2018年第002号','牛栏山','21/箱','个','20','1','19','31','2018年10月11号','1号库2货架中','2018-12-20 14:19:19','admin'),(166,'2018年第002号','青岛啤酒','20/箱','个','20','0','20','30','2018年11月13号','1号库1货架上','2018-12-20 14:19:19','admin'),(167,'2018年第003号','法国干红','22/箱','个','60','0','60','32','2018年10月12号','1号库3货架下','2018-12-20 14:57:25','吴兆跃'),(168,'2018年第003号','牛栏山','21/箱','个','60','10','50','31','2018年10月11号','1号库2货架中','2018-12-20 14:57:25','吴兆跃'),(169,'2018年第003号','青岛啤酒','20/箱','个','60','30','30','30','2018年11月13号','1号库1货架上','2018-12-20 14:57:25','吴兆跃'),(170,'2018年第004号','法国干红','22/箱','个','60','0','60','32','2018年10月12号','1号库3货架下','2018-12-20 15:00:19','吴兆跃'),(171,'2018年第004号','牛栏山','21/箱','个','60','10','50','31','2018年10月11号','1号库2货架中','2018-12-20 15:00:19','吴兆跃'),(172,'2018年第004号','青岛啤酒','20/箱','个','60','30','30','30','2018年11月13号','1号库1货架上','2018-12-20 15:00:19','吴兆跃'),(173,'2018年第005号','法国干红','22/箱','个','60','0','60','32','2018年10月12号','1号库3货架下','2018-12-27 13:49:41','admin'),(174,'2018年第005号','牛栏山','21/箱','个','60','10','50','31','2018年10月11号','1号库2货架中','2018-12-27 13:49:41','admin'),(175,'2018年第005号','青岛啤酒','20/箱','个','60','30','30','30','2018年11月13号','1号库1货架上','2018-12-27 13:49:41','admin'),(176,'2018年第006号','法国干红','22/箱','个','60','0','60','32','2018年10月12号','1号库3货架下','2018-12-27 13:54:24','admin'),(177,'2018年第006号','牛栏山','21/箱','个','60','10','50','31','2018年10月11号','1号库2货架中','2018-12-27 13:54:24','admin'),(178,'2018年第006号','青岛啤酒','20/箱','个','60','30','30','30','2018年11月13号','1号库1货架上','2018-12-27 13:54:24','admin'),(179,'2018年第007号','法国干红','22/箱','个','60','0','60','32','2018年10月12号','1号库3货架下','2018-12-27 13:54:29','admin'),(180,'2018年第007号','牛栏山','21/箱','个','60','10','50','31','2018年10月11号','1号库2货架中','2018-12-27 13:54:29','admin'),(181,'2018年第007号','青岛啤酒','20/箱','个','60','30','30','30','2018年11月13号','1号库1货架上','2018-12-27 13:54:29','admin'),(182,'2018年第008号','农夫山泉','500','ML','30','0','30','10','2018.09.09','1号库1号架中','2018-12-27 14:26:03','admin'),(183,'2018年第008号','法国干红','22/箱','个','100','0','100','32','2018年10月12号','1号库3货架下','2018-12-27 14:26:03','admin'),(184,'2018年第008号','牛栏山','21/箱','个','100','10','90','31','2018年10月11号','1号库2货架中','2018-12-27 14:26:03','admin'),(185,'2018年第008号','青岛啤酒','20/箱','个','120','30','90','30','2018年11月13号','1号库1货架上','2018-12-27 14:26:03','admin'),(186,'2018年第009号','农夫山泉','500','ML','30','0','30','10','2018.09.09','1号库1号架中','2018-12-27 14:26:07','admin'),(187,'2018年第009号','法国干红','22/箱','个','100','0','100','32','2018年10月12号','1号库3货架下','2018-12-27 14:26:07','admin'),(188,'2018年第009号','牛栏山','21/箱','个','100','10','90','31','2018年10月11号','1号库2货架中','2018-12-27 14:26:07','admin'),(189,'2018年第009号','青岛啤酒','20/箱','个','120','30','90','30','2018年11月13号','1号库1货架上','2018-12-27 14:26:07','admin'),(190,'2018年第010号','农夫山泉','500','ML','30','0','30','10','2018.09.09','1号库1号架中','2018-12-27 14:26:13','admin'),(191,'2018年第010号','法国干红','22/箱','个','100','0','100','32','2018年10月12号','1号库3货架下','2018-12-27 14:26:13','admin'),(192,'2018年第010号','牛栏山','21/箱','个','100','10','90','31','2018年10月11号','1号库2货架中','2018-12-27 14:26:13','admin'),(193,'2018年第010号','青岛啤酒','20/箱','个','120','30','90','30','2018年11月13号','1号库1货架上','2018-12-27 14:26:13','admin'),(194,'2018年第011号','农夫山泉','500','ML','30','0','30','10','2018.09.09','1号库1号架中','2018-12-27 14:26:19','admin'),(195,'2018年第011号','法国干红','22/箱','个','100','0','100','32','2018年10月12号','1号库3货架下','2018-12-27 14:26:19','admin'),(196,'2018年第011号','牛栏山','21/箱','个','100','10','90','31','2018年10月11号','1号库2货架中','2018-12-27 14:26:19','admin'),(197,'2018年第011号','青岛啤酒','20/箱','个','120','30','90','30','2018年11月13号','1号库1货架上','2018-12-27 14:26:19','admin'),(198,'2018年第012号','农夫山泉','500','ML','30','0','30','10','2018.09.09','1号库1号架中','2018-12-27 15:14:07','admin'),(199,'2018年第012号','旺仔小馒头','20','克','24','0','24','12','2018.12.12','1号库1号架上','2018-12-27 15:14:07','admin'),(200,'2018年第012号','法国干红','22/箱','个','201','61','140','32','2018年10月12号','1号库3货架下','2018-12-27 15:14:07','admin'),(201,'2018年第012号','牛栏山','21/箱','个','200','15','185','31','2018年10月11号','1号库2货架中','2018-12-27 15:14:07','admin'),(202,'2018年第012号','见客户','123','123','123','0','123','123','123','123','2018-12-27 15:14:07','admin'),(203,'2018年第012号','青岛啤酒','20/箱','个','230','130','100','30','2018年11月13号','1号库1货架上','2018-12-27 15:14:07','admin');

/*Table structure for table `t_chuku` */

DROP TABLE IF EXISTS `t_chuku`;

CREATE TABLE `t_chuku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `out_num` varchar(100) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `agent` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_chuku` */

insert  into `t_chuku`(`id`,`out_num`,`createdate`,`agent`) values (21,'2018年第001号','2018-12-20','admin'),(22,'2018年第002号','2018-12-20','吴兆跃'),(23,'2018年第003号','2018-12-27','admin'),(24,'2018年第004号','2018-12-27','admin'),(25,'2018年第005号','2018-12-27','admin');

/*Table structure for table `t_chukudetail` */

DROP TABLE IF EXISTS `t_chukudetail`;

CREATE TABLE `t_chukudetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `out_num` varchar(100) DEFAULT NULL,
  `food_id` varchar(255) DEFAULT NULL,
  `food_name` varchar(255) DEFAULT NULL,
  `food_standard` varchar(255) DEFAULT NULL,
  `food_unit` varchar(255) DEFAULT NULL,
  `food_num` int(11) DEFAULT NULL,
  `food_price` varchar(255) DEFAULT NULL,
  `food_total` varchar(255) DEFAULT NULL,
  `food_time` varchar(255) DEFAULT NULL,
  `food_poscode` varchar(255) DEFAULT NULL,
  `outman` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

/*Data for the table `t_chukudetail` */

insert  into `t_chukudetail`(`id`,`out_num`,`food_id`,`food_name`,`food_standard`,`food_unit`,`food_num`,`food_price`,`food_total`,`food_time`,`food_poscode`,`outman`) values (52,'2018年第001号','130','牛栏山','21/箱','个',1,'31.0','31.0','2018-12-20 14:19:06','1号库2货架中','admin'),(53,'2018年第002号','136','牛栏山','21/箱','个',9,'31.0','279.0','2018-12-20 14:55:09','1号库2货架中','吴兆跃'),(54,'2018年第002号','135','青岛啤酒','20/箱','个',20,'30.0','600.0','2018-12-20 14:55:09','1号库1货架上','吴兆跃'),(55,'2018年第002号','132','青岛啤酒','20/箱','个',10,'30.0','300.0','2018-12-20 14:55:09','1号库1货架上','吴兆跃'),(56,'2018年第002号','129','青岛啤酒','20/箱','个',0,'30.0','0.0','2018-12-20 14:55:09','1号库1货架上','吴兆跃'),(57,'2018年第003号','143','牛栏山','21/箱','个',2,'31.0','62.0','2018-12-27 14:44:08','1号库2货架中','admin'),(58,'2018年第003号','154','法国干红','22/箱','个',1,'32.0','32.0','2018-12-27 14:44:08','1号库3货架下','admin'),(59,'2018年第004号','141','青岛啤酒','20/箱','个',2,'30.0','60.0','2018-12-27 14:54:19','1号库1货架上','admin'),(60,'2018年第004号','153','牛栏山','21/箱','个',3,'31.0','93.0','2018-12-27 14:54:19','1号库2货架中','admin'),(61,'2018年第005号','164','青岛啤酒','20/箱','项',10,'12.0','120.0','2018-12-27 15:07:13','一号','admin'),(62,'2018年第005号','141','青岛啤酒','20/箱','个',18,'30.0','540.0','2018-12-27 15:07:13','1号库1货架上','admin'),(63,'2018年第005号','148','青岛啤酒','20/箱','个',20,'30.0','600.0','2018-12-27 15:07:13','1号库1货架上','admin'),(64,'2018年第005号','155','青岛啤酒','20/箱','个',20,'30.0','600.0','2018-12-27 15:07:13','1号库1货架上','admin'),(65,'2018年第005号','132','青岛啤酒','20/箱','个',10,'30.0','300.0','2018-12-27 15:07:13','1号库1货架上','admin'),(66,'2018年第005号','161','青岛啤酒','20/箱','个',20,'30.0','600.0','2018-12-27 15:07:13','1号库1货架上','admin'),(67,'2018年第005号','165','法国干红','22/箱','项',1,'12.0','12.0','2018-12-27 15:07:13','二号','admin'),(68,'2018年第005号','154','法国干红','22/箱','个',19,'32.0','608.0','2018-12-27 15:07:13','1号库3货架下','admin'),(69,'2018年第005号','160','法国干红','22/箱','个',20,'32.0','640.0','2018-12-27 15:07:13','1号库3货架下','admin'),(70,'2018年第005号','134','法国干红','22/箱','个',20,'32.0','640.0','2018-12-27 15:07:13','1号库3货架下','admin');

/*Table structure for table `t_food` */

DROP TABLE IF EXISTS `t_food`;

CREATE TABLE `t_food` (
  `f_ID` int(11) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(100) DEFAULT NULL,
  `f_standard` varchar(100) DEFAULT NULL,
  `f_unit` varchar(100) DEFAULT NULL,
  `f_price` float DEFAULT NULL,
  `f_producedate` varchar(100) DEFAULT NULL,
  `f_guaranteeperiod` varchar(100) DEFAULT NULL,
  `f_number` int(11) unsigned DEFAULT '0',
  PRIMARY KEY (`f_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8;

/*Data for the table `t_food` */

insert  into `t_food`(`f_ID`,`f_name`,`f_standard`,`f_unit`,`f_price`,`f_producedate`,`f_guaranteeperiod`,`f_number`) values (129,'青岛啤酒','20/箱','个',30,'2018年11月13号','300.0',20),(130,'牛栏山','21/箱','个',31,'2018年10月11号','300.0',19),(131,'法国干红','22/箱','个',32,'2018年10月12号','300.0',20),(132,'青岛啤酒','20/箱','个',30,'2018年11月13号','300.0',0),(133,'牛栏山','21/箱','个',31,'2018年10月11号','300.0',20),(134,'法国干红','22/箱','个',32,'2018年10月12号','300.0',0),(135,'青岛啤酒','20/箱','个',30,'2018年11月13号','300.0',0),(136,'牛栏山','21/箱','个',31,'2018年10月11号','300.0',11),(137,'法国干红','22/箱','个',32,'2018年10月12号','300.0',20),(138,'青岛啤酒','20/箱','个',30,'2018年11月13号','300.0',20),(139,'牛栏山','21/箱','个',31,'2018年10月11号','300.0',20),(140,'法国干红','22/箱','个',32,'2018年10月12号','300.0',20),(141,'青岛啤酒','20/箱','个',30,'2018-11-13','300',0),(142,'青岛啤酒','20/箱','个',30,'2018年11月13号','300.0',20),(143,'牛栏山','21/箱','个',31,'2018年10月11号','300.0',18),(144,'法国干红','22/箱','个',32,'2018年10月12号','300.0',20),(145,'农夫山泉','500','ML',10,'2018.09.09','30天',30),(146,'旺仔小馒头','20','克',12,'2018.12.12','20天',12),(147,'旺仔小馒头','20','克',12,'2018.12.12','20天',12),(148,'青岛啤酒','20/箱','个',30,'2018年11月13号','300.0',0),(149,'牛栏山','21/箱','个',31,'2018年10月11号','300.0',20),(150,'法国干红','22/箱','个',32,'2018年10月12号','300.0',20),(151,'见客户','123','123',123,'123','123',123),(152,'青岛啤酒','20/箱','个',30,'2018年11月13号','300.0',20),(153,'牛栏山','21/箱','个',31,'2018年10月11号','300.0',17),(154,'法国干红','22/箱','个',32,'2018年10月12号','300.0',0),(155,'青岛啤酒','20/箱','个',30,'2018年11月13号','300.0',0),(156,'牛栏山','21/箱','个',31,'2018年10月11号','300.0',20),(157,'法国干红','22/箱','个',32,'2018年10月12号','300.0',20),(158,'青岛啤酒','20/箱','个',30,'2018年11月13号','300.0',20),(159,'牛栏山','21/箱','个',31,'2018年10月11号','300.0',20),(160,'法国干红','22/箱','个',32,'2018年10月12号','300.0',0),(161,'青岛啤酒','20/箱','个',30,'2018年11月13号','300.0',0),(162,'牛栏山','21/箱','个',31,'2018年10月11号','300.0',20),(163,'法国干红','22/箱','个',32,'2018年10月12号','300.0',20),(164,'青岛啤酒','20/箱','项',12,'2018-01-22','32',0),(165,'法国干红','22/箱','项',12,'2018-01-22','34',0);

/*Table structure for table `t_godownentry` */

DROP TABLE IF EXISTS `t_godownentry`;

CREATE TABLE `t_godownentry` (
  `ge_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ge_entryman` varchar(100) DEFAULT NULL,
  `ge_entrydate` date DEFAULT NULL,
  `ge_entry_order_number` varchar(100) DEFAULT NULL,
  `ge_entryencode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ge_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `t_godownentry` */

insert  into `t_godownentry`(`ge_ID`,`ge_entryman`,`ge_entrydate`,`ge_entry_order_number`,`ge_entryencode`) values (32,'admin','2018-12-20','2018年第001号','null'),(33,'吴兆跃','2018-12-20','2018年第002号','null'),(34,'吴兆跃','2018-12-20','2018年第003号','null'),(35,'admin','2018-12-27','2018年第004号','null'),(36,'admin','2018-12-27','2018年第005号','null'),(37,'admin','2018-12-27','2018年第006号','null'),(38,'admin','2018-12-27','2018年第007号','null'),(39,'哈哈哈','2018-12-27','2018年第008号','null'),(40,'哈哈哈','2018-12-27','2018年第009号','null'),(41,'哈哈哈','2018-12-27','2018年第010号','null'),(42,'admin','2018-12-27','2018年第011号','null'),(43,'admin','2018-12-27','2018年第012号','null'),(44,'admin','2018-12-27','2018年第013号','null'),(45,'admin','2018-12-27','2018年第014号','null'),(46,'admin','2018-12-27','2018年第015号','null'),(47,'admin','2018-12-27','2018年第016号','null');

/*Table structure for table `t_godownentrydetail` */

DROP TABLE IF EXISTS `t_godownentrydetail`;

CREATE TABLE `t_godownentrydetail` (
  `ged_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ged_encode` varchar(100) DEFAULT NULL,
  `ged_foodid` int(11) DEFAULT NULL,
  `ged_number` int(11) DEFAULT NULL,
  `posencode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ged_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8;

/*Data for the table `t_godownentrydetail` */

insert  into `t_godownentrydetail`(`ged_ID`,`ged_encode`,`ged_foodid`,`ged_number`,`posencode`) values (126,'2018年第001号',129,20,'1号库1货架上'),(127,'2018年第001号',130,20,'1号库2货架中'),(128,'2018年第001号',131,20,'1号库3货架下'),(129,'2018年第002号',132,20,'1号库1货架上'),(130,'2018年第002号',133,20,'1号库2货架中'),(131,'2018年第002号',134,20,'1号库3货架下'),(132,'2018年第003号',135,20,'1号库1货架上'),(133,'2018年第003号',136,20,'1号库2货架中'),(134,'2018年第003号',137,20,'1号库3货架下'),(135,'2018年第004号',138,20,'1号库1货架上'),(136,'2018年第004号',139,20,'1号库2货架中'),(137,'2018年第004号',140,20,'1号库3货架下'),(138,'2018年第005号',141,20,'1号库1货架上'),(139,'2018年第006号',142,20,'1号库1货架上'),(140,'2018年第006号',143,20,'1号库2货架中'),(141,'2018年第006号',144,20,'1号库3货架下'),(142,'2018年第007号',145,30,'1号库1号架中'),(143,'2018年第008号',146,12,'1号库1号架上'),(144,'2018年第009号',147,12,'1号库1号架上'),(145,'2018年第010号',148,20,'1号库1货架上'),(146,'2018年第010号',149,20,'1号库2货架中'),(147,'2018年第010号',150,20,'1号库3货架下'),(148,'2018年第011号',151,123,'123'),(149,'2018年第012号',152,20,'1号库1货架上'),(150,'2018年第012号',153,20,'1号库2货架中'),(151,'2018年第012号',154,20,'1号库3货架下'),(152,'2018年第013号',155,20,'1号库1货架上'),(153,'2018年第013号',156,20,'1号库2货架中'),(154,'2018年第013号',157,20,'1号库3货架下'),(155,'2018年第014号',158,20,'1号库1货架上'),(156,'2018年第014号',159,20,'1号库2货架中'),(157,'2018年第014号',160,20,'1号库3货架下'),(158,'2018年第015号',161,20,'1号库1货架上'),(159,'2018年第015号',162,20,'1号库2货架中'),(160,'2018年第015号',163,20,'1号库3货架下'),(161,'2018年第016号',164,10,'一号'),(162,'2018年第016号',165,1,'二号');

/*Table structure for table `t_godownout` */

DROP TABLE IF EXISTS `t_godownout`;

CREATE TABLE `t_godownout` (
  `go_id` int(11) NOT NULL AUTO_INCREMENT,
  `go_outorder_number` varchar(100) DEFAULT NULL,
  `go_preorder_number` varchar(100) DEFAULT NULL,
  `go_createdate` date DEFAULT NULL,
  `go_outdate` date DEFAULT NULL,
  `go_state` varchar(100) DEFAULT NULL,
  `go_agent` varchar(100) DEFAULT NULL,
  `go_storeman` varchar(100) DEFAULT NULL,
  `go_outencode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`go_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_godownout` */

/*Table structure for table `t_godownoutdetail` */

DROP TABLE IF EXISTS `t_godownoutdetail`;

CREATE TABLE `t_godownoutdetail` (
  `god_ID` int(11) NOT NULL AUTO_INCREMENT,
  `god_encode` varchar(100) DEFAULT NULL,
  `god_foodid` int(11) DEFAULT NULL,
  `god_outnum` int(11) DEFAULT NULL,
  `posencode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`god_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_godownoutdetail` */

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `r_ID` int(11) NOT NULL AUTO_INCREMENT,
  `r_Name` varchar(100) DEFAULT NULL,
  `r_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`r_ID`,`r_Name`,`r_level`) values (1,'管理员',1);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `u_ID` int(11) NOT NULL AUTO_INCREMENT,
  `u_Name` varchar(100) DEFAULT NULL,
  `u_password` varchar(100) DEFAULT NULL,
  `u_tlNumber` varchar(100) DEFAULT NULL,
  `u_mail` varchar(100) DEFAULT NULL,
  `u_createTime` date DEFAULT NULL,
  `u_roleID` int(11) DEFAULT NULL,
  PRIMARY KEY (`u_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`u_ID`,`u_Name`,`u_password`,`u_tlNumber`,`u_mail`,`u_createTime`,`u_roleID`) values (1,'admin','123','13552967920','13552967920@163.com','2018-11-07',1),(2,'库管员01','123','13552967920','13552967921@163.com','2018-11-12',2),(3,'经办人01','123','13552967920','13552967922@163.com','2018-11-12',3),(4,'张三','123','13552967920','110@163.com','2018-11-12',2),(5,'吴兆跃','123','234141515552','123@163.com','2018-12-20',2),(6,'jingbanren','123','131244114','456@163.com','2018-12-20',3),(7,'哈哈哈','110','110','110@qq.com','2018-12-27',2),(8,'ji','jjj','888888','jfj@cueb.edu.cn','2018-12-27',2),(9,'经办人测试版','111','111','111@qq.com','2018-12-27',3);

/*Table structure for table `t_warehouse` */

DROP TABLE IF EXISTS `t_warehouse`;

CREATE TABLE `t_warehouse` (
  `w_ID` int(11) NOT NULL AUTO_INCREMENT,
  `w_Name` varchar(100) DEFAULT NULL,
  `w_shelfNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`w_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_warehouse` */

/*Table structure for table `t_yuxuan` */

DROP TABLE IF EXISTS `t_yuxuan`;

CREATE TABLE `t_yuxuan` (
  `yx_id` int(11) NOT NULL AUTO_INCREMENT,
  `yx_preorder_number` varchar(100) DEFAULT NULL,
  `yx_createdate` date DEFAULT NULL,
  `yx_agent` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`yx_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `t_yuxuan` */

insert  into `t_yuxuan`(`yx_id`,`yx_preorder_number`,`yx_createdate`,`yx_agent`,`state`) values (27,'20181010001','2018-12-20','admin',1),(28,'20181010002','2018-12-20','jingbanren',1),(30,'20181010003','2018-12-27','admin',1),(36,'20181010004','2018-12-27','admin',1),(37,'20181010005','2018-12-27','admin',0),(38,'20181010006','2018-12-27','经办人测试版',0),(39,'20181010007','2018-12-27','经办人测试版',0),(40,'20181010008','2018-12-27','admin',0),(41,'20181010009','2018-12-27','admin',0),(42,'20181010010','2018-12-27','admin',1);

/*Table structure for table `t_yuxuandetail` */

DROP TABLE IF EXISTS `t_yuxuandetail`;

CREATE TABLE `t_yuxuandetail` (
  `yxd_id` int(11) NOT NULL AUTO_INCREMENT,
  `yxd_preorder_number` varchar(100) DEFAULT NULL,
  `yxd_foodname` varchar(255) DEFAULT NULL,
  `yxd_foodstandard` varchar(255) DEFAULT NULL,
  `yxd_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`yxd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

/*Data for the table `t_yuxuandetail` */

insert  into `t_yuxuandetail`(`yxd_id`,`yxd_preorder_number`,`yxd_foodname`,`yxd_foodstandard`,`yxd_num`) values (44,'20181010001','牛栏山','21/箱',1),(45,'20181010002','牛栏山','21/箱',9),(46,'20181010002','青岛啤酒','20/箱',30),(47,'20181010003','牛栏山','21/箱',2),(48,'20181010003','法国干红','22/箱',1),(53,'20181010004','青岛啤酒','20/箱',2),(54,'20181010004','牛栏山','21/箱',3),(55,'20181010005','青岛啤酒','20/箱',100),(56,'20181010006','青岛啤酒','20/箱',1),(57,'20181010006','农夫山泉','500',2),(58,'20181010007','青岛啤酒','20/箱',2),(59,'20181010007','农夫山泉','500',3),(60,'20181010008','青岛啤酒','20/箱',30),(61,'20181010008','法国干红','22/箱',39),(62,'20181010009','青岛啤酒','20/箱',5000),(63,'20181010010','青岛啤酒','20/箱',98),(64,'20181010010','法国干红','22/箱',100);

/* Procedure structure for procedure `pro_entry` */

/*!50003 DROP PROCEDURE IF EXISTS  `pro_entry` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_entry`(IN fname VARCHAR(255),IN fstandard VARCHAR(255),IN funit VARCHAR(255),IN fprice VARCHAR(255),
	IN fproducedate VARCHAR(255),IN fguaranteeperiod VARCHAR(255),IN fnumber INT,IN posencode VARCHAR(255),IN entryman VARCHAR(255),
	IN entry_order_num VARCHAR(255),IN gedencode VARCHAR(255),IN finish INT,OUT result INT)
BEGIN
	DECLARE insert_count INT DEFAULT 0;  		
		DECLARE foodid INT;
		DECLARE entryid INT;
		
		START TRANSACTION;
		INSERT INTO t_food(f_name,f_standard,f_unit,f_price,f_producedate,f_guaranteeperiod,f_number) 
		VALUE(fname,fstandard,funit,fprice,fproducedate,fguaranteeperiod,fnumber);
		
		SELECT ROW_COUNT() INTO insert_count;
		SELECT insert_count;
		IF (insert_count > 0) THEN 
			SELECT MAX(LAST_INSERT_ID())FROM t_food INTO foodid ;
			
			INSERT INTO t_godownentrydetail(ged_encode,ged_foodid,ged_number,posencode) VALUES(entry_order_num,foodid,fnumber,posencode);
			SELECT ROW_COUNT() INTO insert_count;
			-- SELECT insert_count;
			IF (insert_count > 0) THEN 
				IF(finish > 0) THEN
					INSERT INTO t_godownentry(ge_entryman,ge_entrydate,ge_entry_order_number,ge_entryencode) VALUE(entryman,NOW(),entry_order_num,gedencode);
					SELECT ROW_COUNT() INTO insert_count;
					IF(insert_count<0)THEN
						ROLLBACK;
					END IF;
				END IF;		
				COMMIT;
				SET result = 1;	
			ELSE 
				ROLLBACK;
			END IF;	
		ELSE 
			ROLLBACK;
		END IF;	
		
	
	END */$$
DELIMITER ;

/*Table structure for table `view_food_remainder` */

DROP TABLE IF EXISTS `view_food_remainder`;

/*!50001 DROP VIEW IF EXISTS `view_food_remainder` */;
/*!50001 DROP TABLE IF EXISTS `view_food_remainder` */;

/*!50001 CREATE TABLE  `view_food_remainder`(
 `fID` int(11) ,
 `name` varchar(100) ,
 `standard` varchar(100) ,
 `unit` varchar(100) ,
 `ennumber` int(11) ,
 `renumber` int(11) unsigned ,
 `detailID` int(11) ,
 `price` float ,
 `producedate` varchar(100) ,
 `guaranteeperiod` varchar(100) ,
 `posencode` varchar(100) ,
 `enID` int(11) ,
 `ge_entry_order_number` varchar(100) ,
 `entrydate` date ,
 `entryman` varchar(100) 
)*/;

/*View structure for view view_food_remainder */

/*!50001 DROP TABLE IF EXISTS `view_food_remainder` */;
/*!50001 DROP VIEW IF EXISTS `view_food_remainder` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_food_remainder` AS (select `t_food`.`f_ID` AS `fID`,`t_food`.`f_name` AS `name`,`t_food`.`f_standard` AS `standard`,`t_food`.`f_unit` AS `unit`,`t_godownentrydetail`.`ged_number` AS `ennumber`,`t_food`.`f_number` AS `renumber`,`t_godownentrydetail`.`ged_ID` AS `detailID`,`t_food`.`f_price` AS `price`,`t_food`.`f_producedate` AS `producedate`,`t_food`.`f_guaranteeperiod` AS `guaranteeperiod`,`t_godownentrydetail`.`posencode` AS `posencode`,`t_godownentry`.`ge_ID` AS `enID`,`t_godownentry`.`ge_entry_order_number` AS `ge_entry_order_number`,`t_godownentry`.`ge_entrydate` AS `entrydate`,`t_godownentry`.`ge_entryman` AS `entryman` from ((`t_food` join `t_godownentrydetail`) join `t_godownentry`) where ((`t_food`.`f_ID` = `t_godownentrydetail`.`ged_foodid`) and (`t_godownentry`.`ge_entry_order_number` = `t_godownentrydetail`.`ged_encode`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
