-- --------------------------------------------------------
-- Anfitrião:                    127.0.0.1
-- Versão do servidor:           8.0.31 - MySQL Community Server - GPL
-- SO do servidor:               Win64
-- HeidiSQL Versão:              12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- A despejar estrutura da base de dados para dissertacao
CREATE DATABASE IF NOT EXISTS `dissertacao` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dissertacao`;

-- A despejar estrutura para tabela dissertacao.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) NOT NULL,
  `nip` varchar(255) NOT NULL,
  `energia` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- A despejar dados para tabela dissertacao.cliente: ~27 rows (aproximadamente)
INSERT INTO `cliente` (`idcliente`, `nome`, `email`, `telefone`, `endereco`, `nip`, `energia`, `descricao`) VALUES
	(3, 'Cobaia 3', 'cobaia3@gmail.com', '777 77 88', 'Rua Nobre12', '30303030-1', 'PRÉ_PAGO', 'Cliente 3'),
	(4, 'Cobaia 4', 'cobaia4@gmail.com', '555 55 55', 'Rua Velha', '40404040-1', 'PÓS_PAGO', 'Cliente 4'),
	(5, 'Cobaia 5', 'cobaia5@gmail.com', '444 44 44', 'Rua Museu', '50505050-1', 'PÓS_PAGO', 'Cliente 5'),
	(7, 'Cobaia 7', 'cobaia7@gmail.com', '222 22 22', 'Rua 8 de Setembro', '70707070-1', 'PÓS_PAGO', 'Cliente 7'),
	(14, 'Cobaia 14', 'cobaia14@gmail.com', '986 25 37', 'Bairro Satón', '505050-1', 'PRÉ_PAGO', 'Cliente 14'),
	(18, 'Cobaia 18', 'cobaia18@hotmail.com', '999 9988', 'Rua da Caixa', '232323-1', 'PRÉ_PAGO', 'Cliente 18'),
	(21, 'Demo1', 'demo1@gmail.com', '9999999', 'Rua Demo1', '10203040-1', 'PRÉ_PAGO', 'Cliente 21'),
	(22, 'Demo2', 'demo2@gmail.com', '8888888', 'Rua Demo2', '90807060-1', 'PÓS_PAGO', 'Cliente Demo 2'),
	(23, 'Demo3', 'demo3@gmail.com', '7777777', 'Rua Demo3', '80808080-2', 'PRÉ-PAGO', 'Cliente Demo 3'),
	(24, 'Demo4', 'demo4@gmail.com', '902020', 'Rua Demo 4', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 4'),
	(25, 'Demo5', 'demo5@gmail.com', '902020', 'Rua Demo 5', '60606061-1', 'PRÉ_PAGO', 'Cliente Demo 5'),
	(26, 'Demo6', 'demo6@gmail.com', '902020', 'Rua Demo 6', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 6'),
	(27, 'Demo7', 'demo7@gmail.com', '902020', 'Rua Demo 7', '60606060-1', 'PRÉ_PAGO', 'Cliente Demo 7'),
	(28, 'Demo8', 'demo8@gmail.com', '902020', 'Rua Demo 8', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 8'),
	(29, 'Demo9', 'demo9@gmail.com', '902020', 'Rua Demo 9', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 9'),
	(30, 'Demo10', 'demo10@gmail.com', '902020', 'Rua Demo 10', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 10'),
	(31, 'Demo11', 'demo11@gmail.com', '902020', 'Rua Demo 11', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 11'),
	(32, 'Demo12', 'demo12@gmail.com', '902020', 'Rua Demo 12', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 12'),
	(33, 'Demo13', 'demo13@gmail.com', '902020', 'Rua Demo 13', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 13'),
	(34, 'Demo14', 'demo14@gmail.com', '902020', 'Rua Demo 14', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 14'),
	(35, 'Demo15', 'demo15@gmail.com', '902020', 'Rua Demo 15', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 15'),
	(36, 'Demo16', 'demo16@gmail.com', '902020', 'Rua Demo 16', '60606061-1', 'PRÉ_PAGO', 'Cliente Demo 16'),
	(37, 'Demo17', 'demo17@gmail.com', '902020', 'Rua Demo 17', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 17'),
	(38, 'Demo18', 'demo18@gmail.com', '902020', 'Rua Demo 18', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 18'),
	(39, 'Demo19', 'demo19@gmail.com', '902020', 'Rua Demo 19', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 19'),
	(40, 'Demo20', 'demo20@gmail.com', '902020', 'Rua Demo 20', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 20'),
	(41, 'Demo21', 'demo21@gmail.com', '902020', 'Rua Demo 21', '60606060-1', 'PÓS_PAGO', 'Cliente Demo 21');

-- A despejar estrutura para tabela dissertacao.contador
CREATE TABLE IF NOT EXISTS `contador` (
  `idcontador` bigint NOT NULL AUTO_INCREMENT,
  `conta_numero` varchar(255) DEFAULT NULL,
  `numero_contador` varchar(255) DEFAULT NULL,
  `leitura_anterior` int DEFAULT NULL,
  `nova_leitura` int DEFAULT NULL,
  `ramal` varchar(255) DEFAULT NULL,
  `amperagem` varchar(255) DEFAULT NULL,
  `distrito` varchar(255) DEFAULT NULL,
  `idcliente` int DEFAULT NULL,
  `idgeorreferencia` bigint DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcontador`),
  KEY `georreferencia_fk_idx` (`idgeorreferencia`),
  KEY `cliente_fk_idx` (`idcliente`) USING BTREE,
  CONSTRAINT `fk_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `fk_georreferencia` FOREIGN KEY (`idgeorreferencia`) REFERENCES `georreferencia` (`idgeorreferencia`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- A despejar dados para tabela dissertacao.contador: ~27 rows (aproximadamente)
INSERT INTO `contador` (`idcontador`, `conta_numero`, `numero_contador`, `leitura_anterior`, `nova_leitura`, `ramal`, `amperagem`, `distrito`, `idcliente`, `idgeorreferencia`, `descricao`) VALUES
	(3, '2021', '6000120010', 200, 410, 'HÍBRIDO', 'A90', 'ÁGUA_GRANDE', 3, 1, 'Casa 180 em São Marçal, adicionado com sucesso!	  '),
	(4, '2022', '6000120011', 50, 60, 'TRIFÁSICO', 'A80', 'ÁGUA_GRANDE', 4, 2, 'Mesquita Água Arroz.						  '),
	(5, '2023', '6000120012', 400, 1300, 'MONOFÁSICO', 'A60', 'ÁGUA_GRANDE', 5, 3, '						  '),
	(14, '2024', '6000120013', 5, 6, 'HÍBRIDO', 'A90', 'MEZÓCHI', 3, 1, '						  '),
	(15, '2025', '6000120014', 20, 25, 'TRIFÁSICO', 'A80', 'ÁGUA_GRANDE', 14, 5, 'Contador Trifásico'),
	(20, '2026', '6000120015', 30, 35, 'MONOFÁSICO', 'A60', 'ÁGUA_GRANDE', 18, 6, 'Novo Contador adicionado ao cliente Demo1.'),
	(21, '2027', '6000120016', 800, 900, 'HÍBRIDO', 'A90', 'MÉ-ZOCHI', 21, 7, NULL),
	(22, '2028', '6000120017', 750, 850, 'TRIFÁSICO', 'A80', 'MÉ-ZOCHI', 22, 8, NULL),
	(23, '2029', '6000120018', 950, 1000, 'MONOFÁSICO', 'A60', NULL, 23, 9, NULL),
	(24, '2030', '6000120019', 960, 980, 'TRIFÁSICO', 'A80', NULL, 24, 10, NULL),
	(25, '2031', '6000120020', 990, 999, 'TRIFÁSICO', 'A80', NULL, 25, 11, NULL),
	(26, '2032', '6000120021', 990, 999, 'MONOFÁSICO', 'A60', NULL, 26, 12, NULL),
	(27, '2033', '6000120022', 990, 999, 'HÍBRIDO', 'A90', NULL, 27, 13, NULL),
	(28, '2034', '6000120023', 990, 999, 'TRIFÁSICO', 'A80', NULL, 28, 14, NULL),
	(29, '2035', '6000120024', 990, 999, 'MONOFÁSICO', 'A60', NULL, 29, 15, NULL),
	(30, '2036', '6000120025', 990, 999, 'HÍBRIDO', 'A90', NULL, 30, 16, NULL),
	(31, '2037', '6000120024', 990, 999, 'TRIFÁSICO', 'A80', NULL, 31, 17, NULL),
	(32, '2038', '6000120025', 990, 999, 'MONOFÁSICO', 'A60', NULL, 32, 18, NULL),
	(33, '2039', '6000120026', 990, 999, 'HÍBRIDO', 'A90', NULL, 33, 19, NULL),
	(34, '2040', '6000120027', 990, 999, 'TRIFÁSICO', 'A80', NULL, 34, 20, NULL),
	(35, '2041', '6000120028', 990, 999, 'TRIFÁSICO', 'A80', NULL, 35, 21, NULL),
	(36, '2042', '6000120029', 990, 999, 'MONOFÁSICO', 'A60', NULL, 36, 22, NULL),
	(37, '2043', '6000120030', 990, 999, 'HÍBRIDO', 'A90', NULL, 37, 23, NULL),
	(38, '2044', '6000120031', 990, 999, 'TRIFÁSICO', 'A80', NULL, 38, 24, NULL),
	(39, '2045', '6000120032', 990, 999, 'MONOFÁSICO', 'A60', NULL, 39, 25, NULL),
	(40, '2046', '6000120033', 990, 999, 'HÍBRIDO', 'A90', NULL, 40, 26, NULL),
	(41, '2047', '6000120034', 990, 999, 'TRIFÁSICO', 'A80', NULL, 41, 27, NULL);

-- A despejar estrutura para tabela dissertacao.georreferencia
CREATE TABLE IF NOT EXISTS `georreferencia` (
  `idgeorreferencia` bigint NOT NULL AUTO_INCREMENT,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idgeorreferencia`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- A despejar dados para tabela dissertacao.georreferencia: ~27 rows (aproximadamente)
