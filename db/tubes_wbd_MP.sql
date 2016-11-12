-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: localhost    Database: tubes_wbd_MP
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

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
-- Table structure for table `like_data`
--

DROP TABLE IF EXISTS `like_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `like_data` (
  `product_id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_data`
--

LOCK TABLES `like_data` WRITE;
/*!40000 ALTER TABLE `like_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `like_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(15) DEFAULT NULL,
  `product_name` char(30) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `description` char(200) DEFAULT NULL,
  `total_likes` int(11) DEFAULT NULL,
  `total_purchased` int(11) DEFAULT NULL,
  `image_address` char(70) DEFAULT NULL,
  `timestamp` int(11) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'cmrudi','Relax Chair',500000,'Enjoy our relax chair with high quality leather',0,0,'chair.jpg',1475135354,0),(3,'cmrudi','Microcontroller',350000,'Microcontroller with recency technology and has may feature',0,0,'controller.jpg',1475135504,0),(4,'cmrudi','Baby Doll',80000,'Very soft doll and playful, buy one for your kids',0,0,'doll.jpg',1475136169,0),(5,'cmrudi','Drawing Book',15000,'Drawing book A4 size with high quality paper',0,0,'drawingbook.png',1475136226,0),(6,'cmrudi','Wolfram Alpha',450000,'Mathematical application widely use for scientist and engineer',0,0,'wolfram.jpg',1475136270,0),(7,'cmrudi','Gold fish',1000000,'Golf fish from indonesia tenggelam pond in ITB, unlimited edition',0,0,'fish.jpg',1475169552,0),(8,'cmrudi','Handphone',5500000,'Super luxurious handphone with high end feature produced by Labtek V',0,0,'handphone.jpg',1475170525,0),(9,'raihan','Olaf Doll',55000,'Turn frozen movie into reality by buying this olaf doll',0,0,'olaf.jpg',1475171004,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_data`
--

DROP TABLE IF EXISTS `purchase_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_data` (
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `username` char(15) DEFAULT NULL,
  `buyer_name` char(25) DEFAULT NULL,
  `buyer_address` char(50) DEFAULT NULL,
  `postal_code` char(6) DEFAULT NULL,
  `phone_number` char(15) DEFAULT NULL,
  `credit_card` char(12) DEFAULT NULL,
  `verif_card` char(3) DEFAULT NULL,
  `timestamp` int(11) DEFAULT NULL,
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`purchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_data`
--

LOCK TABLES `purchase_data` WRITE;
/*!40000 ALTER TABLE `purchase_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-12 16:39:27
