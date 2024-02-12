# Centrale Java (Arthur)

## Lancer l'API :

```bash
./gradlew :api:bootRun
```

## Initialisation de la base de données :

La base de données est gardée en mémoire dans un fichier `./api/data/db.mv.db`.
On peut accéder à celle-ci à l'adresse : `http://localhost:8080/h2-console`.

Rien de particulier à faire pour l'initialiser, elle se crée automatiquement au lancement de l'API avec deux joueurs (Player1, Player2).

## Module API :

On listera toutes les requêtes demandées pour cet exercice dans un premier temps.
Ensuite, on abordera quelques requêtes pratiques pour tester l'API et ne pas se perdre dans le jeu.

### Premère étape : Créer des joueurs

```bash
curl -X POST -H "Content-Type: application/json" "http://localhost:8080/player?name=Joueur3"
curl -X POST -H "Content-Type: application/json" "http://localhost:8080/player?name=Joueur4"
# etc...
curl -X GET -H "Content-Type: application/json" "http://localhost:8080/player/list"
```

### Deuxième étape : Jouer des parties

Exemple (attention, les mains sont en anglais !) :

```bash
curl -X POST -H "Content-Type: application/json" "localhost:8080/play?player1Id=3&player2Id=4&handPlayer1=rock&handPlayer2=scisors"
curl -X POST -H "Content-Type: application/json" "localhost:8080/play?player1Id=3&player2Id=4&handPlayer1=scisors&handPlayer2=scisors"
curl -X POST -H "Content-Type: application/json" "localhost:8080/play?player1Id=3&player2Id=4&handPlayer1=scisors&handPlayer2=rock"
curl -X POST -H "Content-Type: application/json" "localhost:8080/play?player1Id=3&player2Id=4&handPlayer1=scisors&handPlayer2=paper"
curl -X POST -H "Content-Type: application/json" "localhost:8080/play?player1Id=3&player2Id=4&handPlayer1=paper&handPlayer2=rock"
```

### Troisième étape : Voir les résultats

Et vérifier que le joueur 3 a bien gagné 3 fois, dans l'exemple.

```bash
curl -X GET -H "Content-Type: application/json" "localhost:8080/game-stats?playerId1=3"
```

### Commandes annexes :

On peut aussi tester les commandes suivantes.

1. Pour voir toutes les parties jouées
```bash
curl -X GET -H "Content-Type: application/json" "localhost:8080/games"
```

2. Pour voir tous les joueurs
```bash
curl -X GET -H "Content-Type: application/json" "localhost:8080/player/list"
```

## Améliorations possibles

