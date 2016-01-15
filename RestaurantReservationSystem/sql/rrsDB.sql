-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: rrs_db1
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `emailId` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `phoneNumber` int(10) NOT NULL,
  `token` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Prashant','Ninawe','psninawe@yahoo.com','qwerty123',1234567890,NULL),(2,'Kartik','Shankarappa','hskartik@gmail.com','qwerty1234',1234567891,NULL);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `emailId` varchar(45) DEFAULT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1001,'Praveen','Salitra','psalitra@gmail.com','1234567890'),(1002,'Kashyap','Mukkamala','kashyap@gmail.com','1234567891'),(1003,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567890'),(1004,'Ankur','Choudha','ankur@gmail.com','1234567892'),(1005,'Anup','Aparajit','anup@gmail.com','1234567893'),(1006,'Antariksh','Wankhede','antya@gmail.com','1234567894'),(1007,'Anish','Pujari','anish@gmail.com','1234567895'),(1008,'Aditya','Basu','aditya@gmail.com','1234567896'),(1009,'Avnish','Upadhyay','avanish@gmail.com','1234567896');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `confirmationNumber` int(11) NOT NULL AUTO_INCREMENT,
  `tableNumber` int(11) DEFAULT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `emailId` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `partySize` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(45) NOT NULL,
  `reservationStatus` varchar(45) NOT NULL,
  PRIMARY KEY (`confirmationNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=100022 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (100001,1,'Praveen','Salitra','psalitra@gmail.com','1234567890',3,'2016-01-12','18:00:00','CONFIRMED'),(100002,2,'Kashyap','Mukkamala','kashyap@gmail.com','1234567891',5,'2016-01-12','19:00:00','CONFIRMED'),(100005,1,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567890',3,'2016-01-13','20:00:00','CONFIRMED'),(100007,2,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567890',3,'2016-01-13','20:00:00','CONFIRMED'),(100008,3,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567890',3,'2016-01-13','20:00:00','CONFIRMED'),(100009,5,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567890',3,'2016-01-13','20:00:00','CONFIRMED'),(100010,6,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567890',3,'2016-01-13','20:00:00','CONFIRMED'),(100011,8,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567890',3,'2016-01-13','20:00:00','CONFIRMED'),(100012,4,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567890',3,'2016-01-13','20:00:00','CANCELLED'),(100013,4,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567891',3,'2016-01-13','20:00:00','CONFIRMED'),(100014,7,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567890',2,'2016-01-13','20:00:00','CONFIRMED'),(100015,5,'Nitin','Nasnolkar','nitin.nasnolkar@gmail.com','1234567890',3,'2016-01-13','20:00:00','CANCELLED'),(100016,1,'Ankur','Choudha','ankur@gmail.com','1234567892',2,'2016-01-14','21:00:00','CONFIRMED'),(100017,1,'Anup','Aparajit','anup@gmail.com','1234567893',4,'2016-01-14','20:30:00','CONFIRMED'),(100018,2,'Antariksh','Wankhede','antya@gmail.com','1234567894',5,'2016-01-14','21:30:00','CONFIRMED'),(100019,1,'Anish','Pujari','anish@gmail.com','1234567895',3,'2016-01-15','20:00:00','CONFIRMED'),(100020,1,'Aditya','Basu','aditya@gmail.com','1234567896',3,'2016-01-15','18:30:00','CONFIRMED'),(100021,3,'Avanish','Upadhyay','avanish@gmail.com','1234567896',7,'2016-01-16','20:00:00','CANCELLED');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservationtable`
--

DROP TABLE IF EXISTS `reservationtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservationtable` (
  `tableNumber` int(11) NOT NULL,
  `maxOccupancy` int(11) NOT NULL,
  `availability` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`tableNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservationtable`
--

LOCK TABLES `reservationtable` WRITE;
/*!40000 ALTER TABLE `reservationtable` DISABLE KEYS */;
INSERT INTO `reservationtable` VALUES (1,4,1),(2,6,1),(3,8,1),(4,5,1),(5,8,1),(6,8,1),(7,2,1),(8,4,1);
/*!40000 ALTER TABLE `reservationtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant` (
  `restaurantId` int(11) NOT NULL,
  `restaurantName` varchar(45) NOT NULL,
  `emailId` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `zip` int(11) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `daysOfOperation` varchar(45) NOT NULL,
  `openingTime` varchar(45) NOT NULL,
  `closingTime` varchar(45) NOT NULL,
  PRIMARY KEY (`restaurantId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (1,'Chevys Fresh Mex','chevys@gmail.com','1624 Max Way','Fishkill','New York',12524,'1234567890','Mon Tue Wed Thu Fri Sat Sun','10:00:00','23:00:00');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-14 21:51:49