INSERT INTO `georreferencia` (`idgeorreferencia`, `latitude`, `longitude`, `descricao`) VALUES
	(1, '0.3259966', '6.7247009', 'TVS'),
	(2, '0.2855943', '6.7061592', 'Pinheira'),
	(3, '0.322511', '6.7247015', 'MesQui STP'),
	(4, '0.3262042', '6.7291684', 'USTP'),
	(5, '0.3276909', '6.7303989', 'Oficina'),
	(6, '0.3276909', '6.7303989', 'CEDEC'),
	(7, '0.2778319', '6.655007', 'Roça Milagrosa'),
	(8, '0.2998749', '6.6371477', 'Monte Café  - Loja Café Arabico'),
	(9, '0.2754883', '6.6109972', 'Cascata de São Nicolau'),
	(10, '0.2754883', '6.6109972', 'Cascata Bombaim'),
	(11, '0.2523205', '6.6016145', 'Pico de São Tomé'),
	(12, '0.2523205', '6.6016145', 'Jardim Botânico'),
	(13, '0.2970264', '6.674881', 'Pingo Doxi Trindade'),
	(14, '0.344320', '6.722941', 'DK - Rua Padre Martinho Pinto da Rocha'),
	(15, '0.2867698', '6.6815758', 'Campo de Folha Fede - Trindade'),
	(16, '0.3243118', '6.6952351', 'Mercado de Bobo Forro'),
	(17, '0.331257', '6.7054787', 'Riboque - Capital'),
	(18, '0.32807', '6.6520243', 'CIAT'),
	(19, '0.3643613', '6.6745995', 'C.T. Santo Amaro'),
	(20, '0.3729871', '6.6666173', 'Central de Processamento de Resíduos'),
	(21, '0.3169693', '6.5920396', 'Chamiço'),
	(22, '0.250551', '6.6353061', 'Roça Nova'),
	(23, '0.2347695', '6.6488719', 'Bernardo Faro'),
	(24, '0.2335018', '6.6847569', 'Anselmo Andrade'),
	(25, '0.2621126', '6.6916963', 'Uba Budo'),
	(26, '0.3495392', '6.5981436', 'Água Sampaio'),
	(27, '0.3312617', '6.6226396', 'Boa Esperança');

