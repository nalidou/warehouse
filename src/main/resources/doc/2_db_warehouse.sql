
CREATE DATABASE `db_warehouse`;

USE `db_warehouse`;

/*Table structure for table `t_check` */

DROP TABLE IF EXISTS `t_check`;

CREATE TABLE `t_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cd_encode` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `cd_checkman` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `cd_checkdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

/*Data for the table `t_check` */

insert  into `t_check` values (1,'001','张三','2018-10-25'),(2,'002','张三','2018-10-25');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_checkdetail` */

insert  into `t_checkdetail` values (1,'001',25,20,11,9,'2018-10-10','001,324,1','张林'),(2,'001',26,20,1,19,'2018-10-10','001,324,2','张林'),(3,'002',27,12,12,0,'2018-10-10','001,324,1','张林'),(4,'002',25,20,14,6,'2018-10-10','001,324,2','张林'),(5,'002',28,22,12,10,'2018-10-10','001,324,2','张林'),(6,'002',26,20,11,9,'2018-10-10','001,324,1','张林'),(7,'002',29,32,30,2,'2018-10-10','001,324,1','张林'),(8,'002',30,20,20,20,'2018-10-10','001,324,1','张林');

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
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

/*Data for the table `t_food` */

insert  into `t_food` values (61,'苹果','20/箱','个',30,'43417.0','300.0',20),(62,'梨','21/箱','个',31,'43384.0','300.0',20),(63,'香蕉','22/箱','个',32,'43385.0','300.0',20),(64,'榴莲','23/箱','个',33,'43386.0','300.0',20),(65,'啤酒','24/箱','个',34,'43387.0','300.0',20),(66,'红酒','25/箱','个',35,'43388.0','300.0',20),(67,'白酒','26/箱','个',36,'43389.0','300.0',20),(68,'牛栏山','27/箱','个',37,'43390.0','300.0',20),(69,'五粮液','28/箱','个',38,'43391.0','300.0',20),(70,'苹果','20/箱','个',30,'43417.0','300.0',20),(71,'梨','21/箱','个',31,'43384.0','300.0',20),(72,'香蕉','22/箱','个',32,'43385.0','300.0',20),(73,'榴莲','23/箱','个',33,'43386.0','300.0',20),(74,'啤酒','24/箱','个',34,'43387.0','300.0',20),(75,'红酒','25/箱','个',35,'43388.0','300.0',20),(76,'白酒','26/箱','个',36,'43389.0','300.0',20),(77,'牛栏山','27/箱','个',37,'43390.0','300.0',20),(78,'五粮液','28/箱','个',38,'43391.0','300.0',20);

/*Table structure for table `t_godownentry` */

DROP TABLE IF EXISTS `t_godownentry`;

