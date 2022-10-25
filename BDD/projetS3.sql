CREATE TABLE Adresse(
   idAdresse INT NOT NULL AUTO_INCREMENT,
   pays VARCHAR(50) NOT NULL,
   codePost CHAR(5) NOT NULL,
   voie VARCHAR(15) NOT NULL,
   nom VARCHAR(100) NOT NULL,
   numero SMALLINT NOT NULL,
   mention VARCHAR(10),
   complement VARCHAR(100),
   PRIMARY KEY(idAdresse)
);

CREATE TABLE Client(
   idClient INT NOT NULL AUTO_INCREMENT,
   nom VARCHAR(30) NOT NULL,
   prenom VARCHAR(30) NOT NULL,
   numTel VARCHAR(31) NOT NULL,
   gps VARCHAR(21),
   idAdresse INT NOT NULL,
   PRIMARY KEY(idClient),
   FOREIGN KEY(idAdresse) REFERENCES Adresse(idAdresse)
);

CREATE TABLE Admin(
   idAdmin INT NOT NULL AUTO_INCREMENT,
   mail VARCHAR(40) UNIQUE,
   pseudo VARCHAR(30) NOT NULL UNIQUE,
   mdp VARCHAR(255) NOT NULL,
   idImage INT,
   PRIMARY KEY(idAdmin),
   FOREIGN KEY (idImage) REFERENCES Image(idImage)
);

CREATE TABLE Producteur(
   SIRET VARCHAR(14) NOT NULL,
   mail VARCHAR(40) UNIQUE,
   nomProducteur VARCHAR(30) NOT NULL,
   prenomProducteur VARCHAR(30) NOT NULL,
   numTel VARCHAR(31) NOT NULL UNIQUE,
   mdp VARCHAR(255) NOT NULL,
   idAdresse INT NOT NULL,
   idImage INT,
   PRIMARY KEY(SIRET),
   UNIQUE(numTel),
   FOREIGN KEY(idAdresse) REFERENCES Adresse(idAdresse),
   FOREIGN KEY (idImage) REFERENCES Image(idImage)
);

CREATE TABLE Commande(
   numCom INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(50) NOT NULL,
   poids SMALLINT NOT NULL,
   heureDeb TIME,
   heureFin TIME,
   SIRET VARCHAR(14) NOT NULL,
   idClient INT NOT NULL,
   numTournee INT,
   PRIMARY KEY(numCom),
   FOREIGN KEY(SIRET) REFERENCES Producteur(SIRET),
   FOREIGN KEY(idClient) REFERENCES Client(idClient),
   FOREIGN KEY(numTournee) REFERENCES Tournee(numTournee)
);

CREATE TABLE Vehicule(
   immat VARCHAR(9) NOT NULL,
   poidsMax SMALLINT,
   SIRET VARCHAR(14) NOT NULL,
   PRIMARY KEY(immat),
   FOREIGN KEY(SIRET) REFERENCES Producteur(SIRET)
);

CREATE TABLE Tournee(
   numTournee INT NOT NULL AUTO_INCREMENT,
   horaireFin TIME,
   horaireDeb TIME,
   poids INT NOT NULL,
   immat VARCHAR(9) NOT NULL,
   PRIMARY KEY(numTournee),
   FOREIGN KEY(immat) REFERENCES Vehicule(immat)
);

CREATE TABLE Image(
   idImage INT NOT NULL AUTO_INCREMENT,
   picture BLOB NOT NULL,
   PRIMARY KEY(idImage)
);

/*
Adresse = (idAdresse INT, pays VARCHAR(50), codePost CHAR(5), voie VARCHAR(15), nom VARCHAR(100), numero SMALLINT, mention VARCHAR(10), complement VARCHAR(100));
Client = (idClient INT, nom VARCHAR(30), prenom VARCHAR(30), numTel VARCHAR(26), gps VARCHAR(21), #idAdresse);
Admin = (idAdmin INT, mail VARCHAR(40), pseudo VARCHAR(30), mdp VARCHAR(255), #idImage);
Producteur = (SIRET CHAR(14), mail VARCHAR(40), nomProducteur VARCHAR(30), prenomProducteur VARCHAR(30), numTel VARCHAR(26), mdp VARCHAR(255), #idAdresse, #idImage);
Commande = (numCom INT, libelle VARCHAR(50), poids INT, heureDeb TIME, heureFin TIME, #SIRET, #idClient, #numTournee);
Vehicule = (immat VARCHAR(7), poidsMax INT, #SIRET);
Tournee = (numTournee INT, horaireFin TIME, horaireDeb TIME, poids INT, #immat);
Image = (idImage INT, picture BLOB);
*/ 
