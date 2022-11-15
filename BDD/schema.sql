CREATE TABLE Adresse(
   idAdresse INT AUTO_INCREMENT,
   pays VARCHAR(50) NOT NULL,
   codePost VARCHAR(5) NOT NULL,
   ville VARCHAR(100) NOT NULL,
   voie VARCHAR(15) NOT NULL,
   nom VARCHAR(100) NOT NULL,
   numero SMALLINT NOT NULL,
   mention VARCHAR(10),
   complement VARCHAR(100),
   PRIMARY KEY(idAdresse)
);

CREATE TABLE Client(
   idClient INT AUTO_INCREMENT,
   nomClient VARCHAR(30) NOT NULL,
   prenomClient VARCHAR(30) NOT NULL,
   numTel VARCHAR(10) NOT NULL,
   gps VARCHAR(50) NOT NULL,
   idAdresse INT NOT NULL,
   PRIMARY KEY(idClient),
   UNIQUE(idAdresse),
   UNIQUE(numTel),
   FOREIGN KEY(idAdresse) REFERENCES Adresse(idAdresse)
);

CREATE TABLE Admin(
   idAdmin INT AUTO_INCREMENT,
   mail VARCHAR(40) NOT NULL,
   pseudo VARCHAR(30) NOT NULL,
   mdp VARCHAR(255) NOT NULL,
   PRIMARY KEY(idAdmin),
   UNIQUE(mail)
);

CREATE TABLE Producteur(
   SIRET VARCHAR(14),
   mail VARCHAR(50) NOT NULL,
   nomProd VARCHAR(30) NOT NULL,
   prenomProd VARCHAR(30) NOT NULL,
   numTel VARCHAR(10) NOT NULL,
   mdp VARCHAR(255) NOT NULL,
   idAdresse INT NOT NULL,
   PRIMARY KEY(SIRET),
   UNIQUE(idAdresse),
   UNIQUE(mail),
   UNIQUE(numTel),
   FOREIGN KEY(idAdresse) REFERENCES Adresse(idAdresse)
);

CREATE TABLE Vehicule(
   immat VARCHAR(9),
   poidsMax SMALLINT NOT NULL,
   SIRET VARCHAR(14) NOT NULL,
   PRIMARY KEY(immat),
   FOREIGN KEY(SIRET) REFERENCES Producteur(SIRET)
);

CREATE TABLE Tournee(
   numTournee INT AUTO_INCREMENT,
   libelle VARCHAR(50) NOT NULL,
   heureMin TIME NOT NULL,
   heureMax TIME NOT NULL,
   immat VARCHAR(9) NOT NULL,
   PRIMARY KEY(numTournee),
   FOREIGN KEY(immat) REFERENCES Vehicule(immat)
);

CREATE TABLE Commande(
   numCom INT AUTO_INCREMENT,
   libelle VARCHAR(50) NOT NULL,
   poids SMALLINT NOT NULL,
   dateCom DATE NOT NULL,
   heureDeb TIME NOT NULL,
   heureFin TIME NOT NULL,
   SIRET VARCHAR(14) NOT NULL,
   idClient INT NOT NULL,
   numTournee INT,
   PRIMARY KEY(numCom),
   FOREIGN KEY(SIRET) REFERENCES Producteur(SIRET),
   FOREIGN KEY(idClient) REFERENCES Client(idClient),
   FOREIGN KEY(numTournee) REFERENCES Tournee(numTournee)
);
