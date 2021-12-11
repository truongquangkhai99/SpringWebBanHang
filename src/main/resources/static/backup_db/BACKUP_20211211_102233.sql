-- MySQL dump 10.16  Distrib 10.1.31-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: Spring_Web_Ban_Hang
-- ------------------------------------------------------
-- Server version	10.1.31-MariaDB

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
-- Current Database: `Spring_Web_Ban_Hang`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `spring_web_ban_hang` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `Spring_Web_Ban_Hang`;

--
-- Table structure for table `tbl_menu_dong`
--

DROP TABLE IF EXISTS `tbl_menu_dong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_menu_dong` (
  `menu_dong_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_link` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `is_visible` int(11) DEFAULT '1',
  `is_parent` tinyint(1) unsigned NOT NULL,
  `menu_order` tinyint(1) unsigned NOT NULL,
  `parent_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`menu_dong_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_menu_dong`
--

LOCK TABLES `tbl_menu_dong` WRITE;
/*!40000 ALTER TABLE `tbl_menu_dong` DISABLE KEYS */;
INSERT INTO `tbl_menu_dong` VALUES (1,'Xe đẹp 2021','Ô Tô Kia','ô-tô-kia','#0000ff',1,0,0,0),(4,'Xe đẹp 2021','Mecerdes','mecerdes','#00ff00',1,0,0,0),(6,'Xe đẹp 2021','Vinfast','Vinfast','#00ff00',1,0,0,0),(13,'','Toyota','toyota','#00ff00',1,0,0,0),(31,'','Ô Tô Huyndai','ô-tô-huyndai','#000000',1,0,0,0);
/*!40000 ALTER TABLE `tbl_menu_dong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_product`
--

DROP TABLE IF EXISTS `tbl_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `menu_dong_id` int(11) DEFAULT '0',
  `image_name` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `is_visible` int(11) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `sale_percent` varchar(255) DEFAULT NULL,
  `sale_price` varchar(255) DEFAULT NULL,
  `gia_con_lai` varchar(255) DEFAULT NULL,
  `favourite` tinyint(1) unsigned NOT NULL,
  `sale` tinyint(1) unsigned NOT NULL,
  `quantity` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_product`
--

LOCK TABLES `tbl_product` WRITE;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` VALUES (1,'Xe đẹp 2021',6,'vinfast-lux-sa-2_0-ra-mat-tai-viet-nam.jpg','Ô tô Vinfast',1,'350.000.000','10','35.000.000','315.000.000',0,0,0),(5,'Xe đẹp 2021',4,'mercedes-s500-2021-autodaily-46.jpg','Mercedes',1,'1.700.000.000','20','340.000.000','1.360.000.000',0,0,0),(6,'Xe đẹp 2021',1,'gia-xe-toyota-camry-20g-2021-muaxebanxe-com-30.jpg','Toyota camry',1,'1.029.000.000','',NULL,'1.029.000.000',1,1,0),(10,'Xe đẹp 2021',1,'640-kia-morning-2021-ra-mat-tai-viet-nam.jfif','Kia Morning',1,'329.000.000','10','32.900.000','296.100.000',0,1,0),(11,'Xe đẹp 2021',13,'toyota-vios.jpg','Toyota Vios',1,'478.000.000','','478.000.000','478.000.000',0,0,0),(33,'Xe đẹp 2021',1,'honda-brio.jpg','Honda Brio',0,'420.000.000','10','42,000,000','378,000,000',0,0,0),(36,'Xe đẹp 2021',1,'640-kia-morning-2021-ra-mat-tai-viet-nam.jfif','Kia Đỏ',1,'50.000.000','20','10,000,000','40,000,000',1,0,0),(39,'',1,'','tttt',1,'15','10','1','14',0,1,0);
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'nguyenvantuyen6789','123456','Phú Đô','nguyenvantuyen6789@gmail.com','Tuyên Nguyễn','Nam','Admin'),(2,'nguyenvantuyen67891','123456','Phú Đô','nguyenvantuyen67891@gmail.com','Tuyên Nguyễn 3','Nam','User'),(11,'nguyenvantuyen67892','123456','','nguyenvantuyen67892@gmail.com','Tuyên Nguyễn','Nam','Admin'),(12,'nguyenvantuyen67893','123456','','nguyenvantuyen67893@gmail.com','Tuyên Nguyễn','Nam','Admin');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-11 10:22:33
