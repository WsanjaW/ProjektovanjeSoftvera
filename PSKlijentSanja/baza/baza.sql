CREATE DATABASE  IF NOT EXISTS `ps_baza` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ps_baza`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: ps_baza
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `biciklista`
--

DROP TABLE IF EXISTS `biciklista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `biciklista` (
  `biciklistaid` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `jmbg` varchar(13) NOT NULL,
  `naziv_bicikla` varchar(45) DEFAULT NULL,
  `tip_bicikla` set('MTB','Road','Hibrid') DEFAULT NULL,
  `mestoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`biciklistaid`),
  KEY `biciklistamesto_fk_idx` (`mestoid`),
  CONSTRAINT `biciklistamesto_fk` FOREIGN KEY (`mestoid`) REFERENCES `mesto` (`mestoid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biciklista`
--

LOCK TABLES `biciklista` WRITE;
/*!40000 ALTER TABLE `biciklista` DISABLE KEYS */;
/*!40000 ALTER TABLE `biciklista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evidencija`
--

DROP TABLE IF EXISTS `evidencija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evidencija` (
  `biciklistaid` int(11) NOT NULL,
  `putovanjeid` int(11) NOT NULL,
  `datumOd` datetime NOT NULL,
  `datumDo` datetime NOT NULL,
  PRIMARY KEY (`biciklistaid`,`putovanjeid`),
  KEY `evidencijaputovanje_idx` (`putovanjeid`),
  CONSTRAINT `evidencijabicikistaid_fk` FOREIGN KEY (`biciklistaid`) REFERENCES `biciklista` (`biciklistaid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evidencijaputovanje` FOREIGN KEY (`putovanjeid`) REFERENCES `putovanje` (`putovanjeid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evidencija`
--

LOCK TABLES `evidencija` WRITE;
/*!40000 ALTER TABLE `evidencija` DISABLE KEYS */;
/*!40000 ALTER TABLE `evidencija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `izvestaj`
--

DROP TABLE IF EXISTS `izvestaj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `izvestaj` (
  `izvestajid` int(11) NOT NULL,
  `datumKreiranja` datetime NOT NULL,
  `komentar` text,
  `biciklistaid` int(11) DEFAULT NULL,
  `kordinatorid` int(11) DEFAULT NULL,
  PRIMARY KEY (`izvestajid`),
  KEY `izvestajbiciklista_id_idx` (`biciklistaid`),
  KEY `izvestajkordinator_id_idx` (`kordinatorid`),
  CONSTRAINT `izvestajbiciklista_id` FOREIGN KEY (`biciklistaid`) REFERENCES `biciklista` (`biciklistaid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `izvestajkordinator_id` FOREIGN KEY (`kordinatorid`) REFERENCES `kordinator` (`kordinatorid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `izvestaj`
--

LOCK TABLES `izvestaj` WRITE;
/*!40000 ALTER TABLE `izvestaj` DISABLE KEYS */;
/*!40000 ALTER TABLE `izvestaj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kordinator`
--

DROP TABLE IF EXISTS `kordinator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kordinator` (
  `kordinatorid` int(11) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`kordinatorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kordinator`
--

LOCK TABLES `kordinator` WRITE;
/*!40000 ALTER TABLE `kordinator` DISABLE KEYS */;
/*!40000 ALTER TABLE `kordinator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesto`
--

DROP TABLE IF EXISTS `mesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesto` (
  `mestoid` int(11) NOT NULL AUTO_INCREMENT,
  `pttBroj` varchar(45) NOT NULL,
  `naziv` varchar(45) NOT NULL,
  PRIMARY KEY (`mestoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesto`
--

LOCK TABLES `mesto` WRITE;
/*!40000 ALTER TABLE `mesto` DISABLE KEYS */;
/*!40000 ALTER TABLE `mesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `putovanje`
--

DROP TABLE IF EXISTS `putovanje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `putovanje` (
  `putovanjeid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(200) NOT NULL,
  `odMesta` int(11) DEFAULT NULL,
  `doMesta` int(11) DEFAULT NULL,
  PRIMARY KEY (`putovanjeid`),
  KEY `putovanjemestood_fk_idx` (`odMesta`),
  KEY `putovanjemestodo_fk_idx` (`doMesta`),
  CONSTRAINT `putovanjemestood_fk` FOREIGN KEY (`odMesta`) REFERENCES `mesto` (`mestoid`) ON UPDATE CASCADE,
  CONSTRAINT `putovanjemestodo_fk` FOREIGN KEY (`doMesta`) REFERENCES `mesto` (`mestoid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `putovanje`
--

LOCK TABLES `putovanje` WRITE;
/*!40000 ALTER TABLE `putovanje` DISABLE KEYS */;
/*!40000 ALTER TABLE `putovanje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track`
--

DROP TABLE IF EXISTS `track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `track` (
  `putovanjeid` int(11) NOT NULL,
  `trackid` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(200) NOT NULL,
  `kilometraza` decimal(2,0) DEFAULT '0',
  `vreme` timestamp NULL DEFAULT NULL,
  `prosecnaBrzina` decimal(2,0) DEFAULT '0',
  PRIMARY KEY (`trackid`,`putovanjeid`),
  KEY `trackputovanjeid_fk_idx` (`putovanjeid`),
  CONSTRAINT `trackputovanjeid_fk` FOREIGN KEY (`putovanjeid`) REFERENCES `putovanje` (`putovanjeid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-24 13:43:38
