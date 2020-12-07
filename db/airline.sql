-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: airline2
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `country_id` int DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `airport_country_id_fk` (`country_id`),
  KEY `airport_city_id_fk` (`city_id`),
  CONSTRAINT `airport_city_id_fk` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `airport_country_id_fk` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (1,'JFK',1,1),(2,'LAX',1,2),(3,'DTW',1,3),(4,'SYD',2,4),(5,'MSQ',3,5),(6,'YYZ',4,6),(7,'MLE',5,7),(8,'LCY',6,8);
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `country_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `city_country_id_fk` (`country_id`),
  CONSTRAINT `city_country_id_fk` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'New York City',1),(2,'Los Angeles',1),(3,'Detroit',1),(4,'Sydney',2),(5,'Minsk',3),(6,'Toronto',4),(7,'Male',5),(8,'London',6);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'United States of America'),(2,'Australia'),(3,'Belarus'),(4,'Canada'),(5,'Maldives'),(6,'Great Britain');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crew`
--

DROP TABLE IF EXISTS `crew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crew` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew`
--

LOCK TABLES `crew` WRITE;
/*!40000 ALTER TABLE `crew` DISABLE KEYS */;
INSERT INTO `crew` VALUES (11),(12),(13);
/*!40000 ALTER TABLE `crew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crew_member`
--

DROP TABLE IF EXISTS `crew_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crew_member` (
  `crew_id` int NOT NULL,
  `member_id` int NOT NULL,
  KEY `crew_member_crew_id_fk` (`crew_id`),
  KEY `crew_member_member_id_fk` (`member_id`),
  CONSTRAINT `crew_member_crew_id_fk` FOREIGN KEY (`crew_id`) REFERENCES `crew` (`id`),
  CONSTRAINT `crew_member_member_id_fk` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew_member`
--

LOCK TABLES `crew_member` WRITE;
/*!40000 ALTER TABLE `crew_member` DISABLE KEYS */;
INSERT INTO `crew_member` VALUES (11,10),(11,10),(11,13),(11,12),(11,14),(11,14),(11,14),(12,10),(12,11),(12,13),(12,12),(12,14),(12,17),(12,16),(13,10),(13,10),(13,13),(13,12),(13,14),(13,14),(13,14);
/*!40000 ALTER TABLE `crew_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `id` int NOT NULL AUTO_INCREMENT,
  `departure_airport_id` int NOT NULL,
  `arrival_airport_id` int NOT NULL,
  `crew_id` int NOT NULL,
  `date` varchar(32) NOT NULL,
  `seats` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `flight_crew_id_fk` (`crew_id`),
  KEY `flight_airport_id_fk` (`departure_airport_id`),
  KEY `flight_airport_id_fk_2` (`arrival_airport_id`),
  CONSTRAINT `flight_airport_id_fk` FOREIGN KEY (`departure_airport_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `flight_airport_id_fk_2` FOREIGN KEY (`arrival_airport_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `flight_crew_id_fk` FOREIGN KEY (`crew_id`) REFERENCES `crew` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,1,1,11,'2020-12-20T03:27',1),(2,1,5,13,'2020-12-26T03:32',450);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(128) DEFAULT NULL,
  `middle_name` varchar(128) DEFAULT NULL,
  `last_name` varchar(128) DEFAULT NULL,
  `role` enum('admin','supervisor','pilot','navigator','radioman','stewardess','customer') DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `password_hash` char(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'Mikhail','Yurievich','Kavaleuski','admin','admin@airline.io','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918'),(6,'Igor','Pavlovich','Nadenenko','customer','igor@airline.io','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),(9,'Vlad','-','Horbach','admin','horbach@horbach.ru','b27989f8a541631774da5e7c664d22c853f84a1c0fe480e18fcc49fb7600d934'),(10,'pilot1','pilot1','pilot1','pilot','pilot1@horbach.ru','c84c15919aa78185e53a822e589d11f6bd7bb0e18902709af9d0a021e43b89b7'),(11,'pilot2','pilot2','pilot2','pilot','pilot2@horbach.ru','a9be6cd3e9e51c3aaa2d9fc675659f8cc2ea106e2dcf24739b34f6f342cc2939'),(12,'radioman','radioman','radioman','radioman','radioman@horbach.ru','c47f324f69931adc5edd66d44c6807bd7f2fc87656b2af1f278cc5679ac2fd72'),(13,'navigator','navigator','navigator','navigator','navigator@horbach.ru','ebf49dcd836f810084c14e0f2dab4dc1768bbdc5980481bf201fcf76771dff7a'),(14,'stewardess0','stewardess0','stewardess0','stewardess','stewardess0@horbach.ru','9f9faef4e862cf5629b889114115d4619714716c087fcea40a6a660f68b299a1'),(15,'stewardess1','stewardess1','stewardess1','stewardess','stewardess1@horbach.ru','50bb8012da89590575fc3bfd47fd406ee2f8ac595fb61a83be493d796c8dcb15'),(16,'stewardess2','stewardess2','stewardess2','stewardess','stewardess2@horbach.ru','10094eb93798831e36b8aaab6d22d1868db1d0e4401ab30bfec38e7d8bf9693d'),(17,'stewardess3','stewardess3','stewardess3','stewardess','stewardess3@horbach.ru','b7a105d2a88f1fe231f5add5f7d5752d5087662b2558f114463438a369416295'),(18,'stewardess4','stewardess4','stewardess4','stewardess','stewardess4@horbach.ru','984e84ed725c4bfc0daa85f6721a1ff695f2e34d68ba5c0c9d30ba1b73ed6b77'),(19,'radioman55','radioman55','radioman55','radioman','radioman55@horbach.ru','1ba889614adfcfb57ea60d33b9057e8000753dfe58eeb2da68266990dd1e73cf');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `member_id` int DEFAULT NULL,
  `flight_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ticket_flight_id_fk` (`flight_id`),
  KEY `ticket_member_id_fk` (`member_id`),
  CONSTRAINT `ticket_flight_id_fk` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`),
  CONSTRAINT `ticket_member_id_fk` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-07  3:34:19
