#!/bin/bash

# MedCon system startup script
# Copyright 2022

DIR="./frontend"
if [ -d "$DIR" ]; then
  #El directorio existe, no se hace nada
  echo "Se ha encontrado el directorio frontend."
  DIR2="./frontend/.git"
  if [ -d "$DIR2" ]; then
    echo "$DIR2 existe." 
    echo "Se procede a comprobar si hay cambios nuevos en GitHub y a descargarlos en tal caso."
    echo "Introduza su nombre de usuario y token si se le solicita:"
    cd frontend;
    { git pull origin &&
    echo "El FrontEnd está actualizado, se procede a ejecutar el servidor."; } || 
    { echo "Hubo un problema obteniendo los últimos cambios del repositorio del FrontEnd. Se sale del script."; exit 1; }
    cd ..;
  else
    echo "$DIR2 no existe."
    echo "Se procede a clonar y actualizar la carpeta frontend."
    { git clone https://github.com/ISST-Grupo01-MedCon/FrontEnd frontend2 &&
    echo "Se clonó el repositorio de GitHub con éxito."; } ||
    { echo "Hubo un problema clonando el repositorio del FrontEnd. Se sale del script."; exit 1; }
    echo "Copiando los archivos del frontend en el directorio correcto."
    { cp -r ./frontend2/* ./frontend && cp -r ./frontend2/.* ./frontend && rm -rf ./frontend2 && echo "Archivos copiados correctamente. Se procede a ejecutar el servidor."; } ||
    { echo "Hubo un problema actualizando la carpeta frontend. Se sale del script."; exit 1; }
  fi
else
  #El directorio no existe, por lo que se clona de GitHub
  echo "No se ha encontrado el FrontEnd. Clonando de GitHub..."
  echo "Introduza su nombre de usuario y token si se le solicita:"
  { git clone https://github.com/ISST-Grupo01-MedCon/FrontEnd frontend &&
  echo "Se clonó el repositorio de GitHub con éxito. Se procede a ejecutar el servidor."; } ||
  { echo "Hubo un problema clonando el repositorio del FrontEnd. Se sale del script."; exit 1; }
fi

./mvnw clean install -DskipTests=true spring-boot:run
