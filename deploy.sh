#!/bin/bash

set -e

echo "Construction du projet..."
mvn clean package

echo "Renommage du WAR..."
mv target/gestiongarage-1.0-SNAPSHOT.war target/www.axitech.com.war

echo "Déploiement sur Tomcat..."
docker cp target/www.axitech.com.war tomcat-server:/usr/local/tomcat/webapps/

echo "Déploiement terminé avec succès !"