-- A despejar estrutura para tabela dissertacao.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- A despejar dados para tabela dissertacao.roles: ~5 rows (aproximadamente)
INSERT INTO `roles` (`role_id`, `name`) VALUES
	(1, 'ADMIN'),
	(2, 'EDITOR'),
	(3, 'CREATOR'),
	(4, 'USER'),
	(6, 'USER');

-- A despejar estrutura para tabela dissertacao.users
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- A despejar dados para tabela dissertacao.users: ~7 rows (aproximadamente)
INSERT INTO `users` (`user_id`, `username`, `password`, `email`, `enabled`) VALUES
	(1, 'fp', '$2a$10$SqysacxgrksQj8r3S3cre.0ZMxs1Qh4KtpsI21Yd0fAeAjOhfADOq', 'fp@gmail.com', b'1'),
	(2, 'alz', '$2a$10$6I9qvgn7VmCVOw/u.H5dleaiYpjMBV2gfjuHlke9RvIPmSR406MT.', 'alz@gmail.com', b'1'),
	(3, 'lis', '$2a$10$uFlwSUrseY6aHqikwKatg./bN2FpUfrifXHu8Q4mHmwfT9ETJOh6a', 'lis@gmail.com', b'1'),
	(4, 'lav', '$2a$10$arFt38Q7Jl1Tk2IQdI/bxONPhs0R.01PUOrZcY3pq.DZRikDlKw9e', 'lav@gmail.com', b'1'),
	(6, 'oli', '$2a$10$E0vvzR2NbYU8NtX4QtMMaecTbDqV5/s.KT3YhVGCS/jQ./67OLgm.', 'oli@gmail.com', b'1'),
	(7, 'dn', '$2a$10$ajHdxaaixz0GeCukukc8C.GS26surRhr0DdaPS5VQ2D94DJmN8wle', 'dn@hotmail.com', b'1'),
	(15, 'cross', 'cross', 'cross@hotmail.com', b'1');

-- A despejar estrutura para tabela dissertacao.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- A despejar dados para tabela dissertacao.users_roles: ~4 rows (aproximadamente)
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(4, 4);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
