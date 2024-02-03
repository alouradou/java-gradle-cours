# Centrale Java (Arthur)

## Lancer l'API:

```bash
./gradlew :api:bootRun
```

## Initialisation de la base de données:

D'abord, copier le template `application-template.properties` et changer les valeurs pour correspondre à votre environnement.

```bash
cp api/src/main/resources/application.properties.template api/src/main/resources/application.properties
```

J'ai placé ma base de données dans `data/db.mv.db`, par exemple, mais on peut aussi envisager se connecter à un service externe.

On peut accéder à celle-ci à l'adresse : `http://localhost:8080/h2-console`

