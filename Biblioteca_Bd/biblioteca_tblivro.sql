CREATE DATABASE  IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `biblioteca`;
-- MySQL dump 10.13  Distrib 5.1.40, for Win32 (ia32)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	5.1.53-community

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
-- Table structure for table `tblivro`
--

DROP TABLE IF EXISTS `tblivro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblivro` (
  `id_livro` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) DEFAULT NULL,
  `autor` varchar(45) DEFAULT NULL,
  `edicao` varchar(45) DEFAULT NULL,
  `editora` varchar(45) DEFAULT NULL,
  `ano` varchar(15) DEFAULT NULL,
  `emprestimo` varchar(2) DEFAULT NULL,
  `curso` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_livro`)
) ENGINE=InnoDB AUTO_INCREMENT=2231 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblivro`
--

LOCK TABLES `tblivro` WRITE;
/*!40000 ALTER TABLE `tblivro` DISABLE KEYS */;
INSERT INTO `tblivro` VALUES (2222,'Engenharia','Algum doido','1ª','Abril','2011','0','Sistemas'),(2223,'Algoritmo e Logica de programação','Maluco beleza','3ª','Rural','2010','1','Sistemas'),(2224,'Calculo I','Doido vario','5ª','Rural','2011','1','Sistemas'),(2225,'intitulação','Sergio Pinto Martins','5ª','Atras','2010','1','Direito'),(2226,'Processo','Clber Masson','9ª','Atras','2015','1','Direito'),(2227,'Banco de Dados','Navathe','6ª','Atras','1995','1','Sistemas'),(2228,'Java','Neto antoni','1ª','Atras','2009','1','Sistemas'),(2229,'Inglês Tecnico','Otavio Nunes','5ª','abril','2012','1','Sistemas'),(2230,'Algebra Linear','Deilson','1ª','UFRN','2015','1','Sistemas');
/*!40000 ALTER TABLE `tblivro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-17 11:21:01
