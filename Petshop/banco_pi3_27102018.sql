-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pi3_pet
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.29-MariaDB

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
-- Table structure for table `detalhes_pedido`
--

DROP TABLE IF EXISTS `detalhes_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalhes_pedido` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `idProduto` int(11) DEFAULT NULL,
  `idServico` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT '1',
  PRIMARY KEY (`idPedido`),
  KEY `idProduto_idx` (`idProduto`),
  KEY `idServico_idx` (`idServico`),
  CONSTRAINT `idProduto` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idproduto`),
  CONSTRAINT `idServico` FOREIGN KEY (`idServico`) REFERENCES `servico` (`idservico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) DEFAULT NULL,
  `idTipoPagamento` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `precoVenda` double NOT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `idCliente_idx` (`idCliente`),
  KEY `idTipoPagamento_idx` (`idTipoPagamento`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `usuario` (`idusuario`),
  CONSTRAINT `idTipoPagamento` FOREIGN KEY (`idTipoPagamento`) REFERENCES `tipopagamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pet` (
  `idPet` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `nomepet` varchar(45) NOT NULL,
  `especie` varchar(45) NOT NULL,
  `porte` varchar(45) NOT NULL,
  `nascimento` date DEFAULT NULL,
  PRIMARY KEY (`idPet`),
  KEY `idUsuario_idx` (`idCliente`),
  CONSTRAINT `idUsuario` FOREIGN KEY (`idCliente`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `preco` double NOT NULL,
  `fabricante` varchar(60) DEFAULT NULL,
  `estoque` int(11) NOT NULL DEFAULT '0',
  `modelo` varchar(60) DEFAULT NULL,
  `codigodebarras` varchar(45) DEFAULT NULL,
  `tamanho_animal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `idServico` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(60) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `tamanho_animal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idServico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipopagamento`
--

DROP TABLE IF EXISTS `tipopagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(14) NOT NULL,
  `nome` varchar(70) NOT NULL,
  `nascimento` date NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(60) NOT NULL,
  `sexo` char(1) NOT NULL,
  `rg` varchar(12) NOT NULL,
  `endereco` varchar(150) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `tipoacesso` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-27 12:13:54
