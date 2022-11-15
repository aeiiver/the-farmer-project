# MLD textuel

```sql
Adresse = (idAdresse INT, pays VARCHAR(50), codePost VARCHAR(5), ville VARCHAR(100), voie VARCHAR(15), nom VARCHAR(100), numero SMALLINT, mention VARCHAR(10), complement VARCHAR(100));
Client = (idClient INT, nomClient VARCHAR(30), prenomClient VARCHAR(30), numTel VARCHAR(10), gps VARCHAR(50), #idAdresse);
Admin = (idAdmin INT, mail VARCHAR(40), pseudo VARCHAR(30), mdp VARCHAR(255));
Producteur = (SIRET VARCHAR(14), mail VARCHAR(50), nomProd VARCHAR(30), prenomProd VARCHAR(30), numTel VARCHAR(10), mdp VARCHAR(255), #idAdresse);
Vehicule = (immat VARCHAR(9), poidsMax SMALLINT, #SIRET);
Tournee = (numTournee INT, libelle VARCHAR(50), heureMin TIME, heureMax TIME, #immat);
Commande = (numCom INT, libelle VARCHAR(50), poids SMALLINT, dateCom DATE, heureDeb TIME, heureFin TIME, #SIRET, #idClient, #numTournee*);
```
