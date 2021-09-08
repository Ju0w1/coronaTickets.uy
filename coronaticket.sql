-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: Sep 08, 2021 at 05:23 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coronaticket`
--

-- --------------------------------------------------------

--
-- Table structure for table `artistas`
--

CREATE TABLE `artistas` (
  `art_id` int(11) NOT NULL,
  `art_usu` int(11) NOT NULL,
  `art_descripcion` text DEFAULT NULL,
  `art_biografia` text DEFAULT NULL,
  `art_url` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `artistas`
--

INSERT INTO `artistas` (`art_id`, `art_usu`, `art_descripcion`, `art_biografia`, `art_url`) VALUES
(1, 5, 'aasdasdasd', 'aasdasdsadasdadasdasdasdasdas', 'www.hola.com'),
(2, 6, 'Cantante de rock', 'Uruguayo, 20 a?os', 'www.juanpa.com');

-- --------------------------------------------------------

--
-- Table structure for table `compra`
--

CREATE TABLE `compra` (
  `comp_id` int(11) NOT NULL,
  `comp_usu` int(11) DEFAULT NULL,
  `comp_fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `compra_linea`
--

CREATE TABLE `compra_linea` (
  `comp_lin_id` int(11) NOT NULL,
  `comp_lin_comp_id` int(11) DEFAULT NULL,
  `comp_lin_prod` int(11) DEFAULT NULL,
  `comp_lin_tipo` int(11) DEFAULT NULL,
  `comp_lin_precio` double(15,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `espetaculos`
--

CREATE TABLE `espetaculos` (
  `espec_id` int(11) NOT NULL,
  `espec_artista` int(11) DEFAULT NULL,
  `espec_plataforma` int(11) DEFAULT NULL,
  `espec_nombre` varchar(250) DEFAULT NULL,
  `espec_descripcion` text DEFAULT NULL,
  `espec_duracion` double(15,2) DEFAULT NULL,
  `espec_cant_min_espect` int(11) DEFAULT NULL,
  `espec_cant_max_espect` int(11) DEFAULT NULL,
  `espec_url` varchar(2000) DEFAULT NULL,
  `espec_fecha_registro` date DEFAULT NULL,
  `espec_costo` double(15,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `espetaculos`
--

INSERT INTO `espetaculos` (`espec_id`, `espec_artista`, `espec_plataforma`, `espec_nombre`, `espec_descripcion`, `espec_duracion`, `espec_cant_min_espect`, `espec_cant_max_espect`, `espec_url`, `espec_fecha_registro`, `espec_costo`) VALUES
(2, 2, 1, 'Rock de los 90', 'asdasdasd', 90.00, 20, 100, 'www.cualquiercosa.com', '2021-09-20', 200.00),
(6, 2, 1, 'asdad', 'asdsad', 225.00, 22, 222, 'sadasd', '2021-09-05', 123.00),
(7, 2, 2, 'asdasd', 'asdfafsasf', 14.00, 15, 200, 'https://www.hola.com', '2021-09-07', 1200.00);

-- --------------------------------------------------------

--
-- Table structure for table `funcion`
--

CREATE TABLE `funcion` (
  `fun_id` int(11) NOT NULL,
  `fun_espec_id` int(11) DEFAULT NULL,
  `fun_nombre` varchar(250) DEFAULT NULL,
  `fun_fecha_registro` date DEFAULT NULL,
  `fun_hora_inicio` time NOT NULL,
  `fun_fecha_inicio` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcion`
--

INSERT INTO `funcion` (`fun_id`, `fun_espec_id`, `fun_nombre`, `fun_fecha_registro`, `fun_hora_inicio`, `fun_fecha_inicio`) VALUES
(1, 2, 'Buitres', '2021-09-05', '16:30:34', '2021-09-06'),
(2, 2, 'asd', '2021-09-05', '14:14:00', '2021-12-12'),
(3, 2, 'dfsdfsdf', '2021-09-05', '14:14:00', '2021-12-12'),
(4, 2, 'La vela', '2021-09-06', '15:15:00', '2021-10-14'),
(5, 2, 'WOS', '2021-09-06', '16:14:00', '2022-12-08'),
(6, 2, 'NTVG', '2021-09-06', '16:18:00', '2022-04-04'),
(7, 2, 'sdffsdfsdgsdfg', '2021-09-06', '18:29:00', '2022-04-03'),
(8, 2, 'asdad', '2021-09-07', '00:00:00', '2021-01-01'),
(10, 2, 'asdadadadad', '2021-09-07', '00:00:00', '2021-01-01');

-- --------------------------------------------------------

--
-- Table structure for table `funcion_artista`
--

CREATE TABLE `funcion_artista` (
  `funart_fun_id` int(11) DEFAULT NULL,
  `funart_art_id` int(11) DEFAULT NULL,
  `fun_nombre` varchar(45) DEFAULT NULL,
  `funart_vigente` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcion_artista`
--

INSERT INTO `funcion_artista` (`funart_fun_id`, `funart_art_id`, `fun_nombre`, `funart_vigente`) VALUES
(2, 2, NULL, NULL),
(2, 2, NULL, NULL),
(2, 2, NULL, NULL),
(2, 2, NULL, NULL),
(2, 2, NULL, NULL),
(2, 2, NULL, NULL),
(2, 2, NULL, NULL),
(2, 2, NULL, NULL),
(7, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `paquetes`
--

CREATE TABLE `paquetes` (
  `paq_id` int(11) NOT NULL,
  `paq_nombre` varchar(250) NOT NULL,
  `paq_descripcion` text DEFAULT NULL,
  `paq_fecha_inicio` date DEFAULT NULL,
  `paq_fecha_fin` date DEFAULT NULL,
  `paq_descuento` double(15,2) DEFAULT NULL,
  `paq_costo` double DEFAULT NULL,
  `paq_fecha_compra` date DEFAULT NULL,
  `paq_fecha_alta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `paquetes`
--

INSERT INTO `paquetes` (`paq_id`, `paq_nombre`, `paq_descripcion`, `paq_fecha_inicio`, `paq_fecha_fin`, `paq_descuento`, `paq_costo`, `paq_fecha_compra`, `paq_fecha_alta`) VALUES
(2, 'paquete2', 'asd', '2021-02-02', '2021-03-03', 23.00, NULL, NULL, '2021-09-05'),
(3, 'paquete3', 'asdasdas', '2022-11-01', '2021-07-31', 14.00, NULL, NULL, '2021-09-05');

-- --------------------------------------------------------

--
-- Table structure for table `paquete_espetaculos`
--

CREATE TABLE `paquete_espetaculos` (
  `paqespec_paq_id` int(11) DEFAULT NULL,
  `paqespec_espec_id` int(11) DEFAULT NULL,
  `paqespec_paq_vigente` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `paquete_espetaculos`
--

INSERT INTO `paquete_espetaculos` (`paqespec_paq_id`, `paqespec_espec_id`, `paqespec_paq_vigente`) VALUES
(2, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tipo`
--

CREATE TABLE `tipo` (
  `tp_id` int(11) NOT NULL,
  `tp_nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo`
--

INSERT INTO `tipo` (`tp_id`, `tp_nombre`) VALUES
(1, 'Plataforma');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `usu_id` int(11) NOT NULL,
  `usu_nick` varchar(50) DEFAULT NULL,
  `usu_nombre` varchar(250) DEFAULT NULL,
  `usu_apellido` varchar(250) DEFAULT NULL,
  `usu_mail` varchar(250) DEFAULT NULL,
  `usu_nacimiento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`usu_id`, `usu_nick`, `usu_nombre`, `usu_apellido`, `usu_mail`, `usu_nacimiento`) VALUES
(3, 'ju0wi', 'Pablos', 'Peculios', 'pablopeculio@cras-dev.com', '2001-08-13'),
(5, 'Pepe123', 'Pablo', 'Peculiopess', 'pepe@cras-dev.com', '2000-02-12'),
(6, 'Juanpa', 'Juan Pablo', 'Peculios', 'pablopeculio@pepe.com', '2001-07-13'),
(7, 'fede', 'Federico', 'Rodriguez', 'fede@gmail.com', '2001-10-12');

-- --------------------------------------------------------

--
-- Table structure for table `usuario_funcion`
--

CREATE TABLE `usuario_funcion` (
  `funcion_id` int(11) NOT NULL,
  `usu_id` int(11) NOT NULL,
  `fechaRegistro` date NOT NULL,
  `registro_id` int(11) NOT NULL,
  `canjeado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuario_funcion`
--

INSERT INTO `usuario_funcion` (`funcion_id`, `usu_id`, `fechaRegistro`, `registro_id`, `canjeado`) VALUES
(1, 7, '1912-04-12', 18, 1),
(2, 7, '1912-04-12', 19, 1),
(4, 7, '1912-04-12', 20, 1),
(3, 7, '1912-04-12', 21, 0),
(1, 3, '1912-04-12', 22, 1),
(2, 3, '1912-04-12', 23, 1),
(4, 3, '1912-04-12', 24, 1),
(3, 3, '1912-04-12', 25, 0),
(6, 7, '1913-04-12', 26, 0);

-- --------------------------------------------------------

--
-- Table structure for table `valores_tipo`
--

CREATE TABLE `valores_tipo` (
  `tp_id` int(11) NOT NULL,
  `vp_id` int(11) NOT NULL,
  `vp_nombre` varchar(250) DEFAULT NULL,
  `vp_valor_1` text DEFAULT NULL,
  `vp_valor_2` text DEFAULT NULL,
  `vp_vigente` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `valores_tipo`
--

INSERT INTO `valores_tipo` (`tp_id`, `vp_id`, `vp_nombre`, `vp_valor_1`, `vp_valor_2`, `vp_vigente`) VALUES
(1, 1, 'Twitch', 'https://www.twitch.tv', 'plataforma de streaming', NULL),
(1, 2, 'YouTube', 'https://www.youtube.com', 'Videos', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artistas`
--
ALTER TABLE `artistas`
  ADD PRIMARY KEY (`art_id`),
  ADD KEY `FK_art_usu` (`art_usu`);

--
-- Indexes for table `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`comp_id`),
  ADD KEY `compra_usu_idx` (`comp_usu`);

--
-- Indexes for table `compra_linea`
--
ALTER TABLE `compra_linea`
  ADD PRIMARY KEY (`comp_lin_id`),
  ADD KEY `complin_idx` (`comp_lin_comp_id`),
  ADD KEY `conlintipo_idx` (`comp_lin_tipo`);

--
-- Indexes for table `espetaculos`
--
ALTER TABLE `espetaculos`
  ADD PRIMARY KEY (`espec_id`),
  ADD UNIQUE KEY `espec_nombre` (`espec_nombre`),
  ADD KEY `espe_art_idx` (`espec_artista`),
  ADD KEY `espec_plat_idx` (`espec_plataforma`);

--
-- Indexes for table `funcion`
--
ALTER TABLE `funcion`
  ADD PRIMARY KEY (`fun_id`),
  ADD UNIQUE KEY `fun_nombre` (`fun_nombre`),
  ADD KEY `fun_escp_idx` (`fun_espec_id`);

--
-- Indexes for table `funcion_artista`
--
ALTER TABLE `funcion_artista`
  ADD KEY `funart_fun_idx` (`funart_fun_id`),
  ADD KEY `funart_art_idx` (`funart_art_id`);

--
-- Indexes for table `paquetes`
--
ALTER TABLE `paquetes`
  ADD PRIMARY KEY (`paq_id`),
  ADD UNIQUE KEY `paq_nombre` (`paq_nombre`);

--
-- Indexes for table `paquete_espetaculos`
--
ALTER TABLE `paquete_espetaculos`
  ADD KEY `paq_espect_idx` (`paqespec_espec_id`),
  ADD KEY `paq_paq_idx` (`paqespec_paq_id`);

--
-- Indexes for table `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`tp_id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usu_id`),
  ADD UNIQUE KEY `usu_nick` (`usu_nick`),
  ADD UNIQUE KEY `usu_mail` (`usu_mail`);

--
-- Indexes for table `usuario_funcion`
--
ALTER TABLE `usuario_funcion`
  ADD PRIMARY KEY (`registro_id`),
  ADD KEY `usu_id_usuario` (`usu_id`),
  ADD KEY `fun_id_funcion` (`funcion_id`);

--
-- Indexes for table `valores_tipo`
--
ALTER TABLE `valores_tipo`
  ADD PRIMARY KEY (`vp_id`),
  ADD KEY `vp_tipo_idx` (`tp_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artistas`
--
ALTER TABLE `artistas`
  MODIFY `art_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `compra`
--
ALTER TABLE `compra`
  MODIFY `comp_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `compra_linea`
--
ALTER TABLE `compra_linea`
  MODIFY `comp_lin_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `espetaculos`
--
ALTER TABLE `espetaculos`
  MODIFY `espec_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `funcion`
--
ALTER TABLE `funcion`
  MODIFY `fun_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `paquetes`
--
ALTER TABLE `paquetes`
  MODIFY `paq_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tipo`
--
ALTER TABLE `tipo`
  MODIFY `tp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `usuario_funcion`
--
ALTER TABLE `usuario_funcion`
  MODIFY `registro_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `valores_tipo`
--
ALTER TABLE `valores_tipo`
  MODIFY `vp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `artistas`
--
ALTER TABLE `artistas`
  ADD CONSTRAINT `FK_art_usu` FOREIGN KEY (`art_usu`) REFERENCES `usuario` (`usu_id`);

--
-- Constraints for table `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_usu` FOREIGN KEY (`comp_usu`) REFERENCES `usuario` (`usu_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `compra_linea`
--
ALTER TABLE `compra_linea`
  ADD CONSTRAINT `complin` FOREIGN KEY (`comp_lin_comp_id`) REFERENCES `compra` (`comp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `conlintipo` FOREIGN KEY (`comp_lin_tipo`) REFERENCES `valores_tipo` (`vp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `espetaculos`
--
ALTER TABLE `espetaculos`
  ADD CONSTRAINT `espe_art` FOREIGN KEY (`espec_artista`) REFERENCES `artistas` (`art_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `espec_plat` FOREIGN KEY (`espec_plataforma`) REFERENCES `valores_tipo` (`vp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `funcion`
--
ALTER TABLE `funcion`
  ADD CONSTRAINT `fun_escp` FOREIGN KEY (`fun_espec_id`) REFERENCES `espetaculos` (`espec_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `funcion_artista`
--
ALTER TABLE `funcion_artista`
  ADD CONSTRAINT `funart_art` FOREIGN KEY (`funart_art_id`) REFERENCES `artistas` (`art_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `funart_fun` FOREIGN KEY (`funart_fun_id`) REFERENCES `funcion` (`fun_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `paquete_espetaculos`
--
ALTER TABLE `paquete_espetaculos`
  ADD CONSTRAINT `paq_espect` FOREIGN KEY (`paqespec_espec_id`) REFERENCES `espetaculos` (`espec_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `paq_paq` FOREIGN KEY (`paqespec_paq_id`) REFERENCES `paquetes` (`paq_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `usuario_funcion`
--
ALTER TABLE `usuario_funcion`
  ADD CONSTRAINT `fun_id_funcion` FOREIGN KEY (`funcion_id`) REFERENCES `funcion` (`fun_id`),
  ADD CONSTRAINT `usu_id_usuario` FOREIGN KEY (`usu_id`) REFERENCES `usuario` (`usu_id`);

--
-- Constraints for table `valores_tipo`
--
ALTER TABLE `valores_tipo`
  ADD CONSTRAINT `vp_tipo` FOREIGN KEY (`tp_id`) REFERENCES `tipo` (`tp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
