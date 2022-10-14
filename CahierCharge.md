# Cahier des charges
## BDD
* Outil de gestion et d'optimisation de livraison
* Producteur : (__SIRET__, Adresse, NomProprio, PrenomProprio, NumTelephone, GPS, MotPasse)
* Client : (__NumClient__, Nom, Prenom, Adresse, NumTelephone)
* Véhicule : (__Immat__, #Producteur, poids Max)
* Commande : (__NumCom__, #Client, #Producteur, libellé, poids, horaireDeb, horaireFin)
* Tournée : (__NumTournée__, Véhicule, HoraireDeb, HoraireFin, poids)
* Possède : (#NumCom, #NumTournée)
* Admin : (__IDUser__, Pseudo, MotPasse, ImageProfil)

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