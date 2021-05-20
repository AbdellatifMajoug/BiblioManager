-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 20 mai 2021 à 13:57
-- Version du serveur :  10.4.18-MariaDB
-- Version de PHP : 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `biblio`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `name`) VALUES
(5, 'Chimie'),
(2, 'Informatique'),
(4, 'Mathematiques'),
(1, 'Physique'),
(3, 'SVT');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `id` int(11) NOT NULL,
  `log` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `log`, `pass`, `nom`, `prenom`) VALUES
(1, 'Majoug.abdellatif', 'motdepasse$', 'Majoug', 'Abdellatif'),
(2, 'Yassine', 'Mypass', 'Amine', 'Yassine'),
(3, 'Etudiantlog', '123', 'Etudiantnom', 'Etudiantprenom'),
(4, 'Rayanmrabet', 'Test', 'Mrabet', 'Rayane'),
(5, 'B.salmane', 'password', 'Berrada', 'Salmane'),
(6, 'Aziz.idrissi', 'secret', 'Idrissi', 'Aziz'),
(7, 'Mohammedkas', 'mdp', 'Kassimi', 'mohammed');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `name` varchar(255) NOT NULL,
  `categorie` int(11) NOT NULL,
  `auteur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`name`, `categorie`, `auteur`) VALUES
('Calcul d\'équations diff', 4, 'Mohammed'),
('Calcul d\'intégral', 4, 'Ahmed'),
('Developpement limité', 4, 'Abderrahim'),
('Electromagnétique', 1, 'Khalid'),
('Espaces vectoriels', 4, 'Jamal'),
('La division cellulaire', 3, 'Youssef'),
('La fécondation des plantes', 3, 'Youness'),
('La génétique humaine', 3, 'Mounir'),
('Learn c++', 2, 'Riad'),
('Learn HTML & CSS', 2, 'Faouzia'),
('Learn jee', 2, 'Mohammed'),
('Learn PHP', 2, 'Ahmed'),
('Les matrices ', 4, 'Moustapha'),
('Les transformations chimiques', 5, 'Abdellatif'),
('Lois de Newton', 1, 'Abdellah'),
('Mécanique', 1, 'Mohammed');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `categoriename` (`name`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `log` (`log`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`name`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `categorie_fk` (`categorie`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `categorie_fk` FOREIGN KEY (`categorie`) REFERENCES `categorie` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
