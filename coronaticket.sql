-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 11-08-2021 a las 20:07:58
-- Versión del servidor: 5.5.62-0ubuntu0.14.04.1-log
-- Versión de PHP: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `coronaticket`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas`
--

CREATE DATABASE `coronaticket`;
use coronaticket;
CREATE TABLE `artistas` (
  `art_id` int(11) NOT NULL,
  `art_usu` int(11) NOT NULL,
  `art_descripcion` text,
  `art_biografia` text,
  `art_url` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `comp_id` int(11) NOT NULL,
  `comp_usu` int(11) DEFAULT NULL,
  `comp_fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_linea`
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
-- Estructura de tabla para la tabla `espetaculos`
--

CREATE TABLE `espetaculos` (
  `espec_id` int(11) NOT NULL,
  `espec_artista` int(11) DEFAULT NULL,
  `espec_plataforma` int(11) DEFAULT NULL,
  `espec_nombre` varchar(250) DEFAULT NULL,
  `espec_descripcion` text,
  `espec_duracion` double(15,2) DEFAULT NULL,
  `espec_cant_min_espect` int(11) DEFAULT NULL,
  `espec_cant_max_espect` int(11) DEFAULT NULL,
  `espec_url` text,
  `espec_fecha_registro` date DEFAULT NULL,
  `espec_costo` double(15,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE `funcion` (
  `fun_id` int(11) NOT NULL,
  `fun_espec_id` int(11) DEFAULT NULL,
  `fun_nombre` varchar(250) DEFAULT NULL,
  `fun_fecha_registro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion_artista`
--

CREATE TABLE `funcion_artista` (
  `funart_fun_id` int(11) DEFAULT NULL,
  `funart_art_id` int(11) DEFAULT NULL,
  `fun_nombre` int(11) DEFAULT NULL,
  `funart_vigente` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquetes`
--

