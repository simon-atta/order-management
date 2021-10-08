-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: salesorder
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `customer`
--

use salesorder;

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_adress` varchar(255) DEFAULT NULL,
  `cust_code` int(11) DEFAULT NULL,
  `cust_credit_limit` double DEFAULT NULL,
  `cust_credit_current` double DEFAULT NULL,
  `cust_name` varchar(255) DEFAULT NULL,
  `cust_phone_one` varchar(255) DEFAULT NULL,
  `cust_phone_two` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`),
  UNIQUE KEY `UK_1p0bhmnnjdjlku6oge3tavhv0` (`cust_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_line`
--

DROP TABLE IF EXISTS `order_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_line` (
  `quantity` int(11) DEFAULT NULL,
  `product_prod_id` bigint(20) NOT NULL,
  `sales_order_so_id` bigint(20) NOT NULL,
  PRIMARY KEY (`product_prod_id`,`sales_order_so_id`),
  KEY `FK_95j3r6xnv2h2iw3x9pu0uijwr` (`sales_order_so_id`),
  CONSTRAINT `FK_95j3r6xnv2h2iw3x9pu0uijwr` FOREIGN KEY (`sales_order_so_id`) REFERENCES `sales_order` (`so_id`),
  CONSTRAINT `FK_blyw9ntwypncwmrw4ic4gbi8v` FOREIGN KEY (`product_prod_id`) REFERENCES `product` (`prod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_line`
--

LOCK TABLES `order_line` WRITE;
/*!40000 ALTER TABLE `order_line` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `prod_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prod_code` int(11) DEFAULT NULL,
  `prod_desc` varchar(255) DEFAULT NULL,
  `prod_price` double DEFAULT NULL,
  `prod_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`prod_id`),
  UNIQUE KEY `UK_tquqhk5psnxwn2y1u7erhsylx` (`prod_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_order`
--

DROP TABLE IF EXISTS `sales_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_order` (
  `so_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `so_order_id` varchar(255) DEFAULT NULL,
  `so_total_price` double DEFAULT NULL,
  `customer_cust_id` bigint(20) NOT NULL,
  PRIMARY KEY (`so_id`),
  UNIQUE KEY `UK_7h8wxwca5oxo9lw53wjow0872` (`so_order_id`),
  KEY `FK_7ppsdpki8t7r8d265hbk2x625` (`customer_cust_id`),
  CONSTRAINT `FK_7ppsdpki8t7r8d265hbk2x625` FOREIGN KEY (`customer_cust_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_order`
--

LOCK TABLES `sales_order` WRITE;
/*!40000 ALTER TABLE `sales_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-21  4:24:24
