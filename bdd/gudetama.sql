-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 07 Mars 2017 à 17:40
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gudetama`
--

-- --------------------------------------------------------

--
-- Structure de la table `motcle`
--

CREATE TABLE IF NOT EXISTS `motcle` (
  `idMotcle` int(11) NOT NULL AUTO_INCREMENT,
  `idVideo` int(11) NOT NULL,
  `mot` varchar(45) NOT NULL,
  PRIMARY KEY (`idMotcle`),
  KEY `idVideo` (`idVideo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `traduction`
--

CREATE TABLE IF NOT EXISTS `traduction` (
  `idTraduction` int(11) NOT NULL AUTO_INCREMENT,
  `idUtilisateur` int(11) NOT NULL,
  `urlTraduction` varchar(45) NOT NULL,
  `votePositif` int(11) NOT NULL,
  `voteNegatif` int(11) NOT NULL,
  `totalVote` int(11) NOT NULL,
  PRIMARY KEY (`idTraduction`),
  KEY `idUtilisateur` (`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

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
(1, 'Minet', 'minet@licocorne.fr', 'angrydoge', 'Admin'),
(2, 'Tracytto', 'minetto@licocornetto.frtto', 'tto', 'Admin'),
(3, 'paul', 'paul@appelerpaul.fr', 'booya', 'Membre'),
(4, 'Martin', 'fre@po', 'f', 'Membre'),
(5, 'paulette', '45c84a5f3ea89f2c6143b64d88355e6cf62255a3', 'pauletteestbelle', 'Membre'),
(6, 'pou', '8b388e93f679ab54cbfba12688dc17f88760bff2', 'c0168fe6044f2b7aa04505ac25f5eac614bd35e1', 'Membre');

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

CREATE TABLE IF NOT EXISTS `video` (
  `idVideo` int(11) NOT NULL AUTO_INCREMENT,
  `titreVideo` varchar(45) NOT NULL,
  `dateVideo` date NOT NULL,
  `urlVideo` varchar(45) NOT NULL,
  `dureeVideo` time NOT NULL,
  `idTraduction` int(11) NOT NULL,
  `estTraduit` tinyint(1) NOT NULL,
  PRIMARY KEY (`idVideo`),
  KEY `idTraduction` (`idTraduction`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `motcle`
--
ALTER TABLE `motcle`
  ADD CONSTRAINT `fk_motcle_idVideo` FOREIGN KEY (`idVideo`) REFERENCES `video` (`idVideo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `traduction`
--
ALTER TABLE `traduction`
  ADD CONSTRAINT `fk_traduction_idUtilisateur` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `video`
--
ALTER TABLE `video`
  ADD CONSTRAINT `fk_video_idTraduction` FOREIGN KEY (`idTraduction`) REFERENCES `traduction` (`idTraduction`) ON DELETE CASCADE ON UPDATE CASCADE;
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
