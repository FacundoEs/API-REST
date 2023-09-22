-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-09-2023 a las 13:52:13
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `equiposapi`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`id`, `nombre`) VALUES
(2, 'Tenis'),
(7, 'Fútbol'),
(8, 'Futbolito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones`
--

CREATE TABLE `inscripciones` (
  `id` int(11) NOT NULL,
  `equipo_id` int(11) DEFAULT NULL,
  `jugador_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripciones`
--

INSERT INTO `inscripciones` (`id`, `equipo_id`, `jugador_id`) VALUES
(16, 8, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `id` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`id`, `edad`, `nombre`) VALUES
(1, 24, 'Facundo'),
(3, 23, 'Alberto');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK78xjek5ub4c6avj1seoo05v3c` (`equipo_id`),
  ADD KEY `FKcdqy7rdsscof65j77pksjd7x7` (`jugador_id`);

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `equipos`
--
ALTER TABLE `equipos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD CONSTRAINT `FK78xjek5ub4c6avj1seoo05v3c` FOREIGN KEY (`equipo_id`) REFERENCES `equipos` (`id`),
  ADD CONSTRAINT `FKcdqy7rdsscof65j77pksjd7x7` FOREIGN KEY (`jugador_id`) REFERENCES `jugadores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
