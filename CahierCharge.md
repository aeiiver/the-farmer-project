# Cahier des charges
## BDD
* Outil de gestion et d'optimisation de livraison
* Producteur : (__siret__, #idadresse, nom, prenom, numTel, gps, mdp)
* Client : (__idClient__, nom, prenom, #idadresse, numTel)
* Vehicule : (__immat__, #siret, poidsMax)
* Commande : (__numCom__, #idclient, #siret, libelle, poids, heureDeb, heureFin)
* Tournée : (__numTournee__, #immat, heureDeb, heureFin, poids)
* Possède : (#numCom, #numTournee)
* Admin : (__idUser__, pseudo, mdp, photoProfil)
* Adresse : (__idAdresse__, pays, codePost, voie, nom, numero, (biséarité?), complement) 

### Utilisations
* Visualisation des tournées : OSM
* Vérification de la validité des tournées : Somme de poids, horaire
* Estimation des temps de trajet
* Pas besoin de créer une tournée (sauf si on a le temps, peu être cool)

* Estimation des stocks avec un temps

## Questions :
* Est-ce qu'un producteur peut être un administrateur ?
* Est-ce qu'une gestion des stocks pourraient être intéressantes ?
* Est-ce qu'on peut proposer un itinéraire ?
* Quels osnt les utilités des données gps et de l'adresse ?
