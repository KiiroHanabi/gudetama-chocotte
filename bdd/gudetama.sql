-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 13 Mars 2017 à 18:09
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gudetama`
--
CREATE DATABASE IF NOT EXISTS `gudetama` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gudetama`;

-- --------------------------------------------------------

--
-- Structure de la table `favoris`
--

DROP TABLE IF EXISTS `favoris`;
CREATE TABLE IF NOT EXISTS `favoris` (
  `idUtilisateur` int(11) NOT NULL,
  `idVideo` int(11) NOT NULL,
  PRIMARY KEY (`idUtilisateur`,`idVideo`),
  KEY `fk_favoris_idVideo` (`idVideo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `traduction`
--

DROP TABLE IF EXISTS `traduction`;
CREATE TABLE IF NOT EXISTS `traduction` (
  `idTraduction` int(11) NOT NULL AUTO_INCREMENT,
  `idUtilisateur` int(11) NOT NULL,
  `urlTraduction` varchar(45) NOT NULL,
  `votePositif` int(11) NOT NULL DEFAULT '0',
  `voteNegatif` int(11) NOT NULL DEFAULT '0',
  `totalVote` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idTraduction`),
  KEY `idUtilisateur` (`idUtilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=2 ;

--
-- Déclencheurs `traduction`
--
DROP TRIGGER IF EXISTS `calculTotalVotes`;
DELIMITER //
CREATE TRIGGER `calculTotalVotes` BEFORE UPDATE ON `traduction`
 FOR EACH ROW BEGIN
SET new.totalVote = new.votePositif-new.voteNegatif;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  `statut` varchar(45) NOT NULL,
  PRIMARY KEY (`idUtilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `login`, `email`, `mdp`, `statut`) VALUES
(1, 'Minet', '16d3341d3c7d09075c5d2204b94a4ef27f1f8a6e', 'f91a8ee646a277a2f1359709604b99c1b32d9f24', 'Admin'),
(2, 'DogeLord', '558df618987c7202326221628bd07427637f33e1', '7429092da8fd5fb02a68689f184258436db51a0c', 'Admin'),
(3, 'Licorne', '41f2a6ee66ff6e0cd7d6bbc4c6086ec8b498309d', 'f1eb08c4e3f8a5ab5761723b1210ad4c30e41dc7', 'Admin'),
(4, 'Paul', '14a9adfe22557faba7f291923b3673da5e9fc446', '510826e6abbcf0e6ffef30f1e6b15c318e275cf1', 'Membre'),
(5, 'SpongeBob', 'a09bde7dec17828bc87057ba6555bbff5ff2387f', '45a35463c3dd5a39cf170630510175bf7249a2ba', 'Membre'),
(6, 'Steven', '3db7328c914058bb7ac583cf44054556fa6a4b47', 'f725d6d76d5958fe3e0a0b263898ff29907f35f6', 'Membre'),
(7, 'Garnet', 'eb41bd336a942ceb8a9853e67c81b003ea2f764f', '88efff4015896fbc096127ab09a1744b79ae95d3', 'Membre');

--
-- Déclencheurs `utilisateur`
--
DROP TRIGGER IF EXISTS `verif_utilisateur`;
DELIMITER //
CREATE TRIGGER `verif_utilisateur` BEFORE INSERT ON `utilisateur`
 FOR EACH ROW BEGIN IF LENGTH(new.login) < 2 OR LENGTH(new.email) < 2 THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Le login ou email ne peuvent pas avoir moins de deux caracteres...';
ELSEIF new.statut != 'Membre' THEN SET new.statut = 'Membre';
ELSEIF LOCATE('@', new.email) = 0 THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Votre email ne fonctionne pas...';
END IF;
SET new.email = SHA1(new.email);
SET new.mdp = SHA1(new.mdp);
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `video`
--

DROP TABLE IF EXISTS `video`;
CREATE TABLE IF NOT EXISTS `video` (
  `idVideo` int(11) NOT NULL AUTO_INCREMENT,
  `titreVideo` varchar(45) NOT NULL,
  `dateVideo` date NOT NULL,
  `urlVideo` varchar(100) NOT NULL,
  `dureeVideo` time NOT NULL,
  `idTraduction` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVideo`),
  KEY `idTraduction` (`idTraduction`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `video`
--

INSERT INTO `video` (`idVideo`, `titreVideo`, `dateVideo`, `urlVideo`, `dureeVideo`, `idTraduction`) VALUES
(1, 'ぐでたまショートアニメ 第730話「フライング」（36放送）', '2017-03-05', 'C:\\Users\\Jojo\\Desktop\\VidGudetama\\ぐでたまショートアニメ 第730話「フライング」（36放送）.mp4', '00:01:00', NULL),
(2, 'ぐでたまショートアニメ 第731話「ぐでたま名言集」（37放送）', '2017-03-06', 'C:\\Users\\Jojo\\Desktop\\VidGudetama\\ぐでたまショートアニメ 第731話「ぐでたま名言集」（37放送）.mp4', '00:01:00', NULL),
(3, 'ぐでたまショートアニメ 第732話「黄身の名は」（38放送）', '2017-03-07', 'C:\\Users\\Jojo\\Desktop\\VidGudetama\\ぐでたまショートアニメ 第732話「黄身の名は」（38放送）.mp4', '00:01:00', NULL),
(4, 'ぐでたまショートアニメ 第733話「もしもぐでたま 声優」（39放送）', '2017-03-08', 'C:\\Users\\Jojo\\Desktop\\VidGudetama\\ぐでたまショートアニメ 第733話「もしもぐでたま 声優」（39放送）.mp4', '00:01:00', NULL),
(5, 'ぐでたまショートアニメ 第734話「しりに…」（310放送）', '2017-03-09', 'C:\\Users\\Jojo\\Desktop\\VidGudetama\\ぐでたまショートアニメ 第734話「しりに…」（310放送）.mp4', '00:01:00', NULL);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `favoris`
--
ALTER TABLE `favoris`
  ADD CONSTRAINT `fk_favoris_idVideo` FOREIGN KEY (`idVideo`) REFERENCES `video` (`idVideo`),
  ADD CONSTRAINT `fk_favoris_idUtilisateur` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
