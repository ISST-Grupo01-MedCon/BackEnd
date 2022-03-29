#!/bin/bash

# MedCon system startup script
# Copyright 2022

DIR="./frontend"
if [ -d "$DIR" ]; then
  #El directorio existe, no se hace nada
  echo "Se ha encontrado el directorio frontend."
  echo "Se procede a comprobar si hay cambios nuevos en GitHub y a descargarlos en tal caso."
  echo "Introduza su nombre de usuario y token si se le solicita:"
  cd frontend;
  (git pull origin &&
  echo "El FrontEnd está actualizado, se procede a ejecutar el servidor.") || 
  (echo "Hubo un problema obteniendo los últimos cambios del repositorio del FrontEnd. Se sale del script."; exit 1)
  cd ..;
else
  #El directorio no existe, por lo que se clona de GitHub
  echo "No se ha encontrado el FrontEnd. Clonando de GitHub..."
  echo "Introduza su nombre de usuario y token si se le solicita:"
  (git clone git@github.com:ISST-Grupo01-MedCon/FrontEnd.git frontend &&
  echo "Se clonó el repositorio de GitHub con éxito. Se procede a ejecutar el servidor.") ||
  (echo "Hubo un problema clonando el repositorio del FrontEnd. Se sale del script."; exit 1)
fi

./mvnw clean install -DskipTests=true spring-boot:run
