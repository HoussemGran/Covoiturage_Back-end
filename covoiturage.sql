-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 30 nov. 2021 à 11:33
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `covoiturage`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `login` varchar(30) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `login`, `password`) VALUES
(1, 'admin', '21232f297a57a5a743894ae4a801fc3');

-- --------------------------------------------------------

--
-- Structure de la table `rejoindre_trip`
--

CREATE TABLE `rejoindre_trip` (
  `id` int(11) NOT NULL,
  `id_trip` int(11) DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `rejoindre_trip`
--

INSERT INTO `rejoindre_trip` (`id`, `id_trip`, `id_user`) VALUES
(5, 3, 1),
(6, 3, 1),
(7, 3, 1),
(8, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `trip`
--

CREATE TABLE `trip` (
  `id` int(11) NOT NULL,
  `id_conducteur` int(11) NOT NULL,
  `source` varchar(30) NOT NULL,
  `destination` varchar(30) NOT NULL,
  `nb_place` int(11) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `heure` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `trip`
--

INSERT INTO `trip` (`id`, `id_conducteur`, `source`, `destination`, `nb_place`, `date`, `heure`) VALUES
(1, 1, 'proxym', 'sahloul', 2, '2021-11-29', ''),
(3, 1, 'proxym', 'sahloul', 2, '2021-11-29', '15:30'),
(4, 1, 'proxym', 'sahloul', 2, '2021-11-29', '15:30'),
(5, 2, 'sahloul', 'ryadh', 4, '2021-11-29', '10:00');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `login` varchar(30) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `login`, `password`, `email`) VALUES
(1, 'houssem', '1a1dc91c907325c69271ddf0c944bc72', 'houssem.gran@gmail.com'),
(2, 'wassim', '1a1dc91c907325c69271ddf0c944bc72', 'wassim@gmail.com'),
(3, 'abdelhamid', 'c1572d5424decb2a65ec6a82aeacbf', 'adblehmid@gmail.com'),
(8, 'ayoub99', 'd24fd3ec8518e6e43edab9f07dbb7182', 'ayoub@gmail.com'),
(9, 'adem', '9b986ab098bc131828875e64cbacf3', 'adem@gmail.com'),
(10, 'adem2012', '7c37be7260f8cd7c1f5e4dbdd7bc5b23', 'ademds@gmaoil.com');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `rejoindre_trip`
--
ALTER TABLE `rejoindre_trip`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_trip` (`id_trip`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `trip`
--
ALTER TABLE `trip`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_conducteur` (`id_conducteur`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `rejoindre_trip`
--
ALTER TABLE `rejoindre_trip`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `trip`
--
ALTER TABLE `trip`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `rejoindre_trip`
--
ALTER TABLE `rejoindre_trip`
  ADD CONSTRAINT `rejoindre_trip_ibfk_1` FOREIGN KEY (`id_trip`) REFERENCES `trip` (`id`),
  ADD CONSTRAINT `rejoindre_trip_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `trip`
--
ALTER TABLE `trip`
  ADD CONSTRAINT `trip_ibfk_1` FOREIGN KEY (`id_conducteur`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
