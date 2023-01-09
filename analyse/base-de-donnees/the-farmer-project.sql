-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : lun. 09 jan. 2023 à 11:05
-- Version du serveur : 8.0.31-0ubuntu0.20.04.2
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `the-farmer-project`
--

-- --------------------------------------------------------

--
-- Structure de la table `Admin`
--

CREATE TABLE `Admin` (
  `idAdmin` int NOT NULL,
  `mail` varchar(40) NOT NULL,
  `pseudo` varchar(30) NOT NULL,
  `mdp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Adresse`
--

CREATE TABLE `Adresse` (
  `idAdresse` int NOT NULL,
  `pays` varchar(50) NOT NULL,
  `codePost` varchar(5) NOT NULL,
  `ville` varchar(100) NOT NULL,
  `voie` varchar(15) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `numero` smallint DEFAULT NULL,
  `mention` varchar(10) DEFAULT NULL,
  `complement` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Client`
--

CREATE TABLE `Client` (
  `idClient` int NOT NULL,
  `nomClient` varchar(30) NOT NULL,
  `prenomClient` varchar(30) NOT NULL,
  `numTel` varchar(10) NOT NULL,
  `gps` varchar(50) NOT NULL,
  `idAdresse` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Commande`
--

CREATE TABLE `Commande` (
  `numCom` int NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `poids` smallint NOT NULL,
  `dateCom` date NOT NULL,
  `heureDeb` time NOT NULL,
  `heureFin` time NOT NULL,
  `SIRET` varchar(14) NOT NULL,
  `idClient` int NOT NULL,
  `numTournee` int DEFAULT NULL,
  `ordreTournee` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Producteur`
--

CREATE TABLE `Producteur` (
  `SIRET` varchar(14) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `nomProd` varchar(30) NOT NULL,
  `prenomProd` varchar(30) NOT NULL,
  `numTel` varchar(10) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `idAdresse` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Tournee`
--

CREATE TABLE `Tournee` (
  `numTournee` int NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `heureMin` time NOT NULL,
  `heureMax` time NOT NULL,
  `immat` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `Vehicule`
--

CREATE TABLE `Vehicule` (
  `immat` varchar(9) NOT NULL,
  `poidsMax` smallint NOT NULL,
  `SIRET` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`idAdmin`),
  ADD UNIQUE KEY `mail` (`mail`);

--
-- Index pour la table `Adresse`
--
ALTER TABLE `Adresse`
  ADD PRIMARY KEY (`idAdresse`);

--
-- Index pour la table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`idClient`),
  ADD UNIQUE KEY `idAdresse` (`idAdresse`),
  ADD UNIQUE KEY `numTel` (`numTel`);

--
-- Index pour la table `Commande`
--
ALTER TABLE `Commande`
  ADD PRIMARY KEY (`numCom`),
  ADD KEY `SIRET` (`SIRET`),
  ADD KEY `idClient` (`idClient`),
  ADD KEY `numTournee` (`numTournee`);

--
-- Index pour la table `Producteur`
--
ALTER TABLE `Producteur`
  ADD PRIMARY KEY (`SIRET`),
  ADD UNIQUE KEY `idAdresse` (`idAdresse`),
  ADD UNIQUE KEY `mail` (`mail`),
  ADD UNIQUE KEY `numTel` (`numTel`);

--
-- Index pour la table `Tournee`
--
ALTER TABLE `Tournee`
  ADD PRIMARY KEY (`numTournee`),
  ADD KEY `immat` (`immat`);

--
-- Index pour la table `Vehicule`
--
ALTER TABLE `Vehicule`
  ADD PRIMARY KEY (`immat`),
  ADD KEY `SIRET` (`SIRET`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Admin`
--
ALTER TABLE `Admin`
  MODIFY `idAdmin` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Adresse`
--
ALTER TABLE `Adresse`
  MODIFY `idAdresse` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Client`
--
ALTER TABLE `Client`
  MODIFY `idClient` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Commande`
--
ALTER TABLE `Commande`
  MODIFY `numCom` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `Tournee`
--
ALTER TABLE `Tournee`
  MODIFY `numTournee` int NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Client`
--
ALTER TABLE `Client`
  ADD CONSTRAINT `Client_ibfk_1` FOREIGN KEY (`idAdresse`) REFERENCES `Adresse` (`idAdresse`);

--
-- Contraintes pour la table `Commande`
--
ALTER TABLE `Commande`
  ADD CONSTRAINT `Commande_ibfk_1` FOREIGN KEY (`SIRET`) REFERENCES `Producteur` (`SIRET`),
  ADD CONSTRAINT `Commande_ibfk_2` FOREIGN KEY (`idClient`) REFERENCES `Client` (`idClient`),
  ADD CONSTRAINT `Commande_ibfk_3` FOREIGN KEY (`numTournee`) REFERENCES `Tournee` (`numTournee`);

--
-- Contraintes pour la table `Producteur`
--
ALTER TABLE `Producteur`
  ADD CONSTRAINT `Producteur_ibfk_1` FOREIGN KEY (`idAdresse`) REFERENCES `Adresse` (`idAdresse`);

--
-- Contraintes pour la table `Tournee`
--
ALTER TABLE `Tournee`
  ADD CONSTRAINT `Tournee_ibfk_1` FOREIGN KEY (`immat`) REFERENCES `Vehicule` (`immat`);

--
-- Contraintes pour la table `Vehicule`
--
ALTER TABLE `Vehicule`
  ADD CONSTRAINT `Vehicule_ibfk_1` FOREIGN KEY (`SIRET`) REFERENCES `Producteur` (`SIRET`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
