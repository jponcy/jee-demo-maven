Projet de démonstration de Maven
================================

Juste un plugin (eclipse) + la gestion des dépendances.

Pré-requis
----------

Ce projet est fait pour tourner avec :
* eclipse
* un tomcat 10 (intégré à eclipse OK)
* maven (qu'il faut avoir installer)

Installation
------------

Ouvrir un terminal (Git Bash par exemple) dans le dossier dans lequel vous voulez installer le projet.

```bash
git clone https://github.com/jponcy/jee-demo-maven.git
cd jee-demo-maven
mvn -npr eclipse:eclipse
```

Vous pouvez maintenant importer le projet sur eclipse (import>existing maven project).