CREATE TABLE `t_godownentry` (
  `ge_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ge_entryman` varchar(100) DEFAULT NULL,
  `ge_entrydate` date DEFAULT NULL,
  `ge_entry_order_number` varchar(100) DEFAULT NULL,
  `ge_entryencode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ge_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `t_godownentry` */

insert  into `t_godownentry` values (21,'admin','2018-11-13','2018年第001号','null'),(22,'admin','2018-11-13','2018年第002号','null');

/*Table structure for table `t_godownentrydetail` */

DROP TABLE IF EXISTS `t_godownentrydetail`;

CREATE TABLE `t_godownentrydetail` (
  `ged_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ged_encode` varchar(100) DEFAULT NULL,
  `ged_foodid` int(11) DEFAULT NULL,
  `ged_number` int(11) DEFAULT NULL,
  `posencode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ged_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

/*Data for the table `t_godownentrydetail` */

insert  into `t_godownentrydetail` values (58,'2018年第001号',61,20,'1002003.0'),(59,'2018年第001号',62,20,'1002003.0'),(60,'2018年第001号',63,20,'1002003.0'),(61,'2018年第001号',64,20,'1002003.0'),(62,'2018年第001号',65,20,'1002003.0'),(63,'2018年第001号',66,20,'1002003.0'),(64,'2018年第001号',67,20,'1002003.0'),(65,'2018年第001号',68,20,'1002003.0'),(66,'2018年第001号',69,20,'1002003.0'),(67,'2018年第002号',70,20,'1002003.0'),(68,'2018年第002号',71,20,'1002003.0'),(69,'2018年第002号',72,20,'1002003.0'),(70,'2018年第002号',73,20,'1002003.0'),(71,'2018年第002号',74,20,'1002003.0'),(72,'2018年第002号',75,20,'1002003.0'),(73,'2018年第002号',76,20,'1002003.0'),(74,'2018年第002号',77,20,'1002003.0'),(75,'2018年第002号',78,20,'1002003.0');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_godownout` */

insert  into `t_godownout` values (4,'2018年第001号',NULL,'2018-10-25',NULL,'出库','张三',NULL,'20181025001'),(5,'2018年第002号',NULL,'2018-10-25',NULL,'出库','张三',NULL,'20181025002'),(6,'2018年第003号',NULL,'2018-10-25',NULL,'出库','张三',NULL,'20181025003'),(7,'2018年第004号',NULL,'2018-10-25',NULL,'出库','张三',NULL,'20181025004');

/*Table structure for table `t_godownoutdetail` */

DROP TABLE IF EXISTS `t_godownoutdetail`;

CREATE TABLE `t_godownoutdetail` (
  `god_ID` int(11) NOT NULL AUTO_INCREMENT,
  `god_encode` varchar(100) DEFAULT NULL,
  `god_foodid` int(11) DEFAULT NULL,
  `god_outnum` int(11) DEFAULT NULL,
  `posencode` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`god_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `t_godownoutdetail` */

insert  into `t_godownoutdetail` values (2,'20181025001',25,11,'001,324,1'),(3,'20181025001',26,1,'001,324,2'),(4,'20181025002',26,10,'001,324,1'),(5,'20181025002',29,30,'001,324,2'),(6,'20181025003',25,3,'001,324,1'),(7,'20181025003',27,12,'001,324,2'),(8,'20181025003',28,12,'001,324,2'),(9,'20181025004',29,2,'001,324,1'),(10,'20181025004',30,10,'001,324,2');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `r_ID` int(11) NOT NULL AUTO_INCREMENT,
  `r_Name` varchar(100) DEFAULT NULL,
  `r_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role` values (1,'管理员',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user` values (1,'admin','123','13552967920','13552967920@163.com','2018-11-07',1),(2,'库管员01','123','13552967920','13552967921@163.com','2018-11-12',2),(3,'经办人01','123','13552967920','13552967922@163.com','2018-11-12',3),(4,'张三','123','13552967920','110@163.com','2018-11-12',3);

/*Table structure for table `t_warehouse` */

DROP TABLE IF EXISTS `t_warehouse`;

CREATE TABLE `t_warehouse` (
  `w_ID` int(11) NOT NULL AUTO_INCREMENT,
  `w_Name` varchar(100) DEFAULT NULL,
  `w_shelfNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`w_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_warehouse` */

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


CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_food_remainder` AS (
SELECT
  `t_food`.`f_ID`                         AS `fID`,
  `t_food`.`f_name`                       AS `name`,
  `t_food`.`f_standard`                   AS `standard`,
  `t_food`.`f_unit`                       AS `unit`,
  `t_godownentrydetail`.`ged_number`      AS `ennumber`,
  `t_food`.`f_number`                     AS `renumber`,
  `t_godownentrydetail`.`ged_ID`          AS `detailID`,
  `t_food`.`f_price`                      AS `price`,
  `t_food`.`f_producedate`                AS `producedate`,
  `t_food`.`f_guaranteeperiod`            AS `guaranteeperiod`,
  `t_godownentrydetail`.`posencode`       AS `posencode`,
  `t_godownentry`.`ge_ID`                 AS `enID`,
  `t_godownentry`.`ge_entry_order_number` AS `ge_entry_order_number`,
  `t_godownentry`.`ge_entrydate`          AS `entrydate`,
  `t_godownentry`.`ge_entryman`           AS `entryman`
FROM ((`t_food`
    JOIN `t_godownentrydetail`)
   JOIN `t_godownentry`)
WHERE ((`t_food`.`f_ID` = `t_godownentrydetail`.`ged_foodid`)
       AND (`t_godownentry`.`ge_entry_order_number` = `t_godownentrydetail`.`ged_encode`)))$$

DELIMITER ;
