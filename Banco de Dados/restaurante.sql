-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28-Abr-2021 às 21:46
-- Versão do servidor: 10.4.18-MariaDB
-- versão do PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `restaurante`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedidos`
--

CREATE TABLE `pedidos` (
  `ped_id` int(10) NOT NULL,
  `ped_data` date NOT NULL,
  `ped_hora` time NOT NULL,
  `ped_total` decimal(10,2) NOT NULL,
  `ped_cliente_id` int(10) NOT NULL,
  `ped_fun_id` int(10) NOT NULL,
  `ped_ent_id` int(10) NOT NULL,
  `ped_status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`ped_id`),
  ADD KEY `ped_cliente_id` (`ped_cliente_id`),
  ADD KEY `ped_fun_id` (`ped_fun_id`),
  ADD KEY `ped_ent_id` (`ped_ent_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `ped_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `ClientePedido` FOREIGN KEY (`ped_cliente_id`) REFERENCES `clientes` (`cliente_id`),
  ADD CONSTRAINT `EntregadorPedido` FOREIGN KEY (`ped_ent_id`) REFERENCES `entregadores` (`entre_id`),
  ADD CONSTRAINT `FuncionarioPedido` FOREIGN KEY (`ped_fun_id`) REFERENCES `funcionarios` (`fun_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
