# Gradle 

## Description : 

https://docs.gradle.org/current/userguide/userguide.html

Gradle est un outil de build (construction) permettant d'automatiser certaines étapes du processus de développement et de build d'un projet (compilation, exécution des tests, création d'un fichier executable ...) 

Les principales fonctionnalités sont : 
- automatisation du build (`tasks`)
- gestion des dépendances (librairies externes à inclure au projet)
- gestion de sous-projets

Le projet contient un executable gradle (le wrapper). Il n'est donc pas nécessaire d'installer globalement gradle. 

## Structure d'un projet 

- à la racine du projet, on trouve le fichier `settings.gradle` permettant de définir le projet de manière globale. C'est dans ce fichier que l'on précise les modules du projet.
- chaque module (ici `cli`, `domain` et `api`) contient une arborescence de fichiers correspondant à une convention gradle (src/main/java et src/test/java) - c'est dans ces repertoires que l'on placera les classes java source. 
- chaque module contient un fichier `build.gradle` décrivant le module (quels plugins ?, quelles dépendances ?)
- Les plugins permettent d'étendre les fonctionnalités de base de gradle pour un certain type de projet. Entre autres, un plugin permet d'ajouter des `tasks` particulières. (exemple : plugin java qui ajoute la tâche `compileJava`)
- les dépendances du projet : peuvent provenir d'un répertoire distant (souvent mavenCentral : https://mvnrepository.com/repos/central), localement, ou autre. 
- définition personnalisée des tâches. Il est possible de créer des tâches grace au langage de script Groovy. 