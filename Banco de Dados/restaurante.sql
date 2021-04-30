-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 01-Maio-2021 às 01:14
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
-- Estrutura da tabela `cardapio`
--

CREATE TABLE `cardapio` (
  `card_id` int(10) NOT NULL,
  `card_descricao` varchar(100) NOT NULL,
  `card_tipo` varchar(100) NOT NULL,
  `card_valor` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cardapio`
--

INSERT INTO `cardapio` (`card_id`, `card_descricao`, `card_tipo`, `card_valor`) VALUES
(1, 'Bloomin\' Onion', 'Aperitivos', '49.90'),
(2, 'Aussie Cheese Fries', 'Aperitivos', '58.50'),
(3, 'New York Strip Steak', 'Steaks', '89.90'),
(4, 'Herb Crusted Filet', 'Steaks', '71.90'),
(5, 'Firecracker Shrimp Burguer', 'Burgers & Sandwiches', '48.90'),
(6, 'Veggie Blue Cheese Burger', 'Burgers & Sandwiches', '44.00'),
(7, 'Jack Nachos Veggie', 'Veggie', '45.60'),
(8, 'S\'mores', 'Sobremesas', '29.90'),
(9, 'Super Milkshake', 'Sobremesas', '20.90'),
(10, 'Coca Cola 1L', 'Bebidas', '13.75'),
(11, 'Guaraná 1L', 'Bebidas', '13.75'),
(12, 'Chá de Cranberry 1L', 'Bebidas', '12.50'),
(13, 'Chopp Zero Grau', 'Bebidas', '20.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `cliente_id` int(10) NOT NULL,
  `cliente_nome` varchar(100) NOT NULL,
  `cliente_rua` varchar(100) NOT NULL,
  `cliente_bairro` varchar(100) NOT NULL,
  `cliente_telefone` varchar(100) NOT NULL,
  `cliente_data_cadastro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`cliente_id`, `cliente_nome`, `cliente_rua`, `cliente_bairro`, `cliente_telefone`, `cliente_data_cadastro`) VALUES
(1, 'Clara Mattos ', 'Rua Scylla Souza', 'Itaipu', '(21) 22222-2222', '2021-04-30'),
(2, 'Igor Deo Alves', 'Rua José Higino', 'Tijuca', '(21) 22222-2222', '2021-04-30'),
(3, 'Vitor Souza', 'Rua do Wilson Witzel', 'Grajáu', '(21) 22222-2222', '2021-04-30'),
(4, 'Saulo Junior', 'Rua Scylla Souza', 'Itaipu', '(21) 22222-2222', '2021-04-30');

-- --------------------------------------------------------

--
-- Estrutura da tabela `entregadores`
--

CREATE TABLE `entregadores` (
  `entre_id` int(10) NOT NULL,
  `entre_nome` varchar(100) NOT NULL,
  `entre_status` varchar(100) NOT NULL,
  `entre_data_cadastro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `entregadores`
--

INSERT INTO `entregadores` (`entre_id`, `entre_nome`, `entre_status`, `entre_data_cadastro`) VALUES
(1, 'Buck Terceiro', 'Livre', '2021-04-30');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `fun_id` int(10) NOT NULL,
  `fun_nome` varchar(100) NOT NULL,
  `fun_cargo` varchar(100) NOT NULL,
  `fun_data_cadastro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`fun_id`, `fun_nome`, `fun_cargo`, `fun_data_cadastro`) VALUES
(1, 'Clara Mattos', 'Gerente', '2021-04-30'),
(2, 'Saulo Lino', 'Administrador', '2021-04-30'),
(3, 'Sylvia Mattos', 'Caixa', '2021-04-30');

-- --------------------------------------------------------

--
-- Estrutura da tabela `item`
--

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL,
  `item_ent_id` int(11) NOT NULL,
  `item_fun_id` int(11) NOT NULL,
  `item_cli_id` int(11) NOT NULL,
  `item_ped_id` int(11) NOT NULL,
  `item_card_id` int(11) NOT NULL,
  `item_quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `item`
--

INSERT INTO `item` (`item_id`, `item_ent_id`, `item_fun_id`, `item_cli_id`, `item_ped_id`, `item_card_id`, `item_quantidade`) VALUES
(1, 1, 1, 1, 1, 1, 2),
(2, 1, 1, 4, 2, 5, 1);

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
-- Extraindo dados da tabela `pedidos`
--

INSERT INTO `pedidos` (`ped_id`, `ped_data`, `ped_hora`, `ped_total`, `ped_cliente_id`, `ped_fun_id`, `ped_ent_id`, `ped_status`) VALUES
(1, '2021-04-30', '20:01:38', '99.80', 1, 1, 1, 'Pedido Aberto'),
(2, '2021-04-30', '20:02:00', '48.90', 4, 1, 1, 'Pedido Aberto');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cardapio`
--
ALTER TABLE `cardapio`
  ADD PRIMARY KEY (`card_id`);

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`cliente_id`);

--
-- Índices para tabela `entregadores`
--
ALTER TABLE `entregadores`
  ADD PRIMARY KEY (`entre_id`);

--
-- Índices para tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`fun_id`);

--
-- Índices para tabela `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`item_id`,`item_ent_id`,`item_cli_id`,`item_ped_id`,`item_card_id`,`item_quantidade`),
  ADD KEY `ItemPedido` (`item_ped_id`,`item_cli_id`,`item_fun_id`,`item_ent_id`),
  ADD KEY `ItemCardapio` (`item_card_id`),
  ADD KEY `ItemCliente` (`item_cli_id`),
  ADD KEY `ItemEntregador` (`item_ent_id`),
  ADD KEY `ItemFuncionario` (`item_fun_id`);

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
-- AUTO_INCREMENT de tabela `cardapio`
--
ALTER TABLE `cardapio`
  MODIFY `card_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `cliente_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `entregadores`
--
ALTER TABLE `entregadores`
  MODIFY `entre_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `fun_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `item`
--
ALTER TABLE `item`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `ped_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `ItemCardapio` FOREIGN KEY (`item_card_id`) REFERENCES `cardapio` (`card_id`),
  ADD CONSTRAINT `ItemCliente` FOREIGN KEY (`item_cli_id`) REFERENCES `clientes` (`cliente_id`),
  ADD CONSTRAINT `ItemEntregador` FOREIGN KEY (`item_ent_id`) REFERENCES `entregadores` (`entre_id`),
  ADD CONSTRAINT `ItemFuncionario` FOREIGN KEY (`item_fun_id`) REFERENCES `funcionarios` (`fun_id`),
  ADD CONSTRAINT `ItemPedido` FOREIGN KEY (`item_ped_id`) REFERENCES `pedidos` (`ped_id`);

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
