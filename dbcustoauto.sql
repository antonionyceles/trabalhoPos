-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 18-Jul-2017 às 22:38
-- Versão do servidor: 10.1.24-MariaDB
-- PHP Version: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbcustoauto`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `cd_cliente` bigint(20) NOT NULL,
  `nm_nome` varchar(200) NOT NULL,
  `nm_sobrenome` varchar(200) NOT NULL,
  `ds_cpf` varchar(11) DEFAULT NULL,
  `ds_rg` varchar(15) NOT NULL,
  `nr_telefone` varchar(12) NOT NULL,
  `nr_celular` varchar(12) NOT NULL,
  `ds_email` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`cd_cliente`, `nm_nome`, `nm_sobrenome`, `ds_cpf`, `ds_rg`, `nr_telefone`, `nr_celular`, `ds_email`) VALUES
(1, 'ANTONIONY', 'CELES', '04117100521', '09850956', '', '71992019621', 'antonionyceles@gmail.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `cd_usuario` bigint(20) NOT NULL,
  `cd_cliente` bigint(20) NOT NULL COMMENT 'chave para tabela cliente',
  `ds_login` varchar(1000) NOT NULL COMMENT 'login do usuario',
  `ds_password` varchar(1000) NOT NULL COMMENT 'senha md5',
  `dt_cadastro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'data de cadastro'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`cd_usuario`, `cd_cliente`, `ds_login`, `ds_password`, `dt_cadastro`) VALUES
(1, 1, 'antoniony', 'aaa123', '2017-07-10 15:57:24');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cd_cliente`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cd_usuario`),
  ADD KEY `fk_cliente` (`cd_cliente`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `cd_cliente` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `cd_usuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_cliente` FOREIGN KEY (`cd_cliente`) REFERENCES `cliente` (`cd_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
