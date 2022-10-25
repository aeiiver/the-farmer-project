## BDD MLD textuel
* Adresse = (__idAdresse__ INT, pays VARCHAR(50), codePost VARCHAR(5), voie VARCHAR(15), nom VARCHAR(100), numero SMALLINT, mention VARCHAR(10), complement VARCHAR(100));
* Client = (__idClient__ INT, nom VARCHAR(30), prenom VARCHAR(30), numTel VARCHAR(10), gps VARCHAR(50), #idAdresse);
* Admin = (__idAdmin__ INT, pseudo VARCHAR(30), mdp VARCHAR(255), #idImage);
* Producteur = (__SIRET__ VARCHAR(14), nomProducteur VARCHAR(30), prenomProducteur VARCHAR(30), numTel VARCHAR(10), mdp VARCHAR(255), #idAdresse, #idImage);
* Commande = (__numCom__ INT, libelle VARCHAR(50), poids SMALLINT, heureDeb TIME, heureFin TIME, #SIRET, #idClient);
* Vehicule = (__immat__ VARCHAR(9), poidsMax SMALLINT, #SIRET);
* Tournee = (__numTournee__ INT, horaireFin TIME, horaireDeb TIME, poids INT, #immat);
* Image = (__idImage__ INT, picture BLOB);
* Effectue = (#numTournee_1, #numCom_1);
