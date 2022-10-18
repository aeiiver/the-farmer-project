## BDD
* Outil de gestion et d'optimisation de livraison
* Producteur : (__siret__, #idadresse, nom, prenom, numTel, gps, mdp)
* Client : (__idClient__, nom, prenom, #idadresse, numTel)
* Vehicule : (__immat__, #siret, poidsMax)
* Commande : (__numCom__, #idclient, #siret, libelle, poids, heureDeb, heureFin)
* Tournee : (__numTournee__, #immat, heureDeb, heureFin, poids)
* Possede : (__#numCom, #numTournee__)
* Admin : (__idUser__, pseudo, mdp, photoProfil)
* Adresse : (__idAdresse__, pays, codePost, voie, nom, numero, (biséarité?), complement) 
