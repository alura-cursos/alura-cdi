
DROP TABLE IF EXISTS `Autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Autor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autor`
--

LOCK TABLES `Autor` WRITE;
/*!40000 ALTER TABLE `Autor` DISABLE KEYS */;
INSERT INTO `Autor` VALUES (1,'sergio.lopes@caelum.com.br','Sergio Lopes'),(2,'nico.steppat@caelum.com.br','Nico Steppat'),(3,'aniche@teste.com.br','Mauricio Aniche'),(4,'flavio.almeida@caelum.com.br','Flavio Almeida'),(5,'paulo.silveira@caelum.com.br','Paulo Silveira');
/*!40000 ALTER TABLE `Autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Livro`
--

DROP TABLE IF EXISTS `Livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Livro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataLancamento` date DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `preco` double NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Livro`
--

LOCK TABLES `Livro` WRITE;
/*!40000 ALTER TABLE `Livro` DISABLE KEYS */;
INSERT INTO `Livro` VALUES (1,'2016-02-26','121-3-12-312312-3',49.9,'MEAN'),(2,'2016-02-27','123-1-31-212313-1',49.9,'Arquitetura Java'),(3,'2016-03-01','123-1-31-231312-3',39.9,'AngularJS'),(5,'2016-03-01','124-5-55-533223-2',39.9,'TDD'),(7,'2016-03-01','122-3-44-322323-2',59.9,'SOA'),(9,'2016-03-01','123-1-23-131231-2',19.9,'Primefaces'),(10,'2016-03-01','123-1-23-123123-1',79.9,'JSF2'),(11,'2016-03-01','123-1-31-312312-3',59.9,'JPA');
/*!40000 ALTER TABLE `Livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Livro_Autor`
--

DROP TABLE IF EXISTS `Livro_Autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Livro_Autor` (
  `Livro_id` int(11) NOT NULL,
  `autores_id` int(11) NOT NULL,
  KEY `FK9590997AFA17418` (`Livro_id`),
  KEY `FK9590997AD70C7E4A` (`autores_id`),
  CONSTRAINT `FK9590997AD70C7E4A` FOREIGN KEY (`autores_id`) REFERENCES `Autor` (`id`),
  CONSTRAINT `FK9590997AFA17418` FOREIGN KEY (`Livro_id`) REFERENCES `Livro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Livro_Autor`
--

LOCK TABLES `Livro_Autor` WRITE;
/*!40000 ALTER TABLE `Livro_Autor` DISABLE KEYS */;
INSERT INTO `Livro_Autor` VALUES (1,4),(2,1),(2,2),(2,5),(3,1),(5,3),(7,2),(9,1),(10,2),(11,4);
/*!40000 ALTER TABLE `Livro_Autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'nico.steppat@caelum.com.br','12345');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
