-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: vivi
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `t_productpackage`
--

LOCK TABLES `t_productpackage` WRITE;
/*!40000 ALTER TABLE `t_productpackage` DISABLE KEYS */;
INSERT INTO `t_productpackage` VALUES ('402882c659779d030159779f01da0003','2017-01-07',NULL,1,'',NULL,NULL,NULL,'2017-01-07','套餐1','TC1',100,NULL),('402882c659779d03015977a0f2d50005','2017-01-07',NULL,1,'套餐2',NULL,NULL,NULL,'2017-01-07','套餐2','TC2',100,NULL),('402882c659779d03015977a36aed0007','2017-01-07',NULL,1,'套餐3',NULL,NULL,NULL,'2017-01-07','套餐3','TC3',120,NULL),('402882c659779d03015977a42a080009','2017-01-07',NULL,1,'套餐4',NULL,NULL,NULL,'2017-01-07','套餐4','TC4',150,'\0'),('402882c659779d03015977a60d0b000b','2017-01-07',NULL,1,'套餐5',NULL,NULL,NULL,'2017-01-07','套餐5','TC5',150,'\0'),('402882c65977a8e3015977b346ed0000','2017-01-07',NULL,0,'发的啊','2017-01-31 00:00:00','2017-01-01 00:00:00','','2017-01-09','TC8','TC8',110,''),('402882c65977a8e3015977b46b120002','2017-01-07',NULL,0,'套餐9999','2017-01-31 00:00:00','2017-01-01 00:00:00','','2017-01-09','套餐9','TC9',120,'');
/*!40000 ALTER TABLE `t_productpackage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-13 10:11:13