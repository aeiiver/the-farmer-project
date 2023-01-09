# Configuration

Cloner le projet :

```
git clone https://github.com/aeiiver/the-farmer-project.git
```

## Installer le JDK

Dans IntelliJ, aller dans : File > Project Structure.
Dans l'onglet "Project", vérifie que le SDK est `Semeru 17.0.5`.

Pour lancer le projet, aller dans les configurations de lancement,
créer une nouvelle configuration Maven et saisir dans les arguments : `javafx:run`

## Configurer la base de données

La base de données du projet est basée sur un serveur distant.

Si vous voulez changer les détails de la base de données,
changer les constantes suivantes dans la classe [SingleConnection](src/main/java/root/data/SingleConnection.java) :

- `DB_URL`
- `DB_USER`
- `DB_PASSWORD`

## Générer des données pour la base de données

Pour générer des données, exécutez [Main](src/main/java/datageneration/Main.java) du package `datageneration`.
