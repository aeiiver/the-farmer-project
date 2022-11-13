# Table des matières

- [Table des matières](#table-des-matières)
- [Outil](#outil)
- [Diagramme de cas d'utilisation (OK)](#diagramme-de-cas-dutilisation-ok)
- [Diagramme de classes (WIP)](#diagramme-de-classes-wip)
- [Diagramme de séquences (WIP)](#diagramme-de-séquences-wip)
  - [Admin & Producteur](#admin--producteur)
  - [Admin](#admin)
  - [Producteur](#producteur)
- [Diagrammes d'état (TODO)](#diagrammes-détat-todo)

# Outil

Pour [dessiner du l'UML](https://www.reddit.com/r/ProgrammerHumor/comments/b3okry/uml_is_love_uml_is_life/),
on va utiliser [diagrams.net](https://app.diagrams.net/) car il ne requiert pas d'installation sur la machine,
et c'est bien de ne pas polluer sa machine.

# [Diagramme de cas d'utilisation](./CasUtilisation.drawio.png) (OK)

# [Diagramme de classes](./Classes.png) (WIP)

# Diagramme de séquences (WIP)

Les diagrammes de séquence peuvent être trouvés dans `diagrammes-de-sequence`.

Cette liste des diagrammes de séquence a été déduite du [diagramme des cas d'utilisation](#diagramme-de-cas-dutilisation).

## Admin & Producteur

Authentification utilisateur :

- [x] [Connexion](diagrammes-de-sequence/connexion.drawio.png)
- [ ] Déconnexion

## Admin

Gestion de compte producteur par un admin :

- [ ] Ajouter un producteur
- [ ] Modifier un producteur
- [ ] Supprimer un producteur

## Producteur

Gestion de compte producteur par le producteur lui-même :

- [ ] Modifier ses information de producteur
- [ ] Ajouter un véhicule
- [ ] Supprimer un véhicule

Gestion d'une commande par le producteur :

- [ ] Ajouter une commande
- [ ] Consulter les détails d'une commande
- [ ] Modifier une commande
- [ ] Supprimer une commande

Gestion d'une tournée par le producteur :

- [ ] Ajouter une commande existante à la tournée
- [ ] Visualiser sur une carte la tournée
- [ ] Vérifier si la tournée est valide (poids, horaire)
- [ ] Modifier l'ordre des commandes dans la tournée
- [ ] Supprimer une tournée

Gestion des informations client par le producteur :

- [ ] Ajouter un client
- [ ] Consulter les détails d'un clients
- [ ] Modifier un client
- [ ] Supprimer un client

# Diagrammes d'état (TODO)

> Définir quels parties de l'application dont on veut visualiser l'état...
