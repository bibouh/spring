-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 06 mai 2022 à 23:46
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.4.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `spring`
--

-- --------------------------------------------------------

--
-- Structure de la table `approvisionnement`
--

DROP TABLE IF EXISTS `approvisionnement`;
CREATE TABLE IF NOT EXISTS `approvisionnement` (
  `id` int(11) NOT NULL,
  `date_app` date NOT NULL,
  `qt` int(11) NOT NULL,
  `article_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK868evb3tr10abm3vyg2r2rp63` (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `approvisionnement`
--

INSERT INTO `approvisionnement` (`id`, `date_app`, `qt`, `article_id`) VALUES
(16, '2022-05-06', 15, 11),
(17, '2022-05-06', 54, 12),
(22, '2022-05-06', 12, 11),
(23, '2022-05-06', 5, 12),
(24, '2022-05-06', 5, 12),
(26, '2022-05-06', 20, 25),
(31, '2022-05-06', 6, 11),
(32, '2022-05-06', 6, 28),
(36, '2022-05-06', 200, 35),
(42, '2022-05-06', 80, 41),
(44, '2022-05-06', 50, 11);

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id` int(11) NOT NULL,
  `date_creation` date DEFAULT NULL,
  `libelle` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `qt_seuil` int(11) NOT NULL,
  `categorie_id` int(11) DEFAULT NULL,
  `stocks` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqnmbf0yfa804hxcw8c9gneb0v` (`categorie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id`, `date_creation`, `libelle`, `prix`, `qt_seuil`, `categorie_id`, `stocks`) VALUES
(11, '2022-05-01', 'oignon', 15000, 50, 6, 50),
(12, '2022-05-01', 'banane', 100, 500, 6, 43),
(25, '2022-05-06', 'pure water', 450, 5, 6, 6),
(28, '2022-05-06', 'gombo', 50, 80, 13, 6),
(35, '2022-05-06', 'salade', 500, 14, 13, 200),
(41, '2022-05-06', 'cp', 250, 12, 14, 50);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id` int(11) NOT NULL,
  `designation` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `designation`) VALUES
(6, 'liquide'),
(13, 'alimentaire'),
(14, 'ustensile'),
(40, 'cosmetique');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`) VALUES
(1, 'messan', 'folly'),
(3, 'lodo', 'kossi emmanuel'),
(39, 'ouro', 'sasa');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(53);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `firstname`, `password`, `username`) VALUES
(51, 'admin@gmail.com', 'admin', '$2a$10$WsadA9GrxvqiMjXarUf1Wec87F29UgPdcmpMAvdZWs9UWPoQwj4TS', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

DROP TABLE IF EXISTS `vente`;
CREATE TABLE IF NOT EXISTS `vente` (
  `id` int(11) NOT NULL,
  `date_de_vente` date NOT NULL,
  `qt_vendue` int(11) NOT NULL,
  `article_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `numero` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbfsd94pqg2nn8ob777eoyvdtf` (`article_id`),
  KEY `FKt8c0ckr8dqeq9nia3wb7j6r7n` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`id`, `date_de_vente`, `qt_vendue`, `article_id`, `client_id`, `numero`) VALUES
(29, '2022-05-06', 12, 11, 1, 14),
(30, '2022-05-06', 12, 12, 1, 14),
(33, '2022-05-06', 6, 11, 1, 14),
(43, '2022-05-06', 14, 25, 39, 13);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `approvisionnement`
--
ALTER TABLE `approvisionnement`
  ADD CONSTRAINT `FK868evb3tr10abm3vyg2r2rp63` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`);

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `FKqnmbf0yfa804hxcw8c9gneb0v` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `vente`
--
ALTER TABLE `vente`
  ADD CONSTRAINT `FKbfsd94pqg2nn8ob777eoyvdtf` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`),
  ADD CONSTRAINT `FKt8c0ckr8dqeq9nia3wb7j6r7n` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
