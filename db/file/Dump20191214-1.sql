-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: spa
-- ------------------------------------------------------
-- Server version	5.7.28

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
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (1,'dich vu 1',100,''),(2,'dich vu 2',200,NULL),(3,'dich vu 3',150,NULL),(4,'dich vu 4',80,NULL),(5,'dich vu 5',60,NULL);
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dichvu_nguyenlieu`
--

LOCK TABLES `dichvu_nguyenlieu` WRITE;
/*!40000 ALTER TABLE `dichvu_nguyenlieu` DISABLE KEYS */;
/*!40000 ALTER TABLE `dichvu_nguyenlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (17,1,1,0),(18,1,1,0),(19,1,1,0),(20,1,1,0),(21,1,1,0);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hoadon_dichvu_nguyenlieu`
--

LOCK TABLES `hoadon_dichvu_nguyenlieu` WRITE;
/*!40000 ALTER TABLE `hoadon_dichvu_nguyenlieu` DISABLE KEYS */;
INSERT INTO `hoadon_dichvu_nguyenlieu` VALUES (9,10,1,0,1,100,0),(13,14,1,1,1,100,0),(17,16,1,1,1,100,0),(18,18,1,1,1,100,0),(19,18,2,1,1,200,0),(20,18,3,0,1,150,0),(21,18,1,0,3,30,1),(22,18,4,0,4,20,1),(23,19,2,3,2,200,0),(24,19,3,5,3,150,0),(25,19,3,0,2,40,1),(26,19,4,5,1,80,0),(27,20,2,3,1,200,0),(28,21,1,0,10,30,1),(29,21,2,3,1,40,0);
/*!40000 ALTER TABLE `hoadon_dichvu_nguyenlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,1223123,'akh@gmail.com','KH A','Ha noi'),(2,1020102,'bkh@gmail.com','KH B',NULL);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lich`
--

LOCK TABLES `lich` WRITE;
/*!40000 ALTER TABLE `lich` DISABLE KEYS */;
INSERT INTO `lich` VALUES (1,'1223123','2019-12-14 04:19:56.501545',1,2),(2,'1020102','2019-12-14 04:15:12.031814',0,1);
/*!40000 ALTER TABLE `lich` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nguyenlieu`
--

LOCK TABLES `nguyenlieu` WRITE;
/*!40000 ALTER TABLE `nguyenlieu` DISABLE KEYS */;
INSERT INTO `nguyenlieu` VALUES (1,'nguyen lieu 1',10,30,NULL,1),(2,'nguyen lieu 2',30,40,NULL,1),(3,'nguyen lieu 3',40,40,NULL,1),(4,'nguyen lieu 4',40,20,NULL,1),(5,'nguyen lieu 5',50,25,NULL,1);
/*!40000 ALTER TABLE `nguyenlieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES (1,'Nha cung cap 1','Ha ','ncc1@gmail.com');
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Nhan vien 1','1997-02-02 00:00:00',NULL,5000,'12345',1,'nhanviennhankhach'),(2,'Nhan vien 2','1997-09-07 00:00:00','',10000,'12345',1,'nvpv'),(3,'Nhan Vien 3','1997-09-09 00:00:00',NULL,8000,'12345',1,'nvpv'),(4,'Nhan Vien 4','1997-09-09 00:00:00',NULL,8000,'12345',1,'nvpv'),(5,'Nhan Vien 5','1997-09-09 00:00:00',NULL,8000,'12345',0,'nvpv');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nhanvien_dichvu`
--

LOCK TABLES `nhanvien_dichvu` WRITE;
/*!40000 ALTER TABLE `nhanvien_dichvu` DISABLE KEYS */;
INSERT INTO `nhanvien_dichvu` VALUES (1,1,1),(2,1,2),(4,2,2),(5,2,3),(6,2,4),(7,2,5),(8,3,1),(9,3,2),(10,4,3),(11,4,2),(12,5,2),(13,5,4),(14,5,3),(15,5,1);
/*!40000 ALTER TABLE `nhanvien_dichvu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-14 12:09:51
