## MLD textuel
* Adresse = (idAdresse INT, pays VARCHAR(50), codePost CHAR(5), voie VARCHAR(15), nom VARCHAR(100), numero SMALLINT, mention VARCHAR(10), complement VARCHAR(100));
* Client = (idClient INT, nom VARCHAR(30), prenom VARCHAR(30), numTel VARCHAR(26), gps VARCHAR(21), #idAdresse);
* Admin = (idAdmin INT, mail VARCHAR(40), pseudo VARCHAR(30), mdp VARCHAR(255), #idImage);
* Producteur = (SIRET CHAR(14), mail VARCHAR(40), nomProducteur VARCHAR(30), prenomProducteur VARCHAR(30), numTel VARCHAR(26), mdp VARCHAR(255), #idAdresse, #idImage);
* Commande = (numCom INT, libelle VARCHAR(50), poids INT, heureDeb TIME, heureFin TIME, #SIRET, #idClient, #numTournee);
* Vehicule = (immat VARCHAR(7), poidsMax INT, #SIRET);
* Tournee = (numTournee INT, horaireFin TIME, horaireDeb TIME, poids INT, #immat);


