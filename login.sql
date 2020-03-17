-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Vært: 127.0.0.1
-- Genereringstid: 17. 03 2020 kl. 12:47:31
-- Serverversion: 8.0.18
-- PHP-version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `login`
--

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `users`
--

CREATE TABLE `users` (
  `id` int(11) UNSIGNED NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `email` text NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rank` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Data dump for tabellen `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `created`, `rank`) VALUES
(2, 'test', '123456', 'testmail@gmail.com', '2020-01-10 11:43:53', 'user'),
(3, 'javatest', 'testpass', 'testmail', '2020-01-10 12:14:44', 'user'),
(4, 'javatest', 'testpass', 'testmail', '2020-01-10 12:22:14', 'user'),
(5, 'javatest', 'testpass', 'testmail', '2020-01-10 12:24:16', 'user'),
(6, 'javatest', 'testpass', 'testmail', '2020-01-10 12:24:42', 'user'),
(7, 'javatest', 'testpass', 'testmail', '2020-01-10 12:27:18', 'user'),
(8, 'javatest', 'testpass', 'testmail', '2020-01-13 10:36:33', 'user'),
(9, '', 'testpass', 'testmail', '2020-01-13 11:39:48', 'user'),
(10, 'hejusername', 'testpass', 'testmail', '2020-01-13 11:43:45', 'user'),
(11, 'hejusername', 'testpass', 'testmail', '2020-01-13 11:54:23', 'user'),
(12, 'hejusername', 'testpass', 'testmail', '2020-01-13 11:56:33', 'user'),
(13, 'test', 'test', 'test', '2020-01-13 12:06:03', 'user'),
(15, 'hejusername', 'testpass', 'testmail', '2020-01-13 12:11:43', 'user'),
(16, 'hejusername', 'testpass', 'testmail', '2020-01-13 12:12:29', 'user'),
(17, 'normalbruger', '181924', 'burgeremail@mail.dk', '2020-01-13 12:42:30', 'user'),
(18, 'test1', 'test1', 'test1', '2020-01-13 12:46:32', 'user'),
(19, 'hejusername', 'testpass', 'testmail', '2020-01-13 12:49:12', 'user');

--
-- Begrænsninger for dumpede tabeller
--

--
-- Indeks for tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Brug ikke AUTO_INCREMENT for slettede tabeller
--

--
-- Tilføj AUTO_INCREMENT i tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