CREATE TABLE `paquetes` (
  `paq_id` int(11) NOT NULL,
  `paq_nombre` varchar(250) DEFAULT NULL,
  `paq_descripcion` text,
  `paq_fecha_inicio` date DEFAULT NULL,
  `paq_fecha_fin` date DEFAULT NULL,
  `paq_descuento` double(15,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete_espetaculos`
--

CREATE TABLE `paquete_espetaculos` (
  `paqespec_paq_id` int(11) DEFAULT NULL,
  `paqespec_espec_id` int(11) DEFAULT NULL,
  `paqespec_paq_vigente` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `tp_id` int(11) NOT NULL,
  `tp_nombre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usu_id` int(11) NOT NULL,
  `usu_nick` varchar(50) DEFAULT NULL,
  `usu_nombre` varchar(250) DEFAULT NULL,
  `usu_apellido` varchar(250) DEFAULT NULL,
  `usu_mail` varchar(250) DEFAULT NULL,
  `usu_nacimiento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valores_tipo`
--

CREATE TABLE `valores_tipo` (
  `tp_id` int(11) NOT NULL,
  `vp_id` int(11) NOT NULL,
  `vp_nombre` varchar(250) DEFAULT NULL,
  `vp_valor_1` text,
  `vp_valor_2` text,
  `vp_vigente` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artistas`
--
ALTER TABLE `artistas`
  ADD PRIMARY KEY (`art_id`),
  ADD KEY `FK_art_usu` (`art_usu`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`comp_id`),
  ADD KEY `compra_usu_idx` (`comp_usu`);

--
-- Indices de la tabla `compra_linea`
--
ALTER TABLE `compra_linea`
  ADD PRIMARY KEY (`comp_lin_id`),
  ADD KEY `complin_idx` (`comp_lin_comp_id`),
  ADD KEY `conlintipo_idx` (`comp_lin_tipo`);

--
-- Indices de la tabla `espetaculos`
--
ALTER TABLE `espetaculos`
  ADD PRIMARY KEY (`espec_id`),
  ADD UNIQUE KEY `espec_nombre` (`espec_nombre`),
  ADD KEY `espe_art_idx` (`espec_artista`),
  ADD KEY `espec_plat_idx` (`espec_plataforma`);

--
-- Indices de la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD PRIMARY KEY (`fun_id`),
  ADD UNIQUE KEY `fun_nombre` (`fun_nombre`),
  ADD KEY `fun_escp_idx` (`fun_espec_id`);

--
-- Indices de la tabla `funcion_artista`
--
ALTER TABLE `funcion_artista`
  ADD KEY `funart_fun_idx` (`funart_fun_id`),
  ADD KEY `funart_art_idx` (`funart_art_id`);

--
-- Indices de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  ADD PRIMARY KEY (`paq_id`),
  ADD UNIQUE KEY `paq_nombre` (`paq_nombre`);

--
-- Indices de la tabla `paquete_espetaculos`
--
ALTER TABLE `paquete_espetaculos`
  ADD KEY `paq_espect_idx` (`paqespec_espec_id`),
  ADD KEY `paq_paq_idx` (`paqespec_paq_id`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`tp_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usu_id`),
  ADD UNIQUE KEY `usu_nick` (`usu_nick`),
  ADD UNIQUE KEY `usu_mail` (`usu_mail`);

--
-- Indices de la tabla `valores_tipo`
--
ALTER TABLE `valores_tipo`
  ADD PRIMARY KEY (`vp_id`),
  ADD KEY `vp_tipo_idx` (`tp_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `artistas`
--
ALTER TABLE `artistas`
  MODIFY `art_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `comp_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `compra_linea`
--
ALTER TABLE `compra_linea`
  MODIFY `comp_lin_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `espetaculos`
--
ALTER TABLE `espetaculos`
  MODIFY `espec_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `funcion`
--
ALTER TABLE `funcion`
  MODIFY `fun_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paquetes`
--
ALTER TABLE `paquetes`
  MODIFY `paq_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `tp_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usu_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `valores_tipo`
--
ALTER TABLE `valores_tipo`
  MODIFY `vp_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `artistas`
--
ALTER TABLE `artistas`
  ADD CONSTRAINT `FK_art_usu` FOREIGN KEY (`art_usu`) REFERENCES `usuario` (`usu_id`);

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_usu` FOREIGN KEY (`comp_usu`) REFERENCES `usuario` (`usu_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `compra_linea`
--
ALTER TABLE `compra_linea`
  ADD CONSTRAINT `complin` FOREIGN KEY (`comp_lin_comp_id`) REFERENCES `compra` (`comp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `conlintipo` FOREIGN KEY (`comp_lin_tipo`) REFERENCES `valores_tipo` (`vp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `espetaculos`
--
ALTER TABLE `espetaculos`
  ADD CONSTRAINT `espe_art` FOREIGN KEY (`espec_artista`) REFERENCES `artistas` (`art_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `espec_plat` FOREIGN KEY (`espec_plataforma`) REFERENCES `valores_tipo` (`vp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD CONSTRAINT `fun_escp` FOREIGN KEY (`fun_espec_id`) REFERENCES `espetaculos` (`espec_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `funcion_artista`
--
ALTER TABLE `funcion_artista`
  ADD CONSTRAINT `funart_fun` FOREIGN KEY (`funart_fun_id`) REFERENCES `funcion` (`fun_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `funart_art` FOREIGN KEY (`funart_art_id`) REFERENCES `artistas` (`art_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `paquete_espetaculos`
--
ALTER TABLE `paquete_espetaculos`
  ADD CONSTRAINT `paq_espect` FOREIGN KEY (`paqespec_espec_id`) REFERENCES `espetaculos` (`espec_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `paq_paq` FOREIGN KEY (`paqespec_paq_id`) REFERENCES `paquetes` (`paq_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `valores_tipo`
--
ALTER TABLE `valores_tipo`
  ADD CONSTRAINT `vp_tipo` FOREIGN KEY (`tp_id`) REFERENCES `tipo` (`tp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
