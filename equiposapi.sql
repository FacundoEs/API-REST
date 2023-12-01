-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2023 a las 05:15:02
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

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
-- Estructura de tabla para la tabla `datos_del_club`
--

CREATE TABLE `datos_del_club` (
  `id` int(11) NOT NULL,
  `descripcion_del_club` varchar(255) DEFAULT NULL,
  `nombre_del_club` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `datos_del_club`
--

INSERT INTO `datos_del_club` (`id`, `descripcion_del_club`, `nombre_del_club`) VALUES
(1, 'Club Deportivo Estrellas: Promoviendo el deporte y cultivando talentos con pasión y dedicación.', 'Club Deportivo Estrellas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`id`, `descripcion`, `nombre`) VALUES
(1, 'Un equipo multidisciplinario comprometido con la excelencia en diferentes disciplinas deportivas. ¡Somos los titanes de la competición!', 'Titanes del Deporte'),
(2, 'Equipo de fútbol apasionado y competitivo, siempre luchando por la victoria en cada partido. ¡Nuestra pasión por el balón es imparable!', 'Furiosos del Balón'),
(3, 'Un equipo comprometido con la defensa de los valores deportivos y la superación constante en todas las disciplinas. ¡Somos los guardianes del juego limpio!', 'Centinelas del Deporte');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones`
--

CREATE TABLE `inscripciones` (
  `id` int(11) NOT NULL,
  `equipo_id` int(11) DEFAULT NULL,
  `jugador_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `inscripciones`
--

INSERT INTO `inscripciones` (`id`, `equipo_id`, `jugador_id`) VALUES
(16, 1, 1),
(17, 2, 2),
(18, 3, 3),
(19, 1, 4),
(20, 2, 5),
(21, 3, 6),
(22, 1, 7),
(23, 2, 8),
(24, 3, 9),
(25, 1, 10),
(26, 1, 11),
(27, 1, 12),
(28, 1, 13),
(29, 2, 14),
(30, 2, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `id` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`id`, `edad`, `nombre`) VALUES
(1, 25, 'Santiago Morales'),
(2, 22, 'María González'),
(3, 28, 'Diego Martínez'),
(4, 20, 'Lucía Sánchez'),
(5, 24, 'Carlos López'),
(6, 21, 'Valentina Rodríguez'),
(7, 26, 'Andrés Herrera'),
(8, 23, 'Ana Jiménez'),
(9, 27, 'Javier García'),
(10, 19, 'Isabella Pérez'),
(11, 29, 'Miguel Fernández'),
(12, 20, 'Luisa Ramírez'),
(13, 25, 'Daniel Gómez'),
(14, 22, 'Paula Vargas'),
(15, 26, 'Alejandro Torres');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `app_user_role` enum('USER','ADMIN') DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `app_user_role`, `password`, `username`) VALUES
(1, 'ADMIN', '$2a$10$3uBBmYpIL6Bj2cwowB8RHOdx5U1BEgp/fX00oVQhzR/id.hTJkAI.', 'administrador');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `datos_del_club`
--
ALTER TABLE `datos_del_club`
  ADD PRIMARY KEY (`id`);

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
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `datos_del_club`
--
ALTER TABLE `datos_del_club`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `equipos`
--
ALTER TABLE `equipos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
