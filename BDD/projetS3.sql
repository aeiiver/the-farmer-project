CREATE TABLE Adresse(
                        idAdresse INT,
                        pays VARCHAR(50),
                        codePost VARCHAR(5),
                        ville VARCHAR(100),
                        voie VARCHAR(15),
                        nom VARCHAR(100),
                        numero SMALLINT,
                        mention VARCHAR(10),
                        complement VARCHAR(100),
                        PRIMARY KEY(idAdresse)
);

CREATE TABLE Client(
                       idClient INT,
                       nom VARCHAR(30),
                       prenom VARCHAR(30),
                       numTel VARCHAR(10),
                       gps VARCHAR(50),
                       idAdresse INT NOT NULL,
                       PRIMARY KEY(idClient),
                       UNIQUE(idAdresse),
                       FOREIGN KEY(idAdresse) REFERENCES Adresse(idAdresse)
);

CREATE TABLE Admin(
                      idAdmin INT,
                      mail VARCHAR(40),
                      pseudo VARCHAR(30),
                      mdp VARCHAR(255),
                      PRIMARY KEY(idAdmin),
                      UNIQUE(mail)
);

CREATE TABLE Producteur(
                           SIRET VARCHAR(14),
                           mail VARCHAR(40),
                           nomProducteur VARCHAR(30),
                           prenomProducteur VARCHAR(30),
                           numTel VARCHAR(10),
                           mdp VARCHAR(255),
                           idAdresse INT NOT NULL,
                           PRIMARY KEY(SIRET),
                           UNIQUE(idAdresse),
                           UNIQUE(mail),
                           UNIQUE(numTel),
                           FOREIGN KEY(idAdresse) REFERENCES Adresse(idAdresse)
);

CREATE TABLE Commande(
                         numCom INT,
                         libelle VARCHAR(50),
                         poids SMALLINT,
                         heureDeb TIME,
                         heureFin TIME,
                         DateCommande DATE NOT NULL,
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
                        numTournee INT,
                        Libellé VARCHAR(50) NOT NULL,
                        heureMin TIME,
                        heureMax TIME,
                        immat VARCHAR(9) NOT NULL,
                        PRIMARY KEY(numTournee),
                        FOREIGN KEY(immat) REFERENCES Vehicule(immat)
);

CREATE TABLE Effectue(
                         numTournee INT,
                         numCom INT,
                         PRIMARY KEY(numTournee, numCom),
                         FOREIGN KEY(numTournee) REFERENCES Tournee(numTournee),
                         FOREIGN KEY(numCom) REFERENCES Commande(numCom)
);
