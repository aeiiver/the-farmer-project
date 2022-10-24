CREATE TABLE Adresse(
   idAdresse INT NOT NULL AUTO_INCREMENT,
   pays VARCHAR(50),
   codePost VARCHAR(5),
   voie VARCHAR(15),
   nom VARCHAR(100),
   numero SMALLINT,
   mention VARCHAR(10),
   complement VARCHAR(100),
   PRIMARY KEY(idAdresse)
);

CREATE TABLE Client(
   idClient INT NOT NULL AUTO_INCREMENT,
   nom VARCHAR(30),
   prenom VARCHAR(30),
   numTel VARCHAR(10),
   gps VARCHAR(50),
   idAdresse INT NOT NULL,
   PRIMARY KEY(idClient),
   FOREIGN KEY(idAdresse) REFERENCES Adresse(idAdresse)
);

CREATE TABLE Admin(
   idAdmin INT NOT NULL AUTO_INCREMENT,
   pseudo VARCHAR(30),
   mdp VARCHAR(255),
   profilPic blob,
   PRIMARY KEY(idAdmin)
);

CREATE TABLE Producteur(
   SIRET VARCHAR(14) NOT NULL,
   nomProducteur VARCHAR(30) NOT NULL,
   prenomProducteur VARCHAR(30) NOT NULL,
   numTel VARCHAR(10) NOT NULL,
   mdp VARCHAR(255) NOT NULL,
   idAdresse INT NOT NULL,
   PRIMARY KEY(SIRET),
   UNIQUE(numTel),
   FOREIGN KEY(idAdresse) REFERENCES Adresse(idAdresse)
);

CREATE TABLE Commande(
   numCom INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(50) NOT NULL,
   poids SMALLINT,
   heureDeb TIME,
   heureFin TIME,
   SIRET VARCHAR(14) NOT NULL,
   idClient INT NOT NULL,
   PRIMARY KEY(numCom),
   FOREIGN KEY(SIRET) REFERENCES Producteur(SIRET),
   FOREIGN KEY(idClient) REFERENCES Client(idClient)
);

CREATE TABLE Vehicule(
   immat VARCHAR(9),
   poidsMax SMALLINT,
   SIRET VARCHAR(14) NOT NULL,
   PRIMARY KEY(immat),
   FOREIGN KEY(SIRET) REFERENCES Producteur(SIRET)
);

CREATE TABLE Tournee(
   numTournee INT NOT NULL AUTO_INCREMENT,
   horaireFin TIME,
   horaireDeb TIME,
   poids INT,
   immat VARCHAR(9) NOT NULL,
   PRIMARY KEY(numTournee),
   FOREIGN KEY(immat) REFERENCES Vehicule(immat)
);

CREATE TABLE Image(
   idImage INT NOT NULL AUTO_INCREMENT,
   picture BLOB
);

CREATE TABLE Effectue(
   numCom INT,
   numTournee INT,
   PRIMARY KEY(numTournee, numCom),
   FOREIGN KEY(numTournee) REFERENCES Tournee(numTournee),
   FOREIGN KEY(numCom) REFERENCES Commande(numCom)
);


/*
Adresse = (__idAdresse__ INT, pays VARCHAR(50), codePost VARCHAR(5), voie VARCHAR(15), nom VARCHAR(100), numero SMALLINT, mention VARCHAR(10), complement VARCHAR(100));
Client = (__idClient__ INT, nom VARCHAR(30), prenom VARCHAR(30), numTel VARCHAR(10), gps VARCHAR(50), #idAdresse);
Admin = (__idAdmin__ INT, pseudo VARCHAR(30), mdp VARCHAR(255), #idImage);
Producteur = (__SIRET__ VARCHAR(14), nomProducteur VARCHAR(30), prenomProducteur VARCHAR(30), numTel VARCHAR(10), mdp VARCHAR(255), #idAdresse, #idImage);
Commande = (__numCom__ INT, libelle VARCHAR(50), poids SMALLINT, heureDeb TIME, heureFin TIME, #SIRET, #idClient);
Vehicule = (__immat__ VARCHAR(9), poidsMax SMALLINT, #SIRET);
Tournee = (__numTournee__ INT, horaireFin TIME, horaireDeb TIME, poids INT, #immat);
Image = (__idImage__ INT, picture BLOB);
Effectue = (#numTournee_1, #numCom_1);
*/