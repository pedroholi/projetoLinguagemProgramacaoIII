CREATE DATABASE  IF NOT EXISTS `projeto` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `projeto`;
-- MySQL dump 10.16  Distrib 10.1.38-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: projeto
-- ------------------------------------------------------
-- Server version	10.1.38-MariaDB

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
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidade` (
  `idCidade` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCidade` varchar(100) NOT NULL,
  `ufCidade` varchar(5) NOT NULL,
  `paisCidade` varchar(100) NOT NULL,
  PRIMARY KEY (`idCidade`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'Bom Sucesso','MG','Brasil'),(2,'Lavras','MG','Brasil'),(3,'Oliveira','MG','Brasil');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCliente` varchar(150) NOT NULL,
  `rgCliente` varchar(12) NOT NULL,
  `cpfCliente` varchar(15) NOT NULL,
  `emailCliente` varchar(45) DEFAULT NULL,
  `sexoCliente` varchar(45) DEFAULT NULL,
  `dataNascCliente` varchar(10) NOT NULL,
  `telefoneCliente` varchar(13) DEFAULT NULL,
  `celularCliente` varchar(14) DEFAULT NULL,
  `ruaCliente` varchar(50) NOT NULL,
  `bairroCliente` varchar(50) NOT NULL,
  `numCliente` int(11) NOT NULL,
  `cepCliente` varchar(9) NOT NULL,
  `referenciaCliente` varchar(100) DEFAULT NULL,
  `idCidadeCliente` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`,`idCidadeCliente`),
  KEY `fk_Cliente_Cidade_idx` (`idCidadeCliente`),
  CONSTRAINT `fk_Cliente_Cidade` FOREIGN KEY (`idCidadeCliente`) REFERENCES `cidade` (`idCidade`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Alvaro','mg14452452','112.926.856-03','alvaro@email.com','Masculino','30/07/2001','(35)9821-1883','(35)99821-1883','Vigario','Rosario',202,'37220-000','alvaro',1),(6,'11111111111111','111111111111','111.111.111-11','111111111111','Masculino','11/11/1111','(11)1111-1111','(11)11111-1111','11111111111111','1111111111111',1111111,'11111-111','111',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrada` (
  `idEntrada` int(11) NOT NULL AUTO_INCREMENT,
  `idProdutoEntrada` int(11) NOT NULL,
  `quantEntrada` int(11) NOT NULL,
  `dataEntrada` varchar(10) NOT NULL,
  `valorCompraEntrada` double DEFAULT NULL,
  PRIMARY KEY (`idEntrada`,`idProdutoEntrada`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,1,100,'24/06/2019',NULL),(2,1,150,'24/06/2019',NULL);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `nomeMarca` varchar(100) NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Bauducco'),(2,'Nerf'),(3,'Vanish');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeProduto` varchar(150) NOT NULL,
  `dataCadProduto` varchar(10) NOT NULL,
  `unidCompraProduto` varchar(45) NOT NULL,
  `unidVendaProduto` varchar(45) NOT NULL,
  `pesoProduto` double NOT NULL,
  `valorVendaProduto` double NOT NULL,
  `valorCompraProduto` double NOT NULL,
  `descricaoProduto` varchar(200) DEFAULT NULL,
  `idTipoProduto` int(11) NOT NULL,
  `idMarcaProduto` int(11) NOT NULL,
  PRIMARY KEY (`idProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'asd','1111/11/11','1','1',11,10.5,0,'1111',1,1),(2,'1','null','1','1',1,1,1,'null',0,0),(3,'1','null','1','1',1,1,1,'null',1,0),(4,'1','26/06/2019','1','1',1,1,1,'1',1,0);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtovenda`
--

DROP TABLE IF EXISTS `produtovenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtovenda` (
  `idProdutoProdutoVenda` int(11) NOT NULL,
  `idVendaProdutoVenda` int(11) NOT NULL,
  `quantidadeProdutoVenda` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProdutoProdutoVenda`,`idVendaProdutoVenda`),
  KEY `fk_Produto_has_Venda_Venda1_idx` (`idVendaProdutoVenda`),
  KEY `fk_Produto_has_Venda_Produto1_idx` (`idProdutoProdutoVenda`),
  CONSTRAINT `fk_Produto_has_Venda_Produto1` FOREIGN KEY (`idProdutoProdutoVenda`) REFERENCES `produto` (`idProduto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produto_has_Venda_Venda1` FOREIGN KEY (`idVendaProdutoVenda`) REFERENCES `venda` (`idVenda`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtovenda`
--

LOCK TABLES `produtovenda` WRITE;
/*!40000 ALTER TABLE `produtovenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtovenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nomeTipo` varchar(100) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'Alimenticio'),(2,'Limpesa'),(3,'Lazer');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeUsuario` varchar(150) NOT NULL,
  `emailUsuario` varchar(150) NOT NULL,
  `senhaUsuario` varchar(20) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'usuarioName_1','name1@email.com','12545784'),(2,'usuarioName_2','name2@email.com','14578421'),(3,'usuarioName_3','name3@email.com','12569874'),(4,'Alvaro','Alvaro@email.com','123');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `idVenda` int(11) NOT NULL AUTO_INCREMENT,
  `idClienteVenda` int(11) NOT NULL,
  `dataVenda` varchar(10) NOT NULL,
  `valorTotalVenda` varchar(45) DEFAULT NULL,
  `descontoVenda` double DEFAULT NULL,
  `tipoPagamentoVenda` varchar(45) DEFAULT NULL,
  `idProdutoVenda` int(11) NOT NULL,
  `quantidadeProdutoVenda` int(11) NOT NULL,
  PRIMARY KEY (`idVenda`,`idClienteVenda`),
  KEY `fk_Venda_Cliente1_idx` (`idClienteVenda`),
  CONSTRAINT `fk_Venda_Cliente1` FOREIGN KEY (`idClienteVenda`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,1,'26/06/2019','236.25',0.1,'Dinheiro',1,10),(2,1,'26/06/2019','236.25',0.1,'Dinheiro',1,10),(3,1,'26/06/2019','236.25',0.1,'Dinheiro',1,10),(4,1,'26/06/2019','236.25',0.1,'Dinheiro',1,10),(5,1,'26/06/2019','236.25',0.1,'Dinheiro',1,10),(6,1,'26/06/2019','236.25',0.1,'Dinheiro',1,15),(7,1,'26/06/2019','236.25',0.1,'Dinheiro',1,15),(8,1,'26/06/2019','236.25',0.1,'Dinheiro',1,15),(9,1,'26/06/2019','236.25',0.1,'Dinheiro',1,15),(10,1,'26/06/2019','236.25',0.1,'Dinheiro',1,15);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-26 20:16:35
